package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzvl implements Comparator<zzuz> {
    public zzvl(zzvk zzvk) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzuz zzuz = (zzuz) obj;
        zzuz zzuz2 = (zzuz) obj2;
        if (zzuz.zznb() < zzuz2.zznb()) {
            return -1;
        }
        if (zzuz.zznb() > zzuz2.zznb()) {
            return 1;
        }
        if (zzuz.zzna() < zzuz2.zzna()) {
            return -1;
        }
        if (zzuz.zzna() > zzuz2.zzna()) {
            return 1;
        }
        float zznd = (zzuz.zznd() - zzuz.zznb()) * (zzuz.zznc() - zzuz.zzna());
        float zznd2 = (zzuz2.zznd() - zzuz2.zznb()) * (zzuz2.zznc() - zzuz2.zzna());
        if (zznd > zznd2) {
            return -1;
        }
        if (zznd < zznd2) {
            return 1;
        }
        return 0;
    }
}
