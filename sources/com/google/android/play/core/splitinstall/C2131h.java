package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.h */
public final class C2131h {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f920a;

    /* synthetic */ C2131h(Map map) {
        this.f920a = map;
    }

    /* renamed from: a */
    public final Map<String, Set<String>> mo33765a(Collection<String> collection) {
        Set set;
        HashMap hashMap = new HashMap();
        for (String next : this.f920a.keySet()) {
            if (!this.f920a.containsKey(next)) {
                set = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.f920a.get(next).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add((String) entry.getValue());
                    }
                }
                set = Collections.unmodifiableSet(hashSet);
            }
            hashMap.put(next, set);
        }
        return hashMap;
    }
}
