package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzdbg extends zzfm implements zzdbf {
    zzdbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzdbd zza(zzdbb zzdbb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdbb);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzdbd zzdbd = (zzdbd) zzfo.zza(transactAndReadException, zzdbd.CREATOR);
        transactAndReadException.recycle();
        return zzdbd;
    }

    public final void zza(zzday zzday) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzday);
        zza(2, obtainAndWriteInterfaceToken);
    }
}
