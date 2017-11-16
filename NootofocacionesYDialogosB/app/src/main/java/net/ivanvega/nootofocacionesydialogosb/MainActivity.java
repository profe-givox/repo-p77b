package net.ivanvega.nootofocacionesydialogosb;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
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

    public void btnTimePicker_click (View V){
        DialogFragment   dialog  =
                new MiTimePickerDialogFragment();

        dialog.show(getSupportFragmentManager(),"MiPicker");

    }

    public void btnDatePicker_click(View v){


        DatePickerDialog dlg  =
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d("DATEPICKER", "Fecha seleccionada: "
                                + String.valueOf(dayOfMonth) + "/" +
                                String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, 2017, 11, 9);

        dlg.show();


    }

    public void btnNoficacionBarra_click(View v){
        Notification notificacion  =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("Notificacion titulo")
                .setContentText("Mi notitcacion cuerpo")
                .build();

        NotificationManagerCompat nm =
                NotificationManagerCompat.from(this);

        nm.notify(1001, notificacion );
    }
}
