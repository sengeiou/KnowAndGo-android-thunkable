package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzbxh implements zzdti<zzbxg> {
    private final zzdtu<Context> zzeoj;
    private final zzdtu<Integer> zzfgq;
    private final zzdtu<View> zzfhe;
    private final zzdtu<zzavf> zzfip;
    private final zzdtu<zzavg> zzfly;

    private zzbxh(zzdtu<zzavf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzavg> zzdtu3, zzdtu<View> zzdtu4, zzdtu<Integer> zzdtu5) {
        this.zzfip = zzdtu;
        this.zzeoj = zzdtu2;
        this.zzfly = zzdtu3;
        this.zzfhe = zzdtu4;
        this.zzfgq = zzdtu5;
    }

    public static zzbxh zzd(zzdtu<zzavf> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzavg> zzdtu3, zzdtu<View> zzdtu4, zzdtu<Integer> zzdtu5) {
        return new zzbxh(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
    }

    public final /* synthetic */ Object get() {
        return new zzbxg(this.zzfip.get(), this.zzeoj.get(), this.zzfly.get(), this.zzfhe.get(), this.zzfgq.get().intValue());
    }
}
