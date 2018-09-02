package com.yass.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yass.R;
import com.yass.base.BaseFragment;


/**
 * 使用Toolbar
 *
 * Created by wxyass on 2018/8/17.
 */
public class ToolBarDemoFragment extends BaseFragment {

    private Toolbar toolbar;


    public ToolBarDemoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_toolbar,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

         toolbar = view.findViewById(R.id.toolbar);
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


        initToolbarNav(toolbar);

        // 1 在res资源下增加一个"menu"目录, 添加一个menu_main.xml菜单文件.



    }
}
