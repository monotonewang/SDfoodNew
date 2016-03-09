package com.wang.sdfood.model;

import android.graphics.Bitmap;

/**
 * 这是Fragment 我的的实体类
 * Created by user on 2016/3/9.
 */
public class FragmentMineMainEntity {
        private Bitmap imageView1;
        private String  textView;
        private String  textViewCount;
        private Bitmap imageView2;

    public FragmentMineMainEntity(Bitmap imageView1, String textView, String textViewCount, Bitmap imageView2) {
        this.imageView1 = imageView1;
        this.textView = textView;
        this.textViewCount = textViewCount;
        this.imageView2 = imageView2;
    }

    public Bitmap getImageView1() {
        return imageView1;
    }

    public void setImageView1(Bitmap imageView1) {
        this.imageView1 = imageView1;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public String getTextViewCount() {
        return textViewCount;
    }

    public void setTextViewCount(String textViewCount) {
        this.textViewCount = textViewCount;
    }

    public Bitmap getImageView2() {
        return imageView2;
    }

    public void setImageView2(Bitmap imageView2) {
        this.imageView2 = imageView2;
    }
}
