package net.ivanvega.manejofragmentosb;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements  FragmentoUno.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.lytFragDina);

        if (f == null){
            Toast.makeText(this,"No se enontro fragmenro"
            , Toast.LENGTH_LONG).show();
        }

    }

    public void btnFragHardcode_click(View v){
        startActivity(
                new Intent(this, ActividadFragmentoHardcode.class)
        );
    }

    public void btnFragDinamico_click (View v){
          FragmentManager fm = getSupportFragmentManager();



          Fragment  frg =  fm.findFragmentById(R.id.lytFragDina);


        if(frg==null){
            FragmentTransaction ft = fm.beginTransaction();

            //FragmentoUno funo = FragmentoUno.newInstance("","");
            FragmentoUno funo = new  FragmentoUno();
            FragmentoDos fdos = new FragmentoDos();


            ft.add(R.id.lytFragDina, funo);


            ft.commit();
        }else{
            Toast.makeText(this,"El fragmento ya esta cargado",
                    Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
