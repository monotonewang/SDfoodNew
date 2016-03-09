package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.model.FragmentMineMainEntity;

import java.util.List;

/**
 * 这是Fragment 我的 ListView的Adapter
 * Created by user on 2016/3/9.
 */
public class FragmentMineMainLVAdapter extends BaseAdapter {

        private final Context context;
        private final List<FragmentMineMainEntity> list;

        public FragmentMineMainLVAdapter(Context context, List<FragmentMineMainEntity> list) {
            this.context=context;
            this.list=list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView!=null){
                viewHolder= (ViewHolder) convertView.getTag();
            }else{
                viewHolder=new ViewHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.lv_fragment_mine_main,null);
                viewHolder.iv1= (ImageView) convertView.findViewById(R.id.lv_fragment_msg_main_iv1);
                viewHolder.tv= (TextView) convertView.findViewById(R.id.lv_fragment_msg_main_tv);
                viewHolder.tvCount= (TextView) convertView.findViewById(R.id.tv_fragment_count);
                viewHolder.iv2= (ImageView) convertView.findViewById(R.id.lv_fragment_msg_main_iv2);
                convertView.setTag(viewHolder);
            }
            viewHolder.iv1.setImageBitmap(list.get(position).getImageView1());
            viewHolder.tv.setText(list.get(position).getTextView());
            viewHolder.tvCount.setText(list.get(position).getTextViewCount());
            viewHolder.iv2.setImageBitmap(list.get(position).getImageView2());
            return convertView;
        }
        class ViewHolder{
            ImageView iv1;
            TextView tv;
            TextView tvCount;
            ImageView iv2;
       /* public ViewHolder(View view){
            view= iv1.findViewById(R.id.lv_fragment_msg_main_iv1);
            tv.findViewById(R.id.lv_fragment_msg_main_tv);
            iv2.findViewById(R.id.lv_fragment_msg_main_iv2);
        }*/
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }


