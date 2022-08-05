//package com.example.stockui.adapters;
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
//public class ViewPagerAdapter
//        extends FragmentPagerAdapter {
//
//    public ViewPagerAdapter(
//            @NonNull FragmentManager fm)
//    {
//        super(fm);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position)
//    {
//        Fragment fragment = null;
//        if (position == 0)
//            fragment = new AllStocks();
//        else if (position == 1)
//            fragment = new TopGainers();
//        else if (position == 2)
//            fragment = new TopLosers();
//        return fragment;
//    }
//
//    @Override
//    public int getCount()
//    {
//        return 3;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position)
//    {
//        String title = null;
//        if (position == 0)
//            title = "ALlStocks";
//        else if (position == 1)
//            title = "TopLosers";
//        else if (position == 2)
//            title = "TopGainers";
//        return title;
//    }
//}
