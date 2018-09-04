package com.yass.ijkplayerdemo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ijk.media.IjkVideoView;
import com.ijk.media.PlayerManager;
import com.yass.R;
import com.yass.base.BaseFragment;

import tv.danmaku.ijk.media.player.IMediaPlayer;


/**
 * 视频播放Fragment
 *
 * https://blog.csdn.net/huaxun66/article/details/53401231
 *
 * https://blog.csdn.net/sunchaohui5741/article/details/80520066
 *
 * https://blog.csdn.net/qwe511455842/article/details/80373217
 *
 * Created by wxyass on 2018/8/17.
 */
public class IjkPlayerDemoFragment extends BaseFragment implements View.OnClickListener{

    private IjkVideoView mVideoView;
    private PlayerManager player;

    private String url5 = "http://stream1.grtn.cn/tvs2/sd/live.m3u8?_ts&time=1518428696629";
    private String url6 = "http://218.207.213.137//PLTV/88888888/224/3221225879/index.m3u8";
    private String url7 = "http://183.251.61.207/PLTV/88888888/224/3221225829/index.m3u8";
    private String url8 = "http://dn-chunyu.qbox.me/fwb/static/images/home/video/video_aboutCY_A.mp4";

    public IjkPlayerDemoFragment() {
    }

    // 接收传递过来的参数
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // 初始化控件
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ijk,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mVideoView = (IjkVideoView) view.findViewById(R.id.video_view_ijk);
    }

    // 加载数据
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        /*if(findChildFragment(LowFragment.class)==null){
            // loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }*/
        initData();
    }

    private void initData() {
        /** 普通播放 start **/
//        mVideoView.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
//        mVideoView.setVideoURI(Uri.parse(url8));
//        mVideoView.start();
        /** 普通播放 end **/

        initVideo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.third_rl_1://
                ((MainFragment) getParentFragment()).start(new BasisViewFragment());
                break;*/
        }
    }

    //使用滑动控制的话解开注释
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (player.gestureDetector.onTouchEvent(event))
//            return true;
//        return super.onTouchEvent(event);
//    }

    /**
     * 可左半屏滑动控制亮度  右半屏控制音量  双击切换比例  （无提示）
     */
    private void initVideo() {
        player = new PlayerManager(_mActivity,mVideoView);
        player.setFullScreenOnly(true);
        player.live(true);
        player.setScaleType(PlayerManager.SCALETYPE_WRAPCONTENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(new PlayerManager.PlayerStateListener() {
            @Override
            public void onComplete() {
                Log.e("   player  status    :", "complete");
            }

            @Override
            public void onError() {
                Log.e("   player  status    :", "error");
            }

            @Override
            public void onLoading() {
                Log.e("   player  status    :", "loading");
            }

            @Override
            public void onPlay() {
                Log.e("   player  status    :", "play");
            }
        });
        player.play(url8);
        IjkVideoView videoView = player.getVideoView();
        videoView.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                switch (i) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                    case MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                        break;
                }
                return false;

            }
        });
    }
}
