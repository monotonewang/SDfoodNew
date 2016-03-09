package com.wang.sdfood.model;

/**
 * Created by user on 2016/3/9.
 */
public class LoginETEntitys {
    private String str;
    private String edStr;

    public LoginETEntitys(String str, String edStr) {
        this.str = str;
        this.edStr = edStr;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getEdStr() {
        return edStr;
    }

    public void setEdStr(String edStr) {
        this.edStr = edStr;
    }
}
