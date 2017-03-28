package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.deenma.chef.R;
import java.io.File;
import com.example.deenma.chef.Constants;

/**
 * Created by deenma on 19/03/2017.
 */

public class TakePictureIIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture_ii);
        setButtons();
    }

    private void setButtons() {
        Button buttonFrontSideView = (Button) findViewById(R.id.take_picture_ii_button_front_side_view);
        buttonFrontSideView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.IMAGE_FRONT_SIDE_VIEW); // name of the image
            }
        });

        Button buttonFrontSideViewTake = (Button) findViewById(R.id.take_picture_ii_button_front_side_view_take);
        buttonFrontSideViewTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.IMAGE_FRONT_SIDE_VIEW);
            }
        });

        Button buttonCollisionYourCar = (Button) findViewById(R.id.take_picture_ii_button_collision_your_car);
        buttonCollisionYourCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.IMAGE_COLLISION_YOUR_CAR);
            }
        });

        Button buttonCollisionYourCarTake = (Button) findViewById(R.id.take_picture_ii_button_collision_your_car_take);
        buttonCollisionYourCarTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.IMAGE_COLLISION_YOUR_CAR);
            }
        });

        Button buttonCollisionOpponentsCar = (Button) findViewById(R.id.take_picture_ii_button_collision_opponents_car);
        buttonCollisionOpponentsCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.IMAGE_COLLISION_OPPONENTS_CAR);
            }
        });

        Button buttonCollisionOpponentsCarTake =
                (Button) findViewById(R.id.take_picture_ii_button_collision_opponents_car_take);
        buttonCollisionOpponentsCarTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.IMAGE_COLLISION_OPPONENTS_CAR);
            }
        });

        Button buttonLicensePlateYourCar = (Button) findViewById(R.id.take_picture_ii_button_license_plate_your_car);
        buttonLicensePlateYourCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.LICENSE_PLATE_YOUR_CAR);
            }
        });

        Button buttonLicensePlateYourCarTake =
                (Button) findViewById(R.id.take_picture_ii_button_license_plate_your_car_take);
        buttonLicensePlateYourCarTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.LICENSE_PLATE_YOUR_CAR);
            }
        });

        Button buttonLicensePlateOpponentsCar =
                (Button) findViewById(R.id.take_picture_ii_button_license_plate_opponents_car);
        buttonLicensePlateOpponentsCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.LICENSE_PLATE_OPPONENTS_CAR);
            }
        });

        Button buttonLicensePlateOpponentsCarTake =
                (Button) findViewById(R.id.take_picture_ii_button_license_plate_opponents_car_take);
        buttonLicensePlateOpponentsCarTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.LICENSE_PLATE_OPPONENTS_CAR);
            }
        });

        // button_additional
        Button buttonAdditional =
                (Button) findViewById(R.id.take_picture_ii_button_additional);
        buttonAdditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewImage(Constants.ADDITIONAL);
            }
        });

        Button buttonAdditionalTake =
                (Button) findViewById(R.id.take_picture_ii_button_additional_take);
        buttonAdditionalTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAndSave(Constants.ADDITIONAL);
            }
        });

        Button buttonContinue =
                (Button) findViewById(R.id.take_picture_ii_button_continue);
        final Context ctx = this;
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean continueAllowed = checkButtonContinue();
                if (continueAllowed) {
                    Intent intent = new Intent(ctx, TakePictureIIIActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TakePictureIIActivity.this, R.string.not_enough_pics, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkButtonContinue() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), getString(Constants.APP_NAME_ID));
        File[] list = mediaStorageDir.listFiles();
        int num = 0;
        for (File f : list) {
            String fName = f.getName();
            // we strictly restrict our images into one of these five types
            if (fName.contains(Constants.IMAGE_FRONT_SIDE_VIEW)
                    || fName.contains(Constants.IMAGE_COLLISION_YOUR_CAR)
                    || fName.contains(Constants.IMAGE_COLLISION_OPPONENTS_CAR)
                    || fName.contains(Constants.LICENSE_PLATE_YOUR_CAR)
                    || fName.contains(Constants.LICENSE_PLATE_OPPONENTS_CAR)) {
                num++;
            }
        }
        return num == 5; // there shall be 5 effective images
    }

    private void takePictureAndSave(String filename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = Uri.fromFile(getOutputMediaFile(filename));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, Constants.REQUEST_IMAGE_CAPTURE);
    }

    private File getOutputMediaFile(String filename) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), getString(Constants.APP_NAME_ID));
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        String photoPath = mediaStorageDir.getPath() + File.separator +
                "IMG_"+ filename + ".jpg";
        return new File(photoPath);
    }

    private void viewImage(String filename) {
        // create an intent and putExtra the filename, then open this file referring to viewPicture()
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
