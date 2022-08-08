package com.example.stockui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.stockui.fragments.AllStocks;
import com.example.stockui.fragments.Fifty2Week;
import com.example.stockui.fragments.TopGainers;
import com.example.stockui.fragments.TopLosers;

public class ViewPagerAdapter
        extends FragmentPagerAdapter {

    public ViewPagerAdapter(
            @NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new AllStocks();
        else if (position == 1)
            fragment = new TopLosers();
        else if (position == 2)
            fragment = new TopGainers();
        else if (position == 3)
            fragment = new Fifty2Week();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "All Stocks";
        else if (position == 1)
            title = "Top Gainers";
        else if (position == 2)
            title = "Top Losers";
        else if (position == 3)
            title = "52 Week";
        return title;
    }
}
