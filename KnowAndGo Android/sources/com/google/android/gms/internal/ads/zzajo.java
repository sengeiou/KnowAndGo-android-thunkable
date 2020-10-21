package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import javax.annotation.Nullable;

final class zzajo {
    private final zzajt zzdbl;

    private zzajo(zzajt zzajt) {
        this.zzdbl = zzajt;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.zzdbl.zzcs(str);
    }
}
