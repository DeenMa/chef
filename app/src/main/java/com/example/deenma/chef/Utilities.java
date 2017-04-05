package com.example.deenma.chef;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.deenma.chef.activities.ImageViewActivity;

import java.io.File;

/**
 * Created by deenma on 02/04/2017.
 */

public class Utilities {
    public static void takePictureAndSave(Activity activity, String filename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = Uri.fromFile(getOutputMediaFile(activity, filename));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        activity.startActivityForResult(intent, Constants.REQUEST_IMAGE_CAPTURE);
    }

    public static void attachImagePathToView(Activity activity, String filename, int viewId) {
        if (filename != null) {
            Uri uri = Utilities.getURIFromFilename(activity, filename);
            Bitmap bitmapOriginal = BitmapFactory.decodeFile(uri.getPath());
            if (bitmapOriginal != null) {
                ImageView imageView = (ImageView) activity.findViewById(viewId);
                Bitmap bitmapScaled = Utilities.scale(activity, bitmapOriginal);
                imageView.setImageBitmap(bitmapScaled);
            }
        }
    }

    public static Bitmap scale(Activity activity, Bitmap bitmap) {
        Display display = activity.getWindowManager().getDefaultDisplay();
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

    public static void viewImage(Activity activity, String filename) {
        // create an intent and putExtra the filename, then open this file referring to viewPicture()
        Intent intent = new Intent(activity, ImageViewActivity.class);
        intent.putExtra(Constants.GET_IMAGE_REQUEST, filename);
        activity.startActivity(intent);
    }

    public static Uri getURIFromFilename(Activity activity, String filename) {
        File file = getOutputMediaFile(activity, filename);
        Log.d(Utilities.class.getName(), file.getAbsolutePath());
        if (file != null) {
            return Uri.fromFile(file);
        }
        return null;
    }

    private static File getOutputMediaFile(Activity activity, String filename) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), activity.getString(Constants.APP_NAME_ID));
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        String photoPath = mediaStorageDir.getPath() + File.separator +
                "IMG_"+ filename + ".jpg";
        return new File(photoPath);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static void setupButtons(final Activity activity, int viewId, final String constantId, final boolean take) {
        Button button = (Button) activity.findViewById(viewId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (take) {
                    takePictureAndSave(activity, constantId);
                } else {
                    viewImage(activity, constantId);
                }
            }
        });
    }
}
