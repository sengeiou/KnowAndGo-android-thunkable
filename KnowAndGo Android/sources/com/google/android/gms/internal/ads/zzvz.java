package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzvz extends zzfm implements zzvy {
    zzvz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzvs zza(zzvv zzvv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfo.zza(obtainAndWriteInterfaceToken, (Parcelable) zzvv);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzvs zzvs = (zzvs) zzfo.zza(transactAndReadException, zzvs.CREATOR);
        transactAndReadException.recycle();
        return zzvs;
    }
}
