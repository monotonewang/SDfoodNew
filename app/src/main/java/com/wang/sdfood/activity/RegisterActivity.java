package com.wang.sdfood.activity;

import android.content.Intent;

import com.google.android.material.textfield.TextInputLayout;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityRegisterBinding;
import com.wang.sdfood.model.EBUserInfoEntity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.SQLUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


/**
 * 注册的Activity
 * Created by user on 2016/3/9.
 */
public class RegisterActivity extends BaseActivity {
    public List<TextInputLayout> textInputLayouts;
    TextInputLayout t1;
    TextInputLayout t2;
    TextInputLayout t3;
    TextInputLayout t4;
    private String pwd;
    private String userName;
    private String phoneNum;
    private String askcode;
    private ActivityRegisterBinding registerBinding;

    @Override
    protected void getViewResId() {
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
    }

    @Override
    protected void init() {
        super.init();
        t1 = registerBinding.activityRegisterPhone;
        t2 = registerBinding.activityRegisterNickname;
        t3 = registerBinding.activityRegisterPwd;
        t4 = registerBinding.activityRegisterInvitecode;
        editTextListener();
        registerBinding.tvActivityLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwd == null || userName == null || phoneNum == null) {
                    Toast.makeText(getApplicationContext(), "手机号码和用户名和密码不能为空", Toast.LENGTH_LONG).show();
                }
                if (pwd != null && userName != null && phoneNum != null) {
                    /**
                     * 跳转到主页去Fragment_mine
                     */
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(Constants.KEY.ACTIVITY_REG_OK, Constants.KEY.ACTIVITY_REG_OK_VALUE);
                    startActivity(intent);
                    /**
                     * 增加数据到数据库里面
                     */
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SQLUtil.addUser(phoneNum, userName, pwd, askcode);
                        }
                    });
                    /**
                     * 发布数据到用户中心Fragment
                     */
                    EBUserInfoEntity ebUserInfoEntity = new EBUserInfoEntity(phoneNum, userName, pwd, askcode);
                    EventBus.getDefault().postSticky(ebUserInfoEntity);
                }
            }
        });
    }

    /**
     * EditText的文本改变监听
     */
    private void editTextListener() {
        t1.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 11) {
                    t1.setError(getResources().getString(R.string.activity_reg_tl_phone_error));
                    t1.setErrorEnabled(true);
                } else {
                    phoneNum = s.toString();
                    t1.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t2.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 2 || s.length() > 10) {
                    t2.setError(getResources().getString(R.string.activity_reg_tl_nickname_error));
                    t2.setErrorEnabled(true);
                } else {
                    userName = s.toString();
                    t2.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t3.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                if (str.length() < 6 || str.length() > 20) {
                    t3.setError(getResources().getString(R.string.activity_reg_tl_pwd_error));
                    t3.setErrorEnabled(true);
                } else {
                    pwd = str.toString();
                    t3.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t4.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                if (str.length() != 9) {
                    t4.setError(getResources().getString(R.string.activity_reg_tl_ask_error));
                    t4.setErrorEnabled(true);
                } else {
                    askcode = str.toString();
                    t4.setErrorEnabled(false);
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
