package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzaxk implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaxi zzdvz;

    zzaxk(zzaxi zzaxi, Context context) {
        this.zzdvz = zzaxi;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzdvz.zzdvw) {
            String unused = this.zzdvz.zzapq = zzaxi.zzam(this.val$context);
            this.zzdvz.zzdvw.notifyAll();
        }
    }
}
