package a.a.stockmarketsimulation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class History_activity extends AppCompatActivity {


    int i;

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activity);



        GraphView graph= (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5,1.5),
                new DataPoint(6,3),
                new DataPoint(7,6),
                new DataPoint(8,6)

             /* for(i=0; i<8; i++)
             {
                 new DataPoint(i,i);
             }  */
        });
        graph.addSeries(series);
    }
}
