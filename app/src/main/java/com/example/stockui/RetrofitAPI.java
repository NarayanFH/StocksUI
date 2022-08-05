package com.example.stockui;

import com.example.stockui.models.StocksModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("stocks/getstockdata/")
    Call<StocksModel> getPageStocks(@Body StocksModel stocksModel);

//    @FormUrlEncoded
//    @POST("stocks/getstockdata/")
//    Call<StocksModel> getPageBody(
//            @Field("page") int page
//    );


//    @FormUrlEncoded
//    @POST("stocks/getstockdata/")
//    Call<StocksModel> getPageStock(@Field("page") int page);
}
