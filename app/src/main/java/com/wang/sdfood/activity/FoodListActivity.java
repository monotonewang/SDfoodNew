package com.wang.sdfood.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.ActivityMCBookLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.custem.AcitvityCaixiHeadView;
import com.wang.sdfood.databinding.ActivityFoodListBinding;
import com.wang.sdfood.model.CaiXiEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;


/**
 * 这是菜系列表的Activity
 * Created by Administrator on 2016/3/7.
 */
public class FoodListActivity extends BaseActivity implements OkHttpUtil.OnDownLoadListener, AdapterView.OnItemClickListener {
    private String TAG = "print";
    private ActivityMCBookLVAdapter activityMoreCookBookLVAdapter;
    //菜系的URL
    private String url_caixi;
    public ListView listView;
    private List<CaiXiEntity.DataEntity> data;
    private ActivityFoodListBinding foodListBinding;

    @Override
    protected void getViewResId() {
        foodListBinding = DataBindingUtil.setContentView(this, R.layout.activity_food_list);
    }

    //初始化方法
    @Override
    protected void init() {
        super.init();
        listView = foodListBinding.activityDetailLv;
        listView.setOnItemClickListener(this);
        Intent intent = getIntent();
        //通过替换得到详细菜系的URL
        String name = intent.getStringExtra(Constants.KEY.CAIXI_KEY);
        url_caixi = String.format(Constants.URL.CAIXIURL, name);
        /**
         * 给ListView添加一个头部
         */
        listView.addHeaderView(new AcitvityCaixiHeadView(getApplicationContext()));
//        Log.e(TAG, "init: "+url_caixi );
    }

    //下载数据
    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(url_caixi, this);
        // 给listView设置适配器
    }

    //解析数据
    @Override
    public void onResponse(String url, String json) {
//        Log.e(TAG, "onResponse: "+url );
//        Log.e(TAG, "onResponse: "+json );
        if (url.equals(url_caixi)) {
            data = JsonUtil.getCaiXIByJson(json).getData();
//            Log.e(TAG, "onResponse: "+caixi );
        }
        // 给listView设置适配器
        activityMoreCookBookLVAdapter = new ActivityMCBookLVAdapter(this, data);
        listView.setAdapter(activityMoreCookBookLVAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onFailure(String url, String json) {

    }

    /**
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.equals(listView)) {
            String MoreCookBookUrl = String.format(Constants.URL.MORECOOKBOOKS, Integer.valueOf(data.get(position).getId()));
            Intent intent = new Intent(this, FoodDetailActivity.class);
            intent.putExtra(Constants.KEY.MORE_BOOK_DETAIL, MoreCookBookUrl);
            startActivity(intent);
        }
    }
}
