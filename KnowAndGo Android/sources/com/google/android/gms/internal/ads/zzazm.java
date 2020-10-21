package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(17)
@zzard
public final class zzazm {
    private static zzazm zzdya;
    String zzdyb;

    public static zzazm zzws() {
        if (zzdya == null) {
            zzdya = new zzazm();
        }
        return zzdya;
    }

    private zzazm() {
    }
}
