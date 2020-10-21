package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcud implements zzcuz<Bundle> {
    private final Bundle zzfjv;

    public zzcud(Bundle bundle) {
        this.zzfjv = bundle;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzfjv != null) {
            bundle.putAll(this.zzfjv);
        }
    }
}
