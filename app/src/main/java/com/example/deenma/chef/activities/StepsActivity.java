package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deenma.chef.R;

/**
 * Created by deenma on 17/03/2017.
 */

public class StepsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        final Context ctx = this;
        Button buttonStart = (Button) findViewById(R.id.steps_button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, TipsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
