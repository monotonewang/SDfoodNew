package com.wang.sdfood.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.zxing.client.android.Intents;
import com.wang.sdfood.R;
import com.wang.sdfood.adapter.FragmentMsgLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.databinding.ActivityMainBinding;
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


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    //这是搜索框的父布局
    //这是搜索框的打开抽屉布局的方法第一个是回退的按钮，第二个是搜索的图标
    //这是搜索框的下面的线性布局
    //这是搜索框的下面的线性布局是否可见
    private boolean mSearchLinearLayoutIsShow;
    //这是抽屉布局的用户头像
    public ImageView mImageView;
    //这是抽屉布局的用户名
    public TextView mTextView;
    private Fragment fragmentHome, fragmentVisible, fragmentMsg, fragmentMine;
    private FragmentManager fragmentManager;
    private FragmentTransaction beginTransaction;
    //用户名
    private String nickName;
    private ActivityMainBinding mainBinding;

    @Override
    protected void getViewResId() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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
     *
     * @param searchYEntity
     */
    @Subscribe(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void scroolUp(SearchYEntity searchYEntity) {
        if (searchYEntity.getI() == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -300);
            translateAnimation.setDuration(200);
            translateAnimation.setFillAfter(true);
            mainBinding.inSearch.fragmentSearch.startAnimation(translateAnimation);
//            mainBinding.inSearch.fragmentSearch.setBackgroundColor(getResources().getColor(R.color.activityBottomTextCheckColor));
        }
    }

    /**
     * 搜索框下滑的方法
     *
     * @param searchYEntity2
     */
    @Subscribe(priority = 1, sticky = true, threadMode = ThreadMode.MAIN)
    public void scrollDown(SearchYEntity2 searchYEntity2) {
        if (searchYEntity2.getI() == 2) {
            /**
             *相对移动位置
             */
            TranslateAnimation translateAnimationa = new TranslateAnimation(0, 0, -200, 0);
            translateAnimationa.setDuration(200);
//            translateAnimationa.setFillAfter(true);
            mainBinding.inSearch.fragmentSearch.startAnimation(translateAnimationa);
//            mainBinding.inSearch.fragmentSearch.setBackgroundColor(getResources().getColor(R.color.activityLVMenuWordColor));
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
        //搜索框的TextView-设置监听
        mainBinding.inSearch.fragmentSearchEt.setOnClickListener(this);
        //这是搜索框前面打开抽屉布局的iv
        mainBinding.inSearch.fragmentSearchIvSearch.setOnClickListener(this);
        mainBinding.inSearch.fragmentSearchEt.setOnClickListener(this);
        mainBinding.inSearch.fragmentSearchQrcode.setOnClickListener(this);

        //首次进入把线性布局设置不可见
        mainBinding.inSearchBottom.llSearchBottomLv.setVisibility(View.GONE);
        mainBinding.inRadioGroup.activiyHomeRadiogp.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentHome = new HomeFragment();
        fragmentVisible = new VisiableFragment();
        fragmentMsg = new MsgFragment();
        fragmentMine = new MineFragment();
        mainBinding.inRadioGroup.activiyRadiobtnHome.setChecked(true);
        beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_main_fl, fragmentHome);
        beginTransaction.add(R.id.activity_main_fl, fragmentVisible);
        beginTransaction.add(R.id.activity_main_fl, fragmentMsg);
        beginTransaction.add(R.id.activity_main_fl, fragmentMine);
        beginTransaction.commit();

        mainBinding.inSearch.fragmentSearchQrcode.setOnClickListener(this);
        /**
         * 刷新控件的监听方法
         */
//
        //设置ListView的监听
        mainBinding.activityMainDlNavLv.setOnItemClickListener(this);
        /**
         * 接受注册成功界面返回的值/并且显示第三个页面
         */
        Intent intent = getIntent();
        int registerOk = intent.getIntExtra(Constants.KEY.ACTIVITY_REG_OK, -1);
        if (registerOk != -1) {
            mainBinding.inRadioGroup.activiyRadiobtnHome.setChecked(true);
        }
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        List<FragmentMsgEntity> list = getListByResource();
        FragmentMsgLVAdapter fragmentMsgLVAdapter = new FragmentMsgLVAdapter(this, list);
        mainBinding.activityMainDlNavLv.setAdapter(fragmentMsgLVAdapter);
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
                mainBinding.inSearch.fragmentSearch.setVisibility(View.VISIBLE);
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
                mainBinding.inSearch.fragmentSearch.setVisibility(View.GONE);
                FragmentTransaction fragmentTransactionMatch = getSupportFragmentManager().beginTransaction();
                fragmentTransactionMatch.hide(fragmentHome)
                        .show(fragmentVisible)
                        .hide(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_msg:
                mainBinding.inSearch.fragmentSearch.setVisibility(View.GONE);
                FragmentTransaction fragmentTransactionItem = getSupportFragmentManager().beginTransaction();
                fragmentTransactionItem.hide(fragmentHome)
                        .hide(fragmentVisible)
                        .show(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_mine:
                mainBinding.inSearch.fragmentSearch.setVisibility(View.GONE);
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
        if (parent.equals(mainBinding.activityMainDlNavLv)) {
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
        } else if (v.getId() == R.id.fragment_search_et) {
            /**
             * 这里是点击EditText里面的响应
             */
            Log.e("print", "in");
//            if (mSearchLinearLayoutIsShow == true) {
//                Log.e("print", "inf");
//                mSearchLinearLayoutIsShow = false;
//                mainBinding.inSearch.fragmentSearch.setBackgroundColor(getResources().getColor(R.color.activityBottomTextCheckColor));
//                mainBinding.inSearchBottom.llSearchBottomLv.setVisibility(View.GONE);
//            } else
            if (mSearchLinearLayoutIsShow == false) {
                Log.e("print", "int");
                mSearchLinearLayoutIsShow = true;
                mainBinding.inSearchBottom.llSearchBottomLv.setVisibility(View.VISIBLE);
                //设置二维码的图标不可见
                mainBinding.inSearch.fragmentSearchQrcode.setVisibility(View.GONE);
                mainBinding.inSearch.fragmentSearchIvSearch.setImageResource(R.drawable.common_head_btn_back);
            }
        } else if (v.getId() == R.id.fragment_search_iv_search) {
            //隐藏掉mSearchLinearLayout的布局
            Log.e("print", "intsearch");
            if (mSearchLinearLayoutIsShow == true) {
                Log.e("print", "intsearchon");
                mSearchLinearLayoutIsShow = false;
                mainBinding.inSearch.fragmentSearchIvSearch.setImageResource(R.drawable.common_icon_list_def);
                //设置二维码的图标可见
                mainBinding.inSearch.fragmentSearchQrcode.setVisibility(View.VISIBLE);
                mainBinding.inSearchBottom.llSearchBottomLv.setVisibility(View.GONE);
            } else if (mSearchLinearLayoutIsShow == false) {
                Log.e("print", "intsearchoff");
                //这里是打开抽屉布局的方法
//                Log.e("print", "int");
//                mSearchLinearLayoutIsShow = true;
//                mainBinding.inSearch.fragmentSearch.setBackgroundColor(getResources().getColor(R.color.activityLVMenuWordColor));
//                mainBinding.inSearchBottom.llSearchBottomLv.setVisibility(View.VISIBLE);
            }
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
