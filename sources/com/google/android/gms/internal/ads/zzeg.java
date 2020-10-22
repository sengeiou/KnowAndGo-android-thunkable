package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzeg extends zzcf<Integer, Long> {
    public Long zzyn;
    public Long zzyo;
    public Long zzyp;
    public Long zzyq;

    public zzeg() {
    }

    public zzeg(String str) {
        zzak(str);
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        HashMap zzal = zzal(str);
        if (zzal != null) {
            this.zzyn = (Long) zzal.get(0);
            this.zzyo = (Long) zzal.get(1);
            this.zzyp = (Long) zzal.get(2);
            this.zzyq = (Long) zzal.get(3);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzca() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyn);
        hashMap.put(1, this.zzyo);
        hashMap.put(2, this.zzyp);
        hashMap.put(3, this.zzyq);
        return hashMap;
    }
}
