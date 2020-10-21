package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcwd implements Callable {
    private final zzcwc zzgjc;

    zzcwd(zzcwc zzcwc) {
        this.zzgjc = zzcwc;
    }

    public final Object call() {
        zzcwc zzcwc = this.zzgjc;
        return new zzcwb(zzcwc.zzgjb.zzf(zzcwc.zzlj));
    }
}
