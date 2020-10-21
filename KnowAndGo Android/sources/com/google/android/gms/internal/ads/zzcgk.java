package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

final class zzcgk extends zzair {
    private final /* synthetic */ Object zzfvm;
    private final /* synthetic */ String zzfvn;
    private final /* synthetic */ long zzfvo;
    private final /* synthetic */ zzbbr zzfvp;
    private final /* synthetic */ zzcgb zzfvq;

    zzcgk(zzcgb zzcgb, Object obj, String str, long j, zzbbr zzbbr) {
        this.zzfvq = zzcgb;
        this.zzfvm = obj;
        this.zzfvn = str;
        this.zzfvo = j;
        this.zzfvp = zzbbr;
    }

    public final void onInitializationSucceeded() {
        synchronized (this.zzfvm) {
            this.zzfvq.zza(this.zzfvn, true, "", (int) (zzk.zzln().elapsedRealtime() - this.zzfvo));
            this.zzfvp.set(true);
        }
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.zzfvm) {
            this.zzfvq.zza(this.zzfvn, false, str, (int) (zzk.zzln().elapsedRealtime() - this.zzfvo));
            this.zzfvp.set(false);
        }
    }
}
