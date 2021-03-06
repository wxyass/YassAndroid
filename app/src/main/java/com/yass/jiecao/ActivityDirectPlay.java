package com.yass.jiecao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yass.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by Nathen on 16/7/31.
 */
public class ActivityDirectPlay extends AppCompatActivity implements View.OnClickListener {
    Button mStartFullscreen, mStartTiny;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("DirectPlay");*/
        setContentView(R.layout.activity_directly_play);

        mStartFullscreen = findViewById(R.id.fullscreen);
        mStartTiny = findViewById(R.id.tiny_window);

        mStartFullscreen.setOnClickListener(this);
        mStartTiny.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fullscreen:
                JzvdStd.startFullscreen(this, JzvdStd.class, VideoConstant.videoUrlList[6], "饺子辛苦了");
                break;
            case R.id.tiny_window:
                Toast.makeText(ActivityDirectPlay.this, "Comming Soon", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
