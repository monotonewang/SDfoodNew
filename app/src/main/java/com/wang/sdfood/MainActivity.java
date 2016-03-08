package com.wang.sdfood;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wang.sdfood.adapter.FragmentMsgLVAdapter;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.fragment.FragmentHome;
import com.wang.sdfood.fragment.FragmentMine;
import com.wang.sdfood.fragment.FragmentMsg;
import com.wang.sdfood.fragment.FragmentVisiable;
import com.wang.sdfood.model.FragmentMsgEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,AdapterView.OnItemClickListener {
    private static final String TAG ="MainActivity" ;
    @Bind(R.id.activity_main_srl)
    public SwipeRefreshLayout swipeRefreshLayout;
    public Handler handler=new Handler();
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
         * 刷新控件的监听方法
         */
//        if()
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //重新加载一次数据
                loadDatas();
                //过一秒自动关闭
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
        //设置ListView的监听
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        List<FragmentMsgEntity> list = getListByResource();
        FragmentMsgLVAdapter fragmentMsgLVAdapter=new FragmentMsgLVAdapter(this,list);
        listView.setAdapter(fragmentMsgLVAdapter);
    }

    /**
     * 这是抽屉布局的List菜单
     * @return
     */
    private List<FragmentMsgEntity> getListByResource() {
        List<FragmentMsgEntity> list=new ArrayList<>();
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
        FragmentMsgEntity fragmentMsgEntity=new FragmentMsgEntity(bitmap,string,bitmap5);
        FragmentMsgEntity fragmentMsgEntity1=new FragmentMsgEntity(bitmap1,string1,bitmap5);
        FragmentMsgEntity fragmentMsgEntity2=new FragmentMsgEntity(bitmap2,string2,bitmap5);
        FragmentMsgEntity fragmentMsgEntity3=new FragmentMsgEntity(bitmap3,string3,bitmap5);
        FragmentMsgEntity fragmentMsgEntity4=new FragmentMsgEntity(bitmap4,string4,bitmap5);
        list.add(fragmentMsgEntity);
        list.add(fragmentMsgEntity1);
        list.add(fragmentMsgEntity2);
        list.add(fragmentMsgEntity3);
        list.add(fragmentMsgEntity4);
        return list;
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
     * 抽屉布局的ListView的监听事件处理
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.equals(listView)){
            Log.e(TAG, "onItemClick: "+position );
        }
    }
}
