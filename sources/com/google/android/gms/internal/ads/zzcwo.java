package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcwo implements Callable {
    private final zzcwn zzgjj;

    zzcwo(zzcwn zzcwn) {
        this.zzgjj = zzcwn;
    }

    public final Object call() {
        zzcwn zzcwn = this.zzgjj;
        return new zzcwm(zzcwn.zzgji.zzb(zzcwn.zzdly));
    }
}
