package com.example.stockui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stockui.databinding.ActivityMainBinding;
import com.example.stockui.models.StocksModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

//    List<StocksModel> stocksModelList = new ArrayList<>();
    int page = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        getDataFromAPI(page);

//        mBinding.nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                    page = (page.substring(1, page.length()) + 1);
//                    loadingPB.setVisibility(View.VISIBLE);
//                    getDataFromAPI(page);
//                    loadingPB.setVisibility(View.INVISIBLE);
//                }
//            }
//        });
//    }
    }

    private void getDataFromAPI(int page) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url();
                        HttpUrl newHttpUrl = httpUrl
                                .newBuilder()
                                .addQueryParameter("page", Integer.toString(page))
                                .build();
                        Request.Builder requestBuilder = original
                                .newBuilder()
                                .url(newHttpUrl);
                        Request request = requestBuilder
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://minty.co.in/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        StocksModel stocksModel = new StocksModel();
        stocksModel.setPage(page);

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<StocksModel> call = retrofitAPI.getPageStocks(stocksModel);

        call.enqueue(new Callback<StocksModel>() {
            @Override
            public void onResponse(Call<StocksModel> call, Response<StocksModel> response) {

                StocksModel responseFromAPI = response.body();
                System.out.println("Response ---a-"+responseFromAPI.data);
            }

            @Override
            public void onFailure(Call<StocksModel> call, Throwable t) {
                System.out.println("Error From APi  ......" + t.getMessage());
            }
        });

//        Call<StocksModel> call = retrofitAPI.getPageStocks(stocksModel);
//        call.enqueue(new Callback<StocksModel>() {
//            @Override
//            public void onResponse(Call<StocksModel> call, Response<StocksModel> response) {
//
//                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
//                StocksModel responseFromAPI = response.body();
//                System.out.println("Error:" + responseFromAPI);
//
//            }
//
//            @Override
//            public void onFailure(Call<StocksModel> call, Throwable t) {
//                System.out.println("Error From APi  ......" + t.getMessage());
//            }
//        });


//        retrofit.create(RetrofitAPI.class).getPageStocks(stocksModel)
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        int getResponse = Log.e("GetResponse body", response.body().toString());
//                        try {
//                            JSONObject jsonObject = new JSONObject(response.body().string());
//                            Log.e("jsonObject", jsonObject.toString());
//                            Gson gson = new Gson();
//                            Type typeToken = new TypeToken<List<StocksModel>>() {
//                            }.getType();
//                            stocksModelList = gson.fromJson(jsonObject.getJSONArray("data").toString(), typeToken);
//                            System.out.println("Stocks Model load" + stocksModelList);
//                        } catch (Exception e) {
//                            Log.e("error", e.toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        System.out.println("Some error");
//                        t.printStackTrace();
//                    }
//                });
    }

}


//*** tab layout and old adapter bindings

//    TabLayout tabLayout;
//    ViewPager viewPager;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//
//        tabLayout=findViewById(R.id.tablayout);
//        viewPager=findViewById(R.id.viewPager);
//        tabLayout.addTab(tabLayout.newTab().setText("All Stocks"));
//        tabLayout.addTab(tabLayout.newTab().setText("Top Gainers"));
//        tabLayout.addTab(tabLayout.newTab().setText("Top losers"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        TabLayoutAdapter adapter=new TabLayoutAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
//
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


//        userRV = findViewById(R.id.rvStockCard);
//        loadingPB = findViewById(R.id.idPBLoading);
//        nestedSV = findViewById(R.id.idNestedSV);

//    private RecyclerView userRV;
//    private ProgressBar loadingPB;
//    private NestedScrollView nestedSV;


