package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzclb extends zzatl implements zzbsm {
    @GuardedBy("this")
    private zzbsn zzgai;
    @GuardedBy("this")
    private zzatk zzgaj;
    @GuardedBy("this")
    private zzbvo zzgak;

    public final synchronized void zza(zzatk zzatk) {
        this.zzgaj = zzatk;
    }

    public final synchronized void zza(zzbsn zzbsn) {
        this.zzgai = zzbsn;
    }

    public final synchronized void zza(zzbvo zzbvo) {
        this.zzgak = zzbvo;
    }

    public final synchronized void zzae(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzae(iObjectWrapper);
        }
        if (this.zzgak != null) {
            this.zzgak.onInitializationSucceeded();
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzd(iObjectWrapper, i);
        }
        if (this.zzgak != null) {
            this.zzgak.zzdl(i);
        }
    }

    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzah(iObjectWrapper);
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzato zzato) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zza(iObjectWrapper, zzato);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzaj(iObjectWrapper);
        }
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzai(iObjectWrapper);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zze(iObjectWrapper, i);
        }
        if (this.zzgai != null) {
            this.zzgai.onAdFailedToLoad(i);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzag(iObjectWrapper);
        }
    }

    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzaf(iObjectWrapper);
        }
        if (this.zzgai != null) {
            this.zzgai.onAdLoaded();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzgaj != null) {
            this.zzgaj.zzb(bundle);
        }
    }
}
