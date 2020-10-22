package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzep extends zzfk {
    public zzep(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzam(-1);
        this.zzzm.zzan(-1);
        int[] iArr = (int[]) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()});
        synchronized (this.zzzm) {
            this.zzzm.zzam((long) iArr[0]);
            this.zzzm.zzan((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzzm.zzbm((long) iArr[2]);
            }
        }
    }
}
