package com.wang.sdfood.activity;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityRecipeBinding;

import java.util.List;


/**
 * 用户菜谱的页面
 * 这是Fragment-mine-菜谱ListView你跳转的Activity
 * Created by user on 2016/3/10.
 */
public class UserRecipeActivity extends BaseActivity {
    private ActivityRecipeBinding recipeBinding;

    @Override
    protected void getViewResId() {
        recipeBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipe);
    }

    @Override
    protected void init() {
        super.init();
        //跳转过来显示的头部的文字
//        Intent intent = getIntent();
//        intent.getStringExtra();
        //把右边的字隐藏掉
        recipeBinding.head3.activityLoginRegionTextView.setVisibility(View.GONE);
    }
}
