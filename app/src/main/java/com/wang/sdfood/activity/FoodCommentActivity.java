package com.wang.sdfood.activity;

import android.content.Intent;
import android.widget.ListView;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.ActivityCommendFoodLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityCommentFoodBinding;
import com.wang.sdfood.model.StapleFoodEntitys;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 食物内容的列表的activity
 * Created by Administrator on 2016/3/9.
 */
public class FoodCommentActivity extends BaseActivity implements OkHttpUtil.OnDownLoadListener {
    public ListView listView;
    //传递过来的url
    private String url_sweetfood;
    //数据的list集合
    private List<StapleFoodEntitys.DataEntity> mList_stapleFood;
    //适配器
    private ActivityCommendFoodLVAdapter activityCommendFoodLVAdapter;
    private ActivityCommentFoodBinding commentFoodBinding;

    @Override
    protected void getViewResId() {
        commentFoodBinding = DataBindingUtil.setContentView(this, R.layout.activity_comment_food);
    }

    @Override
    protected void init() {
        super.init();
        listView = commentFoodBinding.lvCommenfoodlist;
        Intent intent = getIntent();
        /**
         * 甜食跳转过来的数据
         */
        url_sweetfood = intent.getStringExtra(Constants.KEY.SWEETFOOD_KEY);
        mList_stapleFood = new ArrayList<>();
        /**
         * 热门标签本周最热跳转过来的url
         */
        if (url_sweetfood == null) {
            url_sweetfood = intent.getStringExtra(Constants.KEY.NEW_LABLE_WORK_ID);
        }
        /**
         * 热门标签最新菜谱跳转过来的url
         */
        if (url_sweetfood == null) {
            url_sweetfood = intent.getStringExtra(Constants.KEY.NEW_LABLE_RECIPE_ID);
        }
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(url_sweetfood, this);
    }

    @Override
    public void onResponse(String url, String json) {
        if (url != null && url.equals(url_sweetfood)) {
            mList_stapleFood = JsonUtil.getStapleFoodByJson(json).getData();
        }
        activityCommendFoodLVAdapter = new ActivityCommendFoodLVAdapter(getApplicationContext(), mList_stapleFood);
        listView.setAdapter(activityCommendFoodLVAdapter);
    }

    @Override
    public void onFailure(String url, String json) {

    }
}
