package com.yass.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yass.R;
import com.yass.base.BaseActivity;
import com.yass.base.BaseMainFragment;
import com.yass.first.FirstFragment;
import com.yass.operation.ThirdFragment;
import com.yass.syssetting.FourthFragment;
import com.yass.visit.SecondFragment;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity implements BaseMainFragment.OnBackToFirstListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tl_tab);
        mViewPager = (ViewPager) findViewById(R.id.vp_content);

        initContent();
    }


    private void initContent() {
        tabIndicators = new ArrayList<>();
        tabIndicators.add("首页");
        tabIndicators.add("巡店管理");
        tabIndicators.add("运营管理");
        tabIndicators.add("系统管理");

        tabFragments = new ArrayList<>();
        tabFragments.add(FirstFragment.newInstance());
        tabFragments.add(SecondFragment.newInstance());
        tabFragments.add(ThirdFragment.newInstance());
        tabFragments.add(FourthFragment.newInstance());

        contentAdapter = new MainAdapter(getSupportFragmentManager(), tabFragments, tabIndicators);
        mViewPager.setAdapter(contentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setupNewTabIcons();// 设置底部菜单的图标
    }

    private void setupNewTabIcons() {
        for (int i = 0; i < tabIndicators.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.tab_layout_item, null);
            ImageView img_title = (ImageView) view.findViewById(R.id.img_tab_text);
            TextView txt_title = (TextView) view.findViewById(R.id.tv_tab_text);
            img_title.setImageResource(tabIcons[i]);
            txt_title.setText(tabIndicators.get(i));
            mTabLayout.getTabAt(i).setCustomView(view);
        }
    }

    // 对返回键进行监听
    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void OnBackToFirstFragment() {
        Toast.makeText(this, "先返回第一个Fragment", Toast.LENGTH_SHORT).show();
        // 回到第一个导航页
        mTabLayout.getTabAt(0).select();
        mViewPager.setCurrentItem(0);
    }
}