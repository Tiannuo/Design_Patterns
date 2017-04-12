package com.tiannuo.design_patterns.solid_priciple.srp_priciple;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Tikou on 2017/3/8.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：图片缓存类
 * 参考：
 */

public class ImageCache {
    //图片缓存
    LruCache<String, Bitmap> bitmapLruCache;

    public ImageCache() {
        initImageCache();
    }

    private void initImageCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 4;
        bitmapLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
                //return super.sizeOf(key, value);
            }
        };
    }

    public void put(String key, Bitmap bitmap) {
        bitmapLruCache.put(key, bitmap);
    }

    public Bitmap get(String url){
        return bitmapLruCache.get(url);
    }

}
