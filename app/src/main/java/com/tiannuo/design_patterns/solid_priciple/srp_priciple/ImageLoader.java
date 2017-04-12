package com.tiannuo.design_patterns.solid_priciple.srp_priciple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tikou on 2017/3/7.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：单一职能原则（SRP）
 * 参考：图片加载类
 */

public class ImageLoader {

    //开启线程池cpu的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    ImageCache imageCache=new ImageCache();
    public ImageLoader() {
        initImageLoader();
    }

    //初始化加载类
    private void initImageLoader() {
    }

    //显示图片
    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downLoadImage(url);
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                    imageCache.put(url, bitmap);
                }
            }
        });
    }

    private Bitmap downLoadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url=new URL(imageUrl);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            bitmap= BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("ImageLoader","bitmap="+bitmap.getByteCount());
        return bitmap;
    }

}
