package com.wang.sdfood.util;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by user on 2016/3/3.
 * OkHttp的工具类
 */
public class OkHttpUtil {
    private static OkHttpClient okHttpClient;
    private static Handler handler = new Handler();
    public static void initOkHttp(){
        //设置OkHttp超时的初始化
        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 异步下载Json数据
     * @param url
     * @param onDownLoadListener
     */
    public static void asyncDownJSON(final String url,final OnDownLoadListener onDownLoadListener){
        Request request=new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDownLoadListener.onFailure(url,e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str=response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onDownLoadListener.onResponse(url,str);
                    }
                });

            }
        });

    }

    /**
     * 同步请求数据
     * @param url
     * @return
     */
    public static Response SyncDownResponse(String url){
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * post提交表单
     */
    public static void postSubmitForm(final String url, Map<String, String> params, final OnDownLoadListener onDownDataListener){
        if(params.size() > 0) {
            FormBody.Builder builder = new FormBody.Builder();
            for(String key : params.keySet()){
                String value = params.get(key);
                builder.add(key, value);
            }
            FormBody formBody = builder.build();

            final Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    final String str = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(onDownDataListener != null){
                                onDownDataListener.onResponse(url, str);
                            }
                        }
                    });
                }
            });
        }
    }
    /**
     * post提交字符串请求
     */
    public static void postSubmitString(final String url, String string, final OnDownLoadListener onDownDataListener){
        MediaType mediatype = MediaType.parse("text/x-markdown; charset=utf-8");

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediatype, string))
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(onDownDataListener != null){
                    onDownDataListener.onFailure(url, e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(onDownDataListener != null){
                            onDownDataListener.onResponse(url, str);
                        }
                    }
                });
            }
        });
    }
    public interface OnDownLoadListener{
        void onResponse(String url, String json);
        void onFailure(String url, String json);
    }
}
