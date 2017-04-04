package com.example.deenma.chef.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import com.example.deenma.chef.Constants;
import com.example.deenma.chef.R;

import java.io.File;

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
        if (filename != null) { // otherwise we don't open this file - leave the image view blank
            Uri uri = Utilities.getURIFromFilename(this, filename);
            if (uri != null) {
                ImageView imageView = (ImageView) findViewById(R.id.image_view);
                Bitmap bitmapScaled = scale(uri);
                imageView.setImageBitmap(bitmapScaled);
            }
        }
    }

    private Bitmap scale(Uri uri) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float displayWidth = size.x;
        float displayHeight = size.y;
        float bitmapWidth = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();
        Bitmap bitmapScaled = null;
        if (bitmapWidth > displayWidth || bitmapHeight > displayHeight) {
            float scale = Math.max(bitmapWidth / displayWidth, bitmapHeight / displayHeight);
            bitmapScaled = Bitmap.createScaledBitmap(bitmap, (int) (bitmapWidth / scale), (int) (bitmapHeight / scale), true);
        } else {
            bitmapScaled = bitmap;
        }
        return bitmapScaled;
    }
}
