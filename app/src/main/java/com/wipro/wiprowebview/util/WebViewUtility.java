package com.wipro.wiprowebview.util;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewUtility {
    // General settings for the Web View
    @SuppressLint("SetJavaScriptEnabled")
    public static void setWebViewSettings(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
    }
}
