package com.wang.sdfood.util;

/**
 * 这里主要存放的是访问的地址和Intent用到的Key
 * Created by user on 2016/3/3.
 */
public interface Constants {
    /**
     * 请求数据连接
     */
    interface URL {
        /**
         * 西顿首页Fragment
         */
        String HOMEURL = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getHomeEntity";
        /**
         * 抽屉布局的收藏
         */
        String DREE_COLLECT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyCollects&sessionId=649d5acd76fa47f44de6f65a8231aa25&pageNum=1&pageSize=20";
        /**
         * 抽屉布局的动态
         */
        String DREE_DYNIMIC="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyDynamics&sessionId=649d5acd76fa47f44de6f65a8231aa25&pageNum=1&pageSize=20";
        /**
         *川菜lv keyWord ="川菜"
         */
        String CAIXIURL = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbooksByKeyword&keyword=%s&pageNum=1&pageSize=20";
        /**
         * 搜索的显示--OnTextChanged
         */
        String SEARCH_TEXT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMatcherSearchItems&sessionId=649d5acd76fa47f44de6f65a8231aa25&keyword=%E5%B7%9D";
        /**
         * 提交的search
         */
        String SERACH_TEXT_COMMIT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbooksByKeyword&sessionId=649d5acd76fa47f44de6f65a8231aa25&keyword=%E5%B1%B1%E4%B8%9C%E7%B4%A0%E5%8C%85%E5%AD%90&pageNum=1&pageSize=20";
        /**
         * POST
         * homeFrament的评论
         */
        String LV_HOME_COMMENT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getComments&sessionId=649d5acd76fa47f44de6f65a8231aa25&id=1970&pageNum=1&pageSize=20";
        /**
         * POST
         * homeFrament的收藏
         */
        String LV_HOME_COLLECT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=setCollect&sessionId=649d5acd76fa47f44de6f65a8231aa25&id=1966&collect=true";
        /**
         * 菜系点击下面的内容
         */
        String MORECOOKBOOKS = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbookDetails&id=%d";
        /**
         *菜系点击下面的评论内容
         */
        String FOOD_DETAIL_MORE_COMMENT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getComments&id=777&pageNum=2&pageSize=4";
        /**
         * POST
         * 菜系下面的评论。没有登录的跳到登录界面。登录的就会带上SessionId
         */
        String FOOD_DETAIL_USER_COMMENt="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=addComment&sessionId=649d5acd76fa47f44de6f65a8231aa25&id=212&content=%E4%B8%8D%E9%94%99%E5%95%8A&type=0";
        /**
         * POST
         * 菜系下面的praise。没有登录的跳到登录界面。登录的就会带上SessionId
         */
        String FOOD_DETAIL_PRAISE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=addLike&sessionId=649d5acd76fa47f44de6f65a8231aa25&id=212&isLike=true";
        /**
         * POST
         * 菜系下面的collect。没有登录的跳到登录界面。登录的就会带上SessionId
         */
        String FOOD_DETAIL_COLLECT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=setCollect&sessionId=649d5acd76fa47f44de6f65a8231aa25&id=212&collect=true";
        /**
         *本周最热---最新菜谱
         */
        String WEKK_HOT = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getRecipeTheme&id=%d&pageNum=1&pageSize=20";
        /**
         *最新作品
         */
        String NEW_WORKS = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getNewWork&type=0&id=%d&pageNum=1&pageSize=20";
        /**
         *最新评论
         */
        String NEW_DISCUSS = " http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getNewWork&type=1&pageNum=1&pageSize=20";
        /**
         * 甜食的url
         */
        String SWEET_FOOD = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getRecipeTheme&id=%s&pageNum=1&pageSize=20";
        /**
         * 西顿网友的Url diyige shi 资料第二个是动态(SessionID)
         */
        String XIDUN_USER="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getUserPublicInfo&id=%d";
        /**
         * 西顿网友的关注
         */
        String XIDUN_USER_CONCERN="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&type=1&id=361&pageNum=1&pageSize=20";
        /**
         * 西顿网友的粉丝
         */
        String XIDUN_USER_FAN= "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&type=2&id=361&pageNum=1&pageSize=20";
        /**
         * 西顿网友的动态
         */
        String XIDUN__USER_DYNAMIC="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyDynamics&id=%d&pageNum=1&pageSize=20";
        /**
         * 西顿网友的菜谱
         */
        String XIDUN__USER_RECIPE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyRecipes&id=343&pageNum=1&pageSize=20";
        /**
         * 西顿网友的作品
         */
        String XIDUN__USER_WORKS="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyWorks&id=343&pageNum=1&pageSize=20";
        /**
         * 西顿网友的收藏
         */
        String XIDUN__USER_COLLECT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyCollects&id=347&pageNum=1&pageSize=20";
        /**
         * fragment发现Url
         */
        String DISCOVER = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getGoodsList&pageNum=1&pageSize=10";
        /**
         * fragment发现厨具的详情Url
         */
        String MEG_COOK_DETAIL="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getGoodsDetail&id=%d";
        /**
         * fragment发现厨具的视频WebView-Url
         */
        String MEG_COOK_DETAIL_VIDEO="http://m.xdmeishi.com/meishi/index.php?m=goods&a=goodsdetail&id=%d";
        /**
         * POST
         * 用户注册的account = phoneNum
         * 这也是重新发送验证码的url
         */
        String REGISTER="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=checkcode&account=%s";
        /**
         * POST
         * 提交验证码的url
         * 第一个是手机号码 第二个是六位的验证码
         */
        String REGISTER_SERCITY_CODE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=verifyCheckcode&account=%s&checkcode=%s";
        /**
         * 登录成功后返回给客户端的数据
         */
        String USER_LOGIN_SUBMIT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=login&account=17706519751&password=1722442b586a85c95593a9c6131a0ebd&userId=907147633360718637&channelId=4532405580014010724";
        /**
         * 用户Fragment的被粉丝
         */
        String USER_CONCERN="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=1&id=0&pageNum=1&pageSize=20";
        /**
         * 消息Fragment收到的赞
         */
        String USER_LIKE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getReceiveLikes&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";
        /**
         * 消息Fragment收到的评论
         */
        String USER_DISCUSS="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getReceiveComments&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";
        /**
         * 消息Fragment收到的戳
         */
        String USER_POKE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyPokeList&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";
        /**
         * 消息Fragment收到的通知
         */
        String USER_TOAST="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getReceiveNotify&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";

        /**
         * 用户的关注在消息的Fragment消息中的concerns
         * 用户Fragment的粉丝
         */
        String USER_FENSI="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=2&id=0&pageNum=1&pageSize=20";
        /**
         * 用户Fragment收到的赞
         */
        String USER_LIKE_A="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=3&id=0&pageNum=1&pageSize=20";
        /**
         * 用户的访客
         */
        String USR_VISIT="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyConcerns&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=4&id=0&pageNum=1&pageSize=20";
        /**
         * 用户的积分
         */
        String USER_SCORE="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=signIn&&sessionId=a6ed285ad0edc897b4300f405b2fefba";
        /**
         * UserFragment的菜谱
         */
        String USER_RECIPER="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyRecipes&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";
        /**
         * 用户Fragment的作品
         */
        String USER_WORK="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyWorks&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=0&pageNum=1&pageSize=20";
        /**
         * 用户的视频
         */
        String USER_VIDEO="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyWorks&sessionId=a6ed285ad0edc897b4300f405b2fefba&type=1&id=357&pageNum=1&pageSize=20";
        /**
         * 用户的订单
         */
        String USER_ORDER="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getOrders&sessionId=a6ed285ad0edc897b4300f405b2fefba&status=0&pageNum=1&pageSize=10";
        /**
         * 用户的优惠卷
         */
        String USER_COUPONS="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyCoupons&sessionId=a6ed285ad0edc897b4300f405b2fefba&status=0&pageNum=1&pageSize=20";
        /**
         * 用户的地址
         */
        String USER_ADDR="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getAddressByUser&sessionId=a6ed285ad0edc897b4300f405b2fefba&pageNum=1&pageSize=20";
    }

    /**
     * 常量名
     */
    interface KEY {
        /**
         * 菜系的列表传递的关键字
         */
        String CAIXI_KEY = "caixi";
        String MORE_BOOK_DETAIL = "more_book_detail";
        /**
         *菜系的传递的关键字
         */
        String FOODNAME_ID_KEY = "foodnameid";
        /**
         *甜食的传递的关键字
         */
        String SWEETFOOD_KEY = "foodnameid";
        /**
         * 这是注册界面完成的值传递
         */
        String ACTIVITY_REG_OK="activity_reg_ok";
        /**
         * 这是注册界面跳到用户页面
         */
        Integer ACTIVITY_REG_OK_VALUE=3;
        /**
         * 这是fragment_home 的lv的id。跳转到菜系详情activity
         */
        String HOME_FRAGMENT_LIST_MCBOOK_ID="home_fragment_list_mcbook_id";
    }
}
