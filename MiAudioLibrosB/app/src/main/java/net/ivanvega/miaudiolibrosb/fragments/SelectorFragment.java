package net.ivanvega.miaudiolibrosb.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.ivanvega.miaudiolibrosb.AdaptadorLibros;
import net.ivanvega.miaudiolibrosb.InfoGlobal;
import net.ivanvega.miaudiolibrosb.Libro;
import net.ivanvega.miaudiolibrosb.MainActivity;
import net.ivanvega.miaudiolibrosb.R;

import java.util.Vector;

/**
 * Created by alcohonsilver on 18/09/17.
 */

public class SelectorFragment extends Fragment {

    private Activity actividad;
    private RecyclerView recyclerView;
    private AdaptadorLibros adaptador;
    private Vector<Libro> vectorLibros;

    @Override
    public void onAttach(Context contexto) {
        super.onAttach(contexto);
        if (contexto instanceof Activity) {
            this.actividad = (Activity) contexto;
            InfoGlobal info = InfoGlobal.getInstancia();
            info.inicializa(contexto);
            adaptador = info.getAdaptador();
            vectorLibros = info.getVectorLibros();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle savedInstanceState) {
        View vista = inflador.inflate(R.layout.fragment_selector, contenedor, false);
        recyclerView = (RecyclerView) vista.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(actividad,2));
        recyclerView.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(actividad, "Seleccionado el elemento: "
//                        + recyclerView.getChildAdapterPosition(v), Toast.LENGTH_SHORT).show();


                ((MainActivity) actividad)
                        .mostrarDetalle(
                                recyclerView.getChildAdapterPosition(v));



            } });

        return vista;
    }
}


