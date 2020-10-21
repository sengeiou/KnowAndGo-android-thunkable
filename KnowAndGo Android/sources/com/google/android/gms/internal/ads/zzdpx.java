package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzdpx {
    private static final zzdpx zzhkj = new zzdpx();
    private final zzdqc zzhkk = new zzdoz();
    private final ConcurrentMap<Class<?>, zzdqb<?>> zzhkl = new ConcurrentHashMap();

    public static zzdpx zzazg() {
        return zzhkj;
    }

    public final <T> zzdqb<T> zzg(Class<T> cls) {
        zzdod.zza(cls, "messageType");
        zzdqb<T> zzdqb = (zzdqb) this.zzhkl.get(cls);
        if (zzdqb != null) {
            return zzdqb;
        }
        zzdqb<T> zzf = this.zzhkk.zzf(cls);
        zzdod.zza(cls, "messageType");
        zzdod.zza(zzf, "schema");
        zzdqb<T> putIfAbsent = this.zzhkl.putIfAbsent(cls, zzf);
        return putIfAbsent != null ? putIfAbsent : zzf;
    }

    public final <T> zzdqb<T> zzan(T t) {
        return zzg(t.getClass());
    }

    private zzdpx() {
    }
}
