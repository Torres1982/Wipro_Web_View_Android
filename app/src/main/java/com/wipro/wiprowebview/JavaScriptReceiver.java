package com.wipro.wiprowebview;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.wipro.wiprowebview.util.DialogBoxUtility;

public class JavaScriptReceiver {
    private Context context;
    private Activity currentActivity;

    JavaScriptReceiver(Context newContext, Activity activity) {
        context = newContext;
        currentActivity = activity;
    }

    @JavascriptInterface
    public void validate(String validationString) {
        Toast.makeText(context, validationString, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void confirmSubmission(String message, String name, String surname, String email, String dob, String gender) {
        DialogBoxUtility dialogBox = new DialogBoxUtility(context, currentActivity);
        dialogBox.showConfirmationDialog(message, name, surname, email, dob, gender);
    }
}
