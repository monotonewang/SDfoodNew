package com.wang.sdfood;

import android.content.Intent;
import android.widget.ListView;

import com.wang.sdfood.adapter.ActivityCommendFoodLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.StapleFoodEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/9.
 */
public class ActivityCommendFood extends BaseActivity implements OkHttpUtil.OnDownLoadListener {
    @Bind(R.id.lv_commenfoodlist)
    public ListView listView;
//传递过来的url
    private String url_sweetfood;
    //数据的list集合
    private List<StapleFoodEntity.DataEntity> mList_stapleFood;
    //适配器
   private ActivityCommendFoodLVAdapter activityCommendFoodLVAdapter;
    @Override
    protected int getViewResId() {
        return R.layout.activity_commenfood;
    }

    @Override
    protected void init() {
        super.init();
        Intent intent = getIntent();
        url_sweetfood=intent.getStringExtra(Constants.KEY.SWEETFOOD_KEY);
        mList_stapleFood = new ArrayList<>();

    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
       OkHttpUtil.asyncDownJSON(url_sweetfood,this);
    }

    @Override
    public void onResponse(String url, String json) {
        if (url!=null&&url.equals(url_sweetfood)){
            mList_stapleFood  =  JsonUtil.getStapleFoodByJson(json).getData();
        }
        activityCommendFoodLVAdapter = new ActivityCommendFoodLVAdapter(this,mList_stapleFood);
        listView.setAdapter(activityCommendFoodLVAdapter);
    }

    @Override
    public void onFailure(String url, String json) {

    }
}
