package com.wang.sdfood;

import android.content.Intent;
import android.util.Log;

import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.util.Constants;

/**
 * Created by Administrator on 2016/3/8.
 */
public class ActvityMegcook extends BaseActivity {
    private String TAG = "print";
    @Override
    protected int getViewResId() {
        return R.layout.activity_fooddetail;
    }

    @Override
    protected void init() {
        super.init();
        Intent intent = getIntent();
        int id = intent.getIntExtra(Constants.KEY.FOODNAME_ID_KEY, -1);
        Log.e(TAG, "init: "+id );
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }
}