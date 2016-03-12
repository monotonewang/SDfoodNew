package com.wang.sdfood.activity;

import android.content.Intent;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.OkHttpUtil;

/**
 * 西顿网友的Activity
 * Created by user on 2016/3/12.
 */
public class XiDunUserActivity extends BaseActivity implements OkHttpUtil.OnDownLoadListener {
    //下载的网址
    private String murl;

    @Override
    protected int getViewResId() {
        return R.layout.activity_xidun_user;
    }

    @Override
    protected void init() {
        super.init();
        Intent intent = getIntent();
        murl = intent.getStringExtra(Constants.KEY.XINDUN_USER_KEY);

    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(murl,this);
    }

    @Override
    public void onResponse(String url, String json) {

    }

    @Override
    public void onFailure(String url, String json) {

    }
}
