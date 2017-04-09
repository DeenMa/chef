package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.apps.deenma.chef.Utilities;

/**
 * Created by deenma on 09/04/2017.
 */

public class FileCanceledActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_canceled);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupUI(bundle);
    }

    private void setupUI(final Bundle bundle) {
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.NAME, R.id.file_canceled_textview_opponent_name_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.PLATE_NUMBER, R.id.file_canceled_textview_opponent_license_plate_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.INSURANCE_COMPANY, R.id.file_canceled_textview_opponent_insurance_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.PHONE_NUMBER, R.id.file_canceled_textview_opponent_phone_number_result);

        Button buttonFinish = (Button) findViewById(R.id.file_canceled_button_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
