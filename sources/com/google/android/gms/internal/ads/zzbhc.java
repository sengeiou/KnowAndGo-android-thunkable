package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbhc implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavb zzejs;
    private final /* synthetic */ int zzejt;
    private final /* synthetic */ zzbha zzeju;

    zzbhc(zzbha zzbha, View view, zzavb zzavb, int i) {
        this.zzeju = zzbha;
        this.val$view = view;
        this.zzejs = zzavb;
        this.zzejt = i;
    }

    public final void run() {
        this.zzeju.zza(this.val$view, this.zzejs, this.zzejt - 1);
    }
}
