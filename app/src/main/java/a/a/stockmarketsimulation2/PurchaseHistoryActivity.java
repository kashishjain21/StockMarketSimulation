package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PurchaseHistoryActivity extends AppCompatActivity {

    Button button15,button16,button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        button15=(Button)findViewById(R.id.button15);
        button16=(Button)findViewById(R.id.button16);
        button17=(Button)findViewById(R.id.button17);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGamePlayActivity();
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderingMenuActivity();
            }
        });
    }
    public void openGamePlayActivity()
    {
        Intent i = new Intent(this,GamePlayActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    public void openOrderingMenuActivity()
    {
        Intent j = new Intent(this,OrderingMenuActivity.class);
        startActivity(j);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
