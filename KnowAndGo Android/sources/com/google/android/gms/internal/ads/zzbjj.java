package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbjj extends zzfm implements zzbjh {
    zzbjj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    public final void zzc(zzbjf zzbjf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzbjf);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
