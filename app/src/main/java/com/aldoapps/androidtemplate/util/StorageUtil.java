package com.aldoapps.androidtemplate.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by aldokelvianto on 13/06/16.
 */
public class StorageUtil {

    private static final String TAG = "asdf";
    private static final int COMPRESSION_RATE = 90;

    /**
     * This will save image to storage, but the image wouldn't be shown in device gallery
     * @param imageView
     * @param folderName
     * @param fileName
     * @return
     */
    private static String saveImageToStorage(ImageView imageView,
                                             String folderName, String fileName) {
        Bitmap bitmap = BitmapUtil.getBitmapFromImageView(imageView);
        OutputStream outputStream;

        File filePath = Environment.getExternalStorageDirectory();

        File imageDir = new File(filePath.getAbsolutePath() + folderName);
        if(!imageDir.exists()){
            imageDir.mkdir();
        }

        File imageFile = new File(imageDir, fileName + ".png");

        boolean isSaveSuccessful;

        try {
            outputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, COMPRESSION_RATE, outputStream);
            outputStream.flush();
            outputStream.close();
            isSaveSuccessful = true;
        } catch (IOException e) {
            isSaveSuccessful = false;
            Log.e(TAG, e.getMessage());
        }

        if(isSaveSuccessful){
            String completePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + folderName + "/" + fileName + ".png";
            return completePath;
        }

        return null;
    }

    /**
     * Use this method to save image to storage and make it visible in device Gallery
     * @param imageView
     * @param folderName
     * @param fileName
     * @return
     */
    private static String saveImageToStorageWithMediaScanner(Context context, ImageView imageView,
                                                             String folderName, String fileName) {
        Bitmap bitmap = BitmapUtil.getBitmapFromImageView(imageView);
        OutputStream outputStream;

        File filePath = Environment.getExternalStorageDirectory();

        File imageDir = new File(filePath.getAbsolutePath() + folderName);
        if(!imageDir.exists()){
            imageDir.mkdir();
        }

        File imageFile = new File(imageDir, fileName + ".png");

        boolean isSaveSuccessful;

        try {
            outputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, COMPRESSION_RATE, outputStream);
            outputStream.flush();
            outputStream.close();
            isSaveSuccessful = true;


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        Uri.parse("file://"
                                + Environment.getExternalStorageDirectory())));
            } else {
                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED,
                        Uri.parse("file://"
                                + Environment.getExternalStorageDirectory())));
            }
            new SingleMediaScanner(context, imageFile);
        } catch (IOException e) {
            isSaveSuccessful = false;
            Log.e(TAG, e.getMessage());
        }

        if(isSaveSuccessful){
            String completePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + folderName + "/" + fileName + ".png";
            return completePath;
        }

        return null;
    }
}
