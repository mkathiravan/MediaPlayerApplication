package net.kathir.myapplication.mkplayer;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.kathir.myapplication.R;

import cn.jzvd.Jzvd;

public class MkPlayerActivity extends AppCompatActivity {

    MyJzvdStd myJzvdStd;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mkplayer_view_layout);

        myJzvdStd = (MyJzvdStd) findViewById(R.id.jz_video);
        myJzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "Sample Video");



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

}
