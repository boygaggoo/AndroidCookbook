package com.aldoapps.androidtemplate.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by aldokelvianto on 06/06/16.
 *
 * Usage textView.setTypeface(getTypeface(this, FontLoader.VARELA_ROUND);
 */
public class FontLoader {

    public static final int VARELA_ROUND =   0;
    public static final int FONT_NAME_2 =   1;
    public static final int FONT_NAME_3 =   2;

    private static final int NUM_OF_CUSTOM_FONTS = 1;

    private static boolean fontsLoaded = false;

    private static Typeface[] typefaces = new Typeface[NUM_OF_CUSTOM_FONTS];

    private static String[] fontPath = {
            "fonts/VarelaRound-Regular.ttf"
    };

    /**
     * Returns a loaded custom font based on it's identifier.
     *
     * @param context - the current context
     * @param fontIdentifier = the identifier of the requested font
     *
     * @return Typeface object of the requested font.
     */
    public static Typeface getTypeface(Context context, int fontIdentifier) {
        if (!fontsLoaded) {
            loadFonts(context);
        }
        return typefaces[fontIdentifier];
    }


    private static void loadFonts(Context context) {
        for (int i = 0; i < NUM_OF_CUSTOM_FONTS; i++) {
            typefaces[i] = Typeface.createFromAsset(context.getAssets(), fontPath[i]);
        }
        fontsLoaded = true;
    }
}
