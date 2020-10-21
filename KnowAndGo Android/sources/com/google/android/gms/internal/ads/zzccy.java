package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzccy implements zzbrx {
    private final zzams zzfsy;

    public zzccy(zzams zzams) {
        this.zzfsy = zzams;
    }

    public final void zzbp(@Nullable Context context) {
        try {
            this.zzfsy.pause();
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onPause for rewarded video.", e);
        }
    }

    public final void zzbq(@Nullable Context context) {
        try {
            this.zzfsy.resume();
            if (context != null) {
                this.zzfsy.zzr(ObjectWrapper.wrap(context));
            }
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onResume for rewarded video.", e);
        }
    }

    public final void zzbr(@Nullable Context context) {
        try {
            this.zzfsy.destroy();
        } catch (RemoteException e) {
            zzawz.zzd("Nonagon: Can't invoke onDestroy for rewarded video.", e);
        }
    }
}
