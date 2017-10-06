package net.ivanvega.misqliteenandroidb;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import modelo.Contacto;
import modelo.DAOContactos;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ListView lsvC;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        DAOContactos dao = new DAOContactos(getActivity());

        dao.insert(new Contacto(0, "Perro Negro", "perro-negro@gmail.com"));
        dao.insert(new Contacto(0, "Black Dog", "back-dog@gmail.com"));


        View layout = inflater.inflate(R.layout.fragment_main,
                container, false);

        lsvC = layout.findViewById(R.id.lscContactos);

        ArrayAdapter<Contacto> adp = new ArrayAdapter<Contacto>(
                getActivity(), android.R.layout.simple_list_item_1,
                dao.getAll()
        );

        lsvC.setAdapter(adp);

        return layout;
    }
}