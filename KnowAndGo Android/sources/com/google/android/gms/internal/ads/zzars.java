package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public abstract class zzars extends zzfn implements zzarr {
    public zzars() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb((ParcelFileDescriptor) zzfo.zza(parcel, ParcelFileDescriptor.CREATOR));
                break;
            case 2:
                zza((zzaym) zzfo.zza(parcel, zzaym.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
