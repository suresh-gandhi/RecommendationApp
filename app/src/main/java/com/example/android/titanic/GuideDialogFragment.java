package com.example.android.titanic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by summi on 28-08-2017.
 */

public class GuideDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Hello " + MainActivity.mUsername.toUpperCase() + "!\n\n" + "Please rate any movie and double tap it to confirm!").setPositiveButton("Got it", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
