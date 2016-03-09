package com.wang.sdfood.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.wang.sdfood.R;
import com.wang.sdfood.activity.LoginActivity;
import com.wang.sdfood.base.BaseFragment;

import butterknife.Bind;

/**
 * 这
 * Created by user on 2016/3/4.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    //这是头像的ImageView
    @Bind(R.id.fragment_mine_login_iv)
    public ImageView imageView;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        imageView.setOnClickListener(this);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fragment_mine_login_iv){
            /**
             * 跳转到登录界面
             */
            Intent intent=new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
