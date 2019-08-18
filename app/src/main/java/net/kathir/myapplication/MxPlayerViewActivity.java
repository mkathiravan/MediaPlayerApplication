package net.kathir.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;

public class MxPlayerViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mxplayer_view);

        MxVideoPlayerWidget videoPlayerWidget = (MxVideoPlayerWidget) findViewById(R.id.mpw_video_player);


        /**To enable the normal mode video player **/
       // videoPlayerWidget.startPlay("http://220.194.238.109/2/l/r/m/u/lrmuartyvcqytunfrqatzthrsrsmnm/hc.yinyuetai.com/A1460152D6652EB21A149B9DF5F7E92E.flv", MxVideoPlayer.SCREEN_LAYOUT_NORMAL, "video name");


        /**To enable full screen mode of the video      **/
        videoPlayerWidget.startFullscreen(MxPlayerViewActivity.this, MxVideoPlayerWidget.class,
                "http://220.194.238.109/2/l/r/m/u/lrmuartyvcqytunfrqatzthrsrsmnm/hc.yinyuetai.com/A1460152D6652EB21A149B9DF5F7E92E.flv"
                , "LUV Apink");
    }



    @Override
    protected void onPause() {
        super.onPause();
        MxVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (MxVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
