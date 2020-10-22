package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

final class zzaph implements SignalCallbacks {
    private final /* synthetic */ zzaoy zzdhk;

    zzaph(zzapc zzapc, zzaoy zzaoy) {
        this.zzdhk = zzaoy;
    }

    public final void onSuccess(String str) {
        try {
            this.zzdhk.zzdc(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdhk.onFailure(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
