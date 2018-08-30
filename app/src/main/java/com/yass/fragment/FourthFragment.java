package com.yass.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.core.web.WebDelegateImpl;
import com.yass.R;
import com.yass.base.BaseMainFragment;
import com.yass.main.MainFragment;
import com.yass.syssetting.LowFragment;
import com.yass.video.common.CommonVideoFragment;
import com.yass.webview.WebFragment;


/**
 * 第四个导航页
 *
 * Created by wxyass on 2018/8/17.
 */
public class FourthFragment extends BaseMainFragment implements View.OnClickListener{

    private RelativeLayout backBtn;
    private RelativeLayout confirmBtn;
    private AppCompatTextView confirmTv;
    private AppCompatTextView backTv;
    private AppCompatTextView titleTv;

    RelativeLayout repwd;
    RelativeLayout question;
    RelativeLayout uploadApk;
    RelativeLayout about;
    RelativeLayout exit;

    private View rootView;//缓存Fragment view

    public FourthFragment() {
    }

    public static FourthFragment newInstance(){
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_syssetting,container,false);
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

        repwd = (RelativeLayout) view.findViewById(R.id.dd_system_rl_repwd);
        question = (RelativeLayout) view.findViewById(R.id.dd_system_rl_question);
        uploadApk = (RelativeLayout) view.findViewById(R.id.dd_system_rl_upload);
        about = (RelativeLayout) view.findViewById(R.id.dd_system_rl_about);
        exit = (RelativeLayout) view.findViewById(R.id.dd_system_rl_exit);

        repwd.setOnClickListener(this);
        question.setOnClickListener(this);
        uploadApk.setOnClickListener(this);
        about.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dd_system_rl_repwd:// Fragment跳转
                ((MainFragment) getParentFragment()).start(new LowFragment());
                break;
            case R.id.dd_system_rl_question:// 普通视频
                ((MainFragment) getParentFragment()).start(new CommonVideoFragment());
                break;
            case R.id.dd_system_rl_upload:// 个人博客
                /*final WebDelegateImpl wxyassblogs = WebDelegateImpl.create("http://wxyass.com/");
                // delegate.setTopDelegate(getParentFragment());
                ((MainFragment) getParentFragment()).start(wxyassblogs);*/

                ((MainFragment) getParentFragment()).start(new WebFragment());
                break;
            case R.id.dd_system_rl_about:// 私人定制
                final WebDelegateImpl delegate = WebDelegateImpl.create("http://c.n.h.k.s8ziyuan.space/forum.php");
                // delegate.setTopDelegate(getParentFragment());
                ((MainFragment) getParentFragment()).start(delegate);
                break;
            case R.id.dd_system_rl_exit:// 退出系统
                System.exit(0);
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
