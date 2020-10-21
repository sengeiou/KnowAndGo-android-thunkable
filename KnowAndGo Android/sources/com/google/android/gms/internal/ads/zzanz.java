package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

final class zzanz implements Runnable {
    private final /* synthetic */ zzanu zzdgx;
    private final /* synthetic */ AdRequest.ErrorCode zzdgy;

    zzanz(zzanu zzanu, AdRequest.ErrorCode errorCode) {
        this.zzdgx = zzanu;
        this.zzdgy = errorCode;
    }

    public final void run() {
        try {
            this.zzdgx.zzdgl.onAdFailedToLoad(zzaog.zza(this.zzdgy));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
