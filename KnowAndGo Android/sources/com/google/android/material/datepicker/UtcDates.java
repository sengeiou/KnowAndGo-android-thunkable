package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C1641R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

class UtcDates {
    static final String UTC = "UTC";

    private UtcDates() {
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    static Calendar getTodayCalendar() {
        return getDayCopy(Calendar.getInstance());
    }

    static Calendar getUtcCalendar() {
        return getUtcCalendarOf((Calendar) null);
    }

    static Calendar getUtcCalendarOf(@Nullable Calendar calendar) {
        Calendar instance = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    static long canonicalYearMonthDay(long j) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    @TargetApi(24)
    private static DateFormat getAndroidFormat(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
        return instanceForSkeleton;
    }

    private static java.text.DateFormat getFormat(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    static SimpleDateFormat getTextInputFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String getTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(C1641R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(C1641R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(C1641R.string.mtrl_picker_text_input_year_abbr));
    }

    static SimpleDateFormat getSimpleFormat(String str) {
        return getSimpleFormat(str, Locale.getDefault());
    }

    private static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }

    @TargetApi(24)
    static DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    @TargetApi(24)
    static DateFormat getAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    @TargetApi(24)
    static DateFormat getAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("MMMEd", locale);
    }

    @TargetApi(24)
    static DateFormat getYearAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("yMMMEd", locale);
    }

    static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    static java.text.DateFormat getMediumFormat(Locale locale) {
        return getFormat(2, locale);
    }

    static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    static java.text.DateFormat getMediumNoYear(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    static java.text.DateFormat getFullFormat(Locale locale) {
        return getFormat(0, locale);
    }

    static SimpleDateFormat getYearMonthFormat() {
        return getYearMonthFormat(Locale.getDefault());
    }

    private static SimpleDateFormat getYearMonthFormat(Locale locale) {
        return getSimpleFormat("MMMM, yyyy", locale);
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, str2, 1, findCharactersInDateFormatPattern);
        if (findCharactersInDateFormatPattern2 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), StringUtils.SPACE).trim();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String str, @NonNull String str2, int i, int i2) {
        while (r5 >= 0 && r5 < str.length() && str2.indexOf(str.charAt(r5)) == -1) {
            if (str.charAt(r5) == '\'') {
                r5 += i;
                while (r5 >= 0 && r5 < str.length() && str.charAt(r5) != '\'') {
                    r5 += i;
                }
            }
            i2 = r5 + i;
        }
        return r5;
    }
}