package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

public final class zzcrv implements zzcva<zzcuz<Bundle>> {
    private final zzawm zzbrw;
    private final Executor zzffi;

    zzcrv(Executor executor, zzawm zzawm) {
        this.zzffi = executor;
        this.zzbrw = zzawm;
    }

    public final zzbbh<zzcuz<Bundle>> zzalm() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcri)).booleanValue()) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.zzbrw.zzvd(), zzcrw.zzdrn, this.zzffi);
    }
}
