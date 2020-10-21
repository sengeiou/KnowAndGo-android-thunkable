package com.google.android.gms.internal.ads;

final class zzaks implements zzbbv<zzajw> {
    private final /* synthetic */ zzakh zzdcn;
    private final /* synthetic */ zzala zzdcq;

    zzaks(zzakh zzakh, zzala zzala) {
        this.zzdcn = zzakh;
        this.zzdcq = zzala;
    }

    public final /* synthetic */ void zzh(Object obj) {
        synchronized (this.zzdcn.lock) {
            int unused = this.zzdcn.status = 0;
            if (!(this.zzdcn.zzdcd == null || this.zzdcq == this.zzdcn.zzdcd)) {
                zzawz.zzds("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdcn.zzdcd.zzrz();
            }
            zzala unused2 = this.zzdcn.zzdcd = this.zzdcq;
        }
    }
}
