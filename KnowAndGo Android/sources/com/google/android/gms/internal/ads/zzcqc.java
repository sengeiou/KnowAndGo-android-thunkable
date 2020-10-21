package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqc implements zzbrl, zzbro, zzbsr {
    @GuardedBy("this")
    private zzatb zzgev;
    @GuardedBy("this")
    private zzasu zzgew;

    public final synchronized void zzb(zzatb zzatb) {
        this.zzgev = zzatb;
    }

    public final synchronized void zzb(zzasu zzasu) {
        this.zzgew = zzasu;
    }

    public final synchronized void onAdClosed() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoAdClosed();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoAdLoaded();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoAdOpened();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final synchronized void onRewardedVideoStarted() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onRewardedVideoStarted.", e);
            }
        }
    }

    public final synchronized void zzb(zzasr zzasr, String str, String str2) {
        if (this.zzgev != null) {
            try {
                this.zzgev.zza(zzasr);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onRewarded.", e);
            }
        }
        if (this.zzgew != null) {
            try {
                this.zzgew.zza(zzasr, str, str2);
            } catch (RemoteException e2) {
                zzbad.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    public final synchronized void onRewardedVideoCompleted() {
        if (this.zzgev != null) {
            try {
                this.zzgev.onRewardedVideoCompleted();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
