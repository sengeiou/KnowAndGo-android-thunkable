package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

public final class zzjz {
    private final ExecutorService zzaqh;
    /* access modifiers changed from: private */
    public zzkb zzaqi;
    /* access modifiers changed from: private */
    public boolean zzaqj;

    public zzjz(String str) {
        this.zzaqh = zzkq.zzax(str);
    }

    public final void zza(zzkc zzkc, zzka zzka) {
        Looper myLooper = Looper.myLooper();
        zzkh.checkState(myLooper != null);
        zzkh.checkState(!this.zzaqj);
        this.zzaqj = true;
        this.zzaqi = new zzkb(this, myLooper, zzkc, zzka, 0);
        this.zzaqh.submit(this.zzaqi);
    }

    public final boolean isLoading() {
        return this.zzaqj;
    }

    public final void zzgb() {
        zzkh.checkState(this.zzaqj);
        this.zzaqi.quit();
    }

    public final void release() {
        if (this.zzaqj) {
            zzgb();
        }
        this.zzaqh.shutdown();
    }
}
