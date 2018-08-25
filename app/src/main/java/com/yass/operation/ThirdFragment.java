package com.yass.operation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yass.R;
import com.yass.base.BaseMainFragment;


/**
 * 第三个导航页
 *
 * Created by wxyass on 2018/8/17.
 */
public class ThirdFragment extends BaseMainFragment {

    public static ThirdFragment newInstance(){
        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if(findChildFragment(ThirdFragment.class)==null){
            // loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }
    }
}
