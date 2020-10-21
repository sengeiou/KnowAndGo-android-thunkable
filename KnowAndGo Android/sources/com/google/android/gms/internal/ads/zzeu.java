package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzeu extends zzfk {
    private static final Object zzzl = new Object();
    private static volatile Long zzzn;

    public zzeu(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzzn == null) {
            synchronized (zzzl) {
                if (zzzn == null) {
                    zzzn = (Long) this.zzzw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzzm) {
            this.zzzm.zzav(zzzn.longValue());
        }
    }
}
