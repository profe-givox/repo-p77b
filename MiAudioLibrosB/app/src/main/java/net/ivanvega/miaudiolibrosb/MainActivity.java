package net.ivanvega.miaudiolibrosb;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_fragment_hardcoded);


//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        final InfoGlobal info = InfoGlobal.getInstancia();
//        info.inicializa(this);
//        AdaptadorLibros adp =   info.getAdaptador();
//        adp.setOnItemClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = recyclerView.getChildAdapterPosition(view);
//                String t = ((TextView)view.findViewById(R.id.titulo)).getText().toString();
//                Toast.makeText(getApplication(),
//                        "Elememto seleccioando: " + t,
//                        Toast.LENGTH_SHORT).show();
//
//                Libro l = InfoGlobal.getInstancia().getVectorLibros().elementAt(position);
//
//
//            }
//        });
//                recyclerView.setAdapter(adp);
////        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);


    }



}
