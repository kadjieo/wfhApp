package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityGenerator = (Button) findViewById(R.id.activity_generator_button);
        activityGenerator.setOnClickListener(v -> goToActivityGenerator(ActivityGeneratorPage.class));

        Button supervisor = (Button) findViewById(R.id.supervisor_button);
        supervisor.setOnClickListener(v -> goToActivityGenerator(SupervisorPage.class));
    }

    private void goToActivityGenerator(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }


}