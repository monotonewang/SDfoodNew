package com.wang.sdfood.model;

/**
 * Created by user on 2016/3/9.
 */
public class EBUserInfoEntity {

    private String phoneNum;

    private String nickName;

    private String pwd;

    private String askCode;

    public EBUserInfoEntity(String phoneNum, String nickName, String pwd, String askCode) {
        this.phoneNum = phoneNum;
        this.nickName = nickName;
        this.pwd = pwd;
        this.askCode = askCode;
    }

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
