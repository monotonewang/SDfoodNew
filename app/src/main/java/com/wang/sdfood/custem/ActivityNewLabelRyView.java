package com.wang.sdfood.custem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by user on 2016/3/11.
 */
public class ActivityNewLabelRyView extends RecyclerView {
    public ActivityNewLabelRyView(Context context) {
        super(context);
    }

    public ActivityNewLabelRyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

        @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, height);
    }
}
