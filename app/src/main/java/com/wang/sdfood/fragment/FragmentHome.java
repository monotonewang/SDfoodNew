package com.wang.sdfood.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.adapter.FragmentHomeLVAdapter;
import com.wang.sdfood.adapter.FragmentHomeNewuserLVAdapter;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.menucustem.Menu;
import com.wang.sdfood.menucustem.MenuItem;
import com.wang.sdfood.menucustem.SlideAndDragListView;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;
import com.wang.sdfood.util.ViewFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.codeboy.android.cycleviewpager.BaseViewPager;
import me.codeboy.android.cycleviewpager.CycleViewPager;

/**
 * 整个主页上的内容，也是用户看到的
 * Created by user on 2016/3/4.
 */
public class FragmentHome extends BaseFragment implements OkHttpUtil.OnDownLoadListener, SlideAndDragListView.OnListItemClickListener, SlideAndDragListView.OnSlideListener, SlideAndDragListView.OnMenuItemClickListener {
    //ViewPager
    private CycleViewPager cycleViewPager;
    //这是sweet的View
    //这是推荐的甜点美食的数据
    private MoreCookBooksEntity.DataEntity.RecommendEntity recommend;
    //这是推荐的breakfast的LinearLayout
    private MoreCookBooksEntity.DataEntity.BreakfastEntity breakfast;
    //这是推荐的lunch的LinearLayout
    private MoreCookBooksEntity.DataEntity.LunchEntity lunch;
    //这是推荐的dinner的LinearLayout
    private MoreCookBooksEntity.DataEntity.DinnerEntity dinner;
    //这是该页面所有的TextView
    @Bind({R.id.fragment__home_sweet_recommend_tvname,R.id.fragment__home_sweet_recommend_tvdescription,R.id.fragment__home_sweet_breakfast_tvname,R.id.fragment__home_sweet_breakfast_tvdescription,R.id.fragment__home_sweet_lunch_tvname,R.id.fragment__home_sweet_lunch_tvdescription,R.id.fragment__home_sweet_dinner_tvname,R.id.fragment__home_sweet_dinner_tvdescription})
    public List<TextView> textViews;
    //这是该页面所有的simpledreewView
    @Bind({R.id.fragment__home_sweet_recommend_imageurl,R.id.fragment__home_sweet_breakfast_imageurl,R.id.fragment__home_sweet_lnuch_imageurl,R.id.fragment__home_sweet_dinner_imageurl})
    public List<SimpleDraweeView> simpleDraweeViews;

    //这是西顿厨友的TextView
    @Bind(R.id.fragment_home_newuser_user)
    public TextView newUsertextView;
    @Bind(R.id.fragment_home_newuser_recyclerview)
    public RecyclerView newUserrecyclerView;
    private static final String TAG = "WrapperAdapter";
    private SlideAndDragListView mListView;
    private Menu menu;
    private MoreCookBooksEntity moreCookBooksEntityByJson;
    private List<MoreCookBooksEntity.DataEntity.MoreCookbooksEntity> moreCookbooks;
    private List<MoreCookBooksEntity.DataEntity.AdvertsEntity> adverts;

    private FragmentHomeLVAdapter fragmentHomeLVAdapter;
    private List<MoreCookBooksEntity.DataEntity.NewUserEntity> newUser;



    @Override
    protected int getViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        mListView = (SlideAndDragListView) view.findViewById(R.id.fragment_home_sadlView);
        cycleViewPager = (CycleViewPager) getActivity().getFragmentManager().findFragmentById(R.id.cycleViewPager);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.asyncDownJSON(Constants.URL.HOMEURL, this);
    }

    /**
     * 这是添加的ListView的Menu
     */
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
        Log.e(TAG, "initUiAndListener: " + "this metho1d");
        if(moreCookbooks!=null&&moreCookBooksEntityByJson!=null){
            fragmentHomeLVAdapter = new FragmentHomeLVAdapter(getContext(),moreCookbooks);
            //ViewPager
            List<View> views = new ArrayList<View>();
            int size=adverts.size();
            Log.e(TAG, "init: "+size);
            if(adverts!=null){
                views.add(ViewFactory.getSimpleDreeView(getContext(), adverts.get(size-1).getImageUrl()));
                for (int i = 0; i < size; i++) {
                    views.add(ViewFactory.getSimpleDreeView(getContext(), adverts.get(i).getImageUrl()));
                }
                views.add(ViewFactory.getSimpleDreeView(getContext(),adverts.get(0).getImageUrl()));
            }
            // 设置循环，在调用setData方法前调用
            cycleViewPager.setCycle(true);
            // 在加载数据前设置是否循环
            cycleViewPager.setData(views);
            BaseViewPager viewPager = cycleViewPager.getViewPager();
//            viewPager.addOnPageChangeListener(this);
            //设置轮播
            cycleViewPager.setWheel(true);
            cycleViewPager .setIndicatorCenter();
            // 设置轮播时间，默认5000ms
            cycleViewPager.setTime(1000);

            //绑定sweet的Id
            BindSweetId();
            //
            newUser = moreCookBooksEntityByJson.getData().getNewUser();
            newUsertextView.setText(getResources().getString(R.string.fragment_home_newuser));
//            //recycleView的adapter
            FragmentHomeNewuserLVAdapter fragmentHomeNewuserLVAdapter=new FragmentHomeNewuserLVAdapter(getContext(),newUser);
//            //线性布局管理器
            newUserrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
            newUserrecyclerView.setAdapter(fragmentHomeNewuserLVAdapter);

            Log.e(TAG, "initUiAndListener: " + "this method");
            mListView.setMenu(menu);
            mListView.setAdapter(fragmentHomeLVAdapter);
            mListView.setOnListItemClickListener(this);
            mListView.setOnSlideListener(this);
            mListView.setOnMenuItemClickListener(this);
        }
    }

    /**
     * 绑定sweet的Id
     */
    private void BindSweetId() {
        //这是推荐的甜点美食的LinearLayout
        recommend = moreCookBooksEntityByJson.getData().getRecommend();
        //这是推荐的breakfast的LinearLayout
        breakfast = moreCookBooksEntityByJson.getData().getBreakfast();
        //这是推荐的lunch的LinearLayout
        lunch = moreCookBooksEntityByJson.getData().getLunch();
        //这是推荐的dinner的LinearLayout
        dinner = moreCookBooksEntityByJson.getData().getDinner();
        //下面开始进行设置文字和图片操作
        textViews.get(0).setText(recommend.getName());
        textViews.get(1).setText(recommend.getDescription());
        textViews.get(2).setText(breakfast.getName());
        textViews.get(3).setText(breakfast.getDescription());
        textViews.get(4).setText(lunch.getName());
        textViews.get(5).setText(lunch.getDescription());
        textViews.get(6).setText(dinner.getName());
        textViews.get(7).setText(dinner.getDescription());
        FrescoUtil.imageViewBind(recommend.getImageUrl(), simpleDraweeViews.get(0));
        FrescoUtil.imageViewBind(breakfast.getImageUrl(),simpleDraweeViews.get(1));
        FrescoUtil.imageViewBind(lunch.getImageUrl(),simpleDraweeViews.get(2));
        FrescoUtil.imageViewBind(dinner.getImageUrl(),simpleDraweeViews.get(3));
    }

    @Override
    public void onResponse(String url, String json) {
        if (json != null && url.equals(Constants.URL.HOMEURL)) {
            moreCookBooksEntityByJson = JsonUtil.getMoreCookBooksEntityByJson(json);
            //这是ViewPager的数据
            adverts=moreCookBooksEntityByJson.getData().getAdverts();
//            Log.e(TAG, "onResponse: "+moreCookBooksEntityByJson );
//            home的ListView数据
            moreCookbooks = moreCookBooksEntityByJson.getData().getMoreCookbooks();
            //这是主页的ViewPager的下载数据
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
