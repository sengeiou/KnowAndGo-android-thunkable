package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcex implements zzczz {
    private zzwj zzftz;
    private Map<zzczs, zzcez> zzfuj;

    zzcex(zzwj zzwj, Map<zzczs, zzcez> map) {
        this.zzfuj = map;
        this.zzftz = zzwj;
    }

    public final void zza(zzczs zzczs, String str) {
    }

    public final void zzb(zzczs zzczs, String str) {
        if (this.zzfuj.containsKey(zzczs)) {
            this.zzftz.zza(this.zzfuj.get(zzczs).zzfuk);
        }
    }

    public final void zza(zzczs zzczs, String str, Throwable th) {
        if (this.zzfuj.containsKey(zzczs)) {
            this.zzftz.zza(this.zzfuj.get(zzczs).zzfum);
        }
    }

    public final void zzc(zzczs zzczs, String str) {
        if (this.zzfuj.containsKey(zzczs)) {
            this.zzftz.zza(this.zzfuj.get(zzczs).zzful);
        }
    }
}
