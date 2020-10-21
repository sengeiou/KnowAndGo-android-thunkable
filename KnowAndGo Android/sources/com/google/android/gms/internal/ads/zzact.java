package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class zzact implements Callable<T> {
    private final /* synthetic */ zzacj zzckr;
    private final /* synthetic */ zzacr zzcks;

    zzact(zzacr zzacr, zzacj zzacj) {
        this.zzcks = zzacr;
        this.zzckr = zzacj;
    }

    public final T call() {
        return this.zzckr.zza(this.zzcks.zzckn);
    }
}
