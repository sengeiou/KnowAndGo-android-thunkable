package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzayt {
    /* access modifiers changed from: private */
    public final List<String> zzdxe = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdxf = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdxg = new ArrayList();

    public final zzayt zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzdxe.size()) {
            double doubleValue = this.zzdxg.get(i).doubleValue();
            double doubleValue2 = this.zzdxf.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzdxe.add(i, str);
        this.zzdxg.add(i, Double.valueOf(d));
        this.zzdxf.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzayq zzwq() {
        return new zzayq(this);
    }
}
