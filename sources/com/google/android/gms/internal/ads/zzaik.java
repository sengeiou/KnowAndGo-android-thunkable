package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

final class zzaik extends zzaif {
    private final /* synthetic */ zzbbr zzbxc;

    zzaik(zzaij zzaij, zzbbr zzbbr) {
        this.zzbxc = zzbbr;
    }

    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbxc.set(parcelFileDescriptor);
    }
}
