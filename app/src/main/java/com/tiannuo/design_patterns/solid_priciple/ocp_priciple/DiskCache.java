package com.tiannuo.design_patterns.solid_priciple.ocp_priciple;

import android.os.Environment;

import java.io.File;

/**
 * Created by Tikou on 2017/3/8.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：图片缓存的sd卡
 * 参考：
 */

public class DiskCache {
    public static String cacheDir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+ File.separator+"cache";

    public DiskCache() {

    }
}
