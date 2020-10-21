package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbse extends zzbts<zzbrl> {
    public zzbse(Set<zzbuz<zzbrl>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbsf.zzfka);
    }

    public final void onAdLeftApplication() {
        zza(zzbsg.zzfka);
    }

    public final void onAdOpened() {
        zza(zzbsh.zzfka);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbsi.zzfka);
    }

    public final void zzb(zzasr zzasr, String str, String str2) {
        zza(new zzbsj(zzasr, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbsk.zzfka);
    }
}
