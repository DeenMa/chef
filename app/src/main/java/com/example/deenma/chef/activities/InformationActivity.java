package com.example.deenma.chef.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 29/03/2017.
 */

public class InformationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setupUI();
    }

    private void setupUI() {
        // highway quest
        Spinner spinnerHighwayQuest = (Spinner) findViewById(R.id.information_spinner_highway_quest);
        ArrayAdapter<CharSequence> adapterHighwayQuest = ArrayAdapter.createFromResource(this, R.array.highway_options, android.R.layout.simple_spinner_item);
        adapterHighwayQuest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHighwayQuest.setAdapter(adapterHighwayQuest);

        // your information - plate color
        Spinner spinnerYourInformationPlateColor = (Spinner) findViewById(R.id.information_spinner_your_information_plate_color);
        ArrayAdapter<CharSequence> adapterYourInformationPlateColor = ArrayAdapter.createFromResource(this, R.array.plate_colors, android.R.layout.simple_spinner_item);
        adapterYourInformationPlateColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourInformationPlateColor.setAdapter(adapterYourInformationPlateColor);
    }
}
