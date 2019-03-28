package a.a.stockmarketsimulation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class Start_activity extends AppCompatActivity {

        public Button start_proceed_button;
        public String opt1, opt2, opt3;
        int o1, o2, o3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);



        o1= 4;
        o2= 1;
        o3= 5;
        opt3 = "5";

        StickySwitch stickySwitch = (StickySwitch)findViewById(R.id.sticky_switch_button);
        stickySwitch.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
            @Override
            public void onSelectedChange(StickySwitch.Direction direction, String s) {
                //Toast.makeText(getBaseContext(),"Now selected - "+s+" mins",Toast.LENGTH_SHORT).show();
               // opt1 = s;

                if(s.equals("4"))
                {
                    o1=4;
                }
                else
                {
                    o1=8;
                }
                o3 = o1 + o2;
                opt3=Integer.toString(o3);
            }
        });




        StickySwitch stickySwitch2 = (StickySwitch)findViewById(R.id.sticky_switch_button2);
        stickySwitch2.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
            @Override
            public void onSelectedChange(StickySwitch.Direction direction, String s) {

               // opt2 = s;

                if(s.equals("Easy"))
                {
                    o2=1;
                }
                else
                {
                    o2=2;
                }
                //Toast.makeText(getBaseContext(),"Now selected - "+s+" mode",Toast.LENGTH_SHORT).show();
                o3 = o1 + o2;
                opt3=Integer.toString(o3);

            }
        });









        start_proceed_button = (Button) findViewById(R.id.start_proceed);
        start_proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePlay_activity();

               // tv.setText("Disp: "+ o3);
               // Toast.makeText(getBaseContext(),"Now selected - "+o2+" mode",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getBaseContext(), "Final: "+opt3, Toast.LENGTH_SHORT).show();
            }
        });

    }

        public void openGamePlay_activity() {

            Intent gpintent = new Intent(this, SimulationActivity.class);
            gpintent.putExtra("gauthamKaString",opt3);
            startActivity(gpintent);
        }
}
