package com.google.android.gms.internal.ads;

public final class zzbof implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzeum;
    private final zzdtu<Boolean> zzfae;
    private final zzdtu<zzcmo> zzfag;

    public zzbof(zzdtu<Boolean> zzdtu, zzdtu<zzcmo> zzdtu2, zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzdtu3) {
        this.zzfae = zzdtu;
        this.zzfag = zzdtu2;
        this.zzeum = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfae.get().booleanValue();
        zzcjv zzcjv = (zzcmo) this.zzfag.get();
        zzcjv zzcjv2 = (zzcoe) this.zzeum.get();
        if (!booleanValue) {
            zzcjv = zzcjv2;
        }
        return (zzcjv) zzdto.zza(zzcjv, "Cannot return null from a non-@Nullable @Provides method");
    }
}
