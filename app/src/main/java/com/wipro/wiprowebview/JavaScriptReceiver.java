package com.wipro.wiprowebview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavaScriptReceiver {
    private Context context;

    JavaScriptReceiver(Context newContext) {
        context = newContext;
    }

    @JavascriptInterface
    public void validate(String name) {
        Toast.makeText(context, "!!! Testing Web View !!! " + name, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(context, MainActivity.class);
//        context.startActivity(intent);

    }
}
