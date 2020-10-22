package com.imagepicker.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReadableMap;

public class ReadableMapUtils {
    @NonNull
    public static boolean hasAndNotEmpty(@NonNull Class cls, @NonNull ReadableMap readableMap, @NonNull String str) {
        if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
            return false;
        }
        if (String.class.equals(cls)) {
            return !TextUtils.isEmpty(readableMap.getString(str));
        }
        return true;
    }

    @NonNull
    public static boolean hasAndNotNullReadableMap(@NonNull ReadableMap readableMap, @NonNull String str) {
        return hasAndNotEmpty(ReadableMap.class, readableMap, str);
    }

    @NonNull
    public static boolean hasAndNotEmptyString(@NonNull ReadableMap readableMap, @NonNull String str) {
        return hasAndNotEmpty(String.class, readableMap, str);
    }
}
