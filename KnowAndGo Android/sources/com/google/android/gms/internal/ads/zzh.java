package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.DefaultLoadControl;

public final class zzh implements zzac {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzh() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1, 1.0f);
    }

    private zzh(int i, int i2, float f) {
        this.zzr = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
        this.zzt = 1;
        this.zzu = 1.0f;
    }

    public final int zzb() {
        return this.zzr;
    }

    public final int zzc() {
        return this.zzs;
    }

    public final void zza(zzaf zzaf) throws zzaf {
        boolean z = true;
        this.zzs++;
        this.zzr += (int) (((float) this.zzr) * this.zzu);
        if (this.zzs > this.zzt) {
            z = false;
        }
        if (!z) {
            throw zzaf;
        }
    }
}
