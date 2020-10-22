package com.google.android.gms.internal.ads;

public final class zzy<T> {
    public final T result;
    public final zzc zzbh;
    public final zzaf zzbi;
    public boolean zzbj;

    public static <T> zzy<T> zza(T t, zzc zzc) {
        return new zzy<>(t, zzc);
    }

    public static <T> zzy<T> zzc(zzaf zzaf) {
        return new zzy<>(zzaf);
    }

    private zzy(T t, zzc zzc) {
        this.zzbj = false;
        this.result = t;
        this.zzbh = zzc;
        this.zzbi = null;
    }

    private zzy(zzaf zzaf) {
        this.zzbj = false;
        this.result = null;
        this.zzbh = null;
        this.zzbi = zzaf;
    }
}
