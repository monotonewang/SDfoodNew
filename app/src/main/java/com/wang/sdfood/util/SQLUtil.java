package com.wang.sdfood.util;

//import com.activeandroid.query.Select;
import com.wang.sdfood.model.UserInfoEntity;

import java.util.List;

/**
 * 数据库工具类
 * Created by user on 2016/3/9.
 */
public class SQLUtil {
    /**
     * 这是用户注册成功之后把数据写到UserInfo表里面
     *
     * @param phoneNum
     * @param userName
     * @param pwd
     * @param askcode
     */
    public static void addUser(String phoneNum, String userName, String pwd, String askcode) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setPhoneNum(phoneNum);
        userInfoEntity.setNickName(userName);
        userInfoEntity.setPwd(pwd);
        userInfoEntity.setAskCode(askcode);
        //TODO
//        userInfoEntity.save();
    }

    /**
     * 查询用户是否存在
     *
     * @param phoneNum
     */
    public static UserInfoEntity queryUser(String phoneNum) {
//        UserInfoEntity userInfoEntity = new Select().from(UserInfoEntity.class).where("phoneNum=?", phoneNum).executeSingle();
//        return userInfoEntity;
        //TODO
        return null;
    }

    /**
     * 删除所有用户
     */
    public static void delUser() {
//        List<UserInfoEntity> userInfoEntity = new Select().from(UserInfoEntity.class).execute();
//        for (int i = 0; i < userInfoEntity.size(); i++) {
//            userInfoEntity.get(i).delete();
//        }
        //TODO
    }
    /**
     * 删除该手机号码的用户
     */
    public static void delUser(String PhoneNum) {
//        UserInfoEntity userInfoEntity = new Select().from(UserInfoEntity.class).where("phoneNum=?", PhoneNum).executeSingle();
//        userInfoEntity.delete();
        //TODO
    }
}
