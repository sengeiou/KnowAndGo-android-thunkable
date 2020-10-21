package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcef implements zzdti<zzwj> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Integer> zzfgq;
    private final zzdtu<zzbai> zzfjy;
    private final zzdtu<String> zzftu;
    private final zzdtu<String> zzftv;

    private zzcef(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<Integer> zzdtu4, zzdtu<String> zzdtu5) {
        this.zzeoj = zzdtu;
        this.zzftu = zzdtu2;
        this.zzfjy = zzdtu3;
        this.zzfgq = zzdtu4;
        this.zzftv = zzdtu5;
    }

    public static zzcef zze(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<Integer> zzdtu4, zzdtu<String> zzdtu5) {
        return new zzcef(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        String str = this.zzftu.get();
        zzbai zzbai = this.zzfjy.get();
        int intValue = this.zzfgq.get().intValue();
        String str2 = this.zzftv.get();
        zzwj zzwj = new zzwj(new zzwo(this.zzeoj.get()));
        zzxo zzxo = new zzxo();
        zzxo.zzcfo = Integer.valueOf(zzbai.zzdzc);
        zzxo.zzcfp = Integer.valueOf(zzbai.zzdzd);
        zzxo.zzcfq = Integer.valueOf(zzbai.zzdze ? 0 : 2);
        zzwj.zza((zzwk) new zzcee(intValue, str, zzxo, str2));
        return (zzwj) zzdto.zza(zzwj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
