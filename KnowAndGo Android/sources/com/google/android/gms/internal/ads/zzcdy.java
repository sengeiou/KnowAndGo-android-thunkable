package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcdy implements zzbij {
    private final zzbbr zzbxh;

    zzcdy(zzbbr zzbbr) {
        this.zzbxh = zzbbr;
    }

    public final void zzae(boolean z) {
        zzbbr zzbbr = this.zzbxh;
        if (z) {
            zzbbr.set(null);
        } else {
            zzbbr.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
