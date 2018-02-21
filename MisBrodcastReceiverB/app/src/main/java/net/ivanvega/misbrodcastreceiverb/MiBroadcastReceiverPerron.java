package net.ivanvega.misbrodcastreceiverb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by alcohonsilver on 20/02/18.
 */

public class MiBroadcastReceiverPerron extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();

        if(intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            Toast.makeText(context,
                    "ESTADO TELEFONO: " +
                            intent.getStringExtra(TelephonyManager.EXTRA_STATE),

                    Toast.LENGTH_SHORT
            ).show();
            Log.d("ESTADO TELEFONO:" ,
                    intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            );
        }



    }

}
