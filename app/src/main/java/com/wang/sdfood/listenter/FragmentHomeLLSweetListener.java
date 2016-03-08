package com.wang.sdfood.listenter;

import android.content.Context;
import android.view.View;

/**
 * Created by user on 2016/3/8.
 */
public class FragmentHomeLLSweetListener implements View.OnClickListener  {
    private  String TAG="print";
    private Context context;
    private String str;
    public FragmentHomeLLSweetListener(Context c,String str) {
        super();
        this.str = str;
        context=c;

    }
    @Override
    public void onClick(View v) {

    }
}
