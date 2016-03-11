package com.wang.sdfood.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.zxing.client.android.Intents;
import com.wang.sdfood.R;
import com.wang.sdfood.adapter.FragmentMsgLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.fragment.HomeFragment;
import com.wang.sdfood.fragment.MineFragment;
import com.wang.sdfood.fragment.MsgFragment;
import com.wang.sdfood.fragment.VisiableFragment;
import com.wang.sdfood.model.EBUserInfoEntity;
import com.wang.sdfood.model.FragmentMsgEntity;
import com.wang.sdfood.model.SearchYEntity;
import com.wang.sdfood.model.SearchYEntity2;
import com.wang.sdfood.util.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    //这是搜索框的父布局
    @Bind(R.id.fragment_search)
    public LinearLayout mLinearLayout;
    @Bind(R.id.fragment_search_qrcode)
    public ImageView mQRCode;
    //这是抽屉布局的用户头像
    public ImageView mImageView;
    //这是抽屉布局的用户名
    public TextView mTextView;
    @Bind(R.id.activiy_home_radiogp)
    public RadioGroup radioGroup;
    @Bind({R.id.activiy_radiobtn_home, R.id.activiy_radiobtn_visible, R.id.activiy_radiobtn_msg, R.id.activiy_radiobtn_mine})
    public List<RadioButton> radioButtonList;
    //找到NavView的ID
    @Bind(R.id.activity_main_dl_nav)
    public NavigationView navigationView;
    @Bind(R.id.activity_main_dl_nav_lv)
    public ListView listView;
    //找到Nfab的ID
    @Bind(R.id.activty_main_fab)
    public FloatingActionButton floatingActionButton;
    private Fragment fragmentHome, fragmentVisible, fragmentMsg, fragmentMine;
    private FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction beginTransaction;
    //用户名
    private String nickName;

    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    /**
     * 注册事件
     */
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        if (nickName != null) {
            Log.e("a", nickName);
//            mTextView.setText(nickName);
//            mImageView.setImageResource(R.drawable.ic_social_share_120_qq);
        }
    }

    @Subscribe(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void ab(EBUserInfoEntity ebUserInfoEntity) {
        nickName = ebUserInfoEntity.getNickName();
    }

    /**
     * 搜索框上滑的方法
     * @param searchYEntity
     */
    @Subscribe(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void scroolUp(SearchYEntity searchYEntity) {
        if (searchYEntity.getI() == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -300);
            translateAnimation.setDuration(200);
            translateAnimation.setFillAfter(true);
            mLinearLayout.startAnimation(translateAnimation);
//            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.activityBottomTextCheckColor));
        }
    }

    /**
     * 搜索框下滑的方法
     * @param searchYEntity2
     */
    @Subscribe(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void scrollDown(SearchYEntity2 searchYEntity2) {
        if (searchYEntity2.getI() == 2) {
            /**
             *相对移动位置
             */
            TranslateAnimation translateAnimationa = new TranslateAnimation(0,0, -200, 0);
            translateAnimationa.setDuration(200);
//            translateAnimationa.setFillAfter(true);
            mLinearLayout.startAnimation(translateAnimationa);
//            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.activityLVMenuWordColor));
        }
    }

    /**
     * 消除事件
     */
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void init() {
        super.init();
        mImageView = (ImageView) findViewById(R.id.activity_main_dl_headview_iv1);
        mTextView = (TextView) findViewById(R.id.activity_main_dl_headview_tv);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentHome = new HomeFragment();
        fragmentVisible = new VisiableFragment();
        fragmentMsg = new MsgFragment();
        fragmentMine = new MineFragment();
        radioButtonList.get(0).setChecked(true);
        beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_main_fl, fragmentHome);
        beginTransaction.add(R.id.activity_main_fl, fragmentVisible);
        beginTransaction.add(R.id.activity_main_fl, fragmentMsg);
        beginTransaction.add(R.id.activity_main_fl, fragmentMine);
        beginTransaction.commit();

        mQRCode.setOnClickListener(this);
        /**
         * 刷新控件的监听方法
         */
//
        //设置ListView的监听
        listView.setOnItemClickListener(this);
        /**
         * 接受注册成功界面返回的值/并且显示第三个页面
         */
        Intent intent = getIntent();
        int registerOk = intent.getIntExtra(Constants.KEY.ACTIVITY_REG_OK, -1);
        if (registerOk != -1) {
            radioButtonList.get(registerOk).setChecked(true);
        }
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        List<FragmentMsgEntity> list = getListByResource();
        FragmentMsgLVAdapter fragmentMsgLVAdapter = new FragmentMsgLVAdapter(this, list);
        listView.setAdapter(fragmentMsgLVAdapter);
    }

    /**
     * 这是抽屉布局的List菜单
     *
     * @return
     */
    private List<FragmentMsgEntity> getListByResource() {
        List<FragmentMsgEntity> list = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_document);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_star);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_private);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_sensor);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_settings);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arrow);
        String string = getResources().getString(R.string.activity_main_dl_menu_doucument);
        String string1 = getResources().getString(R.string.activity_main_dl_menu_star);
        String string2 = getResources().getString(R.string.activity_main_dl_menu_private);
        String string3 = getResources().getString(R.string.activity_main_dl_menu_sensor);
        String string4 = getResources().getString(R.string.activity_main_dl_menu_settings);
        FragmentMsgEntity fragmentMsgEntity = new FragmentMsgEntity(bitmap, string, bitmap5);
        FragmentMsgEntity fragmentMsgEntity1 = new FragmentMsgEntity(bitmap1, string1, bitmap5);
        FragmentMsgEntity fragmentMsgEntity2 = new FragmentMsgEntity(bitmap2, string2, bitmap5);
        FragmentMsgEntity fragmentMsgEntity3 = new FragmentMsgEntity(bitmap3, string3, bitmap5);
        FragmentMsgEntity fragmentMsgEntity4 = new FragmentMsgEntity(bitmap4, string4, bitmap5);
        list.add(fragmentMsgEntity);
        list.add(fragmentMsgEntity1);
        list.add(fragmentMsgEntity2);
        list.add(fragmentMsgEntity3);
        list.add(fragmentMsgEntity4);
        return list;
    }

    /**
     * 这是跳转不同的Fragment的方法
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.activiy_radiobtn_home:
                /**
                 * 显示搜索框
                 */
                mLinearLayout.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                fragmentTransactionHome.show(fragmentHome)
                        .hide(fragmentVisible)
                        .hide(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_visible:
                /**
                 * 隐藏搜索框
                 */
                mLinearLayout.setVisibility(View.GONE);
                FragmentTransaction fragmentTransactionMatch = getSupportFragmentManager().beginTransaction();
                fragmentTransactionMatch.hide(fragmentHome)
                        .show(fragmentVisible)
                        .hide(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_msg:
                mLinearLayout.setVisibility(View.GONE);
                FragmentTransaction fragmentTransactionItem = getSupportFragmentManager().beginTransaction();
                fragmentTransactionItem.hide(fragmentHome)
                        .hide(fragmentVisible)
                        .show(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_mine:
                mLinearLayout.setVisibility(View.GONE);
                FragmentTransaction fragmentTransactionCart = getSupportFragmentManager().beginTransaction();
                fragmentTransactionCart.hide(fragmentHome)
                        .hide(fragmentVisible)
                        .hide(fragmentMsg)
                        .show(fragmentMine)
                        .commit();
                break;

        }
    }

    /**
     * 抽屉布局的ListView的监听事件处理
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.equals(listView)) {
            Log.e(TAG, "onItemClick: " + position);
        }
    }

    @Override
    public void onClick(View v) {
        //这里是跳转二维码的代码
        if (v.getId() == R.id.fragment_search_qrcode) {
            Intent intent = new Intent(Intents.Scan.ACTION);
            intent.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);
            //设置扫描预览框的宽高，建议根据屏幕宽高来设置：
            DisplayMetrics displayMetrics =
                    getResources().getDisplayMetrics();

            int w = displayMetrics.widthPixels;
            int h = displayMetrics.heightPixels;
            int size = h < w ? h : w;
            size = size >> 1;
            intent.putExtra(Intents.Scan.WIDTH, size);
            intent.putExtra(Intents.Scan.HEIGHT, size);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivityForResult(intent, 0x001);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x001) {
            // 0x001 代表的 startActivityForResule
            if (resultCode == RESULT_OK && data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
//                String code = data.getStringExtra(Intents.Scan.RESULT);
            }
        }
    }
}
