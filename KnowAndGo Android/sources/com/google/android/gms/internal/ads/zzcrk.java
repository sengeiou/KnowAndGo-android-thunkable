package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrk implements zzcva<Object> {
    private final Executor zzffi;
    private final zzbbh<String> zzggd;

    public zzcrk(zzbbh<String> zzbbh, Executor executor) {
        this.zzggd = zzbbh;
        this.zzffi = executor;
    }

    public final zzbbh<Object> zzalm() {
        return zzbar.zza(this.zzggd, zzcrl.zzbqz, this.zzffi);
    }
}
