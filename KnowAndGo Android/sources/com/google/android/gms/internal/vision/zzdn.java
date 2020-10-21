package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdn extends zzdf<Map.Entry<K, V>> {
    private final /* synthetic */ zzdk zzmb;

    zzdn(zzdk zzdk) {
        this.zzmb = zzdk;
    }

    public final int size() {
        return this.zzmb.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzct.zzc(i, this.zzmb.size);
        Object[] zzb = this.zzmb.zzlx;
        int i2 = i * 2;
        zzdk zzdk = this.zzmb;
        Object obj = zzb[i2];
        Object[] zzb2 = this.zzmb.zzlx;
        zzdk zzdk2 = this.zzmb;
        return new AbstractMap.SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
