package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

public final class zzctv implements zzcuz<Bundle> {
    private final String zzlq;

    /* access modifiers changed from: private */
    public static boolean zzd(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public zzctv(String str) {
        this.zzlq = str;
    }

    public final /* synthetic */ void zzt(Object obj) {
        zzcxz.zza((Bundle) obj, "omid_v", this.zzlq);
    }
}
