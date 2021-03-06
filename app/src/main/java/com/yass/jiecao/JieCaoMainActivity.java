package com.yass.jiecao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.yass.R;
import com.yass.base.BaseActivity;
import com.yass.main.MainActivity;
import com.yass.main.MyApplication;

import cn.jzvd.JZUserAction;
import cn.jzvd.JZUserActionStd;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * 播放主Activity
 */
public class JieCaoMainActivity extends BaseActivity implements View.OnClickListener {

    com.yass.jiecao.CustomView.MyJzvdStd jzvdStd;

    Button mTinyWindow;
    Button mListView;
    Button mDirectFullscreen;
    Button mApi;
    Button mWebView;

    String mp4url = "http://images.wxyass.com/wxyass/images/TroubleMaker.mp4";
    String imgurl = "http://images.wxyass.com/wxyass/images/20180909160358.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiecao_main);

        jzvdStd = (com.yass.jiecao.CustomView.MyJzvdStd) findViewById(R.id.videoplayer);

        mTinyWindow = (Button) findViewById(R.id.main_tiny_window);
        mDirectFullscreen = (Button) findViewById(R.id.direct_play);
        mListView = (Button) findViewById(R.id.main_listview);
        mApi = (Button) findViewById(R.id.api);
        mWebView = (Button) findViewById(R.id.main_webview);

        mTinyWindow.setOnClickListener(this);
        mListView.setOnClickListener(this);
        mDirectFullscreen.setOnClickListener(this);
        mApi.setOnClickListener(this);
        mWebView.setOnClickListener(this);

        jzvdStd.setUp(mp4url, "饺子快长大", JzvdStd.SCREEN_WINDOW_NORMAL);
        Glide.with(this).load(imgurl).into(jzvdStd.thumbImageView);
        Jzvd.setJzUserAction(new MyUserActionStd());

    }

    // 对返回键进行监听
    @Override
    public void onBackPressedSupport() {
        if (Jzvd.backPress()) {
            return;
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.api:
                startActivity(new Intent(MyApplication.getAppContext(), ActivityApi.class));
                break;
            case R.id.main_listview://
                startActivity(new Intent(JieCaoMainActivity.this, ActivityListView.class));
                break;
            case R.id.main_tiny_window:
                startActivity(new Intent(JieCaoMainActivity.this, ActivityTinyWindow.class));
                break;
            case R.id.direct_play:
                startActivity(new Intent(JieCaoMainActivity.this, ActivityDirectPlay.class));
                break;
            case R.id.main_webview://
                startActivity(new Intent(JieCaoMainActivity.this, ActivityWebView.class));
                break;
        }
    }


    /**
     * 这只是给埋点统计用户数据用的，不能写和播放相关的逻辑，监听事件请参考MyJzvdStd，复写函数取得相应事件
     */
    class MyUserActionStd implements JZUserActionStd {

        @Override
        public void onEvent(int type, Object url, int screen, Object... objects) {
            switch (type) {
                case JZUserAction.ON_CLICK_START_ICON:
                    Log.i("USER_EVENT", "ON_CLICK_START_ICON" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_CLICK_START_ERROR:
                    Log.i("USER_EVENT", "ON_CLICK_START_ERROR" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_CLICK_START_AUTO_COMPLETE:
                    Log.i("USER_EVENT", "ON_CLICK_START_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_CLICK_PAUSE:
                    Log.i("USER_EVENT", "ON_CLICK_PAUSE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_CLICK_RESUME:
                    Log.i("USER_EVENT", "ON_CLICK_RESUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_SEEK_POSITION:
                    Log.i("USER_EVENT", "ON_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_AUTO_COMPLETE:
                    Log.i("USER_EVENT", "ON_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_ENTER_FULLSCREEN:
                    Log.i("USER_EVENT", "ON_ENTER_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_QUIT_FULLSCREEN:
                    Log.i("USER_EVENT", "ON_QUIT_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_ENTER_TINYSCREEN:
                    Log.i("USER_EVENT", "ON_ENTER_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_QUIT_TINYSCREEN:
                    Log.i("USER_EVENT", "ON_QUIT_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_TOUCH_SCREEN_SEEK_VOLUME:
                    Log.i("USER_EVENT", "ON_TOUCH_SCREEN_SEEK_VOLUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserAction.ON_TOUCH_SCREEN_SEEK_POSITION:
                    Log.i("USER_EVENT", "ON_TOUCH_SCREEN_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;

                case JZUserActionStd.ON_CLICK_START_THUMB:
                    Log.i("USER_EVENT", "ON_CLICK_START_THUMB" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JZUserActionStd.ON_CLICK_BLANK:
                    Log.i("USER_EVENT", "ON_CLICK_BLANK" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                default:
                    Log.i("USER_EVENT", "unknow");
                    break;
            }
        }
    }
}
