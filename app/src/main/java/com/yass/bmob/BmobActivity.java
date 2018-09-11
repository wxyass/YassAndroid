package com.yass.bmob;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.yass.R;
import com.yass.base.BaseActivity;

/**
 * 测试 跳转Activity
 */
public class BmobActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmob);

        //默认初始化
        //Bmob.initialize(this, "1264bbfa6bec335ea1e022889c2dfdd2");
    }

    // 对返回键进行监听
    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }
}
