package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 17/03/2017.
 */

public class TakePictureIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture_i);
        setButtons();
    }

    private void setButtons() {
        Button buttonSingleCar = (Button) findViewById(R.id.take_picture_i_button_single_car);
        buttonSingleCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TakePictureIActivity.this, R.string.button_toast_not_supported, Toast.LENGTH_SHORT).show();
            }
        });
        final Context ctx = this;
        Button buttonDoubleCars = (Button) findViewById(R.id.take_picture_i_button_double_cars);
        buttonDoubleCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TakePictureIIActivity.class);
                startActivity(intent);
            }
        });
        Button buttonMultipleCars = (Button) findViewById(R.id.take_picture_i_button_multiple_cars);
        buttonMultipleCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TakePictureIActivity.this, R.string.button_toast_not_supported, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
