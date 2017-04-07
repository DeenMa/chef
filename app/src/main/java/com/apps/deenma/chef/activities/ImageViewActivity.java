package com.apps.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.apps.deenma.chef.Constants;
import com.apps.deenma.chef.R;

import com.apps.deenma.chef.Utilities;

/**
 * Created by deenma on 02/04/2017.
 */

public class ImageViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        Intent intent = getIntent();
        String filename = intent.getStringExtra(Constants.GET_IMAGE_REQUEST);
        Utilities.attachImagePathToView(this, filename, R.id.image_view);
    }
}
