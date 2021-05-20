package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<String> activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities = Arrays.asList("Walk for 20 minutes!", "Run for 30 minutes!", "Do yoga for 30 minutes!", "Play padel!",
                "Play badminton!", "Go for a swim!", "Play some tennis!", "Listen to music!", "Stretch your back and legs!",
                "Do Cardio for 40 minutes!");
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
                tv.setText(String.valueOf(millisToSeconds + 1));
            }

            @Override
            public void onFinish() {
                String activity = getRandomActivityFromList(activities);
                intent.putExtra("activity",activity);
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