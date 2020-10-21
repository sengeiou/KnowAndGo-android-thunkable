package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbhd implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavb zzejs;
    private final /* synthetic */ zzbha zzeju;

    zzbhd(zzbha zzbha, zzavb zzavb) {
        this.zzeju = zzbha;
        this.zzejs = zzavb;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzeju.zza(view, this.zzejs, 10);
    }
}
