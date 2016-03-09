package com.wang.sdfood.util;

import com.google.gson.Gson;
import com.wang.sdfood.model.CaiXiEntity;
import com.wang.sdfood.model.DiscoverEntitys;
import com.wang.sdfood.model.MoreCookBookDetailEntity;
import com.wang.sdfood.model.MoreCookBooksEntity;
import com.wang.sdfood.model.StapleFoodEntity;

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
     * 解析Fragment不同菜系的数据
     * @param json
     * @return
     */
    public static StapleFoodEntity getStapleFoodByJson(String json) {
        return new Gson().fromJson(json, StapleFoodEntity.class);
    }
    /**
     * 解析Fragment不同菜系的数据
     * @param json
     * @return
     */
    public static CaiXiEntity getCaiXIByJson(String json) {
        return new Gson().fromJson(json, CaiXiEntity.class);
    }

    /**
     * 解析Fragment发现的数据
     * @param json
     * @return
     */
    public static DiscoverEntitys getDiscoverEntityByJson(String json){
        return new Gson().fromJson(json,DiscoverEntitys.class);
    }

    /**
     * 解析Fragment菜系详情的数据
     * @param json
     * @return
     */
    public static MoreCookBookDetailEntity getMoreCookBookByJson(String json){
        return new Gson().fromJson(json,MoreCookBookDetailEntity.class);
    }
}
