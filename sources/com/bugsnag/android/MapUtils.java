package com.bugsnag.android;

import androidx.annotation.Nullable;
import java.util.Map;

final class MapUtils {
    MapUtils() {
    }

    @Nullable
    static String getStringFromMap(String str, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
