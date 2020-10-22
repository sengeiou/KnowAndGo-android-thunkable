package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.Map;

abstract class zzuc<T extends zzuh<T>> {
    zzuc() {
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(zzub zzub, zzvv zzvv, int i);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB zza(zzwk zzwk, Object obj, zzub zzub, zzuf<T> zzuf, UB ub, zzxd<UT, UB> zzxd) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzte zzte, Object obj, zzub zzub, zzuf<T> zzuf) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzwk zzwk, Object obj, zzub zzub, zzuf<T> zzuf) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzxy zzxy, Map.Entry<?, ?> entry) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int zzb(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract boolean zze(zzvv zzvv);

    /* access modifiers changed from: package-private */
    public abstract zzuf<T> zzw(Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzuf<T> zzx(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzy(Object obj);
}
