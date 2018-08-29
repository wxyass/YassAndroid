package com.yass.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yass.R;
import com.yass.base.BaseFragment;
import com.yass.base.BaseMainFragment;
import com.yass.fragment.FirstFragment;
import com.yass.fragment.FourthFragment;
import com.yass.fragment.ThirdFragment;
import com.yass.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class MainFragment extends BaseFragment {
    private static final int REQ_MSG = 10;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> tabIndicators;
    private List<BaseMainFragment> tabFragments;
    private int[] tabIcons = {
            R.drawable.selector_tab_image_first,
            R.drawable.selector_tab_image_second,
            R.drawable.selector_tab_image_thrid,
            R.drawable.selector_tab_image_fourth
    };
    private MainAdapter contentAdapter;


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tl_tab);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
    }

    private void initContent() {
        tabIndicators = new ArrayList<>();
        tabIndicators.add("新闻");
        tabIndicators.add("游戏");
        tabIndicators.add("电影");
        tabIndicators.add("我的");

        tabFragments = new ArrayList<>();
        tabFragments.add(FirstFragment.newInstance());
        tabFragments.add(SecondFragment.newInstance());
        tabFragments.add(ThirdFragment.newInstance());
        tabFragments.add(FourthFragment.newInstance());

        contentAdapter = new MainAdapter(getChildFragmentManager(), tabFragments, tabIndicators);
        mViewPager.setAdapter(contentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setupNewTabIcons();// 设置底部菜单的图标
    }

    private void setupNewTabIcons() {
        for (int i = 0; i < tabIndicators.size(); i++) {
            View view = LayoutInflater.from(_mActivity).inflate(R.layout.item_tab_layout, null);
            ImageView img_title = (ImageView) view.findViewById(R.id.img_tab_text);
            TextView txt_title = (TextView) view.findViewById(R.id.tv_tab_text);
            img_title.setImageResource(tabIcons[i]);
            txt_title.setText(tabIndicators.get(i));
            mTabLayout.getTabAt(i).setCustomView(view);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initContent();
    }


    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(BaseFragment targetFragment) {
        start(targetFragment);
    }
}
