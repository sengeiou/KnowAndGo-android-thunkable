package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzee extends zzcf<Integer, Long> {
    public Long zzyb;
    public Long zzyc;
    public Long zzyd;
    public Long zzye;
    public Long zzyf;
    public Long zzyg;
    public Long zzyh;
    public Long zzyi;
    public Long zzyj;
    public Long zzyk;
    public Long zzyl;

    public zzee() {
    }

    public zzee(String str) {
        zzak(str);
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        HashMap zzal = zzal(str);
        if (zzal != null) {
            this.zzyb = (Long) zzal.get(0);
            this.zzyc = (Long) zzal.get(1);
            this.zzyd = (Long) zzal.get(2);
            this.zzye = (Long) zzal.get(3);
            this.zzyf = (Long) zzal.get(4);
            this.zzyg = (Long) zzal.get(5);
            this.zzyh = (Long) zzal.get(6);
            this.zzyi = (Long) zzal.get(7);
            this.zzyj = (Long) zzal.get(8);
            this.zzyk = (Long) zzal.get(9);
            this.zzyl = (Long) zzal.get(10);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzca() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyb);
        hashMap.put(1, this.zzyc);
        hashMap.put(2, this.zzyd);
        hashMap.put(3, this.zzye);
        hashMap.put(4, this.zzyf);
        hashMap.put(5, this.zzyg);
        hashMap.put(6, this.zzyh);
        hashMap.put(7, this.zzyi);
        hashMap.put(8, this.zzyj);
        hashMap.put(9, this.zzyk);
        hashMap.put(10, this.zzyl);
        return hashMap;
    }
}
