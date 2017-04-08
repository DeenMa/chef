package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                // TODO:
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.file_claim_button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO:
            }
        });
    }
}
