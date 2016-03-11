package com.wang.sdfood.activity;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;

import butterknife.Bind;

/**
 * 最新作品的activity
 * Created by user on 2016/3/11.
 */
public class LabelNewWorkActivity extends BaseActivity {
    @Bind(R.id.ptrv_lv_new_work)
    public PullToRefreshListView pullToRefreshListView;
    @Override
    protected int getViewResId() {
        return R.layout.activity_label_new_work;
    }

    @Override
    protected void init() {
        super.init();
//          R.layout.lv_label_new_work
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }
}
