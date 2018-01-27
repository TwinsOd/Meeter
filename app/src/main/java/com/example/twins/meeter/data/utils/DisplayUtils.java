package com.example.twins.meeter.data.utils;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

/**
 * Created by user on 9/5/2017.
 */

public class DisplayUtils {

    static public Point getDisplaySize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}
