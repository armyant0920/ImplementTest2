package com.example.implementtest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Https {

    private static final OkHttpClient mclient=new OkHttpClient().newBuilder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

//    static {
//
//
//    mclient=new
//
//    OkHttpClient().newBuilder
//}
}
