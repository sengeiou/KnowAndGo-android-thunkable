package com.google.android.gms.internal.ads;

public final class zzbnq implements zzdti<zzbpb> {
    private final zzbnk zzfhp;

    public zzbnq(zzbnk zzbnk) {
        this.zzfhp = zzbnk;
    }

    public static zzbpb zzc(zzbnk zzbnk) {
        return (zzbpb) zzdto.zza(zzbnk.zzafo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzfhp);
    }
}
