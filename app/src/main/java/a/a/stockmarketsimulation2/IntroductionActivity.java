package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class IntroductionActivity extends AppCompatActivity {
    //ImageView imageView;

    //CustomAdapter adapter;
    //ViewPager viewPager;
    TextView textView;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seting flag for fullscreen
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_introduction);

        //viewPager = (ViewPager)findViewById(R.id.view_pager);
       // adapter = new CustomAdapter(this);
        //viewPager.setAdapter(adapter);

        //getSupportActionBar().hide();

        //imageView = (ImageView)findViewById(R.id.imageView2);

        textView=(TextView)findViewById(R.id.intro);
        textView.setText("The gameplay is simple, first press start to activate all buttons. Select your chosen company from the spinner to activate its profile. Now you can see the no. of shares in that particular company, present rates, and a graph for its history of past round. 4 bottom buttons are for placing your order of buying and selling shares. Make sure you analyse your cash in hand, investment and net worth to win. There will be 16 rounds after which your net worth will be counted as your final score.");

        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroductionActivity.this, Start_activity.class));
                finish();
            }
        });
    }
}