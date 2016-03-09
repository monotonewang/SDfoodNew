package com.wang.sdfood.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.ActivityMCBookLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.CaiXiEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;

import butterknife.Bind;

/**
 * 这是菜系的Activity
 * 菜系的详情页
 * Created by Administrator on 2016/3/7.
 */
public class ActivityMCBooksList extends BaseActivity implements OkHttpUtil.OnDownLoadListener, AdapterView.OnItemClickListener {
    private String TAG = "print";
    private ActivityMCBookLVAdapter activityMoreCookBookLVAdapter;
    //菜系的URL
    private String url_caixi;
    @Bind(R.id.activity_detail_lv)
    public ListView listView;
    private List<CaiXiEntity.DataEntity> data;

    @Override
    protected int getViewResId() {
        return R.layout.activity_detail;
    }

    //初始化方法
    @Override
    protected void init() {
        super.init();
        listView.setOnItemClickListener(this);
        Intent intent = getIntent();
        //通过替换得到详细菜系的URL
        String name = intent.getStringExtra(Constants.KEY.CAIXI_KEY);
        url_caixi = String.format(Constants.URL.CAIXIURL, name);
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
        if (url.equals(url_caixi)){
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
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.equals(listView)){
            String MoreCookBookUrl = String.format(Constants.URL.MORECOOKBOOKS, Integer.valueOf(data.get(position).getId()));
                Intent intent=new Intent(this,McBookDetailActivity.class);
                intent.putExtra(Constants.KEY.MORE_BOOK_DETAIL, MoreCookBookUrl);
                startActivity(intent);
        }
    }
}
