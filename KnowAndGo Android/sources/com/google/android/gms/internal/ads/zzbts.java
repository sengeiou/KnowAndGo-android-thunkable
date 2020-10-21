package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class zzbts<ListenerT> {
    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzfkm = new HashMap();

    protected zzbts(Set<zzbuz<ListenerT>> set) {
        zzb(set);
    }

    public final synchronized void zza(zzbuz<ListenerT> zzbuz) {
        zza(zzbuz.zzflc, zzbuz.zzffi);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfkm.put(listenert, executor);
    }

    private final synchronized void zzb(Set<zzbuz<ListenerT>> set) {
        for (zzbuz<ListenerT> zza : set) {
            zza(zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbtu<ListenerT> zzbtu) {
        for (Map.Entry next : this.zzfkm.entrySet()) {
            ((Executor) next.getValue()).execute(new zzbtt(zzbtu, next.getKey()));
        }
    }
}
