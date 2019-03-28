package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderingMenuActivity extends AppCompatActivity {

    Button button12,button13,button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_menu);

        button12=(Button)findViewById(R.id.button12);
        button13=(Button)findViewById(R.id.button13);
        button14=(Button)findViewById(R.id.button14);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGamePlayActivity();
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPurchaseHistoryActivity();
            }
        });
    }
    public void openGamePlayActivity()
    {
        Intent i = new Intent(this,GamePlayActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    public void openPurchaseHistoryActivity()
    {
        Intent j = new Intent(this,PurchaseHistoryActivity.class);
        startActivity(j);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
