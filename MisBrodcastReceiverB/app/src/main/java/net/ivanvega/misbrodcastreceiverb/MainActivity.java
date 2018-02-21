package net.ivanvega.misbrodcastreceiverb;

import android.content.IntentFilter;
import android.provider.Telephony;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter ifil =
                new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);

        MiBroadcastReceiverPerron recev = new MiBroadcastReceiverPerron();

        registerReceiver(recev,ifil);



    }
}
