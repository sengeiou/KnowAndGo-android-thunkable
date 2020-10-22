package com.google.android.gms.internal.ads;

import java.util.List;

final class zzdox extends zzdou {
    private zzdox() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzdoj zzd = zzd(obj, j);
        if (zzd.zzavi()) {
            return zzd;
        }
        int size = zzd.size();
        zzdoj zzfl = zzd.zzfl(size == 0 ? 10 : size << 1);
        zzdqz.zza(obj, j, (Object) zzfl);
        return zzfl;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzavj();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdoj zzd = zzd(obj, j);
        zzdoj zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzavi()) {
                zzd = zzd.zzfl(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zzdqz.zza(obj, j, (Object) zzd2);
    }

    private static <E> zzdoj<E> zzd(Object obj, long j) {
        return (zzdoj) zzdqz.zzp(obj, j);
    }
}
