package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

public final class zzcgz implements zzdti<zzbbh<zzcxu>> {
    private final zzdtu<zzchq> zzesb;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<zzchl> zzfwn;
    private final zzdtu<zzbbh<zzarx>> zzfwo;

    private zzcgz(zzdtu<zzczt> zzdtu, zzdtu<zzchl> zzdtu2, zzdtu<zzchq> zzdtu3, zzdtu<zzbbh<zzarx>> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        this.zzfhv = zzdtu;
        this.zzfwn = zzdtu2;
        this.zzesb = zzdtu3;
        this.zzfwo = zzdtu4;
        this.zzfhr = zzdtu5;
    }

    public static zzcgz zzf(zzdtu<zzczt> zzdtu, zzdtu<zzchl> zzdtu2, zzdtu<zzchq> zzdtu3, zzdtu<zzbbh<zzarx>> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        return new zzcgz(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        zzcze<E, O2> zzcze;
        zzczt zzczt = this.zzfhv.get();
        zzchl zzchl = this.zzfwn.get();
        zzchq zzchq = this.zzesb.get();
        zzbbh zzbbh = this.zzfwo.get();
        zzk.zzlm().zzng();
        if (this.zzfhr.get().zzghg.zzchb != null) {
            zzcze = zzczt.zza(zzczs.SERVER_TRANSACTION, zzbbh).zzb(zzchq.zzakg()).zzane();
        } else {
            zzcze = zzczt.zza(zzczs.SERVER_TRANSACTION, zzbbh).zza(zzchl).zzane();
        }
        return (zzbbh) zzdto.zza(zzcze, "Cannot return null from a non-@Nullable @Provides method");
    }
}
