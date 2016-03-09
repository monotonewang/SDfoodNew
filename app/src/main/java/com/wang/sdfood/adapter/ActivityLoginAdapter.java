package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.model.LoginETEntitys;

import java.util.List;

/**
 * 这是登录的头部布局
 * Created by user on 2016/3/9.
 */
public class ActivityLoginAdapter extends BaseAdapter {
    private Context context;
    private List<LoginETEntitys> datas;

    public ActivityLoginAdapter(Context context, List<LoginETEntitys> list) {
        this.datas = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_activiy_login, null);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.ll_activity_login_tv);
            viewHolder.et = (EditText) convertView.findViewById(R.id.ll_activity_login_et);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(datas.get(position).getStr());
        viewHolder.et.setHint(datas.get(position).getEdStr());
        return convertView;
    }

    class ViewHolder {
        TextView tv;
        EditText et;
    }
}
