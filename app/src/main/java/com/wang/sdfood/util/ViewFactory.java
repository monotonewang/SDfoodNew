package com.wang.sdfood.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wang.sdfood.R;


/**
 * view工厂
 * 
 * @author YD
 *
 */
public class ViewFactory {

	/**
	 * 获取一个image的视图
	 *
	 * @param url
	 * @return
	 */
	public static View getSimpleDreeView(Context context, String url) {
		View v = LayoutInflater.from(context).inflate(
				R.layout.fragment_home_vp, null);
		SimpleDraweeView textTv = (SimpleDraweeView) v.findViewById(R.id.fragment_home_vp_sdv);
		FrescoUtil.imageViewBind(url,textTv);
		return v;
	}
	/**
	 * 获取一个简单的视图,包含title
	 * 
	 * @param text
	 * @return
	 */
	public static View getImageView(Context context, String text, String title) {
		View v = LayoutInflater.from(context).inflate(
				R.layout.cycleviewpager_textview, null);

		TextView textTv = (TextView) v.findViewById(R.id.text);
		TextView titleTv = (TextView) v.findViewById(R.id.title);
		textTv.setText(text);
		titleTv.setText(title);
		return v;
	}

	/**
	 * 获取一个简单的视图
	 * 
	 * @param text
	 * @return
	 */
	public static View getImageView(Context context, String text) {
		View v = LayoutInflater.from(context).inflate(
				R.layout.cycleviewpager_textview, null);

		TextView textTv = (TextView) v.findViewById(R.id.text);
		TextView titleTv = (TextView) v.findViewById(R.id.title);
		textTv.setText(text);
		titleTv.setVisibility(View.GONE);
		return v;
	}
}