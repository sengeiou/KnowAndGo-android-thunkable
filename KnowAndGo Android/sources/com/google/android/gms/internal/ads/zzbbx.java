package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

final class zzbbx implements zzban<T> {
    private final /* synthetic */ zzbbw zzeaq;

    zzbbx(zzbbw zzbbw) {
        this.zzeaq = zzbbw;
    }

    public final void zzk(@Nullable T t) {
        this.zzeaq.zzeap.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzeaq.zzeap.set(-1);
    }
}
