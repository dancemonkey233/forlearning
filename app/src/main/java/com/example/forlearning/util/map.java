package com.example.forlearning.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class map implements Runnable {
    String s;


    public synchronized void mmap() {
        OkHttpClient client = new OkHttpClient();
        // 注意 请求中若带有IP属性，则返回该IP的地理位置，若无则会针对发来请求的IP进行定位
        Request request = new Request.Builder().get().url("https://api.map.baidu.com/location/ip?ak=RcBP8qTywCUbZ6CnsIYQa0sPHLYUEcWk").build();
        try {
            Response response = client.newCall(request).execute();
            s = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getS() {
        return s;
    }

    @Override
    public void run() {
        mmap();
    }
}