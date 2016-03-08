package com.wang.sdfood.util;

import com.google.gson.Gson;
import com.wang.sdfood.model.DiscoverEntity;
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

    /**
     * 解析Fragment发现的数据
     * @param json
     * @return
     */
    public static DiscoverEntity getDiscoverEntityByJson(String json){
        return new Gson().fromJson(json,DiscoverEntity.class);
    }
}
