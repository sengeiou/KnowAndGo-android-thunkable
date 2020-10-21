package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdl extends zzcf<Integer, Long> {
    public long zzwu;
    public long zzwv;

    public zzdl() {
        this.zzwu = -1;
        this.zzwv = -1;
    }

    public zzdl(String str) {
        this();
        zzak(str);
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzca() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzwu));
        hashMap.put(1, Long.valueOf(this.zzwv));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        HashMap zzal = zzal(str);
        if (zzal != null) {
            this.zzwu = ((Long) zzal.get(0)).longValue();
            this.zzwv = ((Long) zzal.get(1)).longValue();
        }
    }
}
