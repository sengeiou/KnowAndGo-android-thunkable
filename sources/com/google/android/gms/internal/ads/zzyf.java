package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@zzard
public final class zzyf extends zzzt {
    private final AppEventListener zzbqp;

    public zzyf(AppEventListener appEventListener) {
        this.zzbqp = appEventListener;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzbqp.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbqp;
    }
}
