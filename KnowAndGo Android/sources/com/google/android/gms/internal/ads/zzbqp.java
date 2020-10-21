package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbqp implements zzdti<zzbuz<zzo>> {
    private final zzdtu<zzbpv> zzfhs;
    private final zzbqo zzfjo;

    private zzbqp(zzbqo zzbqo, zzdtu<zzbpv> zzdtu) {
        this.zzfjo = zzbqo;
        this.zzfhs = zzdtu;
    }

    public static zzbqp zza(zzbqo zzbqo, zzdtu<zzbpv> zzdtu) {
        return new zzbqp(zzbqo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.zza(new zzbuz(this.zzfhs.get(), zzbbm.zzeaf), "Cannot return null from a non-@Nullable @Provides method");
    }
}
