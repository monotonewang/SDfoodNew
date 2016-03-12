package com.wang.sdfood.activity;

import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;

import butterknife.Bind;

/**
 * 这是厨具的详情activity
 * Created by user on 2016/3/10.
 */
public class MegCookDetailActivity extends BaseActivity {
    //立即购买的textView
    @Bind(R.id.tv_activity_megcook_detail_buy)
    public TextView textView;

    @Override
    protected int getViewResId() {
        return R.layout.activity_megcook_detail;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }
}
