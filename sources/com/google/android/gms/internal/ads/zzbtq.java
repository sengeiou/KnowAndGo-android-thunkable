package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

final /* synthetic */ class zzbtq implements zzbtu {
    private final String zzdbk;
    private final String zzddy;

    zzbtq(String str, String str2) {
        this.zzddy = str;
        this.zzdbk = str2;
    }

    public final void zzr(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzddy, this.zzdbk);
    }
}
