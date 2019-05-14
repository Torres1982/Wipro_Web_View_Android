package com.wipro.wiprowebview;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wipro.wiprowebview.util.WebViewUtility;

public class SecondActivity extends AppCompatActivity {
    private WebView webView;
    private String firstName, lastName, email, dob, gender, fullName;
    private static final String FILE_URL = "file:///android_asset/second_web_view.html";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        webView = findViewById(R.id.web_view_second);
        WebViewUtility.setWebViewSettings(webView);

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

        webView.loadUrl(FILE_URL);

        webView.setWebViewClient(new WebViewClient() {
            // Load javascript functions once that HTML page has been loaded
            public void onPageFinished(WebView view, String url) {
                //webView.loadUrl("javascript:window.Android.setResult(prepopulateSecondWebView(" + fullName + ", " + email + ", " + dob + ", " + gender + "))");
                webView.loadUrl("javascript:prepopulateSecondWebViewName('" + fullName + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewEmail('" + email + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewBirthDate('" + dob + "')");
                webView.loadUrl("javascript:prepopulateSecondWebViewGender('" + gender + "')");

//                webView.evaluateJavascript("callMe(\" + fullName + \", \" + email + \", \" + dob + \", \" + gender + \");", new ValueCallback< String >() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        webView.loadUrl("javascript:callMe('" + fullName + ", " + email + ", " + dob + ", " + gender + "')");
//                    }
//                });
            }
        });
    }
}
