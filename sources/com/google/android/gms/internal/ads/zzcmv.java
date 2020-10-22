package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzcmv implements zzban<T> {
    private final /* synthetic */ String zzgbh;
    private final /* synthetic */ long zzgbi;
    private final /* synthetic */ zzcmu zzgbj;

    zzcmv(zzcmu zzcmu, String str, long j) {
        this.zzgbj = zzcmu;
        this.zzgbh = str;
        this.zzgbi = j;
    }

    public final void zzk(T t) {
        this.zzgbj.zza(this.zzgbh, 0, this.zzgbj.zzbsa.elapsedRealtime() - this.zzgbi);
    }

    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzgbj.zzbsa.elapsedRealtime();
        int i = 3;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (!(th instanceof zzcmk)) {
            i = th instanceof CancellationException ? 4 : (!(th instanceof zzcgm) || ((zzcgm) th).getErrorCode() != 3) ? 6 : 1;
        }
        this.zzgbj.zza(this.zzgbh, i, elapsedRealtime - this.zzgbi);
    }
}
