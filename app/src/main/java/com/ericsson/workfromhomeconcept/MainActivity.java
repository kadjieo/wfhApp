package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ericsson.workfromhomeconcept.utils.TimerSettings;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<String> activities;
    TimerSettings timerSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities = Arrays.asList("Walk for 20 minutes!", "Run for 30 minutes!", "Do yoga for 30 minutes!", "Play padel!",
                "Play badminton!", "Go for a swim!", "Play some tennis!", "Listen to music!", "Stretch your back and legs!",
                "Do Cardio for 40 minutes!");
        setContentView(R.layout.activity_main);
        timerSettings = TimerSettings.getInstance();
        Button activityGenerator = (Button) findViewById(R.id.activities);
        activityGenerator.setOnClickListener(v -> goToActivityGenerator(ActivityGeneratorPage.class));

        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(v -> goToSettings(SettingsPage.class));

        Button start = (Button) findViewById(R.id.timer_start_button);
        start.setOnClickListener(v -> startCountDown(timerSettings.getActivityTimerInMillis()));
    }

    private void startCountDown(long countdownTime) {
        TextView tv  = (TextView) findViewById(R.id.countdown_output);
        Intent intent = new Intent(this, DisplayPage.class);
        new CountDownTimer(countdownTime, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                long millisToSeconds = millisUntilFinished / 1000 + 1;
                if (millisToSeconds < 60) {
                    tv.setText(String.valueOf(millisToSeconds));
                }

            }

            @Override
            public void onFinish() {
                String activity = getRandomActivityFromList(activities);
                intent.putExtra("activity",activity);
                startActivity(intent);
                tv.setText("");
            }
        }.start();
    }

    private void goToSettings(Class<SettingsPage> settingsPageClass) {
        Intent intent = new Intent(this, settingsPageClass);
        startActivity(intent);
    }

    private void goToActivityGenerator(Class c) {
        Intent intent = new Intent(this, c);
        Bundle bundle = new Bundle();
        bundle.putSerializable("activities", (Serializable) activities);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    private String getRandomActivityFromList(final List<String> activities) {
        int size = activities.size();
        int randomIndex = new Random().nextInt(size);
        return activities.get(randomIndex);
    }

}