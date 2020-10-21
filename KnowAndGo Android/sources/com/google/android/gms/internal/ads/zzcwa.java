package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcwa implements zzdti<zzcvy> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbbl> zzfgh;
    private final zzdtu<String> zzftu;
    private final zzdtu<zzasc> zzgit;

    public zzcwa(zzdtu<zzasc> zzdtu, zzdtu<Context> zzdtu2, zzdtu<String> zzdtu3, zzdtu<zzbbl> zzdtu4) {
        this.zzgit = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzftu = zzdtu3;
        this.zzfgh = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcvy(this.zzgit.get(), this.zzeoj.get(), this.zzftu.get(), this.zzfgh.get());
    }
}
