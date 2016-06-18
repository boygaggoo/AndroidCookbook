package com.aldoapps.androidtemplate.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

/**
 * Created by aldokelvianto on 06/06/16.
 */
public class DrawableUtil {
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    /**
     * Please be careful when using this method,
     * Bitmap is wild beast, it consumes a lot of memories,
     * you either you use different thread or making sure your bitmap is small
     * enough for UI Thread.
     * Another options to reduce processing time is to modify blur scale and blur radius.
     * Tune those two parameters to get desireable result.
     * @param bitmap
     * @return
     */
    public static Bitmap getBlurredBitmap(Bitmap bitmap){
        float BLUR_SCALE = 2f;
        int BLUR_RADIUS = 8;

        Bitmap blurBitmap = null;
        try{
            blurBitmap = StackBlur.fastblur(bitmap, BLUR_SCALE, BLUR_RADIUS);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
        }

        return blurBitmap;
    }
}
