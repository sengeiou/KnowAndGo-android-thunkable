package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdel extends zzdob<zzdel, zza> implements zzdpm {
    private static volatile zzdpv<zzdel> zzdv;
    /* access modifiers changed from: private */
    public static final zzdel zzgrj = new zzdel();
    private int zzgre;

    private zzdel() {
    }

    public static final class zza extends zzdob.zza<zzdel, zza> implements zzdpm {
        private zza() {
            super(zzdel.zzgrj);
        }

        /* synthetic */ zza(zzdem zzdem) {
            this();
        }
    }

    public final int zzaoy() {
        return this.zzgre;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdem.zzdi[i - 1]) {
            case 1:
                return new zzdel();
            case 2:
                return new zza((zzdem) null);
            case 3:
                return zza((zzdpk) zzgrj, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrj;
            case 5:
                zzdpv<zzdel> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdel.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrj);
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

    public static zzdel zzapf() {
        return zzgrj;
    }

    static {
        zzdob.zza(zzdel.class, zzgrj);
    }
}
