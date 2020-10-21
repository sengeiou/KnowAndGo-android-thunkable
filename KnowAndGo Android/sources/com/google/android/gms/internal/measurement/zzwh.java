package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzwh {
    private static final zzwh zzcbl = new zzwh();
    private final zzwm zzcbm = new zzvk();
    private final ConcurrentMap<Class<?>, zzwl<?>> zzcbn = new ConcurrentHashMap();

    public static zzwh zzxt() {
        return zzcbl;
    }

    public final <T> zzwl<T> zzi(Class<T> cls) {
        zzuq.zza(cls, "messageType");
        zzwl<T> zzwl = (zzwl) this.zzcbn.get(cls);
        if (zzwl != null) {
            return zzwl;
        }
        zzwl<T> zzh = this.zzcbm.zzh(cls);
        zzuq.zza(cls, "messageType");
        zzuq.zza(zzh, "schema");
        zzwl<T> putIfAbsent = this.zzcbn.putIfAbsent(cls, zzh);
        return putIfAbsent != null ? putIfAbsent : zzh;
    }

    public final <T> zzwl<T> zzak(T t) {
        return zzi(t.getClass());
    }

    private zzwh() {
    }
}
