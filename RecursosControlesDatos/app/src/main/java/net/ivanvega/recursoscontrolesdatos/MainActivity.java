package net.ivanvega.recursoscontrolesdatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lsv;
    String [] arrpresi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsv = (ListView)findViewById(R.id.lsv);

        arrpresi =
                getResources()
                        .getStringArray
                                (R.array.arraypresidentes);

        ArrayAdapter<String> adp = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrpresi);

        lsv.setAdapter(adp);
    }
}
