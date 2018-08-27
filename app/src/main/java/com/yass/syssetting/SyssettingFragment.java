package com.yass.syssetting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yass.R;
import com.yass.base.BaseFragment;


/**
 * 第四个导航页
 *
 * Created by wxyass on 2018/8/17.
 */
public class SyssettingFragment extends BaseFragment implements View.OnClickListener{

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

    public SyssettingFragment() {
    }

    public static SyssettingFragment newInstance(){
        Bundle args = new Bundle();
        SyssettingFragment fragment = new SyssettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourthimpl,container,false);
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
            case R.id.dd_system_rl_repwd:// 修改密码
                YearLowFragment lowFragment = new YearLowFragment();
                //((BaseFragment) getParentFragment()).
                        start(lowFragment);
                break;
            case R.id.dd_system_rl_question:// 问题反馈
                break;
            case R.id.dd_system_rl_upload:// 检查更新

                break;
            case R.id.dd_system_rl_about:// 关于系统
                break;
            case R.id.dd_system_rl_exit:// 退出系统
                System.exit(0);
                break;
        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        /*if(findChildFragment(SyssettingFragment.class)==null){
            // loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }*/
    }
}
