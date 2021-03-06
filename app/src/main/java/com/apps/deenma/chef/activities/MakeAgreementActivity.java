package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;

/**
 * Created by deenma on 03/04/2017.
 */

public class MakeAgreementActivity extends Activity {
    private static final String TAG = MakeAgreementActivity.class.getName();

    private String spinnerResultAccidentType;
    private String spinnerResultYourInformationResponsibility;
    private String spinnerResultOpponentInformationResponsibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_agreement);
        Intent intent = getIntent();
        Bundle bundleInformationActivity = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupUI(bundleInformationActivity);
    }

    private void setupUI(final Bundle bundleInformationActivity) {
        final Context context = this;
        setupSpinner(R.id.make_agreement_spinner_accident_type, context, R.array.accident_types, null, Constants.ACCIDENT_TYPE);
        setupSpinner(R.id.make_agreement_spinner_your_information_responsibility, context, R.array.responsibility_types, Constants.YOUR_INFORMATION, Constants.RESPONSIBILITY);
        setupSpinner(R.id.make_agreement_spinner_opponent_information_responsibility, context, R.array.responsibility_types, Constants.OPPONENT_INFORMATION, Constants.RESPONSIBILITY);

        writeTextView(bundleInformationActivity, Constants.YOUR_INFORMATION, Constants.NAME, R.id.make_agreement_textview_your_information_name_result);
        writeTextView(bundleInformationActivity, Constants.YOUR_INFORMATION, Constants.PLATE_NUMBER, R.id.make_agreement_textview_your_information_plate_number_result);
        writeTextView(bundleInformationActivity, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY, R.id.make_agreement_textview_your_information_insurance_company_result);
        writeTextView(bundleInformationActivity, Constants.YOUR_INFORMATION, Constants.PHONE_NUMBER, R.id.make_agreement_textview_your_information_phone_number_result);

        writeTextView(bundleInformationActivity, Constants.OPPONENT_INFORMATION, Constants.NAME, R.id.make_agreement_textview_opponent_information_name_result);
        writeTextView(bundleInformationActivity, Constants.OPPONENT_INFORMATION, Constants.PLATE_NUMBER, R.id.make_agreement_textview_opponent_information_plate_number_result);
        writeTextView(bundleInformationActivity, Constants.OPPONENT_INFORMATION, Constants.INSURANCE_COMPANY, R.id.make_agreement_textview_opponent_information_insurance_company_result);
        writeTextView(bundleInformationActivity, Constants.OPPONENT_INFORMATION, Constants.PHONE_NUMBER, R.id.make_agreement_textview_opponent_information_phone_number_result);

        Button buttonAgree = (Button) findViewById(R.id.make_agreement_button_agree);
        buttonAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // include responsibility inside
                Bundle bundleAgree = new Bundle(bundleInformationActivity);
                bundleAgree.putString(Constants.CALLING_ACTIVITY, TAG);
                bundleAgree.putString(Constants.ACCIDENT_TYPE, spinnerResultAccidentType);
                Bundle bundleAgreeYourInformation = bundleAgree.getBundle(Constants.YOUR_INFORMATION);
                bundleAgreeYourInformation.putString(Constants.RESPONSIBILITY, spinnerResultYourInformationResponsibility);
                Bundle bundleAgreeOpponentInformation = bundleAgree.getBundle(Constants.OPPONENT_INFORMATION);
                bundleAgreeOpponentInformation.putString(Constants.RESPONSIBILITY, spinnerResultOpponentInformationResponsibility);

                // ??? Can we use the same key for all intents inside the app ???
                Intent intent = new Intent(context, AgreementActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundleAgree);
                startActivity(intent);
            }
        });

        Button buttonDisagree = (Button) findViewById(R.id.make_agreement_button_disagree);
        buttonDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // do not include responsibility inside
                Bundle bundleDisagree = new Bundle(bundleInformationActivity);
                bundleDisagree.putString(Constants.ACCIDENT_TYPE, spinnerResultAccidentType);

                Intent intent = new Intent(context, JudgementSendingActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundleDisagree);
                startActivity(intent);
            }
        });
    }

    private void writeTextView(Bundle bundle, String person, String property, int viewId) {
        Bundle subBundle = bundle.getBundle(person);
        String content = null;
        if (subBundle != null) {
            content = subBundle.getString(property);
        }
        TextView textView = (TextView) findViewById(viewId);
        if (content != null) {
            textView.setText(content);
        }
    }

    /*
    * Note this is very similar to setupSpinner(...) in InformationActivity (the only difference is the global variable names). When possible, refactor the code and combine these two functions
    * */
    private void setupSpinner(int viewId, final Context ctx, int spinArrayOptions, final String people, final String property) {
        Spinner spinner = (Spinner) findViewById(viewId);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = parent.getItemAtPosition(position).toString();
                if (people == null) {
                    if (property.equals(Constants.ACCIDENT_TYPE)) {
                        spinnerResultAccidentType = result;
                    }
                } else if (people.equals(Constants.YOUR_INFORMATION)) {
                    if (property.equals(Constants.RESPONSIBILITY)) {
                        spinnerResultYourInformationResponsibility = result;
                    } else {
                        throw new RuntimeException("Cannot find property information!");
                    }
                } else if (people.equals(Constants.OPPONENT_INFORMATION)) {
                    if (property.equals(Constants.RESPONSIBILITY)) {
                        spinnerResultOpponentInformationResponsibility = result;
                    } else {
                        throw new RuntimeException("Cannot find property information!");
                    }
                } else {
                    throw new RuntimeException("Cannot find person information!");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, spinArrayOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
