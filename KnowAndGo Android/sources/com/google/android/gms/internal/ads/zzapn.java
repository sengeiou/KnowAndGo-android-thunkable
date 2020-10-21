package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzk;

final class zzapn implements Runnable {
    private final /* synthetic */ zzapl zzdhp;
    private final /* synthetic */ AdOverlayInfoParcel zzdhq;

    zzapn(zzapl zzapl, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdhp = zzapl;
        this.zzdhq = adOverlayInfoParcel;
    }

    public final void run() {
        zzk.zzlf();
        zzm.zza(this.zzdhp.zzdhn, this.zzdhq, true);
    }
}
