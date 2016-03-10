package com.wang.sdfood.activity;

import android.view.View;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;

import java.util.List;

import butterknife.Bind;

/**
 * 用户菜谱的页面
 * 这是Fragment-mine-菜谱ListView你跳转的Activity
 * Created by user on 2016/3/10.
 */
public class UserRecipeActivity extends BaseActivity {
    @Bind({R.id.fragment_login_headview_tv,R.id.activity_login_region_textView})
    public List<TextView> textView;
    @Override
    protected int getViewResId() {
        return R.layout.activity_recipe;
    }

    @Override
    protected void init() {
        super.init();
        //跳转过来显示的头部的文字
//        Intent intent = getIntent();
//        intent.getStringExtra();
        //把右边的字隐藏掉
        textView.get(1).setVisibility(View.GONE);
    }
}
