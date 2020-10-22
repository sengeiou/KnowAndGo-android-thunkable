package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzage extends zzfn implements zzagd {
    public zzage() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                onUnconfirmedClickReceived(parcel.readString());
                break;
            case 2:
                onUnconfirmedClickCancelled();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
