package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzbqn implements zzdti<zzb> {
    private final zzdtu<Context> zzeoj;
    private final zzbqm zzfjm;
    private final zzdtu<zzavb> zzfjn;

    private zzbqn(zzbqm zzbqm, zzdtu<Context> zzdtu, zzdtu<zzavb> zzdtu2) {
        this.zzfjm = zzbqm;
        this.zzeoj = zzdtu;
        this.zzfjn = zzdtu2;
    }

    public static zzbqn zza(zzbqm zzbqm, zzdtu<Context> zzdtu, zzdtu<zzavb> zzdtu2) {
        return new zzbqn(zzbqm, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return (zzb) zzdto.zza(new zzb(this.zzeoj.get(), this.zzfjn.get(), (zzark) null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
