package com.wang.sdfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;
import com.wang.sdfood.custem.ActivityMegbookLVView;
import com.wang.sdfood.model.LabelNewWorkEntity;
import com.wang.sdfood.util.FrescoUtil;

import java.util.List;

/**
 * 这是HomeFragment里面的最新作品
 * ListView里面嵌套RecycleView
 * Created by user on 2016/3/11.
 */
public class ActivityNewLabelAdapter extends BaseAdapter {

    private Context applicationContext;
    private LabelNewWorkEntity labelNewWorkByJson;

    public ActivityNewLabelAdapter(Context applicationContext, LabelNewWorkEntity labelNewWorkByJson) {
        this.applicationContext = applicationContext;
        this.labelNewWorkByJson = labelNewWorkByJson;
    }

    @Override
    public int getCount() {
        return labelNewWorkByJson.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return labelNewWorkByJson.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(applicationContext).inflate(R.layout.lv_label_new_work, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //图片url
        FrescoUtil.imageViewBind(labelNewWorkByJson.getData().get(position).getImageUrl(), viewHolder.simpleDraweeView);
        //用户头像的图片
        FrescoUtil.imageViewBind(labelNewWorkByJson.getData().get(position).getUser().getProfileImageUrl(), viewHolder.simpleDraweeViewUser);
        //昵称
        viewHolder.textViewNickName.setText(labelNewWorkByJson.getData().get(position).getUser().getNickname());
        //菜谱名
        viewHolder.textViewRecipeName.setText(labelNewWorkByJson.getData().get(position).getRecipeName());
        //内容
        viewHolder.textViewContent.setText(labelNewWorkByJson.getData().get(position).getContent());
        //对线性布局进行操作.根据网友的数据的不同，添加不同的TextView
        List<LabelNewWorkEntity.DataEntity.PraiseUsersEntity> praiseUsers = labelNewWorkByJson.getData().get(position).getPraiseUsers();
            for (int t = 0; t < praiseUsers.size(); t++) {
                TextView textView = new TextView(applicationContext);
                textView.setText(praiseUsers.get(t).getNickname());
                textView.setTextColor(applicationContext.getResources().getColor(R.color.activityBottomTextUnCheckColor));
                viewHolder.linearLayout.addView(textView);
        } /*else {
            TextView textView = new TextView(applicationContext);
            textView.setText(praiseUsers.size() + "人称赞");
            textView.setTextColor(applicationContext.getResources().getColor(R.color.activityBottomTextUnCheckColor));
            viewHolder.linearLayout.addView(textView);
        }*/
        //comment评论-增加一个ListView的处理
        ActivityNewLabelCommentAdapter activityNewLabelCommentAdapter = new ActivityNewLabelCommentAdapter(position, labelNewWorkByJson.getData().get(position).getComments());
        viewHolder.listViewComment.setAdapter(activityNewLabelCommentAdapter);
        return convertView;
    }

    class ViewHolder {
        SimpleDraweeView simpleDraweeView;
        SimpleDraweeView simpleDraweeViewUser;
        TextView textViewNickName;
        TextView textViewRecipeName;
        TextView textViewContent;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ActivityMegbookLVView listViewComment;

        public ViewHolder(View view) {
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.sdv_lv_label_new_work);
            simpleDraweeViewUser = (SimpleDraweeView) view.findViewById(R.id.sdv_lv_label_new_work_user);
            textViewNickName = (TextView) view.findViewById(R.id.lv_Label_new_work_nickname);
            textViewRecipeName = (TextView) view.findViewById(R.id.lv_Label_new_work_recipeName);
            textViewContent = (TextView) view.findViewById(R.id.lv_Label_new_work_content);
//            recyclerView= (ActivityNewLabelRyView) view.findViewById(R.id.lv_label_new_work_lv_priase);
            linearLayout = (LinearLayout) view.findViewById(R.id.ll_lv_label_new_work_lv_priase);
            listViewComment = (ActivityMegbookLVView) view.findViewById(R.id.lv_label_new_work_lv_comment);
//            linearLayout2= (LinearLayout) view.findViewById(R.id.ll_lv_label_new_work_lv_priase);

        }
    }

    /**
     * 这是网友称赞的Adapter
     */
    class ActivityNewLabelCommentAdapter extends BaseAdapter {

        private List<LabelNewWorkEntity.DataEntity.CommentsEntity> comments;
        private int labelposotion;

        public ActivityNewLabelCommentAdapter(int position, List<LabelNewWorkEntity.DataEntity.CommentsEntity> comments) {
            this.labelposotion = position;
            this.comments = comments;
        }

        @Override
        public int getCount() {
            return comments.size();
        }

        @Override
        public Object getItem(int position) {
            return comments.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolderParise viewHolderParise = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(applicationContext).inflate(R.layout.lv_label_new_work_comment, null);
                viewHolderParise = new ViewHolderParise(convertView);
                convertView.setTag(viewHolderParise);
            } else {
                viewHolderParise = (ViewHolderParise) convertView.getTag();
            }
            viewHolderParise.textView.setText(comments.get(position).getContent());
            return convertView;
        }

        class ViewHolderParise {
            TextView textView;
            public ViewHolderParise(View view) {
                textView = (TextView) view.findViewById(R.id.tv_lv_label_new_work_comment);
            }
        }
    }
}
