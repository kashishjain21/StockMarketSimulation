package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button to_menu_btn;

    ConstraintLayout animated_Layout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        to_menu_btn = (Button)findViewById(R.id.to_menu);
        to_menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain3Activity();
            }
        });

        animated_Layout = (ConstraintLayout)findViewById(R.id.animated_Layout);
        animationDrawable = (AnimationDrawable)animated_Layout.getBackground();

        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

    }
    public void openMain3Activity(){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
}
