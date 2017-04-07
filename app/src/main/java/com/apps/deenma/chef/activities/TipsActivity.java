package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.deenma.chef.R;

/**
 * Created by deenma on 17/03/2017.
 */

public class TipsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        final Context ctx = this;
        Button buttonContinue = (Button) findViewById(R.id.tips_button_continue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TakePictureIActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}