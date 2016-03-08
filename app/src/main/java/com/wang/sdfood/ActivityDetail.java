package com.wang.sdfood;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wang.sdfood.adapter.ActivityDetailLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.CaiXi;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import butterknife.Bind;

/**
 * 菜系的详情页
 * Created by Administrator on 2016/3/7.
 */
public class ActivityDetail extends BaseActivity implements OkHttpUtil.OnDownLoadListener, AdapterView.OnItemClickListener {
    private String  TAG="print";
    private ActivityDetailLVAdapter activityDetailLVAdapter;
    //菜系的实体类
    private CaiXi caixi;
    //菜系的URL
    private String url_caixi ;
    @Bind(R.id.activity_detail_lv)
    public ListView listView;
    @Override
    protected int getViewResId() {
        return R.layout.activity_detail;
    }
    //初始化方法
    @Override
    protected void init() {
        super.init();
        Intent intent = getIntent();
        //通过替换得到详细菜系的URL
        String name = intent.getStringExtra(Constants.KEY.CAIXI_KEY);
        url_caixi = String.format(Constants.URL.CAIXIURL,name);
        Log.e(TAG, "init: "+url_caixi );


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
        Log.e(TAG, "onResponse: "+url );
        Log.e(TAG, "onResponse: "+json );
       // if (url.equals(url_caixi)){
            caixi = JsonUtil.getCaiXIByJson(json);
            Log.e(TAG, "onResponse: "+caixi );
     //   }
        // 给listView设置适配器
        activityDetailLVAdapter=new ActivityDetailLVAdapter(this,caixi.getData());
        listView.setAdapter(activityDetailLVAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onFailure(String url, String json) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e(TAG, "onItemClick: "+i );
    }
}
