//package com.example.stockui.adapters;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
////import com.example.stockui.fragments.AllStocks;
//import com.example.stockui.fragments.TopGainers;
//import com.example.stockui.fragments.TopLosers;
//
//public class TabLayoutAdapter extends FragmentPagerAdapter {
//
//    Context mContext;
//    int mTotalTabs;
//
//    public TabLayoutAdapter(Context context , FragmentManager fragmentManager , int totalTabs) {
//        super(fragmentManager);
//        mContext = context;
//        mTotalTabs = totalTabs;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        Log.d("asasas" , position + "");
//        switch (position) {
//            case 0:
//                return new AllStocks();
//            case 1:
//                return new TopGainers();
//            case 2:
//                return new TopLosers();
//            default:
//                return null;
//
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return mTotalTabs;
//    }
//}
