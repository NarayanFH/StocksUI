package com.example.stockui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.stockui.Utils.NetworkClass;
import com.example.stockui.adapters.StocksRVAdapter;
import com.example.stockui.adapters.ViewPagerAdapter;
import com.example.stockui.databinding.ActivityMainBinding;
import com.example.stockui.models.StocksModel;
import com.google.android.material.tabs.TabLayout;
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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager());
        mBinding.viewPager.setAdapter(viewPagerAdapter);
        mBinding.tablayout.setupWithViewPager(mBinding.viewPager);
    }
}


