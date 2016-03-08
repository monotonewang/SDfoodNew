package com.wang.sdfood.custem;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by user on 2016/3/8.
 */
public class ActivityMegbookLVView extends ListView {
    public ActivityMegbookLVView(Context context) {
        super(context);
    }

    public ActivityMegbookLVView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, height);
    }
}
