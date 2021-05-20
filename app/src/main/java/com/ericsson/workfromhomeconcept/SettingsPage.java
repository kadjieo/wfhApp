package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Button timer = (Button) findViewById(R.id.timer);
        timer.setOnClickListener(v -> goToTimerSettings(TimerSettings.class));
    }

    private void goToTimerSettings(Class<TimerSettings> timerSettingsClass) {
        Intent intent = new Intent(this, timerSettingsClass);
        startActivity(intent);
    }
}