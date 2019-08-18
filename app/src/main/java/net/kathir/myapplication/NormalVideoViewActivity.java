package net.kathir.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.URLUtil;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class NormalVideoViewActivity extends AppCompatActivity {

    private static final String video_path = "https://developers.google.com/training/images/tacoma_narrows.mp4";
    private VideoView mVideoview;
    private TextView mBuffereingTextview;
    private int mCurrentposition = 0;
    private static final String PLAY_TIME = "play_time";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_video_view);

        mVideoview = (VideoView)findViewById(R.id.videoview);
        mBuffereingTextview = (TextView)findViewById(R.id.buffering_textview);

        if(savedInstanceState != null)
        {
            mCurrentposition = savedInstanceState.getInt(PLAY_TIME);
        }


        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(mVideoview);
        mVideoview.setMediaController(mediaController);


    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoview.pause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();

        release_player();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current playback position (in milliseconds) to the
        // instance state bundle.
        outState.putInt(PLAY_TIME, mVideoview.getCurrentPosition());
    }


    private void release_player() {
        mVideoview.stopPlayback();
    }

    private void initializePlayer() {

        //Show the buffereing while loading the video.
        mBuffereingTextview.setVisibility(VideoView.VISIBLE);

        Uri videoUri = getMedia(video_path);
        mVideoview.setVideoURI(videoUri);


        //To hide the buffering message

        mVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {


                mBuffereingTextview.setVisibility(VideoView.INVISIBLE);

                //Restore the saved positon when its available
                if(mCurrentposition > 0)
                {
                    mVideoview.seekTo(mCurrentposition);
                }
                else
                {
                    mVideoview.seekTo(1);
                }

                mVideoview.start();
            }
        });


        mVideoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(NormalVideoViewActivity.this,
                        R.string.toast_message,
                        Toast.LENGTH_SHORT).show();

                // Return the video position to the start.
                mVideoview.seekTo(0);
            }
        });



    }

    private Uri getMedia(String mediaName) {
        if (URLUtil.isValidUrl(mediaName)) {
            // Media name is an external URL.
            return Uri.parse(mediaName);
        } else {
            // Media name is a raw resource embedded in the app.
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + mediaName);
        }
    }
}
