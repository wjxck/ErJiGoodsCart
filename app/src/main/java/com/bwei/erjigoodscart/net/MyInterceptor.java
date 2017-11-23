package com.bwei.erjigoodscart.net;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
//        Request orginRequest = chain.request();
//        FormBody body = (FormBody) orginRequest.body();
//        String name = body.name(0);
//        Request.Builder builder = orginRequest.newBuilder();
//        FormBody formBody = new FormBody.Builder().add("source", "android").build();
//        Request request = builder.post(formBody).build();
//        return chain.proceed(request);

        //获取原始的请求数据
        Request orginRequest = chain.request();
        //先获取原始的请求参数，然后再拼接起来
        FormBody orginBody = (FormBody) orginRequest.body();
        FormBody.Builder builder = new FormBody.Builder();
        for (int i = 0; i < orginBody.size(); i++) {
            String name = orginBody.name(i);
            String value = orginBody.value(i);
            builder.add(name, value);
        }
        builder.add("source", "android");
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(orginRequest.url()).post(formBody).build();


        return chain.proceed(request);


    }
}