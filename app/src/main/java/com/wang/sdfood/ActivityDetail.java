package com.wang.sdfood;

import android.content.Intent;

import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.util.Constants;

/**
 * Created by Administrator on 2016/3/7.
 */
public class ActivityDetail extends BaseActivity {
    @Override
    protected int getViewResId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(Constants.KEY.CAIXI_KEY);

    }

    @Override
    protected void loadDatas() {
    }
}
