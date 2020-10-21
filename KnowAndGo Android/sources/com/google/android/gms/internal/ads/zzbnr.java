package com.google.android.gms.internal.ads;

public final class zzbnr implements zzdti<zzbnf> {
    private final zzdtu<zzbnh> zzfbg;
    private final zzbnk zzfhp;

    public zzbnr(zzbnk zzbnk, zzdtu<zzbnh> zzdtu) {
        this.zzfhp = zzbnk;
        this.zzfbg = zzdtu;
    }

    public static zzbnf zza(zzbnk zzbnk, Object obj) {
        return (zzbnf) zzdto.zza((zzbnh) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfhp, this.zzfbg.get());
    }
}
