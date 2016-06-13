package com.aldoapps.androidtemplate.util;

import android.graphics.Bitmap;
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

            /**
             * I deliberately didn't broadcast Media Scanner
             * (So, user can see movie poster in Gallery)
             * Because I want to make it hard for user to access poster,
             * thus reducing the risk of user deleting posters.
             */
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
