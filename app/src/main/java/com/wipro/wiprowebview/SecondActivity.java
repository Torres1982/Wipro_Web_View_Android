package com.wipro.wiprowebview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView webView;
    String firstName, lastName, email, dob, gender, fullName;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        webView = findViewById(R.id.web_view_second);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);

        // Retrieve String values passed through the Intent
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            firstName = bundle.getString("name");
            lastName = bundle.getString("surname");
            email = bundle.getString("email");
            dob = bundle.getString("birth_date");
            gender =  bundle.getString("gender");
        }
        fullName = firstName + " " + lastName;

        webView.loadUrl("file:///android_asset/second_web_view.html");

        webView.setWebViewClient(new WebViewClient() {
            // Load javascript functions once that HTML page has been loaded
            public void onPageFinished(WebView view, String url){
                webView.loadUrl("javascript:prepopulateSecondWebViewName('" + fullName + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewEmail('" + email + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewBirthDate('" + dob + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewGender('" + gender + "')");
            }
        });
    }
}
