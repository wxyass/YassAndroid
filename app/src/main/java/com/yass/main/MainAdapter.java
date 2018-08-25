package com.yass.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.yass.base.BaseMainFragment;

import java.util.List;


/**
 * Created by wxyass on 2018/8/20.
 */
public class MainAdapter extends FragmentPagerAdapter {

    private List<String> tabIndicators;
    private List<BaseMainFragment> tabFragments;

    public MainAdapter(FragmentManager fm, List<BaseMainFragment> tabFragments, List<String> tabIndicators) {
        super(fm);
        this.tabIndicators = tabIndicators;
        this.tabFragments = tabFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragments.get(position);
    }

    @Override
    public int getCount() {
        return tabIndicators.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabIndicators.get(position);
    }
}
