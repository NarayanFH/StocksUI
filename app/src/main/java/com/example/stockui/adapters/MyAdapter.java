//package com.example.stockui.adapters;
//
//
//import android.content.Context;
//
//
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import com.example.stockui.fragments.AllStocks;
//
//public class MyAdapter extends FragmentPagerAdapter {
//
//    private Context myContext;
//    int totalTabs;
//
//    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
//        super(fm);
//        myContext = context;
//        this.totalTabs = totalTabs;
//    }
//
//    // this is for fragment tabs
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                AllStocks allStocks = new AllStocks();
//                return allStocks;
//            case 1:
//                SportFragment sportFragment = new SportFragment();
//                return sportFragment;
//            case 2:
//                MovieFragment movieFragment = new MovieFragment();
//                return movieFragment;
//            default:
//                return null;
//        }
//    }
//    // this counts total number of tabs
//    @Override
//    public int getCount() {
//        return totalTabs;
//    }
//}