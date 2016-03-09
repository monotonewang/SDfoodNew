package com.wang.sdfood.activity;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;

import java.util.List;

import butterknife.Bind;

/**
 * Created by user on 2016/3/9.
 */
public class RegisterActivity extends BaseActivity {
    @Bind({R.id.activity_register_phone, R.id.activity_register_nickname, R.id.activity_register_pwd, R.id.activity_register_invitecode})
    public List<TextInputLayout> textInputLayouts;

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
