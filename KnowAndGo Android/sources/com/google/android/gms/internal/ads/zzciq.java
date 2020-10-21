package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

final class zzciq implements zzban<ParcelFileDescriptor> {
    private final /* synthetic */ zzarr zzfxr;

    zzciq(zzcig zzcig, zzarr zzarr) {
        this.zzfxr = zzarr;
    }

    public final void zzb(Throwable th) {
        try {
            this.zzfxr.zza(zzaym.zza(th, zzcgm.zze(th)));
        } catch (RemoteException e) {
            zzawz.zza("Service can't call client", e);
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        try {
            this.zzfxr.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzawz.zza("Service can't call client", e);
        }
    }
}
