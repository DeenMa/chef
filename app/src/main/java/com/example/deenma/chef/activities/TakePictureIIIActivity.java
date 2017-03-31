package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 29/03/2017.
 */

public class TakePictureIIIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture_iii);
        Button buttonContinue = (Button) findViewById(R.id.steps_button_continue);
        final Context ctx = this;
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, InformationActivity.class);
                startActivity(intent);
            }
        });
    }
}
