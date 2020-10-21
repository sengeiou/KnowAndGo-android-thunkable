package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcrz implements zzcva<Object> {
    private final String zzcig;
    private final String zzdlo;
    private final zzcxv zzfjp;
    private final zzbqe zzggn;
    private final zzcyi zzggo;

    public zzcrz(String str, String str2, zzbqe zzbqe, zzcyi zzcyi, zzcxv zzcxv) {
        this.zzdlo = str;
        this.zzcig = str2;
        this.zzggn = zzbqe;
        this.zzggo = zzcyi;
        this.zzfjp = zzcxv;
    }

    public final zzbbh<Object> zzalm() {
        return zzbar.zzm(new zzcsa(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Bundle bundle) {
        this.zzggn.zzf(this.zzfjp.zzghg);
        bundle.putBundle("quality_signals", this.zzggo.zzams());
        bundle.putString("seq_num", this.zzdlo);
        bundle.putString("session_id", this.zzcig);
    }
}
