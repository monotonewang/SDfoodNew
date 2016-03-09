package com.wang.sdfood.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.activity.LoginActivity;
import com.wang.sdfood.adapter.FragmentMineMainLVAdapter;
import com.wang.sdfood.adapter.FragmentMsgLVAdapter;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.custem.ActivityMegbookLVView;
import com.wang.sdfood.model.EBUserInfoEntity;
import com.wang.sdfood.model.FragmentMineMainEntity;
import com.wang.sdfood.model.FragmentMsgEntity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 这是用户中心的Fragment
 * Created by user on 2016/3/4.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    //这是头像的ImageView
    @Bind(R.id.fragment_mine_login_iv)
    public ImageView imageView;
    //这是用户名
    @Bind(R.id.fragment_mine_login_tv)
    public TextView textView;
    //ListView
    @Bind({R.id.lv_fragment_mine_score,R.id.lv_fragment_mine_recipe,R.id.lv_fragment_mine_order})
    public List<ActivityMegbookLVView> activityMegbookLVViewList;
    //用户名
    private String userName=null;

    @Override
    protected int getViewResId() {

        return R.layout.fragment_mine;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        /**
         * 注册发布事件
         */
        EventBus.getDefault().register(this);
        //设置用户的头像和用户名
        if(userName!=null){
            textView.setText(userName);
            imageView.setImageResource(R.drawable.ic_social_share_120_qq);
        }
    }
    /**
     * 接受来自注册的Activity的信息
     * 这里只有使用粘性事件才可以接收到消息，普通的事件是接受不到消息的
     * （因为没有注册）
     * @param eBUserInfoEntity
     */
    @Subscribe(priority = 1,sticky = true,threadMode = ThreadMode.MAIN)
    public void ab(EBUserInfoEntity eBUserInfoEntity) {
//        Log.e("aaa", eBUserInfoEntity.getPhoneNum());
        userName = eBUserInfoEntity.getNickName();
    }
    /**
     * 销毁发布事件
     */
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void loadDatas() {
        super.loadDatas();
        /**
         * 这是积分的数据
         */
        List<FragmentMineMainEntity> list = getListByResource();
        FragmentMineMainLVAdapter fragmentMsgLVAdapter=new FragmentMineMainLVAdapter(getContext(),list);
        activityMegbookLVViewList.get(0).setAdapter(fragmentMsgLVAdapter);
        /**
         * 这是菜谱的数据
         */
        List<FragmentMineMainEntity> listRecipe = getListByResourceRecipe();
        FragmentMineMainLVAdapter fragmentMineMainLVAdapter=new FragmentMineMainLVAdapter(getContext(),listRecipe);
        activityMegbookLVViewList.get(1).setAdapter(fragmentMineMainLVAdapter);
        /**
         * 这是订单的数据
         */
        List<FragmentMsgEntity> listOrder = getListByResourceOrder();
        FragmentMsgLVAdapter fragmentMsgLVOrderAdapter=new FragmentMsgLVAdapter(getContext(),listOrder);
        activityMegbookLVViewList.get(2).setAdapter(fragmentMsgLVOrderAdapter);
    }
    /**
     * 这是菜谱的数据
     */
    private List<FragmentMineMainEntity> getListByResourceRecipe() {
        List<FragmentMineMainEntity> list=new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_cooking);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_meal);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_cutlery);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_edit);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arrow);
        String string = getResources().getString(R.string.fragment_mine_user_center_recipe);
        String string1 = getResources().getString(R.string.fragment_mine_user_center_works);
        String string2 = getResources().getString(R.string.fragment_mine_user_center_pat);
        String string3 = getResources().getString(R.string.fragment_mine_user_center_draft);
        FragmentMineMainEntity fragmentMineMainEntity=new FragmentMineMainEntity(bitmap,string,0+"",bitmap5);
        FragmentMineMainEntity fragmentMineMainEntity1=new FragmentMineMainEntity(bitmap1,string1,0+"",bitmap5);
        FragmentMineMainEntity fragmentMineMainEntity2=new FragmentMineMainEntity(bitmap2,string2,0+"",bitmap5);
        FragmentMineMainEntity fragmentMineMainEntity3=new FragmentMineMainEntity(bitmap3,string3,0+"",bitmap5);
        list.add(fragmentMineMainEntity);
        list.add(fragmentMineMainEntity1);
        list.add(fragmentMineMainEntity2);
        list.add(fragmentMineMainEntity3);
        return list;
    }

    /**
     * 添加一个订单数据
     * @return
     */
    private List<FragmentMsgEntity> getListByResourceOrder() {
        List<FragmentMsgEntity> list=new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_order);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_ticket);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_geofence);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arrow);
        String string = getResources().getString(R.string.fragment_mine_user_center_order);
        String string1 = getResources().getString(R.string.fragment_mine_user_center_coupons);
        String string2 = getResources().getString(R.string.fragment_mine_user_center_address);
        FragmentMsgEntity fragmentMsgEntity=new FragmentMsgEntity(bitmap,string,bitmap5);
        FragmentMsgEntity fragmentMsgEntity1=new FragmentMsgEntity(bitmap1,string1,bitmap5);
        FragmentMsgEntity fragmentMsgEntity2=new FragmentMsgEntity(bitmap2,string2,bitmap5);
        list.add(fragmentMsgEntity);
        list.add(fragmentMsgEntity1);
        list.add(fragmentMsgEntity2);
        return list;
    }

    /**
     * 添加一个积分数据
     * @return
     */
    private List<FragmentMineMainEntity> getListByResource() {
        List<FragmentMineMainEntity> list=new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_usercenter_coins);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arrow);
        String string = getResources().getString(R.string.fragment_mine_user_center_score);
        FragmentMineMainEntity fragmentMsgEntity=new FragmentMineMainEntity(bitmap,string,getResources().getString(R.string.fragment_mine_user_center_score_mid),bitmap5);
        list.add(fragmentMsgEntity);
        return list;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fragment_mine_login_iv){
            /**
             * 跳转到登录界面
             */
            Intent intent=new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
