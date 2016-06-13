package com.aldoapps.androidtemplate.util;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by aldokelvianto on 13/06/16.
 */
public class MarkerUtil {

    public static BitmapDescriptor getMarkerIconFromDrawable(int drawableRes){
        return BitmapDescriptorFactory
                .fromResource(drawableRes);
    }

    // BitmapDescriptorFactory.HUE_GREEN
    public static BitmapDescriptor getMarkerWithColor(float color){
        return BitmapDescriptorFactory.defaultMarker(color);
    }

}
