package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.util.FrescoUtil;

import java.util.List;

/**
 * Created by user on 2016/3/5.
 * 这是主页的FragmentHome的ListView
 */
public class FragmentHomeLVAdapter extends BaseAdapter {
    private Context context;
    private List<MoreCookBooksEntity.DataEntity.MoreCookbooksEntity> moreCookbooks;
    public FragmentHomeLVAdapter(Context context, List<MoreCookBooksEntity.DataEntity.MoreCookbooksEntity> moreCookbooks) {
        this.context=context;
        this.moreCookbooks=moreCookbooks;
    }

    @Override
    public int getCount() {
        return moreCookbooks.size();
    }

    @Override
    public Object getItem(int position) {
        return moreCookbooks.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_home_morecb_lv,null);
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
        FrescoUtil.imageViewBind(moreCookbooks.get(position).getImageUrl(), myViewHolder.simpleDraweeView);
        myViewHolder.tvName.setText(moreCookbooks.get(position).getName());
        myViewHolder.tvNickName.setText(moreCookbooks.get(position).getReferrer().getNickname());
        myViewHolder.tvInfredients.setText(moreCookbooks.get(position).getIngredients());
        myViewHolder.tvLikeCount.setText(moreCookbooks.get(position).getLikeCount()+"个喜欢");
        myViewHolder.tvCommentCount.setText(moreCookbooks.get(position).getCommentCount()+"条评论");
        return convertView;
    }
    class MyViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView tvName;
        TextView tvNickName;
        TextView tvInfredients;
        TextView tvLikeCount;
        TextView tvCommentCount;
    }
}
