package com.google.android.gms.internal.ads;

public final class zzbmu implements zzdti<zzaly> {
    private final zzdtu<zzalr> zzfgr;

    private zzbmu(zzdtu<zzalr> zzdtu) {
        this.zzfgr = zzdtu;
    }

    public static zzbmu zzh(zzdtu<zzalr> zzdtu) {
        return new zzbmu(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzaly) zzdto.zza(this.zzfgr.get().zzsc(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
