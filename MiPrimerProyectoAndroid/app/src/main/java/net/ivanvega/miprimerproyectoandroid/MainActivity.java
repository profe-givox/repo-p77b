package net.ivanvega.miprimerproyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button miBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBtn = (Button) findViewById(R.id.btnMensaje);
        miBtn.setText("Mi Super Boton En ejecucion");
        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Se hizo clic al botón", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplication(), OtraActividad.class);

                i.putExtra("param1", "Hola Mundisimo!");
                i.putExtra("param2", 1);

                //startActivity(i);
                startActivityForResult(i, 1000);

                


            }
        });
        //miBtn.setOnClickListener(this);


        Log.d("CICLO", "Paso por el metodo onCreate()");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1000 && resultCode==RESULT_OK)
        {
            Toast.makeText(this,
                    data.getStringExtra("paramreturn"),
                    Toast.LENGTH_LONG
                    ).show();

        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO", "Paso por el metodo onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CICLO", "Paso por el metodo onResume(), puedes interactuar");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("CICLO", "Paso por el metodo onPause(), No esta visible la actividad");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO", "Paso por el metodo onStop(), puede que se destruya la actividad");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("CICLO", "Paso por el metodo onRestart(), resucito la actividad");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("CICLO", "Paso por el metodo onDestroy(), lo sentimos! Actividad destruida");
    }

}
