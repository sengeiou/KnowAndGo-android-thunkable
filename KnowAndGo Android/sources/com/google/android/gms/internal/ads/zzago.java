package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzard
public final class zzago extends zzafp {
    private final NativeCustomTemplateAd.OnCustomClickListener zzczg;

    public zzago(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzczg = onCustomClickListener;
    }

    public final void zza(zzafe zzafe, String str) {
        this.zzczg.onCustomClick(zzafh.zza(zzafe), str);
    }
}
