package com.wipro.wiprowebview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        webView = findViewById(R.id.web_view_second);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Binding JavaScriptReceiver class to JS running in the Second WebView
        // This creates a "Web" interface that is accessible by the Web App
        webView.addJavascriptInterface(new JavaScriptReceiver(this, this), "Web");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/second_web_view.html");

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

    }
}
