package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 03/04/2017.
 */

public class MakeAgreementActivity extends Activity {
    private CharSequence spinnerResultAccidentType;
    private CharSequence spinnerResultYourInformationResponsibility;
    private CharSequence spinnerResultOpponentInformationResponsibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_agreement);
        setupUI();
    }

    private void setupUI() {
        final Context ctx = this;
        Spinner spinnerAccidentType = (Spinner) findViewById(R.id.make_agreement_spinner_accident_type);
        spinnerAccidentType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultAccidentType = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterAccidentType = ArrayAdapter.createFromResource(this, R.array.accident_types, android.R.layout.simple_spinner_item);
        adapterAccidentType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAccidentType.setAdapter(adapterAccidentType);

        Spinner spinnerYourInformationResponsibility = (Spinner) findViewById(R.id.make_agreement_spinner_your_information_responsibility);
        spinnerYourInformationResponsibility.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultYourInformationResponsibility = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterYourInformationResponsibility = ArrayAdapter.createFromResource(this, R.array.responsibility_types, android.R.layout.simple_spinner_item);
        adapterYourInformationResponsibility.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYourInformationResponsibility.setAdapter(adapterYourInformationResponsibility);

        Spinner spinnerOpponentInformationResponsibility = (Spinner) findViewById(R.id.make_agreement_spinner_opponent_information_responsibility);
        spinnerOpponentInformationResponsibility.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerResultOpponentInformationResponsibility = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ctx, R.string.not_making_a_selection, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapterOpponentInformationResponsibility = ArrayAdapter.createFromResource(this, R.array.responsibility_types, android.R.layout.simple_spinner_item);
        adapterOpponentInformationResponsibility.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpponentInformationResponsibility.setAdapter(adapterOpponentInformationResponsibility);
    }
}
