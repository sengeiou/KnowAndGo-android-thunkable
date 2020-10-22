package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzaro extends zzfm implements zzarm {
    zzaro(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzari zza(zzarg zzarg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarg);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzari zzari = (zzari) zzfo.zza(transactAndReadException, zzari.CREATOR);
        transactAndReadException.recycle();
        return zzari;
    }

    public final void zza(zzarg zzarg, zzarp zzarp) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarg);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzarp);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzarx zzarx, zzarr zzarr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarx);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzarr);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzarx zzarx, zzarr zzarr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarx);
        zzfo.zza(obtainAndWriteInterfaceToken, (IInterface) zzarr);
        zza(5, obtainAndWriteInterfaceToken);
    }
}
