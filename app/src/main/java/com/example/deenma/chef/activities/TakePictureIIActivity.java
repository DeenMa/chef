package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.deenma.chef.R;
import java.io.File;
import com.example.deenma.chef.Constants;

import com.example.deenma.chef.Utilities;

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
        final Activity activity = this;
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_front_side_view, Constants.IMAGE_FRONT_SIDE_VIEW, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_front_side_view_take, Constants.IMAGE_FRONT_SIDE_VIEW, true);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_collision_your_car, Constants.IMAGE_COLLISION_YOUR_CAR, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_collision_your_car_take, Constants.IMAGE_COLLISION_YOUR_CAR, true);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_collision_opponents_car, Constants.IMAGE_COLLISION_OPPONENTS_CAR, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_collision_opponents_car_take, Constants.IMAGE_COLLISION_OPPONENTS_CAR, true);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_license_plate_your_car, Constants.LICENSE_PLATE_YOUR_CAR, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_license_plate_your_car_take, Constants.LICENSE_PLATE_YOUR_CAR, true);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_license_plate_opponents_car, Constants.LICENSE_PLATE_OPPONENTS_CAR, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_license_plate_opponents_car_take, Constants.LICENSE_PLATE_OPPONENTS_CAR, true);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_additional, Constants.ADDITIONAL, false);
        Utilities.setupButtons(activity, R.id.take_picture_ii_button_additional_take, Constants.ADDITIONAL, true);

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
        return Utilities.checkRequiredImage(this, Constants.IMAGE_FRONT_SIDE_VIEW)
                && Utilities.checkRequiredImage(this, Constants.IMAGE_COLLISION_YOUR_CAR)
                && Utilities.checkRequiredImage(this, Constants.IMAGE_COLLISION_OPPONENTS_CAR)
                && Utilities.checkRequiredImage(this, Constants.LICENSE_PLATE_YOUR_CAR)
                && Utilities.checkRequiredImage(this, Constants.LICENSE_PLATE_OPPONENTS_CAR);

    }
}
