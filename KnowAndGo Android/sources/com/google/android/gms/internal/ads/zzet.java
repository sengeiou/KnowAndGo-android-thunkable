package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.Callable;

public final class zzet implements Callable {
    private final zzdy zzvd;
    private final zzbp.zza.C4378zza zzzm;

    public zzet(zzdy zzdy, zzbp.zza.C4378zza zza) {
        this.zzvd = zzdy;
        this.zzzm = zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcz */
    public final Void call() throws Exception {
        if (this.zzvd.zzcq() != null) {
            this.zzvd.zzcq().get();
        }
        zzbp.zza zzcp = this.zzvd.zzcp();
        if (zzcp == null) {
            return null;
        }
        try {
            synchronized (this.zzzm) {
                zzbp.zza.C4378zza zza = this.zzzm;
                byte[] byteArray = zzcp.toByteArray();
                zza.zza(byteArray, 0, byteArray.length, zzdno.zzaxe());
            }
            return null;
        } catch (zzdok unused) {
            return null;
        }
    }
}
