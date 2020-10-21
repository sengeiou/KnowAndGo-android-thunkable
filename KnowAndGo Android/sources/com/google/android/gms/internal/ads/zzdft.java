package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdft extends zzdob<zzdft, zza> implements zzdpm {
    private static volatile zzdpv<zzdft> zzdv;
    /* access modifiers changed from: private */
    public static final zzdft zzgsw = new zzdft();
    private zzdfz zzgst;
    private zzdfp zzgsu;
    private int zzgsv;

    private zzdft() {
    }

    public static final class zza extends zzdob.zza<zzdft, zza> implements zzdpm {
        private zza() {
            super(zzdft.zzgsw);
        }

        /* synthetic */ zza(zzdfu zzdfu) {
            this();
        }
    }

    public final zzdfz zzaqp() {
        return this.zzgst == null ? zzdfz.zzarc() : this.zzgst;
    }

    public final zzdfp zzaqq() {
        return this.zzgsu == null ? zzdfp.zzaql() : this.zzgsu;
    }

    public final zzdfd zzaqr() {
        zzdfd zzec = zzdfd.zzec(this.zzgsv);
        return zzec == null ? zzdfd.UNRECOGNIZED : zzec;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfu.zzdi[i - 1]) {
            case 1:
                return new zzdft();
            case 2:
                return new zza((zzdfu) null);
            case 3:
                return zza((zzdpk) zzgsw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzgst", "zzgsu", "zzgsv"});
            case 4:
                return zzgsw;
            case 5:
                zzdpv<zzdft> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdft.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgsw);
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

    public static zzdft zzaqs() {
        return zzgsw;
    }

    static {
        zzdob.zza(zzdft.class, zzgsw);
    }
}
