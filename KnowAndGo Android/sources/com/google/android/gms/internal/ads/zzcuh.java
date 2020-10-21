package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.Nullable;

public final class zzcuh implements zzcva<zzcuz<Bundle>> {
    private final String zzfju;
    private final Context zzlj;

    zzcuh(Context context, @Nullable String str) {
        this.zzlj = context;
        this.zzfju = str;
    }

    public final zzbbh<zzcuz<Bundle>> zzalm() {
        zzcui zzcui;
        if (this.zzfju == null) {
            zzcui = null;
        } else {
            zzcui = new zzcui(this);
        }
        return zzbar.zzm(zzcui);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzlj.getPackageName());
    }
}
