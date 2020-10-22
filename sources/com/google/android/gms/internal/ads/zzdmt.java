package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzdmt implements Comparator<zzdmr> {
    zzdmt() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdmr zzdmr = (zzdmr) obj;
        zzdmr zzdmr2 = (zzdmr) obj2;
        zzdmy zzdmy = (zzdmy) zzdmr.iterator();
        zzdmy zzdmy2 = (zzdmy) zzdmr2.iterator();
        while (zzdmy.hasNext() && zzdmy2.hasNext()) {
            int compare = Integer.compare(zzdmr.zzb(zzdmy.nextByte()), zzdmr.zzb(zzdmy2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdmr.size(), zzdmr2.size());
    }
}
