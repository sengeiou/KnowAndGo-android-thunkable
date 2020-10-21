package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcbc implements zzdti<zzcau> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<zzcan> zzeur;
    private final zzdtu<zzcbi> zzeut;
    private final zzdtu<zzbai> zzfej;
    private final zzdtu<Executor> zzfgh;
    private final zzdtu<zzcxv> zzfhr;
    private final zzdtu<ScheduledExecutorService> zzfjc;
    private final zzdtu<zzdh> zzfni;
    private final zzdtu<zza> zzfrr;
    private final zzdtu<zzwj> zzfrs;

    public zzcbc(zzdtu<Context> zzdtu, zzdtu<zzcan> zzdtu2, zzdtu<zzdh> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<zza> zzdtu5, zzdtu<zzwj> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<zzcxv> zzdtu8, zzdtu<zzcbi> zzdtu9, zzdtu<ScheduledExecutorService> zzdtu10) {
        this.zzeoj = zzdtu;
        this.zzeur = zzdtu2;
        this.zzfni = zzdtu3;
        this.zzfej = zzdtu4;
        this.zzfrr = zzdtu5;
        this.zzfrs = zzdtu6;
        this.zzfgh = zzdtu7;
        this.zzfhr = zzdtu8;
        this.zzeut = zzdtu9;
        this.zzfjc = zzdtu10;
    }

    public final /* synthetic */ Object get() {
        return new zzcau(this.zzeoj.get(), this.zzeur.get(), this.zzfni.get(), this.zzfej.get(), this.zzfrr.get(), this.zzfrs.get(), this.zzfgh.get(), this.zzfhr.get(), this.zzeut.get(), this.zzfjc.get());
    }
}
