package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import com.example.deenma.chef.Constants;
import com.example.deenma.chef.R;

import com.example.deenma.chef.Utilities;

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
