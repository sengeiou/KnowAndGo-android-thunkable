package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

final /* synthetic */ class zzaka implements Predicate {
    private final zzaho zzdbu;

    zzaka(zzaho zzaho) {
        this.zzdbu = zzaho;
    }

    public final boolean apply(Object obj) {
        zzaho zzaho = (zzaho) obj;
        return (zzaho instanceof zzakf) && ((zzakf) zzaho).zzdbz.equals(this.zzdbu);
    }
}
