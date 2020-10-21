package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpw implements zzbrl, zzbro, zzbrw, zzbsr, zzxr {
    @GuardedBy("this")
    private zzyz zzgeo;

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzasr zzasr, String str, String str2) {
    }

    public final synchronized void zzc(zzyz zzyz) {
        this.zzgeo = zzyz;
    }

    public final synchronized zzyz zzald() {
        return this.zzgeo;
    }

    public final synchronized void onAdClosed() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdClosed();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdLeftApplication();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdLoaded();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdOpened();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final synchronized void onAdClicked() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdClicked();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void onAdImpression() {
        if (this.zzgeo != null) {
            try {
                this.zzgeo.onAdImpression();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }
}
