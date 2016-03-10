package com.wang.sdfood.activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.EBUserInfoEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.SQLUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 注册的Activity
 * Created by user on 2016/3/9.
 */
public class RegisterActivity extends BaseActivity {
    @Bind({R.id.activity_register_phone, R.id.activity_register_nickname, R.id.activity_register_pwd, R.id.activity_register_invitecode})
    public List<TextInputLayout> textInputLayouts;
    private String pwd;
    private String userName;
    private String phoneNum;
    private String askcode;

    @Override
    protected int getViewResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        super.init();
        editTextListener();

    }
    /**
     * TextView的监听事件
     */
    @OnClick(R.id.tv_activity_login_now)
    public void OnClick(View view){
        if(view.getId()==R.id.tv_activity_login_now){
//            L.w(pwd+"u"+userName+"p"+phoneNum);
            if(pwd==null||userName==null||phoneNum==null){
                Toast.makeText(getApplicationContext(),"手机号码和用户名和密码不能为空",Toast.LENGTH_LONG).show();
            }
            if(pwd!=null&&userName!=null&&phoneNum!=null){
                /**
                 * 跳转到主页去Fragment_mine
                 */
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra(Constants.KEY.ACTIVITY_REG_OK, Constants.KEY.ACTIVITY_REG_OK_VALUE);
                startActivity(intent);
                /**
                 * 增加数据到数据库里面
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SQLUtil.addUser(phoneNum,userName,pwd,askcode);
                    }
                });
                /**
                 * 发布数据到用户中心Fragment
                 */
                EBUserInfoEntity ebUserInfoEntity=new EBUserInfoEntity(phoneNum,userName,pwd,askcode);
                EventBus.getDefault().postSticky(ebUserInfoEntity);
            }
        }
    }
    /**
     * EditText的文本改变监听
     */
    private void editTextListener() {
        textInputLayouts.get(0).getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 11) {
                    textInputLayouts.get(0).setError(getResources().getString(R.string.activity_reg_tl_phone_error));
                    textInputLayouts.get(0).setErrorEnabled(true);
                } else {
                    phoneNum = s.toString();
                    textInputLayouts.get(0).setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputLayouts.get(1).getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 2 ||s.length() > 10) {
                    textInputLayouts.get(1).setError(getResources().getString(R.string.activity_reg_tl_nickname_error));
                    textInputLayouts.get(1).setErrorEnabled(true);
                } else {
                    userName = s.toString();
                    textInputLayouts.get(1).setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputLayouts.get(2).getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                if (str.length() < 6 || str.length() > 20) {
                    textInputLayouts.get(2).setError(getResources().getString(R.string.activity_reg_tl_pwd_error));
                    textInputLayouts.get(2).setErrorEnabled(true);
                } else {
                    pwd = str.toString();
                    textInputLayouts.get(2).setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputLayouts.get(3).getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                if (str.length() != 9) {
                    textInputLayouts.get(3).setError(getResources().getString(R.string.activity_reg_tl_ask_error));
                    textInputLayouts.get(3).setErrorEnabled(true);
                } else {
                    askcode=str.toString();
                    textInputLayouts.get(3).setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }



}
