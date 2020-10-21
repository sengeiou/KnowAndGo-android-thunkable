package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzams extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException;

    void zza(zzxz zzxz, String str) throws RemoteException;

    void zza(zzxz zzxz, String str, String str2) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException;

    void zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzse() throws RemoteException;

    zzana zzsf() throws RemoteException;

    zzand zzsg() throws RemoteException;

    Bundle zzsh() throws RemoteException;

    Bundle zzsi() throws RemoteException;

    boolean zzsj() throws RemoteException;

    zzafe zzsk() throws RemoteException;

    zzang zzsl() throws RemoteException;
}
