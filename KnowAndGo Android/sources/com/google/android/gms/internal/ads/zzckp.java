package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzckp extends zzaok {
    private zzcjy<zzaov, zzcla> zzfzw;
    private final /* synthetic */ zzckm zzfzx;

    private zzckp(zzckm zzckm, zzcjy zzcjy) {
        this.zzfzx = zzckm;
        this.zzfzw = zzcjy;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zzfzx.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcla) this.zzfzw.zzfzn).onAdLoaded();
    }

    public final void zzdb(String str) throws RemoteException {
        ((zzcla) this.zzfzw.zzfzn).onAdFailedToLoad(0);
    }
}
