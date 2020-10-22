package com.google.android.gms.internal.ads;

import android.os.Bundle;

final /* synthetic */ class zzcuo implements Runnable {
    private final zzcul zzght;
    private final zzcpk zzghu;
    private final Bundle zzghv;
    private final zzcpl zzghw;
    private final zzbbr zzghx;

    zzcuo(zzcul zzcul, zzcpk zzcpk, Bundle bundle, zzcpl zzcpl, zzbbr zzbbr) {
        this.zzght = zzcul;
        this.zzghu = zzcpk;
        this.zzghv = bundle;
        this.zzghw = zzcpl;
        this.zzghx = zzbbr;
    }

    public final void run() {
        this.zzght.zza(this.zzghu, this.zzghv, this.zzghw, this.zzghx);
    }
}
