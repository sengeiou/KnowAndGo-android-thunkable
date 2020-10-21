package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdej extends zzdob<zzdej, zza> implements zzdpm {
    private static volatile zzdpv<zzdej> zzdv;
    /* access modifiers changed from: private */
    public static final zzdej zzgri = new zzdej();
    private int zzgqu;
    private zzdel zzgrg;

    private zzdej() {
    }

    public static final class zza extends zzdob.zza<zzdej, zza> implements zzdpm {
        private zza() {
            super(zzdej.zzgri);
        }

        /* synthetic */ zza(zzdek zzdek) {
            this();
        }
    }

    public final zzdel zzapb() {
        return this.zzgrg == null ? zzdel.zzapf() : this.zzgrg;
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdej zzaf(zzdmr zzdmr) throws zzdok {
        return (zzdej) zzdob.zza(zzgri, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdek.zzdi[i - 1]) {
            case 1:
                return new zzdej();
            case 2:
                return new zza((zzdek) null);
            case 3:
                return zza((zzdpk) zzgri, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrg", "zzgqu"});
            case 4:
                return zzgri;
            case 5:
                zzdpv<zzdej> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdej.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgri);
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

    static {
        zzdob.zza(zzdej.class, zzgri);
    }
}
