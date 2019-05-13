package com.wipro.wiprowebview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wipro.wiprowebview.util.WebViewUtility;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_URL = "file:///android_asset/index.html";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web_view);
        WebViewUtility.setWebViewSettings(webView);

        // Binding JavaScriptReceiver class to JS running in the WebView
        // This creates an "Android" interface that is accessible by the Web App
        webView.addJavascriptInterface(new JavaScriptReceiver(this, this), "Android");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(FILE_URL);
    }

    // This may be used if the user wants more control over where the clicked links load
    private class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
