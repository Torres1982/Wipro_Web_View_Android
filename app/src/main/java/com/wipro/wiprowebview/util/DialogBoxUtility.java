package com.wipro.wiprowebview.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.wipro.wiprowebview.R;
import com.wipro.wiprowebview.SecondActivity;

public class DialogBoxUtility {
    private Context context;
    private Activity activity;

    public DialogBoxUtility(Context newContext, Activity newActivity) {
        context = newContext;
        activity = newActivity;
    }

    // Create a Confirmation Alert Dialog
    public void showConfirmationDialog(String message, final String name, final String surname, final String email, final String dob, final String gender) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirmation_dialog_title);
        builder.setMessage(message + "\nName:\t\t\t" + name + " " + surname + "\nEmail:\t\t\t\t" + email + "\nDOB:\t\t\t\t\t" + dob + "\nGender:\t\t" + gender);

        builder.setPositiveButton(R.string.dialog_box_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Data has been submitted successfully! " + which, Toast.LENGTH_SHORT).show();
                Intent secondActivity = new Intent(context, SecondActivity.class);
                secondActivity.putExtra("name", name);
                secondActivity.putExtra("surname", surname);
                secondActivity.putExtra("email", email);
                secondActivity.putExtra("birth_date", dob);
                secondActivity.putExtra("gender", gender);
                context.startActivity(secondActivity);
                activity.finish();
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
