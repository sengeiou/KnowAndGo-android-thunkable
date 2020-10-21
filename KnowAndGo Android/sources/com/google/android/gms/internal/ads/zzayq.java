package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzayq {
    private final String[] zzdww;
    private final double[] zzdwx;
    private final double[] zzdwy;
    private final int[] zzdwz;
    private int zzdxa;

    private zzayq(zzayt zzayt) {
        int size = zzayt.zzdxf.size();
        this.zzdww = (String[]) zzayt.zzdxe.toArray(new String[size]);
        this.zzdwx = zzd(zzayt.zzdxf);
        this.zzdwy = zzd(zzayt.zzdxg);
        this.zzdwz = new int[size];
        this.zzdxa = 0;
    }

    private static double[] zzd(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzdxa++;
        int i = 0;
        while (i < this.zzdwy.length) {
            if (this.zzdwy[i] <= d && d < this.zzdwx[i]) {
                int[] iArr = this.zzdwz;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzdwy[i]) {
                i++;
            } else {
                return;
            }
        }
    }

    public final List<zzays> zzwp() {
        ArrayList arrayList = new ArrayList(this.zzdww.length);
        for (int i = 0; i < this.zzdww.length; i++) {
            arrayList.add(new zzays(this.zzdww[i], this.zzdwy[i], this.zzdwx[i], ((double) this.zzdwz[i]) / ((double) this.zzdxa), this.zzdwz[i]));
        }
        return arrayList;
    }
}
