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
        //                --正在热卖
        String HOTSALE = " http://www.mogujie.com/xmapi/system/v1/brand/index?_atype=android&_channel=NAFmiui&_saveMode=0&_msys=4.4.2&_app=go&_at=297d34113511861e&tab=1&_network=2&_fs=NAFmiui102&_av=102&_newdid=1c4963f6db1dd0bfe4b231770f55c820&_version=1.0.2.1021&marketType=market_go&_swidth=600&_sdklevel=19&_did2=4aa6794c-548e-4fb6-9f11-b3e10e9eea65&_did=352284045638644&minfo=NoxW&_t=1457093981";
        //                --即将上线
        String ONLINE = "  http://www.mogujie.com/xmapi/system/v1/brand/index?_atype=android&_channel=NAFmiui&_saveMode=0&_msys=4.4.2&_app=go&_at=696a45c32b0b30c4&tab=3&_network=2&_fs=NAFmiui102&_av=102&_newdid=1c4963f6db1dd0bfe4b231770f55c820&_version=1.0.2.1021&marketType=market_go&_swidth=600&_sdklevel=19&_did2=4aa6794c-548e-4fb6-9f11-b3e10e9eea65&_did=352284045638644&minfo=NoxW&_t=1457094361";
        //川菜lv keyWord ="川菜"
        String CAIXIURL = "http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbooksByKeyword&keyword=%s&pageNum=1&pageSize=20";
        //菜系点击下面的内容
        String MoreCookBooks ="http://www.xdmeishi.com/index.php?m=mobile&c=index&a=getCookbookDetails&id=%s";
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
    }
}
