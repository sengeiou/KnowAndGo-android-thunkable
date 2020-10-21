package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzbme implements zzbrl, zzbrw, zzbsr, zzxr {
    private final zzcxu zzffa;
    private final zzdae zzffb;
    private final zzcxm zzffc;
    @GuardedBy("this")
    private boolean zzffd;
    @GuardedBy("this")
    private boolean zzffe;

    public zzbme(zzcxu zzcxu, zzcxm zzcxm, zzdae zzdae) {
        this.zzffa = zzcxu;
        this.zzffc = zzcxm;
        this.zzffb = zzdae;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
    }

    public final synchronized void onAdLoaded() {
        if (this.zzffd) {
            ArrayList arrayList = new ArrayList(this.zzffc.zzdff);
            arrayList.addAll(this.zzffc.zzgka);
            this.zzffb.zza(this.zzffa, this.zzffc, true, (List<String>) arrayList);
        } else {
            this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzgkc);
            this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzgka);
        }
        this.zzffd = true;
    }

    public final void onAdClicked() {
        this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzdfe);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzffe) {
            this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzdff);
            this.zzffe = true;
        }
    }

    public final void zzb(zzasr zzasr, String str, String str2) {
        this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzdnz, zzasr);
    }

    public final void onRewardedVideoStarted() {
        this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzdny);
    }

    public final void onRewardedVideoCompleted() {
        this.zzffb.zza(this.zzffa, this.zzffc, this.zzffc.zzgkb);
    }
}
