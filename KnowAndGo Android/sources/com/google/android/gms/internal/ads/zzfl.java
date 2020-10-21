package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfl<T> {
    private final Map<String, AtomicReference<T>> zzaac = new HashMap();

    public final AtomicReference<T> zzar(String str) {
        synchronized (this) {
            if (!this.zzaac.containsKey(str)) {
                this.zzaac.put(str, new AtomicReference());
            }
        }
        return this.zzaac.get(str);
    }
}
