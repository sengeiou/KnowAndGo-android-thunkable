package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzew extends zzfk {
    private long zzzo = -1;

    public zzew(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 12);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzap(-1);
        this.zzzm.zzap(((Long) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()})).longValue());
    }
}
