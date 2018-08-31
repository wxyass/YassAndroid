package com.yass.low;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.yass.R;
import com.yass.base.BaseActivity;

/**
 * 测试 跳转Activity
 */
public class SecondActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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
