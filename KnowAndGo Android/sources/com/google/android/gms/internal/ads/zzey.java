package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzey extends zzfk {
    public zzey(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzzm) {
            zzdl zzdl = new zzdl((String) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()}));
            synchronized (this.zzzm) {
                this.zzzm.zzal(zzdl.zzwu);
                this.zzzm.zzbn(zzdl.zzwv);
            }
        }
    }
}
