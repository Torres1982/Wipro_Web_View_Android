package com.wipro.wiprowebview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

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
    //message, first_name, surname, email, dob, gender_selected
    public void confirmSubmission(String message, String name, String surname, String email, String dob, String gender) {
        showConfirmationDialog(message, name, surname, email, dob, gender);
    }

    // Create a Confirmation Alert Dialog
    private void showConfirmationDialog(String message, String name, String surname, String email, String dob, String gender) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirmation_dialog_title);
        builder.setMessage(message + "\nName:\t\t\t\t" + name + " " + surname + "\nEmail:\t\t\t\t" + email + "\nDOB:\t\t\t\t\t" + dob + "\nGender:\t\t" + gender);

        builder.setPositiveButton(R.string.dialog_box_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Data has been submitted successfully! " + which, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.dialog_box_negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Data submission has been cancelled! " + which, Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
