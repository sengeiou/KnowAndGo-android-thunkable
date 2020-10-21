package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcgx implements Callable {
    private final zzbbh zzdzo;
    private final zzbai zzfhl;
    private final String zzftt;
    private final ApplicationInfo zzfwb;
    private final List zzfwc;
    private final PackageInfo zzfwd;
    private final zzbbh zzfwe;
    private final zzaxb zzfwf;
    private final String zzfwg;

    zzcgx(zzbbh zzbbh, zzbai zzbai, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzbbh zzbbh2, zzaxb zzaxb, String str2) {
        this.zzdzo = zzbbh;
        this.zzfhl = zzbai;
        this.zzfwb = applicationInfo;
        this.zzftt = str;
        this.zzfwc = list;
        this.zzfwd = packageInfo;
        this.zzfwe = zzbbh2;
        this.zzfwf = zzaxb;
        this.zzfwg = str2;
    }

    public final Object call() {
        zzbbh zzbbh = this.zzdzo;
        zzbai zzbai = this.zzfhl;
        ApplicationInfo applicationInfo = this.zzfwb;
        String str = this.zzftt;
        List list = this.zzfwc;
        PackageInfo packageInfo = this.zzfwd;
        zzbbh zzbbh2 = this.zzfwe;
        zzaxb zzaxb = this.zzfwf;
        String str2 = this.zzfwg;
        boolean zzvp = zzaxb.zzvp();
        return new zzarx((Bundle) zzbbh.get(), zzbai, applicationInfo, str, list, packageInfo, (String) zzbbh2.get(), zzvp, str2);
    }
}
