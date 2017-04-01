package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 29/03/2017.
 */

public class InformationActivity extends Activity {
    private CharSequence spinnerResultHighwayQuest;
    private CharSequence spinnerResultYourInformationPlateColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setupUI();
    }

    private void setupUI() {
        final Context ctx = this;
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
    }
}
