package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
public final class zzazh {
    private Map<Integer, Bitmap> zzdxu = new ConcurrentHashMap();
    private AtomicInteger zzdxv = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdxu.get(num);
    }
}
