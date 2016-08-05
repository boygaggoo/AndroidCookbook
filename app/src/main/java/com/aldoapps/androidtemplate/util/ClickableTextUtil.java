package com.aldoapps.androidtemplate.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.TextView;

/**
 * Created by aldo on 03/08/16.
 */
public class ClickableTextUtil {

    public static TextView createLink(TextView targetTextView, String completeString,
        String partToClick, ClickableSpan clickableAction) {

        SpannableString spannableString = new SpannableString(completeString);
        try {
            int startPosition = completeString.indexOf(partToClick);
            int endPosition = completeString.lastIndexOf(partToClick) + partToClick.length();

            spannableString.setSpan(clickableAction, startPosition, endPosition, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            targetTextView.setText(spannableString);
            targetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        } catch (IndexOutOfBoundsException e) {
            // do nothing
        }
        return targetTextView;
    }

}
