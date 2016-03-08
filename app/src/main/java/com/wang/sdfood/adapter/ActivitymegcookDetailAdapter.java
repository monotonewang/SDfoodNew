package com.wang.sdfood.adapter;

import android.content.Context;

import com.wang.sdfood.R;
import com.wang.sdfood.base.AbsBaseAdapter;
import com.wang.sdfood.model.MoreCookBookDetailEntity;

/**
 * 这是菜系详情页的Adapter
 * Created by user on 2016/3/8.
 */
public class ActivitymegcookDetailAdapter extends AbsBaseAdapter<MoreCookBookDetailEntity.DataEntity.MakingStepsEntity> {

    private static final String TAG = "aaa";

    public ActivitymegcookDetailAdapter(Context context) {
        super(context, R.layout.lv_activity_megbook_detail_steps);
    }

    /**
     * 绑定布局的方法
     * @param viewHolder
     * @param data
     */
    @Override
    public void bindDatas(ViewHolder viewHolder, MoreCookBookDetailEntity.DataEntity.MakingStepsEntity data) {
        viewHolder.bindSimpleDraweeView(R.id.activity_megbook_detail_steps_image,data.getImageUrl());
        viewHolder.bindTextView(R.id.activity_megbook_detail_steps_description, data.getStepNumber() + "、" + data.getDescription());
        viewHolder.bindTextView(R.id.activity_megbook_detail_steps_temp,"温度:"+data.getTemp()+"℃");
        viewHolder.bindTextView(R.id.activity_megbook_detail_steps_time,"时间:"+data.getTemp()+"秒");
    }
}
