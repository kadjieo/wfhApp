package com.ericsson.workfromhomeconcept;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ActivityGeneratorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_page);
        List<String> activities = Arrays.asList("Walk for 20 minutes!", "Run for 30 minutes!", "Do yoga for 30 minutes!", "Play padel!",
                "Play badminton!", "Go for a swim!", "Play some tennis!", "Listen to music!", "Stretch your back and legs!",
                "Do Cardio for 40 minutes!");

        Button generate = (Button) findViewById(R.id.generate);
        generate.setOnClickListener(v -> getRandomActivityFromList(activities));
    }

    private void getRandomActivityFromList(final List<String> activities) {
        int size = activities.size();
        int randomIndex = new Random().nextInt(size);
        TextView tv = (TextView) findViewById(R.id.activity_run);
        tv.setText(activities.get(randomIndex));
    }

}