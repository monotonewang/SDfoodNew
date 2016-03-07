package com.wang.sdfood.util;

import com.google.gson.Gson;
import com.wang.sdfood.model.MoreCookBooksEntity;

/**
 * Created by user on 2016/3/3.
 */
public class JsonUtil {
    public static MoreCookBooksEntity getMoreCookBooksEntityByJson(String json) {
        return new Gson().fromJson(json, MoreCookBooksEntity.class);
    }
}
