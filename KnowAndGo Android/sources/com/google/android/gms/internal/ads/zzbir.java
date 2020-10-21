package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbir implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavb zzejs;
    private final /* synthetic */ zzbio zzemm;

    zzbir(zzbio zzbio, zzavb zzavb) {
        this.zzemm = zzbio;
        this.zzejs = zzavb;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzemm.zza(view, this.zzejs, 10);
    }
}
