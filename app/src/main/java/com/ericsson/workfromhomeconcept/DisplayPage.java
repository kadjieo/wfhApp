package com.ericsson.workfromhomeconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String activity = bundle.getString("activity");

        TextView tv = (TextView) findViewById(R.id.activity_display_text);
        tv.setText(activity);
    }
}