package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface zzamv extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzafe zzafe, String str) throws RemoteException;

    void zza(zzamy zzamy) throws RemoteException;

    void zza(zzatq zzatq) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzato zzato) throws RemoteException;

    void zzcs(int i) throws RemoteException;

    void zzcz(String str) throws RemoteException;

    void zzsm() throws RemoteException;

    void zzsn() throws RemoteException;
}
