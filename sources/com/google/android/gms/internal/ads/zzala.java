package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

public final class zzala extends zzbbw<zzajw> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzayp<zzajw> zzdcc;
    private boolean zzdcw;
    private int zzdcx;

    public zzala(zzayp<zzajw> zzayp) {
        this.zzdcc = zzayp;
        this.zzdcw = false;
        this.zzdcx = 0;
    }

    public final zzakw zzrx() {
        zzakw zzakw = new zzakw(this);
        synchronized (this.lock) {
            zza(new zzalb(this, zzakw), new zzalc(this, zzakw));
            Preconditions.checkState(this.zzdcx >= 0);
            this.zzdcx++;
        }
        return zzakw;
    }

    /* access modifiers changed from: protected */
    public final void zzry() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdcx > 0);
            zzawz.zzds("Releasing 1 reference for JS Engine");
            this.zzdcx--;
            zzsa();
        }
    }

    public final void zzrz() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdcx >= 0);
            zzawz.zzds("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdcw = true;
            zzsa();
        }
    }

    private final void zzsa() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdcx >= 0);
            if (!this.zzdcw || this.zzdcx != 0) {
                zzawz.zzds("There are still references to the engine. Not destroying.");
            } else {
                zzawz.zzds("No reference is left (including root). Cleaning up engine.");
                zza(new zzald(this), new zzbbu());
            }
        }
    }
}
