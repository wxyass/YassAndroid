package com.yass.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.core.web.WebDelegateImpl;
import com.yass.R;
import com.yass.base.BaseFragment;
import com.yass.main.MainFragment;



/**
 * WebFragment  (嵌套FrameLayout)
 * <p>
 * Created by wxyass on 2018/8/17.
 */
public class WebFragment extends BaseFragment implements View.OnClickListener {


    public static final int LOCAL = 0; // 本地
    public static final int ONLINE = 1; // 在线
    private FragmentManager mFM;

    RelativeLayout about;
    RelativeLayout uploadApk;

    public WebFragment() {
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
        View view = inflater.inflate(R.layout.fragment_web_common, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        uploadApk = (RelativeLayout) view.findViewById(R.id.web_rl_local);
        about = (RelativeLayout) view.findViewById(R.id.web_rl_online);

        uploadApk.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    // 加载数据
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initData();
    }

    private void initData() {
        WebDelegateImpl webDelegate = WebDelegateImpl.create("http://wxyass.com/");
        webDelegate.setTopDelegate(this);
        loadRootFragment(R.id.web_fl_container, webDelegate);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.web_rl_local:// 本地视频
                break;
            case R.id.web_rl_online:// 网络视频
                break;
        }
    }
}
