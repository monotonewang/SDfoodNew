package com.wang.sdfood.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;



/**
 * Created by user on 2016/2/25.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG ="BaseActivity" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        getViewResId();
        init();
        loadDatas();

    }

    protected void init() {

    }
    protected void loadDatas() {
    }
    protected  abstract void getViewResId();
}
