package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzfa extends zzfk {
    private List<Long> zzzq = null;

    public zzfa(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzax(-1);
        this.zzzm.zzay(-1);
        if (this.zzzq == null) {
            this.zzzq = (List) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()});
        }
        if (this.zzzq != null && this.zzzq.size() == 2) {
            synchronized (this.zzzm) {
                this.zzzm.zzax(this.zzzq.get(0).longValue());
                this.zzzm.zzay(this.zzzq.get(1).longValue());
            }
        }
    }
}
