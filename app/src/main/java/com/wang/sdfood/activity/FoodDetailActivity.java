package com.wang.sdfood.activity;

import android.content.Intent;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.ActivityMegcookIngredientsLVAdapter;
import com.wang.sdfood.adapter.ActivitymegcookDetailAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.custem.ActivityMegbookLVView;
import com.wang.sdfood.databinding.ActivityFoodDetailBinding;
import com.wang.sdfood.model.MoreCookBookDetailEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.JsonUtil;
import com.wang.sdfood.util.OkHttpUtil;

import java.util.List;


/**
 * 菜系详情的Activity
 * Created by user on 2016/3/8.
 * http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbookDetails&id=1506
 */
public class FoodDetailActivity extends BaseActivity implements OkHttpUtil.OnDownLoadListener {

    private static final String TAG = "print";
    //    public List<ActivityMegbookLVView> activityMegbookLVView;
    ActivityMegbookLVView m1;
    ActivityMegbookLVView m2;
    /**
     * 这是制作步骤的TextView
     */
    TextView t1;
    TextView t2;
    private String moreBookDetailUrl;
    /**
     * 这是菜系详情的所有数据
     */
    private MoreCookBookDetailEntity moreCookBookDetailByJson;
    private ActivityFoodDetailBinding foodDetailBinding;

    @Override
    protected void getViewResId() {
        foodDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_food_detail);
    }

    @Override
    protected void init() {
        super.init();
        m1 = foodDetailBinding.activityMcbookDetailStepsFootDetailLv;
        m2 = foodDetailBinding.activityMcbookDetailStepsLv;
        t1 = foodDetailBinding.guess.fragmentHomeGlTv1;
        t2 = foodDetailBinding.guess.fragmentHomeGlTv2;
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(Constants.KEY.FOODNAME_ID_KEY, -1);
        /**
         * 这个是ViewPager调过来的
         */

        if (intExtra != -1) {
            moreBookDetailUrl = String.format(Constants.URL.MORECOOKBOOKS, intExtra);
        } else {
            /**
             * 这个是菜系跳过的
             */
            moreBookDetailUrl = intent.getStringExtra(Constants.KEY.MORE_BOOK_DETAIL);
            /**
             * 这是homeFragment调过来的
             */
            if (moreBookDetailUrl == null) {
                moreBookDetailUrl = String.format(Constants.URL.MORECOOKBOOKS, Integer.valueOf(intent.getStringExtra(Constants.KEY.HOME_FRAGMENT_LIST_MCBOOK_ID)));
            }
        }
        /**
         * 设置TextView的字
         */
        t1.setText(getResources().getString(R.string.activity_megbook_detail_steps_production_steps));
        t2.setText(getResources().getString(R.string.activity_megbook_detail_steps_production_steps_big));
//        Log.e(TAG, "moreBookDetailUrl:" + moreBookDetailUrl + "id=" + intExtra);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        if (moreBookDetailUrl != null) {
            OkHttpUtil.asyncDownJSON(moreBookDetailUrl, this);
        }

    }

    @Override
    public void onResponse(String url, String json) {
//        Log.e(TAG, "onResponse: " + json);
        moreCookBookDetailByJson = JsonUtil.getMoreCookBookByJson(json);
        //做菜需要的材料的数据
        List<MoreCookBookDetailEntity.DataEntity.IngredientsEntity> ingredients = moreCookBookDetailByJson.getData().getIngredients();
        ActivityMegcookIngredientsLVAdapter activityMegcookIngredientsLVAdapter = new ActivityMegcookIngredientsLVAdapter(this);
        m1.setAdapter(activityMegcookIngredientsLVAdapter);
        m1.setDividerHeight(0);
        activityMegcookIngredientsLVAdapter.setDatas(ingredients);
        //做菜步骤 的List数据
        List<MoreCookBookDetailEntity.DataEntity.MakingStepsEntity> makingSteps = moreCookBookDetailByJson.getData().getMakingSteps();
        ActivitymegcookDetailAdapter activitymegcookDetailAdapter = new ActivitymegcookDetailAdapter(this);
        m2.setAdapter(activitymegcookDetailAdapter);
        activitymegcookDetailAdapter.setDatas(makingSteps);
    }

    @Override
    public void onFailure(String url, String json) {

    }
}
