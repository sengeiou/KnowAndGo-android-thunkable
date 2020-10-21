package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbxb implements zzdti<zzbxa> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<Integer> zzfgq;
    private final zzdtu<zzbgz> zzfhf;
    private final zzdtu<zzcxm> zzfhj;

    private zzbxb(zzdtu<Context> zzdtu, zzdtu<zzbgz> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<Integer> zzdtu5) {
        this.zzeoj = zzdtu;
        this.zzfhf = zzdtu2;
        this.zzfhj = zzdtu3;
        this.zzfej = zzdtu4;
        this.zzfgq = zzdtu5;
    }

    public static zzbxb zzc(zzdtu<Context> zzdtu, zzdtu<zzbgz> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<Integer> zzdtu5) {
        return new zzbxb(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzbxa(this.zzeoj.get(), this.zzfhf.get(), this.zzfhj.get(), this.zzfej.get(), this.zzfgq.get().intValue());
    }
}
