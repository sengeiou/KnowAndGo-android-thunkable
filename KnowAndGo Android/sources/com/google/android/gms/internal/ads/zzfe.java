package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzfe extends zzfk {
    private final zzeh zzwj;
    private long zzzb;

    public zzfe(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, zzeh zzeh) {
        super(zzdy, str, str2, zza, i, 53);
        this.zzwj = zzeh;
        if (zzeh != null) {
            this.zzzb = zzeh.zzcv();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwj != null) {
            this.zzzm.zzbl(((Long) this.zzzw.invoke((Object) null, new Object[]{Long.valueOf(this.zzzb)})).longValue());
        }
    }
}
