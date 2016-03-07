package com.wang.sdfood.util;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by user on 2016/3/3.
 */
public class FrescoUtil {

    public static void initFresco(Context context){
        Fresco.initialize(context);
    }


    public static void initFresco(Context context,ImagePipelineConfig imagePipelineConfig){
        Fresco.initialize(context, imagePipelineConfig);
    }

    /**
     * 加载网络普通图片的方法
     * @param url
     * @param simpleDraweeView
     */
    public static void imageViewBind(String url,SimpleDraweeView simpleDraweeView){
        Uri uri=Uri.parse(url);
        simpleDraweeView.setImageURI(uri);
    }

    /**
     * 开启重试的图片加载
     * @param url
     * @param simpleDraweeView
     */
    public static void imageViewBindRetry(String url,SimpleDraweeView simpleDraweeView){
        Uri uri= Uri.parse(url);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)//开启重试加载
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(build);
    }
}
