package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfr extends zzdob<zzdfr, zza> implements zzdpm {
    private static volatile zzdpv<zzdfr> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfr zzgss = new zzdfr();
    private zzdft zzgsr;

    private zzdfr() {
    }

    public static final class zza extends zzdob.zza<zzdfr, zza> implements zzdpm {
        private zza() {
            super(zzdfr.zzgss);
        }

        /* synthetic */ zza(zzdfs zzdfs) {
            this();
        }
    }

    public final zzdft zzaqn() {
        return this.zzgsr == null ? zzdft.zzaqs() : this.zzgsr;
    }

    public static zzdfr zzaz(zzdmr zzdmr) throws zzdok {
        return (zzdfr) zzdob.zza(zzgss, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfs.zzdi[i - 1]) {
            case 1:
                return new zzdfr();
            case 2:
                return new zza((zzdfs) null);
            case 3:
                return zza((zzdpk) zzgss, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzgsr"});
            case 4:
                return zzgss;
            case 5:
                zzdpv<zzdfr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgss);
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
        zzdob.zza(zzdfr.class, zzgss);
    }
}
