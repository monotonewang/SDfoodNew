package com.wang.sdfood.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.LoginETEntitys;
import com.wang.sdfood.util.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by user on 2016/3/9.
 */
public class LoginActivity extends BaseActivity {
    //头部的两个TextView--第二个是注册
    @Bind({R.id.fragment_login_headview_tv1,R.id.activity_login_region_textView})
    public List<TextView> textViews;
    //EditText的id
    @Bind({R.id.ll_activity_login_et,R.id.ll_activity_login_et_pwd})
    public List<EditText> editTexts;
    @Override
    protected int getViewResId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tv_activity_login_now,R.id.activity_login_region_textView})
    public void  OnClick(View v){
        L.e("click");
        /**
         * 如果EditText为空 ，设置立即登录 按钮不可以点击
         */
        if(v.getId()==R.id.tv_activity_login_now){
            if(TextUtils.isEmpty(editTexts.get(0).getText())&&TextUtils.isEmpty(editTexts.get(1).getText())){
                TextView textView= (TextView) v;
                textView.setClickable(false);
            }else{

            }
            //如果点击的是注册--跳转到注册界面
        }else if(v.getId()==R.id.activity_login_region_textView){
            L.e("reg");
            Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void init() {
        super.init();
        //设置头部的字体
        textViews.get(0).setText(getResources().getString(R.string.activity_login_head_mid_text));
        textViews.get(1).setText(getResources().getString(R.string.activity_login_region_tv));
        /**
         * lv处理
         */
//        List<LoginETEntitys> list = getListByResource();
//        ActivityLoginAdapter activityLoginAdapter=new ActivityLoginAdapter(getApplicationContext(),list);
//        listView.setAdapter(activityLoginAdapter);
    }

    /**
     * 添加数据
     * @return
     */
    private List<LoginETEntitys> getListByResource() {
        List<LoginETEntitys> list = new ArrayList<>();
        String string = getResources().getString(R.string.activity_login_num_tv);
        String string1 = getResources().getString(R.string.activity_login_pwd_tv);
        String string2 = getResources().getString(R.string.activity_login_et_number);
        String string3 = getResources().getString(R.string.activity_login_et_pwd);
        LoginETEntitys loginETEntitys = new LoginETEntitys(string, string2);
        LoginETEntitys loginETEntitys1 = new LoginETEntitys(string1, string3);
        list.add(loginETEntitys);
        list.add(loginETEntitys1);
        return list;
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }


}
