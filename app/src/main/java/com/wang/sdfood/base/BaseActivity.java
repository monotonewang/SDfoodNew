package com.wang.sdfood.base;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


import com.wang.sdfood.R;

import butterknife.ButterKnife;

/**
 * Created by user on 2016/2/25.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG ="BaseActivity" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(getViewResId());
        ButterKnife.bind(this);
        init();
        loadDatas();

    }

    protected void init() {

    }
    protected void loadDatas() {
    }
    protected  abstract int getViewResId();
}
