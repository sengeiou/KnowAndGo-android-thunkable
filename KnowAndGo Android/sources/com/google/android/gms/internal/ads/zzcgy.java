package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

public final class zzcgy implements zzdti<zzbbh<zzarx>> {
    private final zzdtu<zzaxb> zzerj;
    private final zzdtu<zzbai> zzfgp;
    private final zzdtu<zzczt> zzfhv;
    private final zzdtu<String> zzftu;
    private final zzdtu<zzbbh<Bundle>> zzfwh;
    private final zzdtu<ApplicationInfo> zzfwi;
    private final zzdtu<List<String>> zzfwj;
    private final zzdtu<PackageInfo> zzfwk;
    private final zzdtu<zzbbh<String>> zzfwl;
    private final zzdtu<String> zzfwm;

    private zzcgy(zzdtu<zzczt> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<ApplicationInfo> zzdtu4, zzdtu<String> zzdtu5, zzdtu<List<String>> zzdtu6, zzdtu<PackageInfo> zzdtu7, zzdtu<zzbbh<String>> zzdtu8, zzdtu<zzaxb> zzdtu9, zzdtu<String> zzdtu10) {
        this.zzfhv = zzdtu;
        this.zzfwh = zzdtu2;
        this.zzfgp = zzdtu3;
        this.zzfwi = zzdtu4;
        this.zzftu = zzdtu5;
        this.zzfwj = zzdtu6;
        this.zzfwk = zzdtu7;
        this.zzfwl = zzdtu8;
        this.zzerj = zzdtu9;
        this.zzfwm = zzdtu10;
    }

    public static zzcgy zza(zzdtu<zzczt> zzdtu, zzdtu<zzbbh<Bundle>> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<ApplicationInfo> zzdtu4, zzdtu<String> zzdtu5, zzdtu<List<String>> zzdtu6, zzdtu<PackageInfo> zzdtu7, zzdtu<zzbbh<String>> zzdtu8, zzdtu<zzaxb> zzdtu9, zzdtu<String> zzdtu10) {
        return new zzcgy(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8, zzdtu9, zzdtu10);
    }

    public final /* synthetic */ Object get() {
        zzbbh zzbbh = this.zzfwh.get();
        zzbbh zzbbh2 = this.zzfwl.get();
        return (zzbbh) zzdto.zza(this.zzfhv.get().zza(zzczs.REQUEST_PARCEL, (zzbbh<?>[]) new zzbbh[]{zzbbh, zzbbh2}).zzc(new zzcgx(zzbbh, this.zzfgp.get(), this.zzfwi.get(), this.zzftu.get(), this.zzfwj.get(), this.zzfwk.get(), zzbbh2, this.zzerj.get(), this.zzfwm.get())).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
