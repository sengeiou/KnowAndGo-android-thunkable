package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

public final class zzccw extends VideoController.VideoLifecycleCallbacks {
    private final zzbyt zzfmq;

    public zzccw(zzbyt zzbyt) {
        this.zzfmq = zzbyt;
    }

    public final void onVideoStart() {
        zzaau zza = zza(this.zzfmq);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzawz.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzaau zza = zza(this.zzfmq);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzawz.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoEnd() {
        zzaau zza = zza(this.zzfmq);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzawz.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    private static zzaau zza(zzbyt zzbyt) {
        zzaar videoController = zzbyt.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzpx();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
