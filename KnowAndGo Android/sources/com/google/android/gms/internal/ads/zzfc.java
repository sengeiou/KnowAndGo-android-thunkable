package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfc extends zzfk {
    private final StackTraceElement[] zzzs;

    public zzfc(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzdy, str, str2, zza, i, 45);
        this.zzzs = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        zzbz zzbz;
        if (this.zzzs != null) {
            zzdw zzdw = new zzdw((String) this.zzzw.invoke((Object) null, new Object[]{this.zzzs}));
            synchronized (this.zzzm) {
                this.zzzm.zzbi(zzdw.zzxa.longValue());
                if (zzdw.zzxb.booleanValue()) {
                    zzbp.zza.C4378zza zza = this.zzzm;
                    if (zzdw.zzxc.booleanValue()) {
                        zzbz = zzbz.ENUM_FALSE;
                    } else {
                        zzbz = zzbz.ENUM_TRUE;
                    }
                    zza.zzg(zzbz);
                } else {
                    this.zzzm.zzg(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
