package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

public final class zzcjk implements zzczz {
    private final zzcji zzfyt;

    zzcjk(zzcji zzcji) {
        this.zzfyt = zzcji;
    }

    public final void zza(zzczs zzczs, String str) {
    }

    public final void zzb(zzczs zzczs, String str) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczs) {
            this.zzfyt.zzfh(zzk.zzln().elapsedRealtime());
        }
    }

    public final void zza(zzczs zzczs, String str, Throwable th) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczs && this.zzfyt.zzakm() != 0) {
            this.zzfyt.zzev(zzk.zzln().elapsedRealtime() - this.zzfyt.zzakm());
        }
    }

    public final void zzc(zzczs zzczs, String str) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && zzczs.RENDERER == zzczs && this.zzfyt.zzakm() != 0) {
            this.zzfyt.zzev(zzk.zzln().elapsedRealtime() - this.zzfyt.zzakm());
        }
    }
}
