package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.deenma.chef.Constants;
import com.example.deenma.chef.R;
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onResume() {
        super.onResume();
        proceedToStepsActivity();
    }

    private void proceedToStepsActivity() {
        Handler handler = new Handler();
        final Activity ctx = this;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ctx, StepsActivity.class);
                startActivity(intent);
                ctx.finish();
            }
        }, Constants.DELAY_ACTIVITY);
    }
}
