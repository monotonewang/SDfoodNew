package com.wang.sdfood.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.activity.FoodCommentActivity;
import com.wang.sdfood.activity.FoodDetailActivity;
import com.wang.sdfood.activity.FoodListActivity;
import com.wang.sdfood.adapter.FragmentHomeLVAdapter;
import com.wang.sdfood.adapter.FragmentHomeNewuserLVAdapter;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.custem.mainlvcustem.Menu;
import com.wang.sdfood.custem.mainlvcustem.MenuItem;
import com.wang.sdfood.custem.mainlvcustem.SlideAndDragListView;
import com.wang.sdfood.listenter.FragmentHomeLLSweetListener;
import com.wang.sdfood.listenter.ViewPagerListener;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.model.SearchYEntity;
import com.wang.sdfood.model.SearchYEntity2;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.FrescoUtil;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;
import com.wang.sdfood.util.ViewFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import me.codeboy.android.cycleviewpager.BaseViewPager;
import me.codeboy.android.cycleviewpager.CycleViewPager;

/**
 * 整个主页上的内容，也是用户看到的
 * Created by user on 2016/3/4.
 */
public class HomeFragment extends BaseFragment implements OkHttpUtil.OnDownLoadListener, SlideAndDragListView.OnListItemClickListener, SlideAndDragListView.OnSlideListener, SlideAndDragListView.OnMenuItemClickListener, View.OnClickListener {
    //刷新的控件
    @Bind(R.id.fragment_home_srl)
    public SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.sv_fragment_home)
    public ScrollView scrollView;
    public Handler handler = new Handler();
    @Bind(R.id.tv_index)
    public TextView mTvIndex;
    //ViewPager
    private CycleViewPager cycleViewPager;
    //川菜
    @Bind(R.id.btn_chuancai)
    public TextView chuancai;
    //鲁菜
    @Bind(R.id.btn_lucai)
    public TextView lucai;
    //苏菜
    @Bind(R.id.btn_sucai)
    public TextView sucai;
    //浙菜
    @Bind(R.id.btn_zhecai)
    public TextView zhecai;
    //这是热门标签的子控件ID
    @Bind({R.id.fragment_home_hotcategries_mostPopularOfWeek_tv, R.id.fragment_home_hotcategries_newCookbook_tv, R.id.fragment_home_hotcategries_newWorks_tv, R.id.fragment_home_hotcategries_newPai_tv})
    public List<TextView> hotCategoriestv;
    @Bind({R.id.fragment_home_hotcategries_mostPopularOfWeek_sdv, R.id.fragment_home_hotcategries_newCookbook_sdv, R.id.fragment_home_hotcategries_newWorks_sdv, R.id.fragment_home_hotcategries_newPai_sdv})
    public List<SimpleDraweeView> hotCategoriessdv;

    //这是sweet的View
    //LinearLayout的布局id
    @Bind({R.id.fragment_home_sweet_sweets, R.id.fragment_home_sweet_porridge, R.id.fragment_home_sweet_hotfood, R.id.fragment_home_sweet_snacks})
    public List<LinearLayout> linearLayouts;
    //这是推荐的甜点美食的数据
    private MoreCookBooksEntity.DataEntity.RecommendEntity recommend;
    //这是推荐的breakfast的LinearLayout
    private MoreCookBooksEntity.DataEntity.BreakfastEntity breakfast;
    //这是推荐的lunch的LinearLayout
    private MoreCookBooksEntity.DataEntity.LunchEntity lunch;
    //这是推荐的dinner的LinearLayout
    private MoreCookBooksEntity.DataEntity.DinnerEntity dinner;
    //这是该页面所有的TextView
    @Bind({R.id.fragment__home_sweet_recommend_tvname, R.id.fragment__home_sweet_recommend_tvdescription, R.id.fragment__home_sweet_breakfast_tvname, R.id.fragment__home_sweet_breakfast_tvdescription, R.id.fragment__home_sweet_lunch_tvname, R.id.fragment__home_sweet_lunch_tvdescription, R.id.fragment__home_sweet_dinner_tvname, R.id.fragment__home_sweet_dinner_tvdescription})
    public List<TextView> textViews;
    //这是该页面所有的simpledreewView
    @Bind({R.id.fragment__home_sweet_recommend_imageurl, R.id.fragment__home_sweet_breakfast_imageurl, R.id.fragment__home_sweet_lnuch_imageurl, R.id.fragment__home_sweet_dinner_imageurl})
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
//        下拉刷新的监听事件
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //重新加载一次数据
                loadDatas();
                //过一秒自动关闭
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        /**
         * ScroolView监听
         */
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_MOVE:
                        int scrollY = scrollView.getScrollY();
                        int height = scrollView.getHeight();
                        int scrollViewMeasuredHeight = scrollView.getChildAt(0).getMeasuredHeight();
//                        L.e("scrollY+" + scrollY + "height" + height + "scrollViewMeasuredHeight" + scrollViewMeasuredHeight);
                        //当数到页顶的时候
                        Log.e("ssss", "c2s=" + scrollY);
                        if (scrollY == 0) {
                            SearchYEntity searchYEntity = new SearchYEntity(1);
                            EventBus.getDefault().postSticky(searchYEntity);
                        } else if (scrollY < 200 && scrollY > 100) {
                            Log.e("ssss", "c2s");
                            SearchYEntity2 searchYEntity2 = new SearchYEntity2(2);
                            EventBus.getDefault().postSticky(searchYEntity2);
                        }
                        if ((scrollY + height) == scrollViewMeasuredHeight) {
                        }
                        break;

                    default:
                        break;
                }
                return false;
            }
        });
        /**
         * 使TextView获取焦点，
         */
        mTvIndex.setFocusable(true);
        mTvIndex.setFocusableInTouchMode(true);
        mListView = (SlideAndDragListView) view.findViewById(R.id.fragment_home_sadlView);
        cycleViewPager = (CycleViewPager) getActivity().getFragmentManager().findFragmentById(R.id.cycleViewPager);
        //这是不同菜系的点击事件
        chuancai.setOnClickListener(this);
        lucai.setOnClickListener(this);
        sucai.setOnClickListener(this);
        zhecai.setOnClickListener(this);

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
        menu.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.x70))//单个菜单button的宽度
                .setBackground(new ColorDrawable(Color.parseColor("#65DB9E")))//设置菜单的背景
                .setText("收藏")//set text string
                .setTextColor(Color.GRAY)//set text color
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextSize(22)//set text size
                .setTextColor(R.color.activityLVMenuWordColor)
                .build());
        menu.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.x70))
                .setBackground(new ColorDrawable(Color.parseColor("#FE8800")))
                .setText("评论")//set text string
                .setDirection(MenuItem.DIRECTION_RIGHT)//设置方向 (默认方向为DIRECTION_LEFT)
                .setTextSize(22)//set text size
                .setTextColor(R.color.activityLVMenuWordColor)
                .build());
    }

    private void initUiAndListener() {
        Log.e(TAG, "initUiAndListener: " + "this metho1d");
        if (moreCookbooks != null && moreCookBooksEntityByJson != null) {
            fragmentHomeLVAdapter = new FragmentHomeLVAdapter(getContext(), moreCookbooks);
            //ViewPager
            BindViewPager();
            //热门标签的操作
            BindViewHotCategrories();
            //绑定sweet的Id
            BindSweetId();
            //加载视图西顿厨友的操作
            BindNewUser();
            Log.e(TAG, "initUiAndListener: " + "this method");
            mListView.setMenu(menu);
            mListView.setAdapter(fragmentHomeLVAdapter);
            mListView.setOnListItemClickListener(this);
            mListView.setOnSlideListener(this);
            mListView.setOnMenuItemClickListener(this);
        }
    }

    /**
     * 加载视图西顿厨友的操作
     */
    private void BindNewUser() {
        newUser = moreCookBooksEntityByJson.getData().getNewUser();
        newUsertextView.setText(getResources().getString(R.string.fragment_home_newuser));
//            //recycleView的adapter
        FragmentHomeNewuserLVAdapter fragmentHomeNewuserLVAdapter = new FragmentHomeNewuserLVAdapter(getContext(), newUser);
//            //线性布局管理器
        newUserrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false));
        newUserrecyclerView.setAdapter(fragmentHomeNewuserLVAdapter);
    }

    /**
     * //热门标签的操作
     */
    private void BindViewHotCategrories() {
        Log.e(TAG, "BindViewHotCategrories: " + moreCookBooksEntityByJson.getData().getMostPopularOfWeek().getDescription());
        hotCategoriestv.get(0).setText(moreCookBooksEntityByJson.getData().getMostPopularOfWeek().getDescription());
        hotCategoriestv.get(1).setText(moreCookBooksEntityByJson.getData().getNewCookbook().getDescription());
        hotCategoriestv.get(2).setText(moreCookBooksEntityByJson.getData().getNewWorks().getDescription());
        hotCategoriestv.get(3).setText(moreCookBooksEntityByJson.getData().getNewPai().getDescription());
        FrescoUtil.imageViewBind(moreCookBooksEntityByJson.getData().getMostPopularOfWeek().getImageUrl(), hotCategoriessdv.get(0));
        FrescoUtil.imageViewBind(moreCookBooksEntityByJson.getData().getNewCookbook().getImageUrl(), hotCategoriessdv.get(1));
        FrescoUtil.imageViewBind(moreCookBooksEntityByJson.getData().getNewWorks().getImageUrl(), hotCategoriessdv.get(2));
        FrescoUtil.imageViewBind(moreCookBooksEntityByJson.getData().getNewPai().getImageUrl(), hotCategoriessdv.get(3));
    }

    /**
     * 加载ViewPager的操作。
     */
    private void BindViewPager() {
        List<View> views = new ArrayList<View>();
        int size = adverts.size();
        Log.e(TAG, "init: " + size);
        View view, view1, view2;
        if (adverts != null) {
            view = new View(getActivity());
            view = ViewFactory.getSimpleDreeView(getContext(), adverts.get(size - 1).getImageUrl());

            views.add(view);
            for (int i = 0; i < size; i++) {
                view1 = new View(getActivity());
                view1 = ViewFactory.getSimpleDreeView(getContext(), adverts.get(i).getImageUrl());
                views.add(view1);
                view1.setOnClickListener(new ViewPagerListener(getActivity(), moreCookBooksEntityByJson.getData().getAdverts().get(i).getId()));
            }
            view2 = new View(getActivity());
            view2 = ViewFactory.getSimpleDreeView(getContext(), adverts.get(0).getImageUrl());
            views.add(view2);
        }
        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);
        // 在加载数据前设置是否循环
        cycleViewPager.setData(views);
        BaseViewPager viewPager = cycleViewPager.getViewPager();
//            viewPager.addOnPageChangeListener(this);
        //设置轮播
        cycleViewPager.setWheel(true);
        cycleViewPager.setIndicatorCenter();
        // 设置轮播时间，默认5000ms
        cycleViewPager.setTime(10000);
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
        FrescoUtil.imageViewBind(breakfast.getImageUrl(), simpleDraweeViews.get(1));
        FrescoUtil.imageViewBind(lunch.getImageUrl(), simpleDraweeViews.get(2));
        FrescoUtil.imageViewBind(dinner.getImageUrl(), simpleDraweeViews.get(3));
    }

    @Override
    public void onResponse(String url, String json) {
        if (json != null && url.equals(Constants.URL.HOMEURL)) {
            moreCookBooksEntityByJson = JsonUtil.getMoreCookBooksEntityByJson(json);
            //这是ViewPager的数据
            adverts = moreCookBooksEntityByJson.getData().getAdverts();
            /**
             * LinearLayout的监听--热门标签
             */
            linearLayouts.get(0).setOnClickListener(new FragmentHomeLLSweetListener(getActivity(), moreCookBooksEntityByJson.getData().getRecommend().getId()));
            linearLayouts.get(1).setOnClickListener(new FragmentHomeLLSweetListener(getActivity(), moreCookBooksEntityByJson.getData().getBreakfast().getId()));
            linearLayouts.get(2).setOnClickListener(new FragmentHomeLLSweetListener(getActivity(), moreCookBooksEntityByJson.getData().getLunch().getId()));
            linearLayouts.get(3).setOnClickListener(new FragmentHomeLLSweetListener(getActivity(), moreCookBooksEntityByJson.getData().getDinner().getId()));
//            home的ListView数据
            moreCookbooks = moreCookBooksEntityByJson.getData().getMoreCookbooks();
        }
        initMenu();
        initUiAndListener();
    }

    @Override
    public void onFailure(String url, String json) {

    }

    /**
     * 这是homeFragment的ListView的点击事件
     *
     * @param v
     * @param position
     */
    @Override
    public void onListItemClick(View v, int position) {
//        Toast.makeText(getContext(), "onItemClick   position--->" + position, Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onListItemClick   " + position);
        //跳到菜系的详情页
        Intent intent = new Intent(getContext(), FoodDetailActivity.class);
        intent.putExtra(Constants.KEY.HOME_FRAGMENT_LIST_MCBOOK_ID, moreCookBooksEntityByJson.getData().getMoreCookbooks().get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {
//        Toast.makeText(getContext(), "onSlideOpen   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideOpen   " + position + "  direction--->" + direction);
    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {
//        Toast.makeText(getContext(),  "onSlideClose   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideClose   " + position + "  direction--->" + direction);
    }

    /**
     * WrapperAdapter跳转
     *
     * @param v
     * @param itemPosition   第几个item
     * @param buttonPosition 第几个button
     * @param direction      方向
     * @return
     */
    @Override
    public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
//        Log.i(TAG, "onMenuItemClick   " + itemPosition + "   " + buttonPosition + "   " + direction);
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

    /**
     * 不同菜系的点击相应
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        String caixi_key = null;
        switch (view.getId()) {
            case R.id.btn_chuancai:
                caixi_key = moreCookBooksEntityByJson.getData().getHotCategories().get(0).getName();
                break;
            case R.id.btn_lucai:
                caixi_key = moreCookBooksEntityByJson.getData().getHotCategories().get(1).getName();
                break;
            case R.id.btn_sucai:
                caixi_key = moreCookBooksEntityByJson.getData().getHotCategories().get(2).getName();
                break;
            case R.id.btn_zhecai:
                caixi_key = moreCookBooksEntityByJson.getData().getHotCategories().get(3).getName();
                break;
        }
        Intent intent = new Intent(getActivity(), FoodListActivity.class);
        intent.putExtra(Constants.KEY.CAIXI_KEY, caixi_key);
        startActivity(intent);
    }

    @OnClick({R.id.fragment_home_hotcategries_mostPopularOfWeek_sdv, R.id.fragment_home_hotcategries_newCookbook_sdv, R.id.fragment_home_hotcategries_newWorks_sdv, R.id.fragment_home_hotcategries_newPai_sdv})
    public void onCLick(View view) {
        if (view.getId() == R.id.fragment_home_hotcategries_mostPopularOfWeek_sdv) {
            /**
             * 跳到食物内容的列表的activity
             */
            Intent intent = new Intent(getContext(), FoodCommentActivity.class);
            String newWorkUrl = String.format(Constants.URL.WEKK_HOT, Integer.valueOf(moreCookBooksEntityByJson.getData().getMostPopularOfWeek().getId()));
            intent.putExtra(Constants.KEY.NEW_LABLE_WORK_ID, newWorkUrl);
            startActivity(intent);
        } else if (view.getId() == R.id.fragment_home_hotcategries_newCookbook_sdv) {
            Intent intent = new Intent(getContext(), FoodCommentActivity.class);
            String newWorkUrl = String.format(Constants.URL.WEKK_HOT, Integer.valueOf(moreCookBooksEntityByJson.getData().getNewCookbook().getId()));
            intent.putExtra(Constants.KEY.NEW_LABLE_RECIPE_ID, newWorkUrl);
            startActivity(intent);
        } else if (view.getId() == R.id.fragment_home_hotcategries_newWorks_sdv) {

        } else if (view.getId() == R.id.fragment_home_hotcategries_newPai_sdv) {

        }
    }
}
