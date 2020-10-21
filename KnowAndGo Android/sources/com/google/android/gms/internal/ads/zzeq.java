package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzeq extends zzfk {
    private static volatile Long zzzk;
    private static final Object zzzl = new Object();

    public zzeq(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzzk == null) {
            synchronized (zzzl) {
                if (zzzk == null) {
                    zzzk = (Long) this.zzzw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzzm) {
            this.zzzm.zzbh(zzzk.longValue());
        }
    }
}
