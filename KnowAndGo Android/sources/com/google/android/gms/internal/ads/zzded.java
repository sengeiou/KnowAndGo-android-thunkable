package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzded extends zzdob<zzded, zza> implements zzdpm {
    private static volatile zzdpv<zzded> zzdv;
    /* access modifiers changed from: private */
    public static final zzded zzgrd = new zzded();
    private int zzgqu;
    private zzdef zzgrb;

    private zzded() {
    }

    public static final class zza extends zzdob.zza<zzded, zza> implements zzdpm {
        private zza() {
            super(zzded.zzgrd);
        }

        /* synthetic */ zza(zzdee zzdee) {
            this();
        }
    }

    public final zzdef zzaos() {
        return this.zzgrb == null ? zzdef.zzaoz() : this.zzgrb;
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzded zzac(zzdmr zzdmr) throws zzdok {
        return (zzded) zzdob.zza(zzgrd, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdee.zzdi[i - 1]) {
            case 1:
                return new zzded();
            case 2:
                return new zza((zzdee) null);
            case 3:
                return zza((zzdpk) zzgrd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrb", "zzgqu"});
            case 4:
                return zzgrd;
            case 5:
                zzdpv<zzded> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzded.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrd);
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

    public static zzded zzaow() {
        return zzgrd;
    }

    static {
        zzdob.zza(zzded.class, zzgrd);
    }
}
