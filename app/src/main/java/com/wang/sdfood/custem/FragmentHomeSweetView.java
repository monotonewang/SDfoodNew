package com.wang.sdfood.custem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.util.FrescoUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 这是主页的FragmentHome的甜点的美食
 * Created by user on 2016/3/7.
 */

public class FragmentHomeSweetView extends LinearLayout {
    //这是推荐的甜点美食的数据
    private MoreCookBooksEntity.DataEntity.RecommendEntity recommend;
    //这是推荐的breakfast的LinearLayout
    private MoreCookBooksEntity.DataEntity.BreakfastEntity breakfast;
    //这是推荐的lunch的LinearLayout
    private MoreCookBooksEntity.DataEntity.LunchEntity lunch;
    //这是推荐的dinner的LinearLayout
    private MoreCookBooksEntity.DataEntity.DinnerEntity dinner;
    private MoreCookBooksEntity moreCookBooksEntityByJson;
    //这是该页面所有的TextView
    @Bind({R.id.fragment__home_sweet_recommend_tvname,R.id.fragment__home_sweet_recommend_tvdescription,R.id.fragment__home_sweet_breakfast_tvname,R.id.fragment__home_sweet_breakfast_tvdescription,R.id.fragment__home_sweet_lunch_tvname,R.id.fragment__home_sweet_lunch_tvdescription,R.id.fragment__home_sweet_dinner_tvname,R.id.fragment__home_sweet_dinner_tvdescription})
    public List<TextView> textViews;
    //这是该页面所有的simpledreewView
    @Bind({R.id.fragment__home_sweet_recommend_imageurl,R.id.fragment__home_sweet_breakfast_imageurl,R.id.fragment__home_sweet_lnuch_imageurl,R.id.fragment__home_sweet_dinner_imageurl})
    public List<SimpleDraweeView> simpleDraweeViews;
    public FragmentHomeSweetView(Context context, MoreCookBooksEntity moreCookBooksEntityByJson) {
        super(context);
        this.moreCookBooksEntityByJson=moreCookBooksEntityByJson;
        init();
    }


   /* public FragmentHomeSweetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }*/

    public FragmentHomeSweetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
       LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_sweet, this, true);
        //表示绑定当前的SweetView
        ButterKnife.bind(this);
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
}
