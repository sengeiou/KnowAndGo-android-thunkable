package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzff extends zzfk {
    private static final Object zzzl = new Object();
    private static volatile Long zzzt;

    public zzff(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 33);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzzt == null) {
            synchronized (zzzl) {
                if (zzzt == null) {
                    zzzt = (Long) this.zzzw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzzm) {
            this.zzzm.zzaz(zzzt.longValue());
        }
    }
}
