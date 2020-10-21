package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaot extends zzfn implements zzaos {
    public zzaot() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                zzsw();
                break;
            case 3:
                zzdb(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
