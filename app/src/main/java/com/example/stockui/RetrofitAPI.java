package com.example.stockui;

import com.example.stockui.models.StocksModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {


    @POST("stocks/getstockdata/")
    Call<ResponseBody> getPageStocks();


//    @FormUrlEncoded
//    @POST("stocks/getstockdata/")
//    Call<StocksModel> getPageStock(@Body @Field("page") int page);
}
