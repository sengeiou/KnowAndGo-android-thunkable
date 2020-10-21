package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzvc implements Comparator<zzvi> {
    zzvc(zzvb zzvb) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzvi zzvi = (zzvi) obj;
        zzvi zzvi2 = (zzvi) obj2;
        int i = zzvi.zzbvw - zzvi2.zzbvw;
        if (i != 0) {
            return i;
        }
        return (int) (zzvi.value - zzvi2.value);
    }
}
