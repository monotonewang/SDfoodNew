package com.wang.sdfood.model;


/**
 * 这是西顿厨友的用户名
 * Created by user on 2016/3/9.
 */
public class UserInfoEntity {
    private String phoneNum;
    private String nickName;
    private String pwd;
    private String askCode;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAskCode() {
        return askCode;
    }

    public void setAskCode(String askCode) {
        this.askCode = askCode;
    }
}
