package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Map;

final class zzdnq extends zzdnp<Object> {
    zzdnq() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm(zzdpk zzdpk) {
        return zzdpk instanceof zzdob.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzdns<Object> zzy(Object obj) {
        return ((zzdob.zzc) obj).zzhhj;
    }

    /* access modifiers changed from: package-private */
    public final zzdns<Object> zzz(Object obj) {
        zzdob.zzc zzc = (zzdob.zzc) obj;
        if (zzc.zzhhj.isImmutable()) {
            zzc.zzhhj = (zzdns) zzc.zzhhj.clone();
        }
        return zzc.zzhhj;
    }

    /* access modifiers changed from: package-private */
    public final void zzaa(Object obj) {
        zzy(obj).zzavj();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzdqa zzdqa, Object obj, zzdno zzdno, zzdns<Object> zzdns, UB ub, zzdqt<UT, UB> zzdqt) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdro zzdro, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzdno zzdno, zzdpk zzdpk, int i) {
        return zzdno.zza(zzdpk, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdqa zzdqa, Object obj, zzdno zzdno, zzdns<Object> zzdns) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdmr zzdmr, Object obj, zzdno zzdno, zzdns<Object> zzdns) throws IOException {
        throw new NoSuchMethodError();
    }
}
