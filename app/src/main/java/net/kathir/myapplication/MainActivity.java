package net.kathir.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.kathir.myapplication.fbembedded.FacebookVideoViewActivity;
import net.kathir.myapplication.mkplayer.MkPlayerActivity;
import net.kathir.myapplication.sampleAudio.AudioViewActivity;
import net.kathir.myapplication.youtube.YoutubeChannelActivity;

public class MainActivity extends AppCompatActivity {

    Button normalVideoView,mxVideoView,youtubeView,audioView,facbookVideoView,mkPlayerVideoView,youtubeViewPlay,
            exoPlayerView,mxVideoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalVideoView = (Button)findViewById(R.id.normal_video_view);
        mxVideoView = (Button)findViewById(R.id.mx_video_view);
        youtubeView = (Button)findViewById(R.id.youtube_view);
        audioView = (Button)findViewById(R.id.audio_view);
        facbookVideoView = (Button)findViewById(R.id.facebook_video);
        mkPlayerVideoView = (Button)findViewById(R.id.mkplayer_video);
        youtubeViewPlay = (Button)findViewById(R.id.youtube_video_play);
        exoPlayerView = (Button)findViewById(R.id.exo_video_play);
        mxVideoPlayerView = (Button)findViewById(R.id.mx_video_player_view);


        normalVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalVideoViewActivity.class);
                startActivity(intent);
            }
        });

        mxVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,YouTubeActivity.class);
                startActivity(intent);
            }
        });

        youtubeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YoutubeChannelActivity.class);
                startActivity(intent);
            }
        });

        audioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AudioViewActivity.class);
                startActivity(intent);

            }
        });

        facbookVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FacebookVideoViewActivity.class);
                startActivity(intent);

            }
        });

        mkPlayerVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MkPlayerActivity.class);
                startActivity(intent);
            }
        });

        youtubeViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, YouTuberPlayActivity.class);
                startActivity(intent);

            }
        });

        exoPlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ExoPlayerActivity.class);
                startActivity(intent);

            }
        });

        mxVideoPlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MxPlayerViewActivity.class);
                startActivity(intent);

            }
        });

    }
}
