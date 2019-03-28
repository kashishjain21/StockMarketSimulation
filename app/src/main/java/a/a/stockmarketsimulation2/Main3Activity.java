package a.a.stockmarketsimulation2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {

    private Button start_btn;
    private Button history_btn;
    private Button options_btn;
    private Button stats_btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        start_btn = (Button) findViewById(R.id.start);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStart_activity();
            }
        });

        history_btn = (Button)findViewById(R.id.history);
        history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistory_activity();
            }
        });

        options_btn = (Button)findViewById(R.id.options);
        options_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptions_activity();
            }
        });

        stats_btn = (Button)findViewById(R.id.stats);
        stats_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStats_activity();
            }
        });

    }




    public void openStart_activity() {
        Intent sintent = new Intent(this, Start_activity.class);
        startActivity(sintent);
    }


    public void openHistory_activity() {
        Intent hintent = new Intent(this, Options_activity.class);
        startActivity(hintent);
    }

    public void openOptions_activity() {
        Intent ointent = new Intent(this, IntroductionActivity.class);
        startActivity(ointent);
    }

    public void openStats_activity() {
        FirebaseAuth.getInstance().signOut();
        Intent sintent = new Intent(this, LoginActivity.class);
        startActivity(sintent);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle();
        builder.setMessage(R.string.exit_message);

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.show();


    }

}




