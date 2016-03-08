package com.wang.sdfood;

import android.content.Intent;
import android.util.Log;

import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.util.Constants;
import com.wang.sdfood.util.OkHttpUtil;

/**
 * 菜系详情的Activity
 * Created by user on 2016/3/8.
 */
public class ActivityMcBookDetail extends BaseActivity implements OkHttpUtil.OnDownLoadListener {

    private static final String TAG = "ActivityMcBookDetail";
    private String moreBookDetailUrl;

    @Override
    protected int getViewResId() {
        return R.layout.activity_mcbook_detail;
    }

    @Override
    protected void init() {
        super.init();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(Constants.KEY.FOODNAME_ID_KEY, -1);
        /**
         * 这个是ViewPager调过来的
         */

        if (intExtra != -1) {
            moreBookDetailUrl = String.format(Constants.URL.MORECOOKBOOKS, intExtra);
        } else {
            /**
             * 这个是菜系跳过的
             */
            moreBookDetailUrl = intent.getStringExtra(Constants.KEY.MORE_BOOK_DETAIL);
        }
        Log.e(TAG, "moreBookDetailUrl:" + moreBookDetailUrl + "id=" + intExtra);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        if (moreBookDetailUrl != null) {
            OkHttpUtil.asyncDownJSON(moreBookDetailUrl, this);
        }

    }

    @Override
    public void onResponse(String url, String json) {
        Log.e(TAG, "onResponse: " + json);
    }

    @Override
    public void onFailure(String url, String json) {

    }
}
