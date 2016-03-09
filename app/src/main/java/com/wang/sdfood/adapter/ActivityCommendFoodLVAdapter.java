package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.model.StapleFoodEntity;
import com.wang.sdfood.util.FrescoUtil;

import java.util.List;

/**
 * 这是主食的listview的适配器
 * Created by Administrator on 2016/3/9.
 */
public class ActivityCommendFoodLVAdapter extends BaseAdapter {
    //构造方法
    private Context mContext;
    private List<StapleFoodEntity.DataEntity> mStapleFood;
    public ActivityCommendFoodLVAdapter(Context context, List<StapleFoodEntity.DataEntity> mStapleFood) {
        this.mContext=context;
        this.mStapleFood=mStapleFood;
    }
    @Override
    public int getCount() {
        return mStapleFood.size();
    }

    @Override
    public Object getItem(int i) {
        return mStapleFood.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder=null;
        if (view==null){
            myViewHolder=new MyViewHolder();
            view= LayoutInflater.from(mContext).inflate(R.layout.lv_commenfoodlist_item,null);
            myViewHolder.mSDV_profileImage= (SimpleDraweeView) view.findViewById(R.id.im_profileImage);
            myViewHolder.mSDV_foodimage = (SimpleDraweeView) view.findViewById(R.id.im_foodimage);
            myViewHolder.mTV_nickname = (TextView) view.findViewById(R.id.tv_nickname);
            myViewHolder.mTV_foodname = (TextView) view.findViewById(R.id.tv_foodname);
            myViewHolder.mTV_commentCount = (TextView) view.findViewById(R.id.tv_commentCount);
            myViewHolder.mTV_ingredients = (TextView) view.findViewById(R.id.tv_ingredients);
            myViewHolder.mTV_likeCount = (TextView) view.findViewById(R.id.tv_likeCount);
            view.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) view.getTag();
        }

        FrescoUtil.imageViewBind(mStapleFood.get(i).getReferrer().getProfileImageUrl(),myViewHolder.mSDV_profileImage);
        FrescoUtil.imageViewBind(mStapleFood.get(i).getImageUrl(),myViewHolder.mSDV_foodimage);
        myViewHolder.mTV_foodname.setText(mStapleFood.get(i).getName());
        myViewHolder.mTV_likeCount.setText(mStapleFood.get(i).getLikeCount() + "");
        myViewHolder.mTV_ingredients.setText(mStapleFood.get(i).getIngredients());
        myViewHolder.mTV_nickname.setText(mStapleFood.get(i).getReferrer().getNickname());
        myViewHolder.mTV_commentCount.setText(mStapleFood.get(i).getCommentCount()+"");
        return view;
    }


    class MyViewHolder{
        SimpleDraweeView mSDV_profileImage,mSDV_foodimage;
        TextView mTV_nickname,mTV_foodname,mTV_ingredients,mTV_commentCount,mTV_likeCount;
    }
}
