package com.tiannuo.design_patterns.solid_priciple.srp_priciple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tiannuo.design_patterns.R;

import java.util.Random;

/**
 * Created by Tikou on 2017/3/8.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class SrpActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageLoader imageLoader = null;
    private ImageView imageView;
    private Button btn_change;
    private String[] girls = new String[4];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srp);
        imageView= (ImageView) findViewById(R.id.iv);
        btn_change= (Button) findViewById(R.id.bt_change);
        imageLoader = new ImageLoader();
        //imageLoader.displayImage(girls[new Random(4).nextInt()], imageView);
        btn_change.setOnClickListener(this);
        girls[0] = "http://e.hiphotos.baidu.com/image/pic/item/500fd9f9d72a605951f80cc52c34349b023bba01.jpg";
        girls[1] = "http://c.hiphotos.baidu.com/image/pic/item/472309f79052982280874be4d2ca7bcb0a46d465.jpg";
        girls[2] = "http://f.hiphotos.baidu.com/image/pic/item/b151f8198618367a9f738e022a738bd4b21ce573.jpg";
        girls[3] = "http://b.hiphotos.baidu.com/image/pic/item/5bafa40f4bfbfbed7a031d937cf0f736aec31f87.jpg";


    }

    @Override
    public void onClick(View v) {
        imageLoader.displayImage(girls[new Random().nextInt(4)], imageView);
    }
}
