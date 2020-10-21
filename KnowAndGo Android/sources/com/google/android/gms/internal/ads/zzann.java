package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzann implements InitializationCompleteCallback {
    private final /* synthetic */ zzaiq zzdgk;

    zzann(zzanl zzanl, zzaiq zzaiq) {
        this.zzdgk = zzaiq;
    }

    public final void onInitializationSucceeded() {
        try {
            this.zzdgk.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zzdgk.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
