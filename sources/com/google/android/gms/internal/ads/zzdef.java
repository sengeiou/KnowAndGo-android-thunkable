package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdef extends zzdob<zzdef, zza> implements zzdpm {
    private static volatile zzdpv<zzdef> zzdv;
    /* access modifiers changed from: private */
    public static final zzdef zzgrf = new zzdef();
    private int zzgre;

    private zzdef() {
    }

    public static final class zza extends zzdob.zza<zzdef, zza> implements zzdpm {
        private zza() {
            super(zzdef.zzgrf);
        }

        /* synthetic */ zza(zzdeg zzdeg) {
            this();
        }
    }

    public final int zzaoy() {
        return this.zzgre;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdeg.zzdi[i - 1]) {
            case 1:
                return new zzdef();
            case 2:
                return new zza((zzdeg) null);
            case 3:
                return zza((zzdpk) zzgrf, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrf;
            case 5:
                zzdpv<zzdef> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdef.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrf);
                            zzdv = zzdpv;
                        }
                    }
                }
                return zzdpv;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzdef zzaoz() {
        return zzgrf;
    }

    static {
        zzdob.zza(zzdef.class, zzgrf);
    }
}
