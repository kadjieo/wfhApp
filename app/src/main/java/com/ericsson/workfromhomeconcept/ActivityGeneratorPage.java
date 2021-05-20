package com.ericsson.workfromhomeconcept;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Random;

public class ActivityGeneratorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_page);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        List<String> activities = (List<String>) bundle.getSerializable("activities");
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