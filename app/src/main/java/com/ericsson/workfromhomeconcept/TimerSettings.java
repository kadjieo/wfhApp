package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class TimerSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_settings);

        //setting numpicker

        NumberPicker numberPickerHour = findViewById(R.id.numPickerHour);
        numberPickerHour.setMinValue(0);
        numberPickerHour.setMaxValue(24);

        NumberPicker numberPickerMin = findViewById(R.id.numPickerMin);
        numberPickerMin.setMinValue(0);
        numberPickerMin.setMaxValue(59);

        NumberPicker numberPickerSeconds = findViewById(R.id.numPickerSeconds);
        numberPickerSeconds.setMinValue(0);
        numberPickerSeconds.setMaxValue(59);

        Button setButton = (Button) findViewById(R.id.set_timer_button);
        setButton.setOnClickListener(v -> storeTimerValues(numberPickerHour, numberPickerMin, numberPickerSeconds));


    }

    @SuppressLint("SetTextI18n")
    private void storeTimerValues(NumberPicker hours, NumberPicker minutes, NumberPicker seconds) {
        int hoursToMillis = hours.getValue() * 60 * 60 * 1000;
        int minutesToMillis = minutes.getValue() * 60 * 1000;
        int secondsToMillis = seconds.getValue() * 1000;
        com.ericsson.workfromhomeconcept.utils.TimerSettings.getInstance().setActivityTimerInMillis(hoursToMillis + minutesToMillis + secondsToMillis);
        TextView tv = (TextView) findViewById(R.id.timer_set_message);
        tv.setText("Timer set");
    }
}