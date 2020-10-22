package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.C1982af;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlayCoreVersion {

    /* renamed from: a */
    private static final Set<String> f712a = new HashSet(Arrays.asList(new String[]{"review"}));

    /* renamed from: b */
    private static final Set<String> f713b = new HashSet(Arrays.asList(new String[]{"native", "unity"}));

    /* renamed from: c */
    private static final Map<String, Map<String, Integer>> f714c = new HashMap();

    /* renamed from: d */
    private static final C1982af f715d = new C1982af("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    /* renamed from: a */
    public static Bundle m566a() {
        Bundle bundle = new Bundle();
        Map<String, Integer> a = m567a("review");
        bundle.putInt("playcore_version_code", a.get("java").intValue());
        if (a.containsKey("native")) {
            bundle.putInt("playcore_native_version", a.get("native").intValue());
        }
        if (a.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", a.get("unity").intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    public static synchronized Map<String, Integer> m567a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            if (!f714c.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 10800);
                f714c.put(str, hashMap);
            }
            map = f714c.get(str);
        }
        return map;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        synchronized (PlayCoreVersion.class) {
            if (!f712a.contains(str)) {
                f715d.mo33554d("Illegal module name: %s", str);
            } else if (!f713b.contains(str2)) {
                f715d.mo33554d("Illegal platform name: %s", str2);
            } else {
                m567a(str).put(str2, Integer.valueOf(i));
            }
        }
    }
}
