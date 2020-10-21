package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzard
final class zzbgn {
    private final ArrayList<zzsa> zzeir = new ArrayList<>();
    private long zzeis;

    zzbgn() {
    }

    /* access modifiers changed from: package-private */
    public final long zzzz() {
        Iterator<zzsa> it = this.zzeir.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry next : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzeis = Math.max(this.zzeis, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzeis;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzsa zzsa) {
        this.zzeir.add(zzsa);
    }
}
