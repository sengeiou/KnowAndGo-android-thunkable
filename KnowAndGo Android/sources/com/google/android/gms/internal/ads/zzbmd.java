package com.google.android.gms.internal.ads;

public final class zzbmd implements zzbro {
    private final zzcxo zzfez;
    private final zzcxu zzffa;
    private final zzdae zzffb;

    public zzbmd(zzcxu zzcxu, zzdae zzdae) {
        this.zzffa = zzcxu;
        this.zzffb = zzdae;
        this.zzfez = zzcxu.zzgky.zzgku;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzffb.zza(this.zzffa, (zzcxm) null, this.zzfez.zzdfh);
    }
}
