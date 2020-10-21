package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzaxd implements Runnable {
    private final Context zzcjt;
    private final String zzdsr;
    private final zzaxc zzdvm;

    zzaxd(zzaxc zzaxc, Context context, String str) {
        this.zzdvm = zzaxc;
        this.zzcjt = context;
        this.zzdsr = str;
    }

    public final void run() {
        this.zzdvm.zzo(this.zzcjt, this.zzdsr);
    }
}
