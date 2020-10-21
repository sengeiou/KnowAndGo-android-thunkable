package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcgu implements Callable {
    private final Context zzdef;

    zzcgu(Context context) {
        this.zzdef = context;
    }

    public final Object call() {
        CookieManager zzaz = zzk.zzli().zzaz(this.zzdef);
        if (zzaz != null) {
            return zzaz.getCookie("googleads.g.doubleclick.net");
        }
        return "";
    }
}
