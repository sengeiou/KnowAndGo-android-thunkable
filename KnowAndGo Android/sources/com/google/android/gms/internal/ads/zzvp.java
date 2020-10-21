package com.google.android.gms.internal.ads;

final class zzvp implements zzut {
    private final /* synthetic */ zzvn zzbwq;

    zzvp(zzvn zzvn) {
        this.zzbwq = zzvn;
    }

    public final void zzp(boolean z) {
        if (z) {
            this.zzbwq.connect();
        } else {
            this.zzbwq.disconnect();
        }
    }
}
