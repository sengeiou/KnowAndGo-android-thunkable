package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfd extends zzfk {
    public zzfd(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzzm) {
            zzdx zzdx = new zzdx((String) this.zzzw.invoke((Object) null, new Object[0]));
            this.zzzm.zzbj(zzdx.zzxd.longValue());
            this.zzzm.zzbk(zzdx.zzxe.longValue());
        }
    }
}
