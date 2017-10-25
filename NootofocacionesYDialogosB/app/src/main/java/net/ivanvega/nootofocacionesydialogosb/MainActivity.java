package net.ivanvega.nootofocacionesydialogosb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String[] frutas = new String[]{"Sandia","mango","fresa", "melon"};
    String[] generos_musicales = new String[]{"rock","rap","clasica", "pop", "jazz"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnInfo_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                .setTitle("Dialogo informativo")
                .setMessage("Deseas cerrar al APP")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Esta bien", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancenlar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();

        dialog.show();

    }

    public void btnList_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Dialogo de listas")
                        .setItems(frutas, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        frutas[which], Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .create();

        dialog.show();

    }

    public void btnListCheckBox_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Dialogo de listas")
                        .setMultiChoiceItems(generos_musicales,
                                new boolean[]{true, false, true, false, true}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which, boolean isChecked) {

                                        Toast.makeText(MainActivity.this,
                                                generos_musicales[which] +
                                                        (isChecked ? " Verificado": " No verificado"),
                                                Toast.LENGTH_SHORT
                                        ).show();


                                    }
                                })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();

        dialog.show();

    }


}
