package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdx extends zzcf<Integer, Long> {
    public Long zzxd;
    public Long zzxe;

    public zzdx() {
    }

    public zzdx(String str) {
        zzak(str);
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        HashMap zzal = zzal(str);
        if (zzal != null) {
            this.zzxd = (Long) zzal.get(0);
            this.zzxe = (Long) zzal.get(1);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzca() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzxd);
        hashMap.put(1, this.zzxe);
        return hashMap;
    }
}
