package com.wipro.wiprowebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textViewName;
    TextView textViewEmail;
    TextView textViewDob;
    TextView textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textViewName = findViewById(R.id.text_view_name);
        textViewEmail =  findViewById(R.id.text_view_email);
        textViewDob = findViewById(R.id.text_view_dob);
        textViewGender = findViewById(R.id.text_view_gender);
    }
}
