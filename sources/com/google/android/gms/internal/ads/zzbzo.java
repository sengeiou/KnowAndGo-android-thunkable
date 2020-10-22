package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

final class zzbzo implements zzadx {
    private final /* synthetic */ zzcab zzfpw;
    private final /* synthetic */ ViewGroup zzfpx;
    private final /* synthetic */ zzbzl zzfpy;

    zzbzo(zzbzl zzbzl, zzcab zzcab, ViewGroup viewGroup) {
        this.zzfpy = zzbzl;
        this.zzfpw = zzcab;
        this.zzfpx = viewGroup;
    }

    public final void zzrg() {
        if (zzbzl.zza(this.zzfpw, zzbzj.zzfpm)) {
            this.zzfpw.onClick(this.zzfpx);
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzfpw.onTouch((View) null, motionEvent);
    }
}
