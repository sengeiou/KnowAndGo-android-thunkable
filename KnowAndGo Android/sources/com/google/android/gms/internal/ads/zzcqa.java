package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqa implements zzbrl, zzbrs {
    @GuardedBy("this")
    private zzatw zzges;
    @GuardedBy("this")
    private zzaue zzget;

    public final synchronized void zzb(zzatw zzatw) {
        this.zzges = zzatw;
    }

    public final synchronized void zzb(zzaue zzaue) {
        this.zzget = zzaue;
    }

    public final synchronized void onAdOpened() {
        if (this.zzges != null) {
            try {
                this.zzges.onRewardedAdOpened();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdClosed() {
        if (this.zzges != null) {
            try {
                this.zzges.onRewardedAdClosed();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void zzb(zzasr zzasr, String str, String str2) {
        if (this.zzges != null) {
            try {
                this.zzges.zza(new zzaup(zzasr.getType(), zzasr.getAmount()));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
        if (this.zzget != null) {
            try {
                this.zzget.zza(new zzaup(zzasr.getType(), zzasr.getAmount()), str, str2);
            } catch (RemoteException e2) {
                zzbad.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final synchronized void zzcs(int i) {
        if (this.zzges != null) {
            try {
                this.zzges.onRewardedAdFailedToShow(i);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
    }

    public final synchronized void onRewardedVideoStarted() {
    }

    public final synchronized void onRewardedVideoCompleted() {
    }
}
