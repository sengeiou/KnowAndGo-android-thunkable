package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzcct<T> implements zzaho<Object> {
    private final WeakReference<T> zzfst;
    private final String zzfsu;
    private final zzaho<T> zzfsv;
    private final /* synthetic */ zzccj zzfsw;

    private zzcct(zzccj zzccj, WeakReference<T> weakReference, String str, zzaho<T> zzaho) {
        this.zzfsw = zzccj;
        this.zzfst = weakReference;
        this.zzfsu = str;
        this.zzfsv = zzaho;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzfst.get();
        if (obj2 == null) {
            this.zzfsw.zzb(this.zzfsu, this);
        } else {
            this.zzfsv.zza(obj2, map);
        }
    }

    /* synthetic */ zzcct(zzccj zzccj, WeakReference weakReference, String str, zzaho zzaho, zzccm zzccm) {
        this(zzccj, weakReference, str, zzaho);
    }
}
