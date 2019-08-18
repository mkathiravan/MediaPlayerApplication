package net.kathir.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public class MxVideoViewActivity extends FragmentActivity implements YouTubePlayer.OnInitializedListener {


    private static final int RECOVERY_DIALOG_REQUEST = 34;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mx_video_layout);


        YouTubePlayerSupportFragment fragmentA = new YouTubePlayerSupportFragment();
        FragmentManager fragmentManager = getSupportFragmentManager().findFragmentById(R.id.official_player_view).getFragmentManager();




    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {


        if (!b) {
            youTubePlayer.cueVideo("YE7VzlLtp-4");
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {

            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_LONG).show();
        }


    }
}
