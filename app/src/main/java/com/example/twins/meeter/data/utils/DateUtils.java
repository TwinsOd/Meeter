package com.example.twins.meeter.data.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 10/18/2017.
 */

public class DateUtils {

    public static String formatDateEmail(long millis) {
        CharSequence s = android.text.format.DateFormat.format("MM/dd/yy", millis);
        return s.toString();
    }

    public static String formatDateForPreview(String dateText) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        Date date;
        try {
            date = parser.parse(dateText);
        } catch (ParseException e) {
            e.printStackTrace();
            return "error parse";
        }
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        return formatterDate.format(date);
    }

    public static String formatPreview(long date) {
        CharSequence s = android.text.format.DateFormat.format("dd MMMM yyyy", date);
        return s.toString();
    }
}
