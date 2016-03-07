package com.wang.sdfood;

import android.app.Application;

import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.OkHttpUtil;
import com.wang.sdfood.util.Shareutil;

/**
 * Created by user on 2016/3/5.
 */
public class AppContext extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtil.initOkHttp();
        FrescoUtil.initFresco(this);
        Shareutil.initShared(this);
    }
}
