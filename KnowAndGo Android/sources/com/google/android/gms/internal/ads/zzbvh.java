package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzbvh implements zzbvg {
    private final List<String> zzdnl;
    private final zzdae zzffb;
    private boolean zzflf;

    public zzbvh(zzcxm zzcxm, zzdae zzdae) {
        this.zzdnl = zzcxm.zzdnl;
        this.zzffb = zzdae;
    }

    public final void zzagx() {
        if (!this.zzflf) {
            this.zzffb.zzh(this.zzdnl);
            this.zzflf = true;
        }
    }
}
