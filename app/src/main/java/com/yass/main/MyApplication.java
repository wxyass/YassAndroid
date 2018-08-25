package com.yass.main;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yass.R;
import com.yass.core.app.Latte;
import com.yass.core.icon.FontEcModule;
import com.yass.core.net.HttpUrl;
import com.yass.core.net.interceptors.DebugInterceptor;

import me.yokeyword.fragmentation.BuildConfig;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * Created by wxyass on 2018/8/17.
 */

public class MyApplication extends Application {

    public static final String TAG = "MyApplication";
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        MyApplication.context = getApplicationContext();

        // 通过全局配置器,配置参数
        Latte.init(this)// 配置ApplicationContext,全局handler
                .withIcon(new FontAwesomeModule())// 配置字体图标
                .withIcon(new FontEcModule())// 配置另一种字体图标
                .withApiHost(HttpUrl.API_HOST)// 配置ApiHost
                .withInterceptor(new DebugInterceptor("test", R.raw.test))// 拦截url请求中包含test的url请求
                .configure();// 修改→配置完成的标记true


        // 建议在Application里初始化
        Fragmentation.builder()
                // BUBBLE显示悬浮球 ; SHAKE: 摇一摇唤出 ;  NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
