package com.yass.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.core.web.WebDelegateImpl;
import com.yass.R;
import com.yass.appbarlayout.AppbarLayoutDemoFragment;
import com.yass.base.BaseMainFragment;
import com.yass.bmob.BmobActivity;
import com.yass.harvic.paintbasis.BasisViewFragment;
import com.yass.jiecao.JieCaoMainActivity;
import com.yass.low.SecondActivity;
import com.yass.main.MainFragment;
import com.yass.toolbar.ToolBarDemoFragment;
import com.yass.webview.WebFragment;
import com.yass.yuyin.YuyinFragment;


/**
 * 第三个导航页
 * <p>
 * Created by wxyass on 2018/8/17.
 */
public class ThirdFragment extends BaseMainFragment implements View.OnClickListener {

    private LinearLayout mThird_rl_1;
    private LinearLayout mThird_rl_2;
    private LinearLayout mThird_rl_3;
    private LinearLayout mThird_rl_4;
    private LinearLayout mThird_rl_5;
    private LinearLayout mThird_rl_6;
    private LinearLayout mThird_rl_7;
    private LinearLayout mThird_rl_8;
    private LinearLayout mThird_rl_9;
    private LinearLayout mThird_rl_10;
    private LinearLayout mThird_rl_11;
    private LinearLayout mThird_rl_12;


    public static ThirdFragment newInstance() {
        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mThird_rl_1 = (LinearLayout) view.findViewById(R.id.third_rl_1);
        mThird_rl_2 = (LinearLayout) view.findViewById(R.id.third_rl_2);
        mThird_rl_3 = (LinearLayout) view.findViewById(R.id.third_rl_3);
        mThird_rl_4 = (LinearLayout) view.findViewById(R.id.third_rl_4);
        mThird_rl_5 = (LinearLayout) view.findViewById(R.id.third_rl_5);
        mThird_rl_6 = (LinearLayout) view.findViewById(R.id.third_rl_6);
        mThird_rl_7 = (LinearLayout) view.findViewById(R.id.third_rl_7);
        mThird_rl_8 = (LinearLayout) view.findViewById(R.id.third_rl_8);
        mThird_rl_9 = (LinearLayout) view.findViewById(R.id.third_rl_9);
        mThird_rl_10 = (LinearLayout) view.findViewById(R.id.third_rl_10);
        mThird_rl_11 = (LinearLayout) view.findViewById(R.id.third_rl_11);
        mThird_rl_12 = (LinearLayout) view.findViewById(R.id.third_rl_12);

        mThird_rl_1.setOnClickListener(this);
        mThird_rl_2.setOnClickListener(this);
        mThird_rl_3.setOnClickListener(this);
        mThird_rl_4.setOnClickListener(this);
        mThird_rl_5.setOnClickListener(this);
        mThird_rl_6.setOnClickListener(this);
        mThird_rl_7.setOnClickListener(this);
        mThird_rl_8.setOnClickListener(this);
        mThird_rl_9.setOnClickListener(this);
        mThird_rl_10.setOnClickListener(this);
        mThird_rl_11.setOnClickListener(this);
        mThird_rl_12.setOnClickListener(this);

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(ThirdFragment.class) == null) {
            // loadRootFragment(R.id.fl_third_container, FourthFragment.newInstance());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.third_rl_1:// 1 自定义控件之开篇
                ((MainFragment) getParentFragment()).start(new BasisViewFragment());
                break;
            case R.id.third_rl_2:// 2 自定义控件之动画篇
                //((MainFragment) getParentFragment()).start(new CommonVideoFragment());
                break;
            case R.id.third_rl_3:// 3 自定义控件之绘图篇
                ((MainFragment) getParentFragment()).start(new WebFragment());
                break;
            case R.id.third_rl_4:// 4 自定义控件之视图篇
                final WebDelegateImpl delegate = WebDelegateImpl.create("http://wxyass.com/");
                ((MainFragment) getParentFragment()).start(delegate);
                break;
            case R.id.third_rl_5:// toolbar的使用
                ((MainFragment) getParentFragment()).start(new ToolBarDemoFragment());
                break;
            case R.id.third_rl_6:// AppbarLayout的简单用法
                ((MainFragment) getParentFragment()).start(new AppbarLayoutDemoFragment());
                break;
            case R.id.third_rl_7:// 语音
                ((MainFragment) getParentFragment()).start(new YuyinFragment());
                break;
            case R.id.third_rl_8:// Bmob
                _mActivity.startActivity(new Intent(_mActivity, BmobActivity.class));
                break;
            case R.id.third_rl_9:// jiecao播放
                _mActivity.startActivity(new Intent(_mActivity, JieCaoMainActivity.class));
                break;
            case R.id.third_rl_10://
                _mActivity.startActivity(new Intent(_mActivity, SecondActivity.class));
                break;
            case R.id.third_rl_11://
                _mActivity.startActivity(new Intent(_mActivity, SecondActivity.class));
                break;
            case R.id.third_rl_12://
                _mActivity.startActivity(new Intent(_mActivity, SecondActivity.class));
                break;
        }
    }
}
