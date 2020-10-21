package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcla extends zzamw implements zzbsm {
    @GuardedBy("this")
    private zzamv zzdhl;
    @GuardedBy("this")
    private zzbsn zzgai;

    public final synchronized void zza(zzamv zzamv) {
        this.zzdhl = zzamv;
    }

    public final synchronized void zza(zzbsn zzbsn) {
        this.zzgai = zzbsn;
    }

    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdFailedToLoad(i);
        }
        if (this.zzgai != null) {
            this.zzgai.onAdFailedToLoad(i);
        }
    }

    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdLeftApplication();
        }
    }

    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdOpened();
        }
    }

    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdLoaded();
        }
        if (this.zzgai != null) {
            this.zzgai.onAdLoaded();
        }
    }

    public final synchronized void zza(zzamy zzamy) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zza(zzamy);
        }
    }

    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAdImpression();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onAppEvent(str, str2);
        }
    }

    public final synchronized void zza(zzafe zzafe, String str) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zza(zzafe, str);
        }
    }

    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onVideoEnd();
        }
    }

    public final synchronized void zzcz(String str) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzcz(str);
        }
    }

    public final synchronized void zzsm() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzsm();
        }
    }

    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onVideoPlay();
        }
    }

    public final synchronized void zzb(zzato zzato) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzb(zzato);
        }
    }

    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.onVideoPause();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzb(bundle);
        }
    }

    public final synchronized void zzsn() throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzsn();
        }
    }

    public final synchronized void zzcs(int i) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zzcs(i);
        }
    }

    public final synchronized void zza(zzatq zzatq) throws RemoteException {
        if (this.zzdhl != null) {
            this.zzdhl.zza(zzatq);
        }
    }
}
