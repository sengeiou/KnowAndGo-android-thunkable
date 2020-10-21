package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfg extends zzfk {
    public zzfg(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zze(zzbz.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()})).booleanValue();
        synchronized (this.zzzm) {
            if (booleanValue) {
                try {
                    this.zzzm.zze(zzbz.ENUM_TRUE);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                this.zzzm.zze(zzbz.ENUM_FALSE);
            }
        }
    }
}
