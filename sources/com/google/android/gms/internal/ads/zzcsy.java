package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcsy implements zzcuz<Bundle> {
    private final int zzghf;
    private final zzxz zzghg;

    public zzcsy(int i, zzxz zzxz) {
        this.zzghf = i;
        this.zzghg = zzxz;
    }

    public final /* synthetic */ void zzt(Object obj) {
        zzcxz.zza((Bundle) obj, "correlation_id", Integer.valueOf(this.zzghf), this.zzghg.versionCode >= 6);
    }
}
