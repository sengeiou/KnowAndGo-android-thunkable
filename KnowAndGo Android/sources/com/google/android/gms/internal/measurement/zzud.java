package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.Map;

final class zzud extends zzuc<Object> {
    zzud() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzvv zzvv) {
        return zzvv instanceof zzuo.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzuf<Object> zzw(Object obj) {
        return ((zzuo.zzc) obj).zzbyl;
    }

    /* access modifiers changed from: package-private */
    public final zzuf<Object> zzx(Object obj) {
        zzuo.zzc zzc = (zzuo.zzc) obj;
        if (zzc.zzbyl.isImmutable()) {
            zzc.zzbyl = (zzuf) zzc.zzbyl.clone();
        }
        return zzc.zzbyl;
    }

    /* access modifiers changed from: package-private */
    public final void zzy(Object obj) {
        zzw(obj).zzsw();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzwk zzwk, Object obj, zzub zzub, zzuf<Object> zzuf, UB ub, zzxd<UT, UB> zzxd) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzxy zzxy, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzub zzub, zzvv zzvv, int i) {
        return zzub.zza(zzvv, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzwk zzwk, Object obj, zzub zzub, zzuf<Object> zzuf) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzte zzte, Object obj, zzub zzub, zzuf<Object> zzuf) throws IOException {
        throw new NoSuchMethodError();
    }
}
