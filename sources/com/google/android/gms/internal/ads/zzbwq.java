package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbwq implements zzo {
    private final zzbsv zzflp;
    private final zzbuv zzflq;

    public zzbwq(zzbsv zzbsv, zzbuv zzbuv) {
        this.zzflp = zzbsv;
        this.zzflq = zzbuv;
    }

    public final void zzsz() {
        this.zzflp.zzsz();
        this.zzflq.onHide();
    }

    public final void onPause() {
        this.zzflp.onPause();
    }

    public final void onResume() {
        this.zzflp.onResume();
    }

    public final void zzta() {
        this.zzflp.zzta();
        this.zzflq.zzagw();
    }
}
