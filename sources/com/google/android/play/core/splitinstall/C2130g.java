package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.g */
public final class C2130g {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f919a = new HashMap();

    /* renamed from: a */
    public final C2131h mo33763a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f919a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new C2131h(Collections.unmodifiableMap(hashMap));
    }

    /* renamed from: a */
    public final void mo33764a(String str, String str2, String str3) {
        if (!this.f919a.containsKey(str2)) {
            this.f919a.put(str2, new HashMap());
        }
        this.f919a.get(str2).put(str, str3);
    }
}
