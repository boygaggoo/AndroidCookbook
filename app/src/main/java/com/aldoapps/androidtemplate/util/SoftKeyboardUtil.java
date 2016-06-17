package com.aldoapps.androidtemplate.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by aldokelvianto on 14/06/16.
 */
public class SoftKeyboardUtil {

    private void dismissKeyboard(Context context, View containerView, EditText editText){
        containerView.requestFocus();
        InputMethodManager imm = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
