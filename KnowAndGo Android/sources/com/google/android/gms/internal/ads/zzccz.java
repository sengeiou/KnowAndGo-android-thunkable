package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzccz implements zzahy {
    private final zzbse zzfjg;
    @Nullable
    private final zzato zzfsz;
    private final String zzfta;
    private final String zzftb;

    public zzccz(zzbse zzbse, zzcxm zzcxm) {
        this.zzfjg = zzbse;
        this.zzfsz = zzcxm.zzdnx;
        this.zzfta = zzcxm.zzdeu;
        this.zzftb = zzcxm.zzdev;
    }

    public final void zzrq() {
        this.zzfjg.onRewardedVideoStarted();
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzato zzato) {
        int i;
        String str = "";
        if (this.zzfsz != null) {
            zzato = this.zzfsz;
        }
        if (zzato != null) {
            str = zzato.type;
            i = zzato.zzdqm;
        } else {
            i = 1;
        }
        this.zzfjg.zzb(new zzasp(str, i), this.zzfta, this.zzftb);
    }

    public final void zzrr() {
        this.zzfjg.onRewardedVideoCompleted();
    }
}
