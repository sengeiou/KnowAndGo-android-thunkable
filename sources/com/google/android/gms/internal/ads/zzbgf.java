package com.google.android.gms.internal.ads;

@zzard
public final class zzbgf extends zzbft {
    public zzbgf(zzbdf zzbdf) {
        super(zzbdf);
    }

    public final void abort() {
    }

    public final boolean zzex(String str) {
        zzbdf zzbdf = (zzbdf) this.zzeht.get();
        if (zzbdf != null) {
            zzbdf.zza(zzey(str), (zzbft) this);
        }
        zzawz.zzep("VideoStreamNoopCache is doing nothing.");
        zza(str, zzey(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
