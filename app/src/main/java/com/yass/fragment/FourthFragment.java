package com.yass.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.core.web.WebDelegateImpl;
import com.yass.R;
import com.yass.base.BaseMainFragment;
import com.yass.low.SecondActivity;
import com.yass.main.MainFragment;
import com.yass.low.LowFragment;
import com.yass.webview.WebFragment;


/**
 * 第四个导航页
 * <p>
 * Created by wxyass on 2018/8/17.
 */
public class FourthFragment extends BaseMainFragment implements View.OnClickListener {

    private RelativeLayout backBtn;
    private RelativeLayout confirmBtn;
    private AppCompatTextView confirmTv;
    private AppCompatTextView backTv;
    private AppCompatTextView titleTv;

    private LinearLayout mFourth_rl_01;
    private LinearLayout mFourth_rl_02;
    private LinearLayout mFourth_rl_03;
    private LinearLayout mFourth_rl_04;
    private LinearLayout mFourth_rl_05;
    private LinearLayout mFourth_rl_06;

    private View rootView;//缓存Fragment view

    public FourthFragment() {
    }

    public static FourthFragment newInstance() {
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        backBtn = (RelativeLayout) view.findViewById(R.id.top_navigation_rl_back);
        confirmBtn = (RelativeLayout) view.findViewById(R.id.top_navigation_rl_confirm);
        confirmTv = (AppCompatTextView) view.findViewById(R.id.top_navigation_bt_confirm);
        backTv = (AppCompatTextView) view.findViewById(R.id.top_navigation_bt_back);
        titleTv = (AppCompatTextView) view.findViewById(R.id.top_navigation_tv_title);
        backBtn.setVisibility(View.INVISIBLE);
        confirmBtn.setVisibility(View.INVISIBLE);
        confirmBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        mFourth_rl_01 = (LinearLayout) view.findViewById(R.id.fourth_rl_01);
        mFourth_rl_02 = (LinearLayout) view.findViewById(R.id.fourth_rl_02);
        mFourth_rl_03 = (LinearLayout) view.findViewById(R.id.fourth_rl_03);
        mFourth_rl_04 = (LinearLayout) view.findViewById(R.id.fourth_rl_04);
        mFourth_rl_05 = (LinearLayout) view.findViewById(R.id.fourth_rl_05);
        mFourth_rl_06 = (LinearLayout) view.findViewById(R.id.fourth_rl_06);

        mFourth_rl_01.setOnClickListener(this);
        mFourth_rl_02.setOnClickListener(this);
        mFourth_rl_03.setOnClickListener(this);
        mFourth_rl_04.setOnClickListener(this);
        mFourth_rl_05.setOnClickListener(this);
        mFourth_rl_06.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fourth_rl_01:// Fragment跳转
                ((MainFragment) getParentFragment()).start(new LowFragment());
                break;
            case R.id.fourth_rl_02:// 2

                StringBuffer buffer = new StringBuffer();
                buffer.append("http://192.168.0.35/app-main-intf/index.html");

                //final WebDelegateImpl index = WebDelegateImpl.create("index.html");
                final WebDelegateImpl index = WebDelegateImpl.create(buffer.toString());
                ((MainFragment) getParentFragment()).start(index);
                break;
            case R.id.fourth_rl_03:// Fragment中嵌套WebView
                ((MainFragment) getParentFragment()).start(new WebFragment());
                break;
            case R.id.fourth_rl_04:// 整体Fragment
                final WebDelegateImpl delegate = WebDelegateImpl.create("http://wxyass.com/");
                ((MainFragment) getParentFragment()).start(delegate);
                break;
            case R.id.fourth_rl_05:// 退出系统
                System.exit(0);
                break;
            case R.id.fourth_rl_06:// Activity跳转
                _mActivity.startActivity(new Intent(_mActivity, SecondActivity.class));
                break;

        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        /*if(findChildFragment(FourthFragment.class)==null){
            // loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }*/
    }
}
