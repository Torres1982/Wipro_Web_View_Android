package com.wipro.wiprowebview.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.wipro.wiprowebview.MainActivity;
import com.wipro.wiprowebview.R;

public class DialogBoxUtility {
    private Context context;

    public DialogBoxUtility(Context newContext) {
        context = newContext;
    }

    // Create a Confirmation Alert Dialog
    public void showConfirmationDialog(String message, String name, String surname, String email, String dob, String gender) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirmation_dialog_title);
        builder.setMessage(message + "\nName:\t\t\t\t" + name + " " + surname + "\nEmail:\t\t\t\t" + email + "\nDOB:\t\t\t\t\t" + dob + "\nGender:\t\t" + gender);

        builder.setPositiveButton(R.string.dialog_box_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Data has been submitted successfully! " + which, Toast.LENGTH_SHORT).show();
                Intent refreshActivity = new Intent(context, MainActivity.class);
                context.startActivity(refreshActivity);
            }
        });

        builder.setNegativeButton(R.string.dialog_box_negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Data submission has been cancelled! " + which, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
