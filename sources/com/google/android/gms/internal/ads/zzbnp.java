package com.google.android.gms.internal.ads;

public final class zzbnp implements zzdti<zzcxn> {
    private final zzbnk zzfhp;

    public zzbnp(zzbnk zzbnk) {
        this.zzfhp = zzbnk;
    }

    public static zzcxn zzb(zzbnk zzbnk) {
        return (zzcxn) zzdto.zza(zzbnk.zzafp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfhp);
    }
}
