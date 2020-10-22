package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcqz implements zzbal<zzarx, zzcrc> {
    private Executor zzffi;
    private zzchz zzgfv;

    public zzcqz(Executor executor, zzchz zzchz) {
        this.zzffi = executor;
        this.zzgfv = zzchz;
    }

    public final /* synthetic */ zzbbh zzf(Object obj) throws Exception {
        zzarx zzarx = (zzarx) obj;
        return zzbar.zza(this.zzgfv.zzg(zzarx), new zzcra(zzarx), this.zzffi);
    }
}
