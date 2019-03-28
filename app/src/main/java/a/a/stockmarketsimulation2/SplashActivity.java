package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seting flag for fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        //getSupportActionBar().hide();

        videoView = (VideoView)findViewById(R.id.videoView);

        Uri splashactivity = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splashactivity);

        videoView.setVideoURI(splashactivity);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish(); //so when we click back button, we arent redirected to the video
            }
        });
        videoView.start();
    }
}
