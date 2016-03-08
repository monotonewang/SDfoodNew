package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.model.CaiXiEntity;
import com.wang.sdfood.util.FrescoUtil;

import java.util.List;

/**
 * Activity菜名详情页的适配器
 * Created by Administrator on 2016/3/8.
 */
public class ActivityMCBookLVAdapter extends BaseAdapter {
    private Context context;
    private List<CaiXiEntity.DataEntity> dataEntities;
    public ActivityMCBookLVAdapter(Context context, List<CaiXiEntity.DataEntity> dataEntities) {
        this.context=context;
        this.dataEntities=dataEntities;
    }

    @Override
    public int getCount() {
        return dataEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return dataEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder=null;
        if(convertView==null){
            myViewHolder=new MyViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_fragment_home_morecb,null);
            myViewHolder.imageView= (ImageView) convertView.findViewById(R.id.lv_fragment_home_morecb_iv_yun);
            myViewHolder.simpleDraweeView= (SimpleDraweeView) convertView.findViewById(R.id.fragment_home_morecb_lv_sdv);
            myViewHolder.tvName= (TextView) convertView.findViewById(R.id.fragment_home_morecb_lv_name);
            myViewHolder.tvNickName= (TextView) convertView.findViewById(R.id.fragment_home_morecb_lv_nickName);
            myViewHolder.tvInfredients= (TextView) convertView.findViewById(R.id.fragment_home_morecb_lv_ingredients);
            myViewHolder.tvLikeCount= (TextView) convertView.findViewById(R.id.fragment_home_morecb_lv_likeCount);
            myViewHolder.tvCommentCount= (TextView) convertView.findViewById(R.id.fragment_home_morecb_lv_commentCount);
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        FrescoUtil.imageViewBind(dataEntities.get(position).getImageUrl(), myViewHolder.simpleDraweeView);
        myViewHolder.tvName.setText(dataEntities.get(position).getName());
        myViewHolder.tvNickName.setText(dataEntities.get(position).getReferrer().getNickname());
        myViewHolder.tvInfredients.setText(dataEntities.get(position).getIngredients());
        myViewHolder.tvLikeCount.setText(dataEntities.get(position).getCollectCount()+context.getResources().getString(R.string.activity_caixi_detail_collectcount));
        myViewHolder.tvCommentCount.setText(dataEntities.get(position).getHitscount() + context.getResources().getString(R.string.activity_caixi_detail_hitscount));
        myViewHolder.imageView.setVisibility(View.GONE);
        return convertView;
    }
    class MyViewHolder{
        ImageView imageView;
        SimpleDraweeView simpleDraweeView;
        TextView tvName;
        TextView tvNickName;
        TextView tvInfredients;
        TextView tvLikeCount;
        TextView tvCommentCount;
    }
}
