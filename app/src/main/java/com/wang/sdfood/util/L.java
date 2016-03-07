package com.wang.sdfood.util;

import android.util.Log;

/**
 * Created by user on 2016/3/3.
 */
public class L {
    private static final String TAG = "TAG";
    private static final int ALL = 7;
    private static final int VERBOSE = 6;
    private static final int DEBUG = 5;
    private static final int INFO = 4;
    private static final int WARM = 3;
    private static final int ERROR = 2;
    private static final int ASSERT = 1;

    private static final int SHOW_LEVEL=ALL;

    public static void v(String msg) {
        if(SHOW_LEVEL>VERBOSE){
            Log.v(TAG, msg);
        }
    }
    public static void d(String msg) {
        if(SHOW_LEVEL>DEBUG){
            Log.d(TAG, msg);
        }
    }
    public static void i(String msg) {
        if(SHOW_LEVEL>INFO){
            Log.i(TAG, msg);
        }
    }
    public static void w(String msg) {
        if(SHOW_LEVEL>WARM){
            Log.w(TAG, msg);
        }
    }
    public static void e(String msg) {
        if(SHOW_LEVEL>ERROR){
            Log.e(TAG, msg);
        }
    }
    public static void a(String msg) {
        if(SHOW_LEVEL>ASSERT){
            Log.e(TAG, msg);
        }
    }
}
