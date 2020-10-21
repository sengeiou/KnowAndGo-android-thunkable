package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrt extends zzbts<zzbrw> {
    private boolean zzfkb = false;

    public zzbrt(Set<zzbuz<zzbrw>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfkb) {
            zza(zzbru.zzfka);
            this.zzfkb = true;
        }
    }
}
