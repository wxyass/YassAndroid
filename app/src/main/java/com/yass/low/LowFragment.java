package com.yass.low;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.core.web.WebDelegateImpl;
import com.yass.R;
import com.yass.appbarlayout.AppbarLayoutDemoFragment;
import com.yass.base.BaseFragment;
import com.yass.harvic.paintbasis.BasisViewFragment;
import com.yass.main.MainFragment;
import com.yass.toolbar.ToolBarDemoFragment;
import com.yass.video.common.CommonVideoFragment;
import com.yass.webview.WebFragment;


/**
 * 测试 跳转Fragment
 *
 * Created by wxyass on 2018/8/17.
 */
public class LowFragment extends BaseFragment implements View.OnClickListener {

    public LowFragment() {
    }

    // 接收传递过来的参数
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // 初始化控件
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_low,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }

    // 加载数据
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        /*if(findChildFragment(LowFragment.class)==null){
            // loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }*/
        initData();
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.third_rl_1://
                ((MainFragment) getParentFragment()).start(new BasisViewFragment());
                break;*/
        }
    }
}
