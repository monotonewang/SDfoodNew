package com.wang.sdfood.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;

import butterknife.Bind;

/**
 * 这是厨具的详情activity
 * Created by user on 2016/3/10.
 */
public class MegCookDetailActivity extends BaseActivity implements View.OnClickListener {
    //立即购买的textView
    @Bind(R.id.tv_activity_megcook_detail_buy)
    public TextView textView;
    private PopupWindow mPopupWindow;

    @Override
    protected int getViewResId() {
        return R.layout.activity_megcook_detail;
    }

    @Override
    protected void init() {
        super.init();
        textView.setOnClickListener(this);

        initPopoupWindow();
    }

    /**
     * 加载布局文件
     */
    private void initPopoupWindow() {
        View view = getLayoutInflater().inflate(R.layout.buy_popupwindow, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_buy_popup_window);
        TextView textView1 = (TextView) view.findViewById(R.id.tv_buy_sure1);
        textView1.setOnClickListener(this);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 400, true);

        ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
        mPopupWindow.setBackgroundDrawable(colorDrawable);
        mPopupWindow.setTouchable(true);
        // 设置空白区域取消PopupWindow
        mPopupWindow.setOutsideTouchable(true);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }

    /**
     * 点击立即购买的跳转方法
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_activity_megcook_detail_buy) {
            if (mPopupWindow == null) {
                initPopoupWindow();
            } else {

                mPopupWindow.showAsDropDown(v, Gravity.CENTER, 0, 0);

            }
        } else if (v.getId() == R.id.tv_buy_sure1) {
            //跳转到支付宝支付页面确认
            Intent intent=new Intent(getApplicationContext(),PayWaysActivity.class);
            startActivity(intent);
        }
    }

    // 处理返回键事件
    @Override
    public void onBackPressed() {
        //
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
        super.onBackPressed();
    }

    //  处理按键的按下事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 如果按返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断是否为空，并且显示了
            if (mPopupWindow != null && mPopupWindow.isShowing()) {
                // 取消mPopupWindow显示
                mPopupWindow.dismiss();
                mPopupWindow = null;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
