package com.wang.sdfood.fragment;


import android.content.Intent;

import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.wang.sdfood.R;
import com.wang.sdfood.activity.MegCookDetailActivity;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.model.DiscoverEntitys;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;


/**
 * 这是发现的Fragment
 * Created by user on 2016/3/4.
 */
public class VisiableFragment extends BaseFragment implements OkHttpUtil.OnDownLoadListener, View.OnClickListener {
    //下拉刷新的ID
    public PullToRefreshScrollView pullToRefreshScrollView;
    //可视界面的容器的监听
    public LinearLayout linearLayout;
    private static final String TAG = "print";
    //绑定头部的TextView
    public TextView textView;
    public ImageView imageViews1;
    public ImageView imageViews2;
    public SimpleDraweeView simpleDraweeView;
    public List<TextView> textViews;
    public TextView textViews1;
    public TextView textViews2;
    public TextView textViews3;
    public TextView textViews4;
    private DiscoverEntitys discoverEntityByJson;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_visiable;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        pullToRefreshScrollView = view.findViewById(R.id.fragment_visible_ptrv);
        linearLayout = view.findViewById(R.id.ll_fragment_visible);
        textView = view.findViewById(R.id.fragment_msg_headview_tv);
        imageViews1 = view.findViewById(R.id.fragment_common_headview_back);
        imageViews2 = view.findViewById(R.id.fragment_common_headview_share);
        simpleDraweeView = view.findViewById(R.id.fragment_visiable_sdv);
        textViews1 = view.findViewById(R.id.fragment_visiable_goodsName);
        textViews2 = view.findViewById(R.id.fragment_visiable_briefinfo);
        textViews3 = view.findViewById(R.id.fragment_visiable_price);
        textViews4 = view.findViewById(R.id.fragment_visiable_salesCount);


        textView.setText(getResources().getString(R.string.fragment_discover_head_text));
        imageViews1.setVisibility(View.GONE);
        imageViews2.setVisibility(View.GONE);
        //对下拉刷新的操作
        pullToRefreshScrollView.getRefreshableView().setSmoothScrollingEnabled(true);
        pullToRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
//        ILoadingLayout loadingLayoutProxy = pullToRefreshScrollView.getLoadingLayoutProxy(true, false);
//        loadingLayoutProxy.setPullLabel("下拉刷新。。。");
//        loadingLayoutProxy.setRefreshingLabel("正在载入...");// 刷新时
//        loadingLayoutProxy.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
        linearLayout.setOnClickListener(this);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(Constants.URL.DISCOVER, this);
    }

    /**
     * 成功接收返回的Json数据
     *
     * @param url
     * @param json
     */
    @Override
    public void onResponse(String url, String json) {
        if (json != null) {
            discoverEntityByJson = JsonUtil.getDiscoverEntityByJson(json);
            BindItemId();
        } else {
            Log.e(TAG, "onResponse: " + "no data");
        }
    }

    private void BindItemId() {
        FrescoUtil.imageViewBind(discoverEntityByJson.getData().get(0).getGoodsImg(), simpleDraweeView);
        textViews.get(0).setText(discoverEntityByJson.getData().get(0).getGoodsName());
        textViews.get(1).setText(discoverEntityByJson.getData().get(0).getBriefInfo());
        textViews.get(2).setText(getResources().getString(R.string.fragment_discover_price) + discoverEntityByJson.getData().get(0).getPrice());
        textViews.get(2).setTextColor(getResources().getColor(R.color.colorPrimary));
        textViews.get(3).setText(discoverEntityByJson.getData().get(0).getSalesCount() + getResources().getString(R.string.fragment_discover_salecount));
        textViews.get(3).setTextColor(getResources().getColor(R.color.colorPrimary));

    }

    @Override
    public void onFailure(String url, String json) {

    }

    /**
     * LinearLayout 的点击监听
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        //跳转到厨具的详情销售页面
        Intent intent = new Intent(getContext(), MegCookDetailActivity.class);
        startActivity(intent);
    }
}
