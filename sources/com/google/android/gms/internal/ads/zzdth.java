package com.google.android.gms.internal.ads;

public final class zzdth<T> implements zzdte<T>, zzdtu<T> {
    private static final Object zzhuh = new Object();
    private volatile Object zzdxz = zzhuh;
    private volatile zzdtu<T> zzhui;

    private zzdth(zzdtu<T> zzdtu) {
        this.zzhui = zzdtu;
    }

    public final T get() {
        T t = this.zzdxz;
        if (t == zzhuh) {
            synchronized (this) {
                t = this.zzdxz;
                if (t == zzhuh) {
                    t = this.zzhui.get();
                    T t2 = this.zzdxz;
                    if (t2 != zzhuh && !(t2 instanceof zzdtn)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzdxz = t;
                    this.zzhui = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> zzao(P p) {
        zzdto.checkNotNull(p);
        if (p instanceof zzdth) {
            return p;
        }
        return new zzdth(p);
    }

    public static <P extends zzdtu<T>, T> zzdte<T> zzap(P p) {
        if (p instanceof zzdte) {
            return (zzdte) p;
        }
        return new zzdth((zzdtu) zzdto.checkNotNull(p));
    }
}
