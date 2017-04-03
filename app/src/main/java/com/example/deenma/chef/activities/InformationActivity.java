package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
        final Context ctx = this;
        final Activity activity = this;
        // highway quest
        Spinner spinnerHighwayQuest = (Spinner) findViewById(R.id.information_spinner_highway_quest);
        spinnerHighwayQuest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultHighwayQuest = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterHighwayQuest = ArrayAdapter.createFromResource(this, R.array.highway_options, android.R.layout.simple_spinner_item);
        adapterHighwayQuest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHighwayQuest.setAdapter(adapterHighwayQuest);

        // your information - plate color
        Spinner spinnerYourInformationPlateColor = (Spinner) findViewById(R.id.information_spinner_your_information_plate_color);
        spinnerYourInformationPlateColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultYourInformationPlateColor = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterYourInformationPlateColor = ArrayAdapter.createFromResource(this, R.array.plate_colors, android.R.layout.simple_spinner_item);
        adapterYourInformationPlateColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourInformationPlateColor.setAdapter(adapterYourInformationPlateColor);

        // your information - car type
        Spinner spinnerYourInformationCarType = (Spinner) findViewById(R.id.information_spinner_your_information_car_type);
        spinnerYourInformationCarType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultYourInformationCarType = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterYourInformationCarType = ArrayAdapter.createFromResource(this, R.array.car_types, android.R.layout.simple_spinner_item);
        adapterYourInformationCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourInformationCarType.setAdapter(adapterYourInformationCarType);

        // opponent information - plate color
        Spinner spinnerOpponentInformationPlateColor = (Spinner) findViewById(R.id.information_spinner_opponent_information_plate_color);
        spinnerOpponentInformationPlateColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultOpponentInformationPlateColor = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterOpponentInformationPlateColor = ArrayAdapter.createFromResource(this, R.array.plate_colors, android.R.layout.simple_spinner_item);
        adapterOpponentInformationPlateColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpponentInformationPlateColor.setAdapter(adapterOpponentInformationPlateColor);

        // opponent information - car type
        Spinner spinnerOpponentInformationCarType = (Spinner) findViewById(R.id.information_spinner_opponent_information_car_type);
        spinnerOpponentInformationCarType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultOpponentInformationCarType = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterOpponentInformationCarType = ArrayAdapter.createFromResource(this, R.array.car_types, android.R.layout.simple_spinner_item);
        adapterOpponentInformationCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpponentInformationCarType.setAdapter(adapterOpponentInformationCarType);

        // information_button_your_information_driver_license
        Button buttonYourInformationDriverLicense =
                (Button) findViewById(R.id.information_button_your_information_driver_license);
        buttonYourInformationDriverLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.viewImage(activity, Constants.DRIVER_LICENSE_YOUR_CAR);
            }
        });

        // information_button_your_information_driver_license_take
        Button buttonYourInformationDriverLicenseTake =
                (Button) findViewById(R.id.information_button_your_information_driver_license_take);
        buttonYourInformationDriverLicenseTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.takePictureAndSave(activity, Constants.DRIVER_LICENSE_YOUR_CAR);
            }
        });

        // information_button_opponent_information_driver_license
        Button buttonOpponentInformationDriverLicense =
                (Button) findViewById(R.id.information_button_opponent_information_driver_license);
        buttonOpponentInformationDriverLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.viewImage(activity, Constants.DRIVER_LICENSE_OPPONENT_CAR);
            }
        });

        // information_button_opponent_information_driver_license_take
        Button buttonOpponentInformationDriverLicenseTake =
                (Button) findViewById(R.id.information_button_opponent_information_driver_license_take);
        buttonOpponentInformationDriverLicenseTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.takePictureAndSave(activity, Constants.DRIVER_LICENSE_OPPONENT_CAR);
            }
        });

        // information_button_continue
        Button buttonContinue = (Button) findViewById(R.id.information_button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAvailability()) {
                    Intent intent = new Intent(ctx, MakeAgreementActivity.class);
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
}
