package com.wang.sdfood.util;

import com.google.gson.Gson;
import com.wang.sdfood.model.CaiXi;
import com.wang.sdfood.model.DiscoverEntitys;
import com.wang.sdfood.model.MoreCookBooksEntity;

/**
 * Created by user on 2016/3/3.
 */
public class JsonUtil {
    /**
     * 解析主页的数据
     * @param json
     * @return
     */
    public static MoreCookBooksEntity getMoreCookBooksEntityByJson(String json) {
        return new Gson().fromJson(json, MoreCookBooksEntity.class);
    }
    public static CaiXi getCaiXIByJson(String json) {
        return new Gson().fromJson(json, CaiXi.class);
    }

    /**
     * 解析Fragment发现的数据
     * @param json
     * @return
     */
    public static DiscoverEntitys getDiscoverEntityByJson(String json){
        return new Gson().fromJson(json,DiscoverEntitys.class);
    }
}
