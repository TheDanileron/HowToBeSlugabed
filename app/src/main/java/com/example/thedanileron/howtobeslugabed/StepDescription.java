package com.example.thedanileron.howtobeslugabed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StepDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_description);

        String catName = getIntent().getStringExtra("CAT_NAME");
        TextView textView = findViewById(R.id.stepTitle);
        textView.setText(catName);
    }
}
