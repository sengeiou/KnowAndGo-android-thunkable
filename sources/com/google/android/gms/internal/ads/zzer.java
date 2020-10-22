package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzer extends zzfk {
    private long startTime;

    public zzer(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, long j, int i, int i2) {
        super(zzdy, str, str2, zza, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzzw.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzzm) {
            this.zzzm.zzbr(longValue);
            if (this.startTime != 0) {
                this.zzzm.zzat(longValue - this.startTime);
                this.zzzm.zzaw(this.startTime);
            }
        }
    }
}
