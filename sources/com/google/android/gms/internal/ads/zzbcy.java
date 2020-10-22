package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@zzard
public final class zzbcy {
    private final long zzecr = TimeUnit.MILLISECONDS.toNanos(((Long) zzyt.zzpe().zzd(zzacu.zzcme)).longValue());
    private long zzecs;
    private boolean zzect = true;

    zzbcy() {
    }

    public final void zzxm() {
        this.zzect = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbcn zzbcn) {
        if (zzbcn != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzect || Math.abs(timestamp - this.zzecs) >= this.zzecr) {
                this.zzect = false;
                this.zzecs = timestamp;
                zzaxi.zzdvv.post(new zzbcz(this, zzbcn));
            }
        }
    }
}
