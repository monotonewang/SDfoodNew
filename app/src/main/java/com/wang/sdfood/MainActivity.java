package com.wang.sdfood;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.activiy_home_radiogp)
    public RadioGroup radioGroup;
    @Bind({R.id.activiy_radiobtn_home, R.id.activiy_radiobtn_visible, R.id.activiy_radiobtn_msg, R.id.activiy_radiobtn_mine})
    public List<RadioButton> radioButtonList;
    @Bind(R.id.tv_index)
    public TextView mTvIndex;
    private Fragment fragmentHome;
    private Fragment fragmentVisible;
    private Fragment fragmentMsg;
    private Fragment fragmentMine;
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

        mTvIndex.setFocusable(true);
        mTvIndex.setFocusableInTouchMode(true);
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
}
