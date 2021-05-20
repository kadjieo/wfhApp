package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityGenerator = (Button) findViewById(R.id.activities);
        activityGenerator.setOnClickListener(v -> goToActivityGenerator(ActivityGeneratorPage.class));

        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(v -> goToSettings(SettingsPage.class));

        Button start = (Button) findViewById(R.id.timer_start_button);
        start.setOnClickListener(v -> startCountDown(10));
    }

    private void startCountDown(int i) {
        TextView tv  = (TextView) findViewById(R.id.countdown_output);
        Intent intent = new Intent(this, DisplayPage.class);
        new CountDownTimer(10000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                long millisToSeconds = millisUntilFinished / 1000;
                tv.setText(String.valueOf(millisToSeconds));
            }

            @Override
            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }

    private void goToSettings(Class<SettingsPage> settingsPageClass) {
        Intent intent = new Intent(this, settingsPageClass);
        startActivity(intent);
    }

    private void goToActivityGenerator(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }


}