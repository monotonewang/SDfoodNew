package com.wang.sdfood.model;

import android.graphics.Bitmap;

/**
 * Created by user on 2016/3/8.
 */
public class FragmentMsgEntity {
    private Bitmap imageView1;
    private String  textView;
    private Bitmap imageView2;

    public FragmentMsgEntity(Bitmap imageView1,String textView,  Bitmap imageView2) {

        this.imageView1 = imageView1;
        this.textView = textView;
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

    public Bitmap getImageView2() {
        return imageView2;
    }

    public void setImageView2(Bitmap imageView2) {
        this.imageView2 = imageView2;
    }
}
