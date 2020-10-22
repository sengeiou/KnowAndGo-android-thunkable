package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcjd implements Callable {
    private final zzcja zzfye;

    private zzcjd(zzcja zzcja) {
        this.zzfye = zzcja;
    }

    static Callable zza(zzcja zzcja) {
        return new zzcjd(zzcja);
    }

    public final Object call() {
        return this.zzfye.getWritableDatabase();
    }
}
