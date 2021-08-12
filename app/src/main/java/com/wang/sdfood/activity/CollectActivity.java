package com.wang.sdfood.activity;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityHomeCollectBinding;

/**
 * 这是收藏的Activity
 * Created by user on 2016/3/6.
 */
public class CollectActivity extends BaseActivity {
    @Override
    protected void getViewResId() {
        ActivityHomeCollectBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home_collect);
    }
}
