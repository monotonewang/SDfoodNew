package com.wang.sdfood.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.model.MoreCookBooksEntity;

import java.util.List;

/**
 * 西顿厨友的RecycleView的Adapter
 * Created by user on 2016/3/7.
 */
public class FragmentHomeNewuserLVAdapter extends RecyclerView.Adapter<FragmentHomeNewuserLVAdapter.ViewHolder> {
    private Context context;
    private List<MoreCookBooksEntity.DataEntity.NewUserEntity> datas;
    private View.OnClickListener onClickListener;
    public FragmentHomeNewuserLVAdapter(Context context, List<MoreCookBooksEntity.DataEntity.NewUserEntity> datas) {
            this.context=context;
        this.datas=datas;
    }

    /**
     * Item点击的接口回调方法
     * @param onClickListener
     */
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lv_fragment_home_newuser, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position).getNickname());
        holder.simpleDraweeView.setImageURI(Uri.parse(datas.get(position).getProfileImageUrl()));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        SimpleDraweeView simpleDraweeView;
        public ViewHolder(View itemView) {
            super(itemView);
            if(onClickListener!=null){
                itemView.setOnClickListener(onClickListener);
            }
            textView= (TextView) itemView.findViewById(R.id.fragment_home_newuser_nickName);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.fragment_home_newuser_user_sdv);
        }
    }
}
