package com.wang.sdfood.custem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.wang.sdfood.R;

/**
 * 菜系详情的HeadView
 * Created by user on 2016/3/10.
 */
public class AcitvityCaixiHeadView extends LinearLayout {
    public AcitvityCaixiHeadView(Context context) {
        super(context);
        init();
    }

    public AcitvityCaixiHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_caixi_headview,this,true);
    }

}
