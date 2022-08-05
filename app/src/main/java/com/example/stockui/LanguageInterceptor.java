package com.example.stockui;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class LanguageInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("page","1")
                .build();

        Request request = chain.request()
                .newBuilder()
                .url(url)
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}