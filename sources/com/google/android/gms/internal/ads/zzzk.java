package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzzk extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaax zzaax) throws RemoteException;

    void zza(zzacd zzacd) throws RemoteException;

    void zza(zzado zzado) throws RemoteException;

    void zza(zzaqn zzaqn) throws RemoteException;

    void zza(zzaqt zzaqt, String str) throws RemoteException;

    void zza(zzatb zzatb) throws RemoteException;

    void zza(zzyd zzyd) throws RemoteException;

    void zza(zzyw zzyw) throws RemoteException;

    void zza(zzzp zzzp) throws RemoteException;

    void zza(zzzs zzzs) throws RemoteException;

    void zzb(zzyz zzyz) throws RemoteException;

    void zzb(zzzy zzzy) throws RemoteException;

    boolean zzb(zzxz zzxz) throws RemoteException;

    void zzbt(String str) throws RemoteException;

    String zzpj() throws RemoteException;

    IObjectWrapper zzpl() throws RemoteException;

    void zzpm() throws RemoteException;

    zzyd zzpn() throws RemoteException;

    zzzs zzpo() throws RemoteException;

    zzyz zzpp() throws RemoteException;
}
