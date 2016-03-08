package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.model.MoreCookBookDetailEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/8.
 */
public class ActivityMegcookIngredientsLVAdapter extends BaseAdapter {


    private Context context;
    private List<MoreCookBookDetailEntity.DataEntity.IngredientsEntity> datas;

    public ActivityMegcookIngredientsLVAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<MoreCookBookDetailEntity.DataEntity.IngredientsEntity>();
    }

    public void setDatas(List<MoreCookBookDetailEntity.DataEntity.IngredientsEntity> ingredients) {
        this.datas = ingredients;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (datas.size() % 2 == 0) {
            return datas.size() / 2;
        }
        return datas.size() / 2 + 1;
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_activity_megbook_detail_steps_food_detail, null);
            viewHolder.textView11 = (TextView) convertView.findViewById(R.id.lv_activity_megbook_detail_steps_food_detail_tvname1);
            viewHolder.textView12 = (TextView) convertView.findViewById(R.id.lv_activity_megbook_detail_steps_food_detail_tvunit1);
            viewHolder.textView21 = (TextView) convertView.findViewById(R.id.lv_activity_megbook_detail_steps_food_detail_tvname2);
            viewHolder.textView22 = (TextView) convertView.findViewById(R.id.lv_activity_megbook_detail_steps_food_detail_tvunit2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView11.setText(datas.get(position * 2).getName());
        viewHolder.textView12.setText(datas.get(position * 2).getUnit());
        if (position * 2 + 1 < datas.size()) {
            viewHolder.textView21.setText(datas.get(position * 2 + 1).getName());
            viewHolder.textView22.setText(datas.get(position * 2 + 1).getUnit());
        }
        return convertView;
    }

    class ViewHolder {
        TextView textView11;
        TextView textView12;
        TextView textView21;
        TextView textView22;
    }

}
