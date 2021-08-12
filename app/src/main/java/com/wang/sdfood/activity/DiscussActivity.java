package com.wang.sdfood.activity;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityHomeDiscussBinding;

/**
 * 这是评论的Activity
 * Created by user on 2016/3/6.
 */
public class DiscussActivity extends BaseActivity {

    @Override
    protected void getViewResId() {
        ActivityHomeDiscussBinding homeDiscussBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_discuss);
    }
}
