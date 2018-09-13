package com.yass.jiecao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.yass.R;
import com.yass.base.BaseFragment;

import cn.jzvd.JzvdStd;


/**
 * Fragment
 *
 * Created by wxyass on 2018/8/17.
 */
public class JieCaoMainFragment extends BaseFragment implements View.OnClickListener {

    com.yass.jiecao.CustomView.MyJzvdStd jzvdStd;

    Button mTinyWindow;
    Button mListView;
    Button mDirectFullscreen;
    Button mApi;
    Button mWebView;

    public JieCaoMainFragment() {
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
        View view = inflater.inflate(R.layout.activity_jiecao_main,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        String mp4url = "http://images.wxyass.com/wxyass/images/TroubleMaker.mp4";
        String imgurl = "http://images.wxyass.com/wxyass/images/20180909160358.png";

        jzvdStd = (com.yass.jiecao.CustomView.MyJzvdStd) view.findViewById(R.id.videoplayer);

        mTinyWindow = (Button) view.findViewById(R.id.main_tiny_window);
        mDirectFullscreen = (Button) view.findViewById(R.id.direct_play);
        mListView = (Button) view.findViewById(R.id.main_listview);
        mApi = (Button) view.findViewById(R.id.api);
        mWebView = (Button) view.findViewById(R.id.main_webview);

        /*mTinyWindow.setOnClickListener(this);
        mListView.setOnClickListener(this);
        mDirectFullscreen.setOnClickListener(this);
        mApi.setOnClickListener(this);
        mWebView.setOnClickListener(this);*/

        jzvdStd.setUp(mp4url, "饺子快长大", JzvdStd.SCREEN_WINDOW_NORMAL);
        Glide.with(this).load(imgurl).into(jzvdStd.thumbImageView);
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
