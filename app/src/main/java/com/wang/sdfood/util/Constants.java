package com.wang.sdfood.util;

/**
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
        //川菜lv keyWord ="川菜"
        String CAIXIURL = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbooksByKeyword&keyword=%s&pageNum=1&pageSize=20";

        //菜系点击下面的内容
        String MORECOOKBOOKS = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbookDetails&id=%d";

        //本周最热---最新菜谱
        String WEKK_HOT = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getRecipeTheme&id=%d&pageNum=1&pageSize=20";
        //最新作品
        String NEW_WORKS = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getNewWork&type=0&id=%d&pageNum=1&pageSize=20";
        //最新评论
        String NEW_DISCUSS = " http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getNewWork&type=1&pageNum=1&pageSize=20";
        /**
         * 甜食的url
         */
        String SWEET_FOOD = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getRecipeTheme&id=%s&pageNum=1&pageSize=20";
        /**
         * 西顿网友的Url
         */
        String NEW_USER="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getUserPublicInfo&id=%d";
        String NEW_USER_FOOD="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getMyDynamics&id=%d&pageNum=1&pageSize=20";
        /**
         * fragment发现Url
         */
        String DISCOVER = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getGoodsList&pageNum=1&pageSize=10";


    }

    /**
     * 常量名
     */
    interface KEY {
        //菜系的列表传递的关键字
        String CAIXI_KEY = "caixi";
        String MORE_BOOK_DETAIL = "more_book_detail";
        //菜系的传递的关键字
        String FOODNAME_ID_KEY = "foodnameid";
        //甜食的传递的关键字
        String SWEETFOOD_KEY = "foodnameid";
        /**
         * 这是注册界面完成的值传递
         */
        String ACTIVITY_REG_OK="activity_reg_ok";
        Integer ACTIVITY_REG_OK_VALUE=3;
    }
}
