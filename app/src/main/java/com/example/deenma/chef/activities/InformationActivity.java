package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deenma.chef.Constants;
import com.example.deenma.chef.R;
import com.example.deenma.chef.Utilities;

import java.lang.reflect.ParameterizedType;

/**
 * Created by deenma on 29/03/2017.
 */

public class InformationActivity extends Activity {
    private CharSequence spinnerResultHighwayQuest;
    private CharSequence spinnerResultYourInformationPlateColor;
    private CharSequence spinnerResultYourInformationCarType;
    private CharSequence spinnerResultOpponentInformationPlateColor;
    private CharSequence spinnerResultOpponentInformationCarType;

    private String editTextResultYourInformationName;
    private String editTextResultYourInformationPlateNumber;
    private String editTextResultYourInformationInsuranceCompany;
    private String editTextResultYourInformationPhoneNumber;
    private String editTextResultOpponentInformationName;
    private String editTextResultOpponentInformationPlateNumber;
    private String editTextResultOpponentInformationInsuranceCompany;
    private String editTextResultOpponentInformationPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setupUI();
    }

    private void setupUI() {
        final Context context = this;
        final Activity activity = this;

        setupSpinner(R.id.information_spinner_highway_quest, context, R.array.highway_options, null, Constants.RESULT_HIGHWAY_QUEST); // highway quest
        setupSpinner(R.id.information_spinner_your_information_plate_color, context, R.array.plate_colors, Constants.YOUR_INFORMATION, Constants.PLATE_COLOR); // your information - plate color
        setupSpinner(R.id.information_spinner_your_information_car_type, context, R.array.car_types, Constants.YOUR_INFORMATION, Constants.CAR_TYPE); // your information - car type
        setupSpinner(R.id.information_spinner_opponent_information_plate_color, context, R.array.plate_colors, Constants.OPPONENT_INFORMATION, Constants.PLATE_COLOR); // opponent information - plate color
        setupSpinner(R.id.information_spinner_opponent_information_car_type, context, R.array.car_types, Constants.OPPONENT_INFORMATION, Constants.CAR_TYPE); // opponent information - car type

        // information_button_your_information_driver_license
        Utilities.setupButtons(activity, R.id.information_button_your_information_driver_license, Constants.DRIVER_LICENSE_YOUR_CAR, false);
        // information_button_your_information_driver_license_take
        Utilities.setupButtons(activity, R.id.information_button_your_information_driver_license_take, Constants.DRIVER_LICENSE_YOUR_CAR, true);
        // information_button_opponent_information_driver_license
        Utilities.setupButtons(activity, R.id.information_button_opponent_information_driver_license, Constants.DRIVER_LICENSE_OPPONENT_CAR, false);
        // information_button_opponent_information_driver_license_take
        Utilities.setupButtons(activity, R.id.information_button_opponent_information_driver_license_take, Constants.DRIVER_LICENSE_OPPONENT_CAR, true);

        // information_button_continue
        Button buttonContinue = (Button) findViewById(R.id.information_button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAvailability()) {
                    Intent intent = new Intent(context, MakeAgreementActivity.class);
                    Bundle bundleInformationActivity = new Bundle();
                    bundleInformationActivity.putCharSequence(Constants.RESULT_HIGHWAY_QUEST, spinnerResultHighwayQuest);

                    Bundle bundleYourInformation = new Bundle();
                    bundleYourInformation.putCharSequence(Constants.PLATE_COLOR, spinnerResultYourInformationPlateColor);
                    bundleYourInformation.putCharSequence(Constants.CAR_TYPE, spinnerResultYourInformationCarType);
                    bundleYourInformation.putString(Constants.NAME, editTextResultYourInformationName);
                    bundleYourInformation.putString(Constants.PLATE_NUMBER, editTextResultYourInformationPlateNumber);
                    bundleYourInformation.putString(Constants.INSURANCE_COMPANY, editTextResultYourInformationInsuranceCompany);
                    bundleYourInformation.putString(Constants.PHONE_NUMBER, editTextResultYourInformationPhoneNumber);
                    bundleInformationActivity.putBundle(Constants.YOUR_INFORMATION, bundleYourInformation);

                    Bundle bundleOpponentInformation = new Bundle();
                    bundleOpponentInformation.putCharSequence(Constants.PLATE_COLOR, spinnerResultOpponentInformationPlateColor);
                    bundleOpponentInformation.putCharSequence(Constants.CAR_TYPE, spinnerResultOpponentInformationCarType);
                    bundleOpponentInformation.putString(Constants.NAME, editTextResultOpponentInformationName);
                    bundleOpponentInformation.putString(Constants.PLATE_NUMBER, editTextResultOpponentInformationPlateNumber);
                    bundleOpponentInformation.putString(Constants.INSURANCE_COMPANY, editTextResultOpponentInformationInsuranceCompany);
                    bundleOpponentInformation.putString(Constants.PHONE_NUMBER, editTextResultOpponentInformationPhoneNumber);
                    bundleInformationActivity.putBundle(Constants.OPPONENT_INFORMATION, bundleOpponentInformation);

                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkAvailability() {
        EditText editTextYourInformationName = (EditText) findViewById(R.id.information_edittext_your_information_name);
        editTextResultYourInformationName = editTextYourInformationName.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultYourInformationName)) {
            Toast.makeText(this, "Your Information -> Name is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextYourInformationPlateNumber = (EditText) findViewById(R.id.information_edittext_your_information_plate_number);
        editTextResultYourInformationPlateNumber = editTextYourInformationPlateNumber.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultYourInformationPlateNumber)) {
            Toast.makeText(this, "Your Information -> Plate Number is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextYourInformationInsuranceCompany = (EditText) findViewById(R.id.information_edittext_your_information_insurance_company);
        editTextResultYourInformationInsuranceCompany = editTextYourInformationInsuranceCompany.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultYourInformationInsuranceCompany)) {
            Toast.makeText(this, "Your Information -> Insurance is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextYourInformationPhoneNumber = (EditText) findViewById(R.id.information_edittext_your_information_phone_number);
        editTextResultYourInformationPhoneNumber = editTextYourInformationPhoneNumber.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultYourInformationPhoneNumber)) {
            Toast.makeText(this, "Your Information -> Insurance is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextOpponentInformationName = (EditText) findViewById(R.id.information_edittext_opponent_information_name);
        editTextResultOpponentInformationName = editTextOpponentInformationName.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultOpponentInformationName)) {
            Toast.makeText(this, "Opponent Information -> Name is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextOpponentInformationPlateNumber = (EditText) findViewById(R.id.information_edittext_opponent_information_plate_number);
        editTextResultOpponentInformationPlateNumber = editTextOpponentInformationPlateNumber.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultOpponentInformationPlateNumber)) {
            Toast.makeText(this, "Opponent Information -> Plate Number is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextOpponentInformationInsuranceCompany = (EditText) findViewById(R.id.information_edittext_opponent_information_insurance_company);
        editTextResultOpponentInformationInsuranceCompany = editTextOpponentInformationInsuranceCompany.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultOpponentInformationInsuranceCompany)) {
            Toast.makeText(this, "Opponent Information -> Insurance is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText editTextOpponentInformationPhoneNumber = (EditText) findViewById(R.id.information_edittext_opponent_information_phone_number);
        editTextResultOpponentInformationPhoneNumber = editTextOpponentInformationPhoneNumber.getText().toString();
        if (Utilities.isNullOrEmpty(editTextResultOpponentInformationPhoneNumber)) {
            Toast.makeText(this, "Opponent Information -> Insurance is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /*
* this is dirty code - are there any way of passing the object name as an argument into the function,
* get the object by its name, and then assign value to it?
* */
    private void setupSpinner(int viewId, final Context ctx, int spinArrayOptions, final String people, final String property) {
        Spinner spinner = (Spinner) findViewById(viewId);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence result = (CharSequence) parent.getItemAtPosition(position);
                if (people == null) {
                    if (property.equals(Constants.RESULT_HIGHWAY_QUEST)) {
                        spinnerResultHighwayQuest = result;
                    }
                } else if (people.equals(Constants.YOUR_INFORMATION)) {
                    if (property.equals(Constants.PLATE_COLOR)) {
                        spinnerResultYourInformationPlateColor = result;
                    } else if (property.equals(Constants.CAR_TYPE)) {
                        spinnerResultYourInformationCarType = result;
                    } else {
                        throw new RuntimeException("Cannot find property information!");
                    }
                } else if (people.equals(Constants.OPPONENT_INFORMATION)) {
                    if (property.equals(Constants.PLATE_COLOR)) {
                        spinnerResultOpponentInformationPlateColor = result;
                    } else if (property.equals(Constants.CAR_TYPE)) {
                        spinnerResultOpponentInformationCarType = result;
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
