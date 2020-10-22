package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzcss implements zzcuz<Bundle> {
    private final String zzdnd;
    private final Bundle zzghc;

    private zzcss(String str, Bundle bundle) {
        this.zzdnd = str;
        this.zzghc = bundle;
    }

    public final /* synthetic */ void zzt(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zzdnd);
        bundle.putBundle("iab_consent_info", this.zzghc);
    }
}
