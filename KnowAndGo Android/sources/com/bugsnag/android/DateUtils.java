package com.bugsnag.android;

import androidx.annotation.NonNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class DateUtils {
    private static final ThreadLocal<DateFormat> iso8601Holder = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        @NonNull
        public DateFormat initialValue() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat;
        }
    };

    DateUtils() {
    }

    static String toIso8601(@NonNull Date date) {
        return iso8601Holder.get().format(date);
    }

    static Date fromIso8601(@NonNull String str) throws ParseException {
        return iso8601Holder.get().parse(str);
    }
}
