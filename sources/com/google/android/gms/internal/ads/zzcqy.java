package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzcqy implements zzdti<zzbbh<zzcrc>> {
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<zzcqz> zzfwn;
    private final zzdtu<zzbbh<zzarx>> zzfwo;

    public zzcqy(zzdtu<zzczt> zzdtu, zzdtu<zzcqz> zzdtu2, zzdtu<zzbbh<zzarx>> zzdtu3) {
        this.zzfhv = zzdtu;
        this.zzfwn = zzdtu2;
        this.zzfwo = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.zzfhv.get().zza(zzczs.GENERATE_SIGNALS, this.zzfwo.get()).zza(this.zzfwn.get()).zza((long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcvn)).intValue(), TimeUnit.SECONDS).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
