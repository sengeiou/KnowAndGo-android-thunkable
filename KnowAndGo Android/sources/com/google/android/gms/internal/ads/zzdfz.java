package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfz extends zzdob<zzdfz, zza> implements zzdpm {
    private static volatile zzdpv<zzdfz> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfz zzgtc = new zzdfz();
    private int zzgqy;
    private int zzgta;
    private zzdmr zzgtb = zzdmr.zzhcr;

    private zzdfz() {
    }

    public static final class zza extends zzdob.zza<zzdfz, zza> implements zzdpm {
        private zza() {
            super(zzdfz.zzgtc);
        }

        /* synthetic */ zza(zzdga zzdga) {
            this();
        }
    }

    public final zzdgf zzara() {
        zzdgf zzek = zzdgf.zzek(this.zzgta);
        return zzek == null ? zzdgf.UNRECOGNIZED : zzek;
    }

    public final zzdgj zzaoo() {
        zzdgj zzel = zzdgj.zzel(this.zzgqy);
        return zzel == null ? zzdgj.UNRECOGNIZED : zzel;
    }

    public final zzdmr zzarb() {
        return this.zzgtb;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdga.zzdi[i - 1]) {
            case 1:
                return new zzdfz();
            case 2:
                return new zza((zzdga) null);
            case 3:
                return zza((zzdpk) zzgtc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzgta", "zzgqy", "zzgtb"});
            case 4:
                return zzgtc;
            case 5:
                zzdpv<zzdfz> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfz.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgtc);
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

    public static zzdfz zzarc() {
        return zzgtc;
    }

    static {
        zzdob.zza(zzdfz.class, zzgtc);
    }
}
