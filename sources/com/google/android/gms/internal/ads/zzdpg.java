package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzdpg implements zzdpf {
    zzdpg() {
    }

    public final Map<?, ?> zzae(Object obj) {
        return (zzdpe) obj;
    }

    public final zzdpd<?, ?> zzaj(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzaf(Object obj) {
        return (zzdpe) obj;
    }

    public final boolean zzag(Object obj) {
        return !((zzdpe) obj).isMutable();
    }

    public final Object zzah(Object obj) {
        ((zzdpe) obj).zzavj();
        return obj;
    }

    public final Object zzai(Object obj) {
        return zzdpe.zzayt().zzayu();
    }

    public final Object zzc(Object obj, Object obj2) {
        zzdpe zzdpe = (zzdpe) obj;
        zzdpe zzdpe2 = (zzdpe) obj2;
        if (!zzdpe2.isEmpty()) {
            if (!zzdpe.isMutable()) {
                zzdpe = zzdpe.zzayu();
            }
            zzdpe.zza(zzdpe2);
        }
        return zzdpe;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzdpe zzdpe = (zzdpe) obj;
        if (zzdpe.isEmpty()) {
            return 0;
        }
        Iterator it = zzdpe.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
