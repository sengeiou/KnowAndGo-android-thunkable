package com.google.android.gms.internal.ads;

public final class zzdtt<T> implements zzdtu<T> {
    private static final Object zzhuh = new Object();
    private volatile Object zzdxz = zzhuh;
    private volatile zzdtu<T> zzhui;

    private zzdtt(zzdtu<T> zzdtu) {
        this.zzhui = zzdtu;
    }

    public final T get() {
        T t = this.zzdxz;
        if (t != zzhuh) {
            return t;
        }
        zzdtu<T> zzdtu = this.zzhui;
        if (zzdtu == null) {
            return this.zzdxz;
        }
        T t2 = zzdtu.get();
        this.zzdxz = t2;
        this.zzhui = null;
        return t2;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> zzao(P p) {
        return ((p instanceof zzdtt) || (p instanceof zzdth)) ? p : new zzdtt((zzdtu) zzdto.checkNotNull(p));
    }
}
