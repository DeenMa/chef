package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.apps.deenma.chef.Utilities;

import org.w3c.dom.Text;

/**
 * Created by deenma on 09/04/2017.
 */

public class FileSuccessActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_success);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupUI(bundle);
    }

    private void setupUI(final Bundle bundle) {
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.NAME, R.id.file_success_textview_person_a_name_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY, R.id.file_success_textview_insurance_result);
        String stringTime = bundle.getString(Constants.TIME);
        ((TextView) findViewById(R.id.file_success_textview_time_result)).setText(stringTime);

        Button buttonFinish = (Button) findViewById(R.id.file_success_button_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
