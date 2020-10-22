package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfb extends zzfk {
    private final boolean zzzr;

    public zzfb(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 61);
        this.zzzr = zzdy.zzco();
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext(), Boolean.valueOf(this.zzzr)})).longValue();
        synchronized (this.zzzm) {
            this.zzzm.zzbo(longValue);
        }
    }
}
