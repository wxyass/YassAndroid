package com.yass.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yass.R;
import com.yass.base.BaseFragment;


/**
 * AppbarLayout的使用
 *
 * https://www.jianshu.com/p/bbc703a0015e
 *
 *
 * Created by wxyass on 2018/8/17.
 */
public class AppbarLayoutDemoFragment extends BaseFragment {

    public AppbarLayoutDemoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_appbarlayout,container,false);
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
}
