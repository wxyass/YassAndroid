package com.yass.base;

import android.content.Context;

import com.yass.core.initbase.InitFragment;
import com.yass.first.FirstFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 导航页基础Fragment
 *
 * Created by wxyass on 2018/8/17.
 */
public class BaseMainFragment extends InitFragment {
    protected OnBackToFirstListener _mBackToFirstListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackToFirstListener) {
            _mBackToFirstListener = (OnBackToFirstListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _mBackToFirstListener = null;
    }

    // 对返回键进行监听
    @Override
    public boolean onBackPressedSupport() {
        // 当前栈中的Fragment个数大于1
        if(getChildFragmentManager().getBackStackEntryCount()>1){
            popChild();
        }else{
            // 当前的Fragment是第一个导航页,直接退出
            if(this instanceof FirstFragment){
                _mActivity.finish();
            }else{
                // 返回到第一个导航页
                _mBackToFirstListener.OnBackToFirstFragment();
            }
        }
        return true;
    }

    public interface OnBackToFirstListener {
        void OnBackToFirstFragment();
    }
}
