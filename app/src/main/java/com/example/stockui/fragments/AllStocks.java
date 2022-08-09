package com.example.stockui.fragments;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockui.R;
import com.example.stockui.RetrofitAPI;
import com.example.stockui.Utils.NetworkClass;
import com.example.stockui.adapters.StocksRVAdapter;
import com.example.stockui.databinding.FragmentAllStocksBinding;
import com.example.stockui.models.StocksModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStocks extends Fragment {
    FragmentAllStocksBinding mBinding;
    private ArrayList<StocksModel> stocksModelList;
    StocksRVAdapter stocksRVAdapter;
    int page = 1;
    int savedPage = 1;
    Parcelable state;
    public AllStocks() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_all_stocks, container, false);

        mBinding = FragmentAllStocksBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        getDataFromAPI(page);
        stocksModelList = new ArrayList<>();
        mBinding.rvStocksMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE) {
                    page++;
                    getDataFromAPI(page);
                    System.out.println("Page Number: " + page);
                }
            }
        });

//        mBinding.rvStocksMain.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//                    @Override
//                    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                        if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                            page++;
//                            getDataFromAPI(page);
//                            System.out.println("Page Number: " + page);
//                        }
//                    }
//                });

        return view;
    }

    private void getDataFromAPI(int page) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait...");
//        progressDialog.setProgressDrawable(drawable/fintoo_loader_gif);
        progressDialog.setCancelable(false);
        progressDialog.show();
        StocksModel stocksModel = new StocksModel();
        stocksModel.setPage(page);
        NetworkClass.apiClient().create(RetrofitAPI.class).getPageStocks(stocksModel)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        System.out.println("Response body:" + response.body());
                        Log.e("Stock Rwspnseo:--", response.body().toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONArray dataArray = jsonObject.getJSONArray("data");
                            Log.e("jsonObjectasset", jsonObject.toString());
                            String value = jsonObject.optString("data", "");
                            Gson gson = new Gson();
                            Type typeToken = new TypeToken<List<StocksModel>>() {
                            }.getType();
                            stocksRVAdapter = new StocksRVAdapter(stocksModelList, getActivity());
                            stocksModelList.addAll(gson.fromJson(value, typeToken));
                            mBinding.rvStocksMain.setLayoutManager(new LinearLayoutManager(getActivity()));
                            mBinding.rvStocksMain.setAdapter(stocksRVAdapter);
                            stocksRVAdapter.updateDataSet(stocksModelList);
                            System.out.println(savedPage);
                            progressDialog.dismiss();
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        progressDialog.dismiss();
                        System.out.println("Error From APi  ......" + t.getMessage());
                    }
                });
    }
}