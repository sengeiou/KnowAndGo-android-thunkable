package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

final /* synthetic */ class zzbzn implements Runnable {
    private final zzbzl zzfpt;
    private final ViewGroup zzfpv;

    zzbzn(zzbzl zzbzl, ViewGroup viewGroup) {
        this.zzfpt = zzbzl;
        this.zzfpv = viewGroup;
    }

    public final void run() {
        this.zzfpt.zzb(this.zzfpv);
    }
}
