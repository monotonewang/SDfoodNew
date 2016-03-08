package com.wang.sdfood.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.adapter.FragmentMsgLVAdapter;
import com.wang.sdfood.base.BaseFragment;
import com.wang.sdfood.model.FragmentMsgEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 消息的Fragment
 * Created by user on 2016/3/4.
 */
public class FragmentMsg extends BaseFragment {

    //绑定头部的TextView
    @Nullable
    @Bind(R.id.fragment_msg_headview_tv)
    public TextView textView;
    @Bind({R.id.fragment_common_headview_back,R.id.fragment_common_headview_share})
    public List<ImageView> imageViews;
    @Bind(R.id.fragment_msg_lv)
    public ListView listView;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_msg;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        //设置头部的字体
        textView.setText(getResources().getString(R.string.fragment_msg_head_text));
        imageViews.get(0).setVisibility(View.GONE);
        imageViews.get(1).setVisibility(View.GONE);
        List<FragmentMsgEntity> list = getListByResource();
        FragmentMsgLVAdapter  fragmentMsgLVAdapter=new FragmentMsgLVAdapter(getContext(),list);
        listView.setAdapter(fragmentMsgLVAdapter);
    }

    /**
     * 创建数据源，显示到Msg上面
     * @return
     */
    private List<FragmentMsgEntity> getListByResource() {
        List<FragmentMsgEntity> list=new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_msg_fan);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_msg_like);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_msg_comm);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_msg_poke);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_msg_mess);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arrow);
        String string = getResources().getString(R.string.fragment_msg_fan);
        String string1 = getResources().getString(R.string.fragment_msg_like);
        String string2 = getResources().getString(R.string.fragment_msg_comm);
        String string3 = getResources().getString(R.string.fragment_msg_poke);
        String string4 = getResources().getString(R.string.fragment_msg_mess);
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
    protected void loadDatas() {
        super.loadDatas();
    }


}
