package net.ivanvega.nootofocacionesydialogosb;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by alcohonsilver on 09/11/17.
 */

public class MiTimePickerDialogFragment
        extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this,
                hour, minute, true);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("TIMEPICKER", "Hora seleccionada: "
                + String.valueOf(hourOfDay) + ":" +
                String.valueOf(minute));
    }


}
