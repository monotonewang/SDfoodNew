package com.wang.sdfood.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.sdfood.R;
import com.wang.sdfood.base.BaseActivity;
import com.wang.sdfood.model.LoginETEntitys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;


/**
 * 登录界面
 * Created by user on 2016/3/9.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, PlatformActionListener {
    //头部的两个TextView--第二个是注册
    @Bind({R.id.fragment_login_headview_tv1, R.id.activity_login_region_textView})
    public List<TextView> textViews;
    //EditText的id
    @Bind({R.id.ll_activity_login_et, R.id.ll_activity_login_et_pwd})
    public List<EditText> editTexts;
    @Bind(R.id.iv_login_qq)
    public ImageView imageView;

    @Override
    protected int getViewResId() {

        return R.layout.activity_login;

    }

    @OnClick({R.id.tv_activity_login_now, R.id.activity_login_region_textView})
    public void OnClick(View v) {
        /**
         * 如果EditText为空 ，设置立即登录 按钮不可以点击
         */
        if (v.getId() == R.id.tv_activity_login_now) {
            if (TextUtils.isEmpty(editTexts.get(0).getText()) && TextUtils.isEmpty(editTexts.get(1).getText())) {
                TextView textView = (TextView) v;
                textView.setClickable(false);
            } else {

            }
            //如果点击的是注册--跳转到注册界面
        } else if (v.getId() == R.id.activity_login_region_textView) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);

        }
    }

    @Override
    protected void init() {
        super.init();
        imageView.setOnClickListener(this);
        //设置头部的字体
        textViews.get(0).setText(getResources().getString(R.string.activity_login_head_mid_text));
        textViews.get(1).setText(getResources().getString(R.string.activity_login_region_tv));
        /**
         * lv处理
         */
//        List<LoginETEntitys> list = getListByResource();
//        ActivityLoginAdapter activityLoginAdapter=new ActivityLoginAdapter(getApplicationContext(),list);
//        listView.setAdapter(activityLoginAdapter);
    }

    /**
     * 添加数据
     *
     * @return
     */
    private List<LoginETEntitys> getListByResource() {
        List<LoginETEntitys> list = new ArrayList<>();
        String string = getResources().getString(R.string.activity_login_num_tv);
        String string1 = getResources().getString(R.string.activity_login_pwd_tv);
        String string2 = getResources().getString(R.string.activity_login_et_number);
        String string3 = getResources().getString(R.string.activity_login_et_pwd);
        LoginETEntitys loginETEntitys = new LoginETEntitys(string, string2);
        LoginETEntitys loginETEntitys1 = new LoginETEntitys(string1, string3);
        list.add(loginETEntitys);
        list.add(loginETEntitys1);
        return list;
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }

    /**
     * 点击了Seession的Id,,操作。
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_login_qq) {
            getQQUserInfo();
        }
    }

    /**
     * QQ三方分享代码
     */
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.activity_bottom_rgb_home));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }

    /**
     * QQ三方登录方法
     */
    public void getQQUserInfo(){
        ShareSDK.initSDK(this);
        Platform qq = ShareSDK.getPlatform(getApplicationContext(), QQ.NAME);
        qq.setPlatformActionListener(this);
        qq.showUser(null);//执行登录，登录后在回调里面获取用户资料
        //weibo.showUser(“3189087725”);//获取账号为“3189087725”的资料
    }

    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
        //用户资源都保存到res
        //通过打印res数据看看有哪些数据是你想要的
            if (action == Platform.ACTION_USER_INFOR) {
                PlatformDb platDB = platform.getDb();//获取数平台数据DB
                //通过DB获取各种数据
                String token = platDB.getToken();
                String userGender = platDB.getUserGender();
                String userIcon = platDB.getUserIcon();
                String userId = platDB.getUserId();
                String userName = platDB.getUserName();
                Log.e("print","token"+token);
                Log.e("print","userGender"+userGender);
                Log.e("print","userIcon"+userIcon);
                Log.e("print","userId"+userId);
                Log.e("print","userName"+userName);
            }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}
