package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbiq implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavb zzejs;
    private final /* synthetic */ int zzejt;
    private final /* synthetic */ zzbio zzemm;

    zzbiq(zzbio zzbio, View view, zzavb zzavb, int i) {
        this.zzemm = zzbio;
        this.val$view = view;
        this.zzejs = zzavb;
        this.zzejt = i;
    }

    public final void run() {
        this.zzemm.zza(this.val$view, this.zzejs, this.zzejt - 1);
    }
}
