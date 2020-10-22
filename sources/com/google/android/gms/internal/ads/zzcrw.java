package com.google.android.gms.internal.ads;

import java.util.ArrayList;

final /* synthetic */ class zzcrw implements zzbam {
    static final zzbam zzdrn = new zzcrw();

    private zzcrw() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcrx(arrayList);
    }
}
