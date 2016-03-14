package com.wang.sdfood.application;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.activeandroid.ActiveAndroid;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.wang.sdfood.R;
import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.OkHttpUtil;
import com.wang.sdfood.util.Shareutil;

import java.io.File;

/**
 * 全局初始化Application类
 * Created by user on 2016/3/5.
 */
public class AppContext extends Application{
    private ImageLoader mImageLoader;
    private DisplayImageOptions options;
    private static AppContext appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext=this;
        OkHttpUtil.initOkHttp();
        FrescoUtil.initFresco(this);
        Shareutil.initShared(this);
        ActiveAndroid.initialize(this);
    }
    /**
     * 获取当前的应用程序对象
     * @return
     */
    public static AppContext getApp(){
        return appContext;
    }

    /**
     * 返回ImageLoader
     * @return
     */
    public ImageLoader getmImageLoader(){
        return this.mImageLoader;
    }
    public DisplayImageOptions getOptions()
    {
        return this.options;
    }
    /**
     * 初始化图片加载对象
     */
    private void initImageDisplaye(){
        mImageLoader = ImageLoader.getInstance();

        /**
         * 初始化
         */
        // 获取SDCard目录路径
        String diskCachePath = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            diskCachePath = new StringBuffer()
                    .append(Environment.getExternalStorageDirectory())
                    .append(File.separator)
                    .append("SDFood/imageCache").toString();
            // /mnt/sdcard/qianfeng/imageCache
        }
        else
        {
            diskCachePath = new StringBuffer().append(Environment.getDataDirectory())
                    .append(File.separator)
                    .append(this.getPackageName())
                    .append("SDfood/imageCache").toString();
            // /data/data/com.example.volley_case_greentree_list/qianfeng/imageCache
        }

        // 设置内存缓存
        int cacheSize = (int) Runtime.getRuntime().maxMemory() / 8;
        // 创建ImageLoader配置
        ImageLoaderConfiguration configuration =
                new ImageLoaderConfiguration.Builder(getApplicationContext())
                        .threadPoolSize(5) // 设置线程池线程大小
                                // 磁盘缓存位置
                        .diskCache(new UnlimitedDiskCache(new File(diskCachePath)))
                        .diskCacheSize(60 * 1024 * 1024) // 磁盘缓存的大小 60M
                        .diskCacheFileCount(200) // 磁盘缓存的文件数量
                                // 可以设置自定义内存缓存，并且自定义缓存大小
                                //.memoryCache(new LruMemoryCache(5 * 1024 * 1024))
                        .memoryCacheSize(cacheSize) // 设置内存缓存大小
                        .build();
        // 初始化配置
        ImageLoader.getInstance().init(configuration);

        // 在全局设置图片显示选项
        DisplayImageOptions options =
                new DisplayImageOptions.Builder()
                        .cacheInMemory(true) // 是否缓存到内存
                        .cacheOnDisk(true) // 是否缓存到磁盘
                        .showImageOnLoading(R.drawable.ic_ab_back_mtrl_am_alpha) // 加载显示的图片
                        .showImageOnFail(R.drawable.icon_msg_like) // 加载失败显示的图片
                        .bitmapConfig(Bitmap.Config.ARGB_8888) // 设置图片属性 RGB_565 无效，4.0后无效
                        .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
