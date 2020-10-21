package com.google.android.gms.internal.ads;

import android.os.Bundle;

final /* synthetic */ class zzavj implements zzavw {
    private final String zzddy;
    private final Bundle zzdso;

    zzavj(String str, Bundle bundle) {
        this.zzddy = str;
        this.zzdso = bundle;
    }

    public final void zza(zzbjf zzbjf) {
        zzbjf.logEvent("am", this.zzddy, this.zzdso);
    }
}
