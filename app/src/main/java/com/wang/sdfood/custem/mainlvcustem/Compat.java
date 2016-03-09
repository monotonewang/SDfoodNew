package com.wang.sdfood.custem.mainlvcustem;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/**
 * 这个主页的ListVIew的Menu的布局主要文件
 * Created by user on 2016/3/6.
 */
public class Compat {


    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static boolean afterLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}


