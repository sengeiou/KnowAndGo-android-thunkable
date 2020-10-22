package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

final class zzapm implements zzo {
    private final /* synthetic */ zzapl zzdhp;

    zzapm(zzapl zzapl) {
        this.zzdhp = zzapl;
    }

    public final void zzsz() {
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdhp.zzdho.onAdClosed(this.zzdhp);
    }

    public final void onPause() {
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzta() {
        zzbad.zzdp("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdhp.zzdho.onAdOpened(this.zzdhp);
    }
}
