package com.wang.sdfood.activity;

import android.content.Intent;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityMegcookBinding;
import com.wang.sdfood.util.Constants;

/**
 * 这是ViewPager第一页的厨具
 * Created by Administrator on 2016/3/8.
 */
public class MegcookActvity extends BaseActivity {
    private String TAG = "print";
    @Override
    protected void getViewResId() {

        ActivityMegcookBinding megcookBinding= DataBindingUtil.setContentView(this, R.layout.activity_megcook);
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
