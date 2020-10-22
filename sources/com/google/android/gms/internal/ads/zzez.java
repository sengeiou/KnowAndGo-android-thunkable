package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzez extends zzfk {
    public zzez(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zzzm.zzh(((Boolean) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()})).booleanValue() ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzzm.zzh(zzbz.ENUM_FAILURE);
        }
    }
}
