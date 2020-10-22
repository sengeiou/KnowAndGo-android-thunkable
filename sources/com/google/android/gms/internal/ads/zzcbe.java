package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class zzcbe implements zzbam {
    static final zzbam zzdrn = new zzcbe();

    private zzcbe() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcbg zzcbg : (List) obj) {
            if (zzcbg != null) {
                arrayList.add(zzcbg);
            }
        }
        return arrayList;
    }
}
