package com.google.android.gms.internal.ads;

public final class zzdtg<T> implements zzdti<T> {
    private zzdtu<T> zzhug;

    public final T get() {
        if (this.zzhug != null) {
            return this.zzhug.get();
        }
        throw new IllegalStateException();
    }

    public static <T> void zzav(zzdtu<T> zzdtu, zzdtu<T> zzdtu2) {
        zzdto.checkNotNull(zzdtu2);
        zzdtg zzdtg = (zzdtg) zzdtu;
        if (zzdtg.zzhug == null) {
            zzdtg.zzhug = zzdtu2;
            return;
        }
        throw new IllegalStateException();
    }
}
