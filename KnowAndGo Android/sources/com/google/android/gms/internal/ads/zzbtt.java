package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzbtt implements Runnable {
    private final Object zzdeb;
    private final zzbtu zzfkn;

    zzbtt(zzbtu zzbtu, Object obj) {
        this.zzfkn = zzbtu;
        this.zzdeb = obj;
    }

    public final void run() {
        try {
            this.zzfkn.zzr(this.zzdeb);
        } catch (Throwable th) {
            zzk.zzlk().zzb(th, "EventEmitter.notify");
            zzawz.zza("Event emitter exception.", th);
        }
    }
}
