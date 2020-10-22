package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbsm;

public interface zzcka<AdT, AdapterT, ListenerT extends zzbsm> {
    void zza(zzcxu zzcxu, zzcxm zzcxm, zzcjy<AdapterT, ListenerT> zzcjy) throws RemoteException;

    AdT zzb(zzcxu zzcxu, zzcxm zzcxm, zzcjy<AdapterT, ListenerT> zzcjy) throws RemoteException, zzcmw;
}
