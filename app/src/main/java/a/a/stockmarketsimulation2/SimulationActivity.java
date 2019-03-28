package a.a.stockmarketsimulation2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class SimulationActivity extends AppCompatActivity {

    Button p, m, c, res, s, g, next;
    TextView ord, nos, pr, tot, timer, round,in,net,cash;
    int price, coms, min, max, curr, co,cih,inv,nw,block;
    CountDownTimer tp;
    Spinner com;
    int timeset, level,column;
    int[] amt = new int[5];
    //  int[] co = new int[5];
    int[] to = new int[5];
    int[][] cp = new int[5][16];

    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series1;
    private LineGraphSeries<DataPoint> series2;
    private LineGraphSeries<DataPoint> series3;
    private LineGraphSeries<DataPoint> series4;
    private LineGraphSeries<DataPoint> series5;
    private int lastX = 1;


    String recieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        recieved = getIntent().getStringExtra("gauthamKaString");
        g = (Button) findViewById(R.id.button5);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGraphActivity();
            }
        });

        Button p = (Button) findViewById(R.id.button);
        Button m = (Button) findViewById(R.id.button2);
        Button c = (Button) findViewById(R.id.button3);
        Button res = (Button) findViewById(R.id.button4);
        Button s = (Button) findViewById(R.id.button6);
        Button next = (Button) findViewById(R.id.button7);

        final TextView ord = (TextView) findViewById(R.id.textView);
        final TextView in = (TextView) findViewById(R.id.textView12);
        final TextView cash = (TextView) findViewById(R.id.textView10);
        final TextView net = (TextView) findViewById(R.id.textView11);
        final TextView tot = (TextView) findViewById(R.id.textView2);
        final TextView pr = (TextView) findViewById(R.id.textView3);
        final TextView nos = (TextView) findViewById(R.id.textView4);
        final TextView timer = (TextView) findViewById(R.id.textView5);
        final TextView round = (TextView) findViewById(R.id.textView7);

        Spinner com = (Spinner) findViewById(R.id.spinner);


        final GraphView graph = (GraphView) findViewById(R.id.graph);
       //graph.getViewport().setBackgroundColor(Color.argb(150, 000, 000, 000));

        graph.getViewport().setBackgroundColor(Color.argb(250, 0, 0, 0));
        graph.getViewport().setDrawBorder(true);
        graph.getViewport().setBorderColor(Color.BLACK);
        graph.getGridLabelRenderer().setGridColor(Color.argb(150,126,87,194));
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.argb(150,126,87,194));
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.argb(150,126,87,194));
        //graph.getGridLabelRenderer().set;

        series1 = new LineGraphSeries<DataPoint>();
        series1.setColor(Color.WHITE);
        series1.setDrawBackground(true);
        series1.setBackgroundColor(Color.argb(100,147,112,219));

        series2 = new LineGraphSeries<DataPoint>();
        series2.setColor(Color.WHITE);
        series2.setDrawBackground(true);
        series2.setBackgroundColor(Color.argb(100,147,112,219));

        series3 = new LineGraphSeries<DataPoint>();
        series3.setColor(Color.WHITE);
        series3.setDrawBackground(true);
        series3.setBackgroundColor(Color.argb(100,147,112,219));

        series4 = new LineGraphSeries<DataPoint>();
        series4.setColor(Color.WHITE);
        series4.setDrawBackground(true);
        series4.setBackgroundColor(Color.argb(100,147,112,219));

        series5 = new LineGraphSeries<DataPoint>();
        series5.setColor(Color.WHITE);
        series5.setDrawBackground(true);
        series5.setBackgroundColor(Color.argb(100,147,112,219));



      //  graph.addSeries(series1);

        Viewport viewport = graph.getViewport();

      //  level=15;


        if(recieved.equals("5"))
        {
            timeset=30000;
            level=8;
            column=8;
        }
        else if(recieved.equals("6"))
        {
            timeset=15000;
            level=15;
            column=16;
        }
        else if(recieved.equals("9"))
        {
            timeset=60000;
            level=8;
            column=8;
        }
        else
        {
            timeset=30000;
            level=15;
            column=16;
        }



      //  column=16;

        viewport.setXAxisBoundsManual(true);
        viewport.setMinX(0);
        viewport.setMaxX(column);
        viewport.setScrollable(true);

        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(600);
        viewport.setScrollable(true);


        curr = 0;
        block=1;
        cih=10000;
        inv=0;
        nw=0;

        to[0] = 0;
        to[1] = 0;
        to[2] = 0;
        to[3] = 0;
        to[4] = 0;

        amt[0] = 0;
        amt[1] = 0;
        amt[2] = 0;
        amt[3] = 0;
        amt[4] = 0;



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Company, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        com.setAdapter(adapter);

        Random r;
        r = new Random();
        round.setText("Round: 1");
        cash.setText("Cash: 10000");
        in.setText("Investment: 0");
        net.setText("Net worth: 10000");

        int i;
        price = 100;
        for (i = 0; i < 16; i++) {

            if(price * 110/100 <30)
            {
                max=30;
            }
            else
            {
                max = price * 110 / 100;
            }

            min = price * 90 / 100;
            cp[0][i] = price = r.nextInt(max - min) + min;
        }

        price = 50;
        for (i = 0; i < 16; i++) {

            if(price * 120/100 <30)
            {
                max=30;
            }
            else
            {
                max = price * 120 / 100;
            }

            min = price * 80 / 100;
            cp[1][i] = price = r.nextInt(max - min) + min;

        }

        price = 75;
        for (i = 0; i < 16; i++) {

            if(price * 120/100 <30)
            {
                max=30;
            }
            else
            {
                max = price * 120 / 100;
            }

            min = price * 90 / 100;
            cp[2][i] = price = r.nextInt(max - min) + min;
        }

        price = 200;
        for (i = 0; i < 16; i++) {

            if(price * 140/100 <30)
            {
                max=30;
            }
            else
            {
                max = price * 140 / 100;
            }

            min = price * 70 / 100;
            cp[3][i] = price = r.nextInt(max - min) + min;

        }

        price = 150;
        for (i = 0; i < 16; i++) {

            if(price * 130/100 <30)
            {
                max=30;
            }
            else
            {
                max = price * 130 / 100;
            }
            min = price * 90 / 100;
            cp[4][i] = price = r.nextInt(max - min) + min;
        }

        graph.addSeries(series1);


        com.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int z, long l) {


                coms = z;

                pr.setText("Price: " + cp[z][curr]);
                // tot.setText("Total: "+amt[z]);
               // nos.setText("No. of shares: " + to[z]);
                nos.setText("Shares: " + to[z]);

                if(z==0)
                {
                    graph.removeAllSeries();
                    graph.addSeries(series1);
                }
                else if(z==1)
                {
                    graph.removeAllSeries();
                    graph.addSeries(series2);
                }
                else if (z==2)
                {
                    graph.removeAllSeries();
                    graph.addSeries(series3);
                }
                else if(z==3)
                {
                    graph.removeAllSeries();
                    graph.addSeries(series4);
                }
                else
                {
                    graph.removeAllSeries();
                    graph.addSeries(series5);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              if(block==0)
              {


                  if (((co + 1) * cp[coms][curr]) > cih) {
                      ord.setText("Order: " + co);
                  } else {
                      co++;
                      ord.setText("Order: " + co);
                  }
              }


            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(block==0)
               {

                   if ((to[coms] + co) > 0) {
                       co--;
                       ord.setText("Order: " + co);
                   } else {

                       ord.setText("Order: " + co);
                   }
               }


            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              if(block==0)
              {

                  co = 0;
                  ord.setText("Order: 0");
              }

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(block==0)
                {


                    to[coms] = to[coms] + co;

                    cih = cih - (co * cp[coms][curr]);
                    inv = (to[0] * cp[0][curr]) + (to[1] * cp[1][curr]) + (to[2] * cp[2][curr]) + (to[3] * cp[3][curr]) + (to[4] * cp[4][curr]);
                    nw = cih + inv;

                    cash.setText("Cash: " + cih);
                    in.setText("Investment: " + inv);
                    net.setText("Net worth: " + nw);

                    // amt[curr]= amt[curr] + (co*cp[coms][curr]);
                    co = 0;


                    ord.setText("Order: " + co);
                    //  tot.setText("Total: "+amt[curr]);
                    nos.setText("Shares: " + to[coms]);


                }

            }
        });

        addEntry();

        tp = new CountDownTimer( timeset , 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("Timer: 0");

                addEntry();

                curr++;

                pr.setText("Price: " + cp[coms][curr]);
                //    tot.setText("Total: "+amt[coms]);
                nos.setText("Shares: " + to[coms]);


                round.setText("Round: " + (curr+1));
                cash.setText("Cash: "+cih);
                in.setText("Investment: "+inv);
                net.setText("Net worth: "+nw);

                co = 0;
                ord.setText("Order: " + co);










                cancel();

                if(curr!=level)
                {
                    start();
                }
                else
                {
                    block=2;
                    net.setText("Final Score: "+nw);
                    round.setText("Round: "+ curr);
                }



}


        };


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(block==1)
               {
                   block=0;
                   tp.start();
                  // Toast.makeText(getApplicationContext(),"Selected-" +recieved, Toast.LENGTH_SHORT).show();

               }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(block==1)
                {

                }


             /*   Intent i;
                i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i); */
            }
        });


    }
  /*  protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            addEntry();
                        }
                    });


                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }).start();
    }  */

    // add random data to graph
    private void addEntry() {

        series1.appendData(new DataPoint(lastX, cp[0][curr+1]), false, 16);
        series2.appendData(new DataPoint(lastX, cp[1][curr+1]), false, 16);
        series3.appendData(new DataPoint(lastX, cp[2][curr+1]), false, 16);
        series4.appendData(new DataPoint(lastX, cp[3][curr+1]), false, 16);
        series5.appendData(new DataPoint(lastX, cp[4][curr+1]), false, 16);

        lastX++;

    }


    public void openGraphActivity() {
        Intent gintent = new Intent(this, DGraphActivity.class);
        startActivity(gintent);
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