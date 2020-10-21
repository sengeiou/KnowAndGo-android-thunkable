package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
@zzard
public class zzbbw<T> {
    private final zzbbr<T> zzeao = new zzbbr<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzeap = new AtomicInteger(0);

    public zzbbw() {
        zzbar.zza(this.zzeao, new zzbbx(this), zzbbm.zzeaf);
    }

    @Deprecated
    public final void zza(zzbbv<T> zzbbv, zzbbt zzbbt) {
        zzbar.zza(this.zzeao, new zzbby(this, zzbbv, zzbbt), zzbbm.zzeaf);
    }

    @Deprecated
    public final void zzo(T t) {
        this.zzeao.set(t);
    }

    @Deprecated
    public final void reject() {
        this.zzeao.setException(new Exception());
    }

    @Deprecated
    public final int getStatus() {
        return this.zzeap.get();
    }
}
