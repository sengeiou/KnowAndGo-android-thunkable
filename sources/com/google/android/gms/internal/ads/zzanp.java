package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzanp extends zzamw {
    private final zzatk zzdge;
    private final Adapter zzdgp;

    zzanp(Adapter adapter, zzatk zzatk) {
        this.zzdgp = adapter;
        this.zzdge = zzatk;
    }

    public final void onAdImpression() throws RemoteException {
    }

    public final void onAdLeftApplication() throws RemoteException {
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    public final void onVideoEnd() throws RemoteException {
    }

    public final void onVideoPause() throws RemoteException {
    }

    public final void onVideoPlay() throws RemoteException {
    }

    public final void zza(zzafe zzafe, String str) throws RemoteException {
    }

    public final void zza(zzamy zzamy) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzb(zzato zzato) throws RemoteException {
    }

    public final void zzcs(int i) throws RemoteException {
    }

    public final void zzcz(String str) throws RemoteException {
    }

    public final void onAdLoaded() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzaf(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void onAdOpened() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzag(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void onAdClosed() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzai(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void zza(zzatq zzatq) throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zza(ObjectWrapper.wrap(this.zzdgp), new zzato(zzatq.getType(), zzatq.getAmount()));
        }
    }

    public final void zzsm() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzah(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void zzsn() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzal(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void onAdClicked() throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zzaj(ObjectWrapper.wrap(this.zzdgp));
        }
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdge != null) {
            this.zzdge.zze(ObjectWrapper.wrap(this.zzdgp), i);
        }
    }
}
