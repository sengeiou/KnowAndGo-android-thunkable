package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzsd {
    private final Map<String, String> zzbmp = new HashMap();
    private Map<String, String> zzbmq;

    public final synchronized Map<String, String> zzjw() {
        if (this.zzbmq == null) {
            this.zzbmq = Collections.unmodifiableMap(new HashMap(this.zzbmp));
        }
        return this.zzbmq;
    }
}
