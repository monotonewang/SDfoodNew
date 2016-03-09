package com.wang.sdfood.fragment;


import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.model.DiscoverEntitys;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;

import butterknife.Bind;

/**
 * 这是发现的Fragment
 * Created by user on 2016/3/4.
 */
public class VisiableFragment extends BaseFragment implements OkHttpUtil.OnDownLoadListener {

    private static final String TAG ="print" ;
    //绑定头部的TextView
    @Nullable
    @Bind(R.id.fragment_msg_headview_tv)
    public TextView textView;
    @Bind({R.id.fragment_common_headview_back,R.id.fragment_common_headview_share})
    public List<ImageView> imageViews;
    @Bind(R.id.fragment_visiable_sdv)
    public SimpleDraweeView simpleDraweeView;
    @Bind({R.id.fragment_visiable_goodsName,R.id.fragment_visiable_briefinfo,R.id.fragment_visiable_price,R.id.fragment_visiable_salesCount})
    public List<TextView> textViews;
    private DiscoverEntitys discoverEntityByJson;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_visiable;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        textView.setText(getResources().getString(R.string.fragment_discover_head_text));
        imageViews.get(0).setVisibility(View.GONE);
        imageViews.get(1).setVisibility(View.GONE);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(Constants.URL.DISCOVER, this);
    }

    /**
     * 成功接收返回的Json数据
     * @param url
     * @param json
     */
    @Override
    public void onResponse(String url, String json) {
        if(json!=null) {
            discoverEntityByJson = JsonUtil.getDiscoverEntityByJson(json);
            BindItemId();
        }else{
            Log.e(TAG, "onResponse: "+"no data" );
        }
    }

    private void BindItemId() {
        FrescoUtil.imageViewBind(discoverEntityByJson.getData().get(0).getGoodsImg(),simpleDraweeView);
        textViews.get(0).setText(discoverEntityByJson.getData().get(0).getGoodsName());
        textViews.get(1).setText(discoverEntityByJson.getData().get(0).getBriefInfo());
        textViews.get(2).setText(getResources().getString(R.string.fragment_discover_price)+discoverEntityByJson.getData().get(0).getPrice());
        textViews.get(2).setTextColor(getResources().getColor(R.color.colorPrimary));
        textViews.get(3).setText(discoverEntityByJson.getData().get(0).getSalesCount()+getResources().getString(R.string.fragment_discover_salecount));
        textViews.get(3).setTextColor(getResources().getColor(R.color.colorPrimary));

    }

    @Override
    public void onFailure(String url, String json) {

    }
}
