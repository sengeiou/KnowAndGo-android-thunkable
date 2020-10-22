package com.google.android.gms.internal.ads;

public final class zzbqu implements zzdti<zzbuz<zzbtk>> {
    private final zzdtu<zzbqr> zzfgm;
    private final zzbqt zzfjr;

    private zzbqu(zzbqt zzbqt, zzdtu<zzbqr> zzdtu) {
        this.zzfjr = zzbqt;
        this.zzfgm = zzdtu;
    }

    public static zzbqu zza(zzbqt zzbqt, zzdtu<zzbqr> zzdtu) {
        return new zzbqu(zzbqt, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfgm.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
