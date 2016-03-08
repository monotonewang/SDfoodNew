package com.wang.sdfood.listenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.wang.sdfood.FoodDetailActvity;
import com.wang.sdfood.util.Constants;

/**
 * Created by Administrator on 2016/3/8.
 */
public class ViewPagerListener implements View.OnClickListener {
    private  String TAG="print";
    private Context context;
    private int id;
    public ViewPagerListener(Context c,int i) {
        super();
        id = i;
        context=c;

    }

    @Override
    public void onClick(View view) {
        Log.e(TAG, "ViewPagerListener: " + id);
        Intent intent = new Intent(context, FoodDetailActvity.class);
        intent.putExtra(Constants.KEY.FOODNAME_ID_KEY,id);
        context.startActivity(intent);
    }
}
