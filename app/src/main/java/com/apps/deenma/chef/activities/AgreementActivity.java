package com.apps.deenma.chef.activities;

import com.apps.deenma.chef.Utilities;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by deenma on 04/04/2017.
 */

public class AgreementActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = AgreementActivity.class.getName();
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        Intent intent = getIntent();
        Bundle bundleAgree = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        // remove this "if statement" in the formal app, since the server returns the responsibility results. this is only a mock
        if (bundleAgree.getString(Constants.CALLING_ACTIVITY).equals(JudgementSendingActivity.class.getName())) {
            Bundle bundleAgreeYourInformation = bundleAgree.getBundle(Constants.YOUR_INFORMATION);
            bundleAgreeYourInformation.putString(Constants.RESPONSIBILITY, "Partial");
            Bundle bundleAgreeOpponentInformation = bundleAgree.getBundle(Constants.OPPONENT_INFORMATION);
            bundleAgreeOpponentInformation.putString(Constants.RESPONSIBILITY, "Partial");
        }
        setupUI(bundleAgree);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        Log.d(TAG, "google api client connected!");
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
            StringBuilder builder = new StringBuilder();
            try {
                Log.d(TAG, "latitude = " + mLastLocation.getLatitude());
                Log.d(TAG, "longitude = " + mLastLocation.getLongitude());
                List<Address> address = geoCoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
                int maxLines = address.get(0).getMaxAddressLineIndex();
                for (int i = 0; i < maxLines; i++) {
                    String addressStr = address.get(0).getAddressLine(i);
                    builder.append(addressStr);
                    builder.append(" ");
                }
                // update to the location section
                String addressFinal = builder.toString();
                TextView agreementLocation = (TextView) findViewById(R.id.agreement_agreement_location_result);
                agreementLocation.setText(addressFinal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.w(TAG, "mLastLocation == null");
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Connection suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "Connection failed");
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        Log.d(TAG, "google api client connecting ... ");
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    private void setupUI(final Bundle bundle) {
        // get current time
        TextView agreementTime = (TextView) findViewById(R.id.agreement_agreement_time_result);
        String currentTime = Utilities.getCurrentTime("yyyy/MM/dd HH:mm:ss");
        bundle.putString(Constants.TIME, currentTime);
        agreementTime.setText(currentTime);

        // location information is set by onConnected()

        // set accident type
        TextView agreementAccidentType = (TextView) findViewById(R.id.agreement_agreement_accident_type_result);
        String stringAccidentType = bundle.getString(Constants.ACCIDENT_TYPE);
        agreementAccidentType.setText(stringAccidentType);

        // set all personal information
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.NAME, R.id.agreement_person_a_name_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.PLATE_NUMBER, R.id.agreement_person_a_plate_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY, R.id.agreement_person_a_insurance_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.PHONE_NUMBER, R.id.agreement_person_a_phone_result);

        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.NAME, R.id.agreement_person_b_name_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.PLATE_NUMBER, R.id.agreement_person_b_plate_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.INSURANCE_COMPANY, R.id.agreement_person_b_insurance_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.PHONE_NUMBER, R.id.agreement_person_b_phone_result);

        // set responsibilities
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.RESPONSIBILITY, R.id.agreement_responsibility_person_a_result);
        Utilities.setText(bundle, this, Constants.OPPONENT_INFORMATION, Constants.RESPONSIBILITY, R.id.agreement_responsibility_person_b_result);

        // get the final information to file the claim
        final Context context = this;
        final Activity activity = this;
        Button buttonContinue = (Button) findViewById(R.id.agreement_button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FileClaimActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundle);
                startActivity(intent);
            }
        });
    }


}
