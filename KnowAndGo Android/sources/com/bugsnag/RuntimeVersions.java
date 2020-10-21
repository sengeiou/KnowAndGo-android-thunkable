package com.bugsnag;

import com.facebook.react.modules.systeminfo.ReactNativeVersion;
import java.util.HashMap;
import java.util.Map;

public class RuntimeVersions {
    public static void addRuntimeVersions(Map<String, Object> map) {
        Map map2 = (Map) map.get("runtimeVersions");
        if (map2 == null) {
            map2 = new HashMap();
            map.put("runtimeVersions", map2);
        }
        map2.put("reactNative", findReactNativeVersion());
    }

    private static String findReactNativeVersion() {
        StringBuilder sb = new StringBuilder();
        String stringSafe = getStringSafe("major", ReactNativeVersion.VERSION);
        if (stringSafe != null) {
            sb.append(stringSafe);
            sb.append(".");
        }
        String stringSafe2 = getStringSafe("minor", ReactNativeVersion.VERSION);
        if (stringSafe2 != null) {
            sb.append(stringSafe2);
            sb.append(".");
        }
        String stringSafe3 = getStringSafe("patch", ReactNativeVersion.VERSION);
        if (stringSafe3 != null) {
            sb.append(stringSafe3);
        }
        String stringSafe4 = getStringSafe("prerelease", ReactNativeVersion.VERSION);
        if (stringSafe4 != null) {
            sb.append("-");
            sb.append(stringSafe4);
        }
        return sb.toString();
    }

    private static String getStringSafe(String str, Map<String, Object> map) {
        Object obj = map.get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}
