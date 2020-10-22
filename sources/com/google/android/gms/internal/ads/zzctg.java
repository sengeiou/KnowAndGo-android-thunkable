package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzctg implements zzcuz<Bundle> {
    private final Bundle zzdmm;

    public zzctg(Bundle bundle) {
        this.zzdmm = bundle;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzcxz.zza(bundle, "device");
        zza.putBundle("android_mem_info", this.zzdmm);
        bundle.putBundle("device", zza);
    }
}
