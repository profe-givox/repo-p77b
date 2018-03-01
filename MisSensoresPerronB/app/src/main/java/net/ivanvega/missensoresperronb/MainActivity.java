package net.ivanvega.missensoresperronb;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    TextView txt;

    private Sensor mLight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.sensor_data);
        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);

        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        List<Sensor> deviceSensors =
                mSensorManager.getSensorList(Sensor.TYPE_ALL);


        for (Sensor sersor : deviceSensors){
              String info = sersor.getName() + "\n";
            info += sersor.getMaximumRange() + "\n";
            info += sersor.getVendor() + "\n";
            info += sersor.getPower() + "\n";
            info += sersor.getMinDelay();

            Toast.makeText(this, info,
                    Toast.LENGTH_SHORT).show();


            Log.i("MISSENSORITOS", info);


            if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
                // Success! There's a magnetometer.

                Log.i("MISSENSORITOS", "EXISTE EL SENSOR DE CAMPO MAGNETICO");
            }
            else {
                // Failure! No magnetometer.
                Log.i("MISSENSORITOS", "NO PINCHES " +
                        "EXISTE EL SENSOR DE CAMPO MAGNETICO");
            }


        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        float lux = event.values[0];
        // Do something with this sensor value.
        txt.setText(String.valueOf(lux));


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
