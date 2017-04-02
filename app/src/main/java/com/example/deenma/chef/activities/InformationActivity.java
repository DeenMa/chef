package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

        // information_button_your_information_driver_license_take
        Button buttonYourInformationDriverLicenseTake =
                (Button) findViewById(R.id.information_button_your_information_driver_license_take);
        buttonYourInformationDriverLicenseTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.takePictureAndSave(activity, Constants.DRIVER_LICENSE_YOUR_CAR);
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
                Toast.makeText(ctx, spinnerResultHighwayQuest + " "
                        + spinnerResultYourInformationPlateColor + " " + spinnerResultYourInformationCarType + " "
                        + spinnerResultOpponentInformationPlateColor + " " + spinnerResultOpponentInformationCarType,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
