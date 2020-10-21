package com.google.android.gms.internal.ads;

final class zzakt implements zzbbt {
    private final /* synthetic */ zzakh zzdcn;
    private final /* synthetic */ zzala zzdcq;

    zzakt(zzakh zzakh, zzala zzala) {
        this.zzdcn = zzakh;
        this.zzdcq = zzala;
    }

    public final void run() {
        synchronized (this.zzdcn.lock) {
            int unused = this.zzdcn.status = 1;
            zzawz.zzds("Failed loading new engine. Marking new engine destroyable.");
            this.zzdcq.zzrz();
        }
    }
}
