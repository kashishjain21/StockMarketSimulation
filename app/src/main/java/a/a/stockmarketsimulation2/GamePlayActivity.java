package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamePlayActivity extends AppCompatActivity {

    Button button9,button10,button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);

        button9=(Button)findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);
        button11=(Button)findViewById(R.id.button11);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openOrderingMenuActivity();
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPurchaseHistoryActivity();
            }
        });
    }
    public void openOrderingMenuActivity()
    {
        Intent i = new Intent(this,OrderingMenuActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void openPurchaseHistoryActivity()
    {
        Intent j = new Intent(this,PurchaseHistoryActivity.class);
        startActivity(j);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
