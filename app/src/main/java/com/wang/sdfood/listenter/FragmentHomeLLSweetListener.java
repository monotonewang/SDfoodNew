package com.wang.sdfood.listenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.wang.sdfood.activity.FoodCommentActivity;
import com.wang.sdfood.util.Constants;

/**
 * 热门标签的跳转
 * Created by user on 2016/3/8.
 */
public class FragmentHomeLLSweetListener implements View.OnClickListener  {
    private  String TAG="print";
    private Context context;
    private String str;
    private String url_staplefood;
    public FragmentHomeLLSweetListener(Context c,String str) {
        super();
        this.str = str;

        context=c;

    }
    @Override
    public void onClick(View v) {
        url_staplefood=String.format(Constants.URL.SWEET_FOOD,str);
        //Log.e(TAG, "onClick: "+url_staplefood );
        /**
         * 甜食的跳转
         */
        Intent intent = new Intent(context, FoodCommentActivity.class);
        intent.putExtra(Constants.KEY.SWEETFOOD_KEY,url_staplefood);
        context.startActivity(intent);
    }
}
