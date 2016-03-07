package com.wang.sdfood;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.fragment.FragmentHome;
import com.wang.sdfood.fragment.FragmentMine;
import com.wang.sdfood.fragment.FragmentMsg;
import com.wang.sdfood.fragment.FragmentVisiable;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.activiy_home_radiogp)
    public RadioGroup radioGroup;
    @Bind({R.id.activiy_radiobtn_home, R.id.activiy_radiobtn_visible, R.id.activiy_radiobtn_msg, R.id.activiy_radiobtn_mine})
    public List<RadioButton> radioButtonList;
    @Bind(R.id.tv_index)
    public TextView mTvIndex;
    //找到NavView的ID
    @Bind(R.id.activity_main_dl_nav)
    public NavigationView navigationView;
    //找到Nfab的ID
    @Bind(R.id.activty_main_fab)
    public FloatingActionButton floatingActionButton;
    private Fragment fragmentHome,fragmentVisible,fragmentMsg,fragmentMine;
    private FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction beginTransaction;

    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentHome = new FragmentHome();
        fragmentVisible = new FragmentVisiable();
        fragmentMsg = new FragmentMsg();
        fragmentMine = new FragmentMine();
        radioButtonList.get(0).setChecked(true);
        beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_main_fl, fragmentHome);
        beginTransaction.add(R.id.activity_main_fl, fragmentVisible);
        beginTransaction.add(R.id.activity_main_fl, fragmentMsg);
        beginTransaction.add(R.id.activity_main_fl, fragmentMine);
        beginTransaction.commit();
        /**
         * 使TextView获取焦点，
         */
        mTvIndex.setFocusable(true);
        mTvIndex.setFocusableInTouchMode(true);
        //设置Nav的监听
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.activiy_radiobtn_home:
                FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                fragmentTransactionHome .show(fragmentHome)
                        .hide(fragmentVisible)
                        .hide(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_visible:

                FragmentTransaction fragmentTransactionMatch = getSupportFragmentManager().beginTransaction();
                fragmentTransactionMatch.hide(fragmentHome)
                        .show(fragmentVisible)
                        .hide(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_msg:

                FragmentTransaction fragmentTransactionItem = getSupportFragmentManager().beginTransaction();
                fragmentTransactionItem.hide(fragmentHome)
                        .hide(fragmentVisible)
                        .show(fragmentMsg)
                        .hide(fragmentMine)
                        .commit();
                break;
            case R.id.activiy_radiobtn_mine:

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
     * 抽屉布局Menu的回调方法
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.activity_dl_menu_document:

                break;
            case R.id.activity_dl_menu_star:

                break;
            case R.id.activity_dl_menu_private:

                break;
            case R.id.activity_dl_menu_sensor:

                break;
            case R.id.activity_dl_menu_setting:

                break;
        }
        return false;

    }
}
