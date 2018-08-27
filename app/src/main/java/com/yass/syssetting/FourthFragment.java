package com.yass.syssetting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yass.R;
import com.yass.base.BaseMainFragment;


/**
 * 第四个导航页
 *
 * Created by wxyass on 2018/8/17.
 */
public class FourthFragment extends BaseMainFragment {

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


    public static FourthFragment newInstance(){
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(findChildFragment(FourthFragment.class)==null){
            loadRootFragment(R.id.fl_fourth_container, SyssettingFragment.newInstance());
        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        /*if(findChildFragment(FourthFragment.class)==null){
            loadRootFragment(R.id.fl_fourth_container, new SyssettingFragment());
        }*/
    }
}
