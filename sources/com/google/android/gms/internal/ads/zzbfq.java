package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzbfq extends zzawv {
    final zzbdf zzebt;
    private final String zzecf;
    private final String[] zzecg;
    final zzbft zzehq;

    zzbfq(zzbdf zzbdf, zzbft zzbft, String str, String[] strArr) {
        this.zzebt = zzbdf;
        this.zzehq = zzbft;
        this.zzecf = str;
        this.zzecg = strArr;
        zzk.zzmc().zza(this);
    }

    public final void zzto() {
        try {
            this.zzehq.zze(this.zzecf, this.zzecg);
        } finally {
            zzaxi.zzdvv.post(new zzbfr(this));
        }
    }
}
