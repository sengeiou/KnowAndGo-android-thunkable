package com.google.android.gms.internal.ads;

public final class zzdtj<T> implements zzdte<T>, zzdti<T> {
    private static final zzdtj<Object> zzhuj = new zzdtj<>((Object) null);
    private final T zzdxz;

    public static <T> zzdti<T> zzar(T t) {
        return new zzdtj(zzdto.zza(t, "instance cannot be null"));
    }

    private zzdtj(T t) {
        this.zzdxz = t;
    }

    public final T get() {
        return this.zzdxz;
    }
}
