package com.example.stockui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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
    NestedScrollView nestedScrollView;
    ProgressBar progressBar;
    RecyclerView recyclerView;
//    FragmentAllStocksBinding mBinding;
    private ArrayList<StocksModel> stocksModelList;
    StocksRVAdapter stocksRVAdapter;
    int page = 1;
    int savedPage = 1;

    public AllStocks() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_stocks, container, false);
        nestedScrollView = view.findViewById(R.id.idNestedSV);
        progressBar = view.findViewById(R.id.idPBLoading);
        recyclerView = view.findViewById(R.id.idRVUsers);


        getDataFromAPI(page);
        stocksModelList = new ArrayList<>();
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    page++;
                    getDataFromAPI(page);
                    System.out.println(savedPage);
                    System.out.println("Page Number" + page);
                } else if (scrollY == 0 & page > 1) {
                    page--;
                    getDataFromAPI(page);
                    System.out.println("Page Number" + page);
                }
            }
        });

        return view;
    }

    private void getDataFromAPI(int page) {
        StocksModel stocksModel = new StocksModel();
        stocksModel.setPage(page);
        NetworkClass.apiClient().create(RetrofitAPI.class).getPageStocks(stocksModel)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        progressBar.setVisibility(View.VISIBLE);
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
                            stocksModelList = gson.fromJson(value, typeToken);
                            for (int i = 0; i < dataArray.length(); i++) {
                                stocksModelList.add(new StocksModel(stocksModelList.get(i).getStockName(), stocksModelList.get(i).getCurrentPrice(), stocksModelList.get(i).getDayChangeP(), stocksModelList.get(i).getYearChangeP()));
                                stocksRVAdapter = new StocksRVAdapter(stocksModelList, getActivity());
                                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                recyclerView.setAdapter(stocksRVAdapter);
                            }
                            System.out.println(savedPage);
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("Error From APi  ......" + t.getMessage());
                    }
                });
    }
}