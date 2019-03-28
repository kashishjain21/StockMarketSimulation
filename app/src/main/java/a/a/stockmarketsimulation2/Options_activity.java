package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

public class Options_activity extends AppCompatActivity {

    Button editprofile_button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_activity);

        textView=(TextView)findViewById(R.id.about);
        textView.setText("This app is created by Gautham, Kashish and Himalay");

        editprofile_button = (Button)findViewById(R.id.editprofilebutton);
        /*editprofile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfileActivity();
            }
        });
       /* Button crashButton = new Button(this);
        crashButton.setText("Crash!");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Crashlytics.getInstance().crash(); // Force a crash
            }
        });
        addContentView(crashButton, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));*/
    }
    /*public void openEditProfileActivity(){
        Intent eintent = new Intent(this,EditUserActivity.class);
        startActivity(eintent);
    }*/
}
