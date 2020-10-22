package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.amplitude.api.Constants;

public final class zzcvj implements zzcuz<Bundle> {
    private final String zzdph;
    private final int zzdps;
    private final int zzdpt;
    private final int zzdpu;
    private final boolean zzdpz;
    private final int zzdqa;

    public zzcvj(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdph = str;
        this.zzdps = i;
        this.zzdpt = i2;
        this.zzdpu = i3;
        this.zzdpz = z;
        this.zzdqa = i4;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        boolean z = true;
        zzcxz.zza(bundle, Constants.AMP_TRACKING_OPTION_CARRIER, this.zzdph, !TextUtils.isEmpty(this.zzdph));
        Integer valueOf = Integer.valueOf(this.zzdps);
        if (this.zzdps == -2) {
            z = false;
        }
        zzcxz.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.zzdpt);
        bundle.putInt("pt", this.zzdpu);
        Bundle zza = zzcxz.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzcxz.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdqa);
        zza2.putBoolean("active_network_metered", this.zzdpz);
    }
}
