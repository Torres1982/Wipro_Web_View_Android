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

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String firstName = bundle.getString("name");
            String lastName = bundle.getString("surname");
            String email = bundle.getString("email");
            String dob = bundle.getString("birth_date");
            String gender =  bundle.getString("gender");
            String fullName = firstName + " " + lastName;

            setTextViewValues(fullName, email, dob, gender);
        }
    }

    // Fill the Text View with passed values from WebView
    private void setTextViewValues(String fullName, String email, String dob, String gender) {
        textViewName.setText(fullName);
        textViewEmail.setText(email);
        textViewDob.setText(dob);
        textViewGender.setText(gender);
    }
}
