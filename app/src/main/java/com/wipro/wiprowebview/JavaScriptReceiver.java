package com.wipro.wiprowebview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.wipro.wiprowebview.util.DialogBoxUtility;

public class JavaScriptReceiver {
    private Context context;

    JavaScriptReceiver(Context newContext) {
        context = newContext;
    }

    @JavascriptInterface
    public void validate(String validationString) {
        Toast.makeText(context, validationString, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void confirmSubmission(String message, String name, String surname, String email, String dob, String gender) {
        DialogBoxUtility dialogBox = new DialogBoxUtility(context);
        dialogBox.showConfirmationDialog(message, name, surname, email, dob, gender);
    }
}
