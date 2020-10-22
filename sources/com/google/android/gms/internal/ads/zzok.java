package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzok extends zzoj {
    public final List<zzol> zzama = new ArrayList();
    public final List<zzok> zzamb = new ArrayList();
    public final long zzbdz;

    public zzok(int i, long j) {
        super(i);
        this.zzbdz = j;
    }

    public final zzol zzay(int i) {
        int size = this.zzama.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzol zzol = this.zzama.get(i2);
            if (zzol.type == i) {
                return zzol;
            }
        }
        return null;
    }

    public final zzok zzaz(int i) {
        int size = this.zzamb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzok zzok = this.zzamb.get(i2);
            if (zzok.type == i) {
                return zzok;
            }
        }
        return null;
    }

    public final String toString() {
        String zzu = zzu(this.type);
        String arrays = Arrays.toString(this.zzama.toArray());
        String arrays2 = Arrays.toString(this.zzamb.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzu).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzu);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
