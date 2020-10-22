package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzse {
    /* access modifiers changed from: private */
    public final ExecutorService zzaqh;
    /* access modifiers changed from: private */
    public zzsg<? extends zzsh> zzbmr;
    /* access modifiers changed from: private */
    public IOException zzbms;

    public zzse(String str) {
        this.zzaqh = zzsy.zzax(str);
    }

    public final <T extends zzsh> long zza(T t, zzsf<T> zzsf, int i) {
        Looper myLooper = Looper.myLooper();
        zzsk.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzsg(this, myLooper, t, zzsf, i, elapsedRealtime).zzeq(0);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.zzbmr != null;
    }

    public final void zzgb() {
        this.zzbmr.zzl(false);
    }

    public final void zza(Runnable runnable) {
        if (this.zzbmr != null) {
            this.zzbmr.zzl(true);
        }
        this.zzaqh.execute(runnable);
        this.zzaqh.shutdown();
    }

    public final void zzbm(int i) throws IOException {
        if (this.zzbms != null) {
            throw this.zzbms;
        } else if (this.zzbmr != null) {
            this.zzbmr.zzbm(this.zzbmr.zzbmv);
        }
    }
}
