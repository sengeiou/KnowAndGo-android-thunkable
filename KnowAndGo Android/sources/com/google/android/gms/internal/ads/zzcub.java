package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import javax.annotation.Nullable;

public final class zzcub implements zzcuz<Bundle>, zzcva<zzcuz<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdlm;

    zzcub(ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdlm = packageInfo;
    }

    public final zzbbh<zzcuz<Bundle>> zzalm() {
        return zzbar.zzm(this);
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.applicationInfo.packageName;
        Integer valueOf = this.zzdlm == null ? null : Integer.valueOf(this.zzdlm.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
    }
}
