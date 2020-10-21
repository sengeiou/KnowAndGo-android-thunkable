package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class zzux implements ValueCallback<String> {
    private final /* synthetic */ zzuw zzbvr;

    zzux(zzuw zzuw) {
        this.zzbvr = zzuw;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.zzbvr.zzbvm.zza(this.zzbvr.zzbvo, this.zzbvr.zzbvp, (String) obj, this.zzbvr.zzbvq);
    }
}
