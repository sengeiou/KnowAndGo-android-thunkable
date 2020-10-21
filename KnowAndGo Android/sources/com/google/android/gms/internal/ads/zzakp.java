package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzakp implements zzaho<zzalf> {
    private final /* synthetic */ zzajw zzdcm;
    private final /* synthetic */ zzakh zzdcn;
    private final /* synthetic */ zzdh zzdco;
    private final /* synthetic */ zzazk zzdcp;

    zzakp(zzakh zzakh, zzdh zzdh, zzajw zzajw, zzazk zzazk) {
        this.zzdcn = zzakh;
        this.zzdco = zzdh;
        this.zzdcm = zzajw;
        this.zzdcp = zzazk;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.zzdcn.lock) {
            zzawz.zzeo("JS Engine is requesting an update");
            if (this.zzdcn.status == 0) {
                zzawz.zzeo("Starting reload.");
                int unused = this.zzdcn.status = 2;
                this.zzdcn.zza(this.zzdco);
            }
            this.zzdcm.zzb("/requestReload", (zzaho) this.zzdcp.get());
        }
    }
}
