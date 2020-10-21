package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcwc implements zzcva<zzcwb> {
    private zzbbl zzfqw;
    zzvx zzgjb;
    Context zzlj;

    public zzcwc(zzvx zzvx, zzbbl zzbbl, Context context) {
        this.zzgjb = zzvx;
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcwb> zzalm() {
        return this.zzfqw.zza(new zzcwd(this));
    }
}
