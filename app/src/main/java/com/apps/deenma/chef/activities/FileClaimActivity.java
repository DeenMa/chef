package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;
import com.apps.deenma.chef.Utilities;

import java.io.File;

/**
 * Created by deenma on 08/04/2017.
 */

public class FileClaimActivity extends Activity {
    private static final String TAG = FileClaimActivity.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_claim);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Constants.BUNDLE_INFORMATION);
        setupUI(bundle);
    }

    private void setupUI(final Bundle bundle) {
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.NAME, R.id.file_claim_textview_person_a_name_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.RESPONSIBILITY, R.id.file_claim_textview_responsibility_result);
        Utilities.setText(bundle, this, Constants.YOUR_INFORMATION, Constants.INSURANCE_COMPANY, R.id.file_claim_textview_insurance_company_result);

        final Context context = this;
        final Activity activity = this;
        Button buttonFile = (Button) findViewById(R.id.file_claim_button_file);
        buttonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save all pictures into history folder, delay 3 seconds, and move to FileSuccessActivity
                moveAllImageFilesToHistoryFolder(activity, bundle);
                Toast.makeText(context, R.string.transfer_to_server, Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(context, FileSuccessActivity.class);
                intent.putExtra(Constants.BUNDLE_INFORMATION, bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, Constants.DELAY_ACTIVITY);
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.file_claim_button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: implement this + activity, Tell the user where can they find the picture, and basic opponent information
            }
        });
    }

    // to move them in order not to mix images from old claim with images with new claim
    private void moveAllImageFilesToHistoryFolder(Activity activity, Bundle bundle) {
        String stringTime = Utilities.getCurrentTime("yyyyMMddHHmmss");
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), activity.getString(Constants.APP_NAME_ID));
        File newFileDir = new File(mediaStorageDir.getPath() + File.separator + stringTime);
        if (!newFileDir.exists()) {
            newFileDir.mkdir();
        }
        Log.d(TAG, "newFileDir is " + newFileDir);

        File[] list = mediaStorageDir.listFiles();
        for (File f : list) {
            if (f.isFile()) {
                String fileName = f.getName();
                Log.d(TAG, "Currently processing " + fileName);
                if (fileName.contains("IMG_")) {
                    File newFile = new File(newFileDir.getAbsolutePath() + File.separator + fileName);
                    File oldFile = new File(f.getAbsolutePath());
                    oldFile.renameTo(newFile);
                }
            }
        }
    }
}
