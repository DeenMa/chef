package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.apps.deenma.chef.Utilities;

/**
 * Created by deenma on 05/04/2017.
 */

public class JudgementSendingActivity extends Activity {
    private static final String TAG = JudgementSendingActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judgement_sending);

        Intent intent = getIntent();
        Bundle bundleDisagree = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupHiddenUI(bundleDisagree);
        setupUI(bundleDisagree);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showContinueButton();
    }

    private void showContinueButton() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Button buttonContinue = (Button) findViewById(R.id.judgement_sending_button_continue);
                buttonContinue.setVisibility(View.VISIBLE);
            }
        }, Constants.DELAY_ACTIVITY);
    }

    private void setupHiddenUI(Bundle bundle) {
        // public information
        String stringPublic =
                getStringFromBundle(bundle, null, Constants.RESULT_HIGHWAY_QUEST)
                + " "
                + getStringFromBundle(bundle, null, Constants.ACCIDENT_TYPE);
        ((TextView) findViewById(R.id.judgement_sending_information_public)).setText(stringPublic);

        String stringYourInformation = getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.NAME) + ", "
                + getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.PLATE_NUMBER) + ", "
                + getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.PLATE_COLOR) + ", "
                + getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.CAR_TYPE) + ", "
                + getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY) + ", "
                + getStringFromBundle(bundle, Constants.YOUR_INFORMATION, Constants.PHONE_NUMBER);
        ((TextView) findViewById(R.id.judgement_sending_your_information)).setText(stringYourInformation);

        String stringOpponentInformation = getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.NAME) + ", "
                + getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.PLATE_NUMBER) + ", "
                + getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.PLATE_COLOR) + ", "
                + getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.CAR_TYPE) + ", "
                + getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.INSURANCE_COMPANY) + ", "
                + getStringFromBundle(bundle, Constants.OPPONENT_INFORMATION, Constants.PHONE_NUMBER);
        ((TextView) findViewById(R.id.judgement_sending_opponent_information)).setText(stringOpponentInformation);

        Utilities.attachImagePathToView(this, Constants.IMAGE_FRONT_SIDE_VIEW, R.id.judgement_sending_imageview_front_side_view);
        Utilities.attachImagePathToView(this, Constants.IMAGE_COLLISION_YOUR_CAR, R.id.judgement_sending_imageview_collision_your_car);
        Utilities.attachImagePathToView(this, Constants.IMAGE_COLLISION_OPPONENTS_CAR, R.id.judgement_sending_imageview_collision_opponent_car);
        Utilities.attachImagePathToView(this, Constants.LICENSE_PLATE_YOUR_CAR, R.id.judgement_sending_imageview_license_plate_your_car);
        Utilities.attachImagePathToView(this, Constants.LICENSE_PLATE_OPPONENTS_CAR, R.id.judgement_sending_imageview_license_plate_opponent_car);
        Utilities.attachImagePathToView(this, Constants.ADDITIONAL, R.id.judgement_sending_imageview_additional);
        Utilities.attachImagePathToView(this, Constants.DRIVER_LICENSE_YOUR_CAR, R.id.judgement_sending_imageview_your_driver_license);
        Utilities.attachImagePathToView(this, Constants.DRIVER_LICENSE_OPPONENT_CAR, R.id.judgement_sending_imageview_opponent_driver_license);
        Utilities.attachImagePathToView(this, Constants.INSURANCE_CARD_YOUR_CAR, R.id.judgement_sending_imageview_your_insurance_card);
        Utilities.attachImagePathToView(this, Constants.INSURANCE_CARD_OPPONENT_CAR, R.id.judgement_sending_imageview_opponent_insurance_card);
    }

    private String getStringFromBundle(Bundle bundle, String person, String property) {
        if (person == null) {
            return bundle.getString(property);
        }
        Bundle bundlePerson = bundle.getBundle(person);
        return bundlePerson.getString(property);
    }

    private void setupUI(final Bundle bundle) {
        final Context context = this;
        Button buttonBack = (Button) findViewById(R.id.judgement_sending_button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button buttonContinue = (Button) findViewById(R.id.judgement_sending_button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AgreementActivity.class);
                Bundle bundleJudgementSending = new Bundle(bundle);
                bundleJudgementSending.putString(Constants.CALLING_ACTIVITY, TAG);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundleJudgementSending);
                startActivity(intent);
                finish();
            }
        });
        buttonContinue.setVisibility(View.GONE);
    }
}
