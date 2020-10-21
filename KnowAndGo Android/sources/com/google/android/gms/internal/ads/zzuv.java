package com.google.android.gms.internal.ads;

import android.view.View;

final class zzuv implements Runnable {
    private final /* synthetic */ View zzbvl;
    private final /* synthetic */ zzuu zzbvm;

    zzuv(zzuu zzuu, View view) {
        this.zzbvm = zzuu;
        this.zzbvl = view;
    }

    public final void run() {
        this.zzbvm.zzi(this.zzbvl);
    }
}
