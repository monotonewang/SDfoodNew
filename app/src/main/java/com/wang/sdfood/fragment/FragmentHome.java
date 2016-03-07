package com.wang.sdfood.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.FragmentHomeLVAdapter;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.menucustem.Menu;
import com.wang.sdfood.menucustem.MenuItem;
import com.wang.sdfood.menucustem.SlideAndDragListView;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;

/**
 * Created by user on 2016/3/4.
 */
public class FragmentHome extends BaseFragment implements OkHttpUtil.OnDownLoadListener, SlideAndDragListView.OnListItemClickListener, SlideAndDragListView.OnSlideListener, SlideAndDragListView.OnMenuItemClickListener {
    private static final String TAG = "WrapperAdapter";
    private SlideAndDragListView mListView;
    private Menu menu;
    private List<MoreCookBooksEntity.DataEntity.MoreCookbooksEntity> moreCookbooks;
    private List<MoreCookBooksEntity.DataEntity.AdvertsEntity> adverts;
    private FragmentHomeLVAdapter fragmentHomeLVAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        mListView = (SlideAndDragListView) view.findViewById(R.id.fragment_home_sadlView);

    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(Constants.URL.HOMEURL, this);
    }


    private void initMenu() {
        menu = new Menu(new ColorDrawable(Color.WHITE), false, 0);
        menu.addItem(new MenuItem.Builder().setWidth(300)//单个菜单button的宽度
                .setBackground(new ColorDrawable(Color.parseColor("#65DB9E")))//设置菜单的背景
                .setText("收藏")//set text string
                .setTextColor(Color.GRAY)//set text color
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextSize(22)//set text size
                .setTextColor(R.color.activityLVMenuWordColor)
                .build());
        menu.addItem(new MenuItem.Builder().setWidth(300)
                .setBackground(new ColorDrawable(Color.parseColor("#FE8800")))
                .setText("评论")//set text string
                .setDirection(MenuItem.DIRECTION_RIGHT)//设置方向 (默认方向为DIRECTION_LEFT)
                .setTextSize(22)//set text size
                .setTextColor(R.color.activityLVMenuWordColor)
                .build());
    }

    private void initUiAndListener() {
        if(moreCookbooks!=null&&adverts!=null){
//            AutoScrollViewPager autoScrollViewPager=new AutoScrollViewPager(getContext());
            //猜你喜欢头部控件
            fragmentHomeLVAdapter = new FragmentHomeLVAdapter(getContext(),moreCookbooks);
            View guessLike = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_guesslike, null);
            mListView.addHeaderView(guessLike);
//            Log.e(TAG, "initUiAndListener: "+"this method" );
            mListView.setMenu(menu);
            mListView.setAdapter(fragmentHomeLVAdapter);
            mListView.setOnListItemClickListener(this);
            mListView.setOnSlideListener(this);
            mListView.setOnMenuItemClickListener(this);
        }
    }

    @Override
    public void onResponse(String url, String json) {
        if (json != null && url.equals(Constants.URL.HOMEURL)) {
            MoreCookBooksEntity moreCookBooksEntityByJson = JsonUtil.getMoreCookBooksEntityByJson(json);
//            Log.e(TAG, "onResponse: "+moreCookBooksEntityByJson );
//            home的ListView数据
            moreCookbooks = moreCookBooksEntityByJson.getData().getMoreCookbooks();
            adverts = moreCookBooksEntityByJson.getData().getAdverts();
        }
        initMenu();
        initUiAndListener();
     }

    @Override
    public void onFailure(String url, String json) {

    }

    @Override
    public void onListItemClick(View v, int position) {
        Toast.makeText(getContext(), "onItemClick   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onListItemClick   " + position);
    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {
        Toast.makeText(getContext(), "onSlideOpen   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideOpen   " + position + "  direction--->" + direction);
    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {
        Toast.makeText(getContext(),  "onSlideClose   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideClose   " + position + "  direction--->" + direction);
    }

    @Override
    public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        Log.i(TAG, "onMenuItemClick   " + itemPosition + "   " + buttonPosition + "   " + direction);
        switch (direction) {
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_START_ACTIVITY;
                    case 1:
                        return Menu.ITEM_START_ACTIVITY2;
                }
        }
        return Menu.ITEM_NOTHING;
    }
}
