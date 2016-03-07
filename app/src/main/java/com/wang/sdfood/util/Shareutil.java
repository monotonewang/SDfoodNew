package com.wang.sdfood.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 2016/3/3.
 */
public class Shareutil {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static String CityFileName = "FoodStreetConfig";

    //初始化共享参数
    public static void initShared(Context context) {
        sharedPreferences = context.getSharedPreferences(CityFileName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //保存城市的名称
    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    //获取城市名称
    public static String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    //保存城市的Id
    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    //获取城市Id
    public static int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    //写入boolean类型的值
    public static void putWelcomeBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    //获取boolean类型的值
    public static boolean getWelocomeBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}
