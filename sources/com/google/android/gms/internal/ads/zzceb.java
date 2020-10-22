package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzceb implements zzdti<zzcdn> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<zzbtb> zzfht;
    private final zzdtu<zzdh> zzfni;
    private final zzdtu<zzwj> zzfrs;
    private final zzdtu<zzbhf> zzfsx;
    private final zzdtu<zza> zzftp;

    private zzceb(zzdtu<zzbhf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzdh> zzdtu4, zzdtu<zzbai> zzdtu5, zzdtu<zza> zzdtu6, zzdtu<zzwj> zzdtu7, zzdtu<zzbtb> zzdtu8) {
        this.zzfsx = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfhr = zzdtu3;
        this.zzfni = zzdtu4;
        this.zzfej = zzdtu5;
        this.zzftp = zzdtu6;
        this.zzfrs = zzdtu7;
        this.zzfht = zzdtu8;
    }

    public static zzceb zzb(zzdtu<zzbhf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<zzdh> zzdtu4, zzdtu<zzbai> zzdtu5, zzdtu<zza> zzdtu6, zzdtu<zzwj> zzdtu7, zzdtu<zzbtb> zzdtu8) {
        return new zzceb(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8);
    }

    public final /* synthetic */ Object get() {
        return new zzcdn(this.zzfsx.get(), this.zzeoj.get(), this.zzfhr.get(), this.zzfni.get(), this.zzfej.get(), this.zzftp.get(), this.zzfrs.get(), this.zzfht.get());
    }
}
