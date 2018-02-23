package net.ivanvega.mismensajitossmsbperron;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtC, txtSMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtC = findViewById(R.id.txtCel);
        txtSMS = findViewById(R.id.txtSMS);


        IntentFilter intfil =
                new IntentFilter("android.provider.Telephony.SMS_RECEIVED");


        SMSBroadcastReceiver smsreceiver =
                new SMSBroadcastReceiver();

        registerReceiver(smsreceiver, intfil);



    }

    public void btnEnviar_click(View v){

        SmsManager smsM = SmsManager.getDefault();


        smsM.sendTextMessage(txtC.getText().toString(), null,
                txtSMS.getText().toString(),null,null
        );

        Toast.makeText(this,"Mensaje enviado",Toast.LENGTH_LONG).show();


    }

}
