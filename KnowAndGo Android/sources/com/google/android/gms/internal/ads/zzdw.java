package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdw extends zzcf<Integer, Object> {
    public Long zzxa;
    public Boolean zzxb;
    public Boolean zzxc;

    public zzdw() {
    }

    public zzdw(String str) {
        zzak(str);
    }

    /* access modifiers changed from: protected */
    public final void zzak(String str) {
        HashMap zzal = zzal(str);
        if (zzal != null) {
            this.zzxa = (Long) zzal.get(0);
            this.zzxb = (Boolean) zzal.get(1);
            this.zzxc = (Boolean) zzal.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzca() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzxa);
        hashMap.put(1, this.zzxb);
        hashMap.put(2, this.zzxc);
        return hashMap;
    }
}
