package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcwk implements Callable {
    private final zzbbh zzdzi;
    private final zzbbh zzdzo;

    zzcwk(zzbbh zzbbh, zzbbh zzbbh2) {
        this.zzdzo = zzbbh;
        this.zzdzi = zzbbh2;
    }

    public final Object call() {
        return new zzcwi((String) this.zzdzo.get(), (String) this.zzdzi.get());
    }
}
