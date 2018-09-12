package com.yass.bmob;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.yass.R;
import com.yass.base.BaseActivity;
import com.yass.bmob.domain.Person;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 测试 跳转Activity
 */
public class BmobActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmob);

        //默认初始化
        Bmob.initialize(this, "4c1af865be4b31c8e2bae4e8f1f2b78c");

        addData();
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

    // 添加数据
    private void addData() {
        Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    //
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
