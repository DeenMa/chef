package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.apps.deenma.chef.Utilities;

/**
 * Created by deenma on 08/04/2017.
 */

public class FileClaimActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_claim);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupUI(bundle);
    }

    private void setupUI(final Bundle bundle) {
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.NAME, R.id.file_claim_textview_person_a_name_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.RESPONSIBILITY, R.id.file_claim_textview_responsibility_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY, R.id.file_claim_textview_insurance_company_result);

        final Context context = this;
        Button buttonFile = (Button) findViewById(R.id.file_claim_button_file);
        buttonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save all pictures into history folder, delay 3 seconds, and move to FileSuccessActivity
                Toast.makeText(context, R.string.transfer_to_server, Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(context, FileSuccessActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, Constants.DELAY_ACTIVITY);
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.file_claim_button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to FileCanceledActivity, remember to display all the required opponents information into this activity
                /*
                Intent intent = new Intent(context, FileFailedActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                */
            }
        });
    }
}
