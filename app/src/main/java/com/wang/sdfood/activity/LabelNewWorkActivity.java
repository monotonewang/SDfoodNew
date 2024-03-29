package com.wang.sdfood.activity;

import android.content.Intent;

import androidx.databinding.DataBindingUtil;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wang.sdfood.R;
import com.wang.sdfood.adapter.ActivityNewLabelAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityLabelNewWorkBinding;
import com.wang.sdfood.model.LabelNewWorkEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;


/**
 * 最新作品的activity
 * Created by user on 2016/3/11.
 */
public class LabelNewWorkActivity extends BaseActivity implements OkHttpUtil.OnDownLoadListener {
    public PullToRefreshListView pullToRefreshListView;
    private String url;
    private ActivityLabelNewWorkBinding labelNewWorkBinding;

    @Override
    protected void getViewResId() {
        labelNewWorkBinding = DataBindingUtil.setContentView(this, R.layout.activity_label_new_work);
    }

    @Override
    protected void init() {
        super.init();
        pullToRefreshListView = labelNewWorkBinding.ptrvLvNewWork;
//          R.layout.lv_label_new_work
        Intent intent = getIntent();
        url = intent.getStringExtra(Constants.KEY.NEW_LABLE_WORKS_ID);

    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(url, this);
    }

    @Override
    public void onResponse(String url, String json) {
        if (json != null) {
            /**
             * 表示数据下载成功
             */
            LabelNewWorkEntity labelNewWorkByJson = JsonUtil.getLabelNewWorkByJson(json);
            //适配器
            ActivityNewLabelAdapter activityNewLabelAdapter = new ActivityNewLabelAdapter(getApplicationContext(), labelNewWorkByJson);
            pullToRefreshListView.getRefreshableView().setAdapter(activityNewLabelAdapter);
        }
    }

    @Override
    public void onFailure(String url, String json) {

    }
}
