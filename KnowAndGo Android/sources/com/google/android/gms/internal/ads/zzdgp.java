package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgp extends zzdob<zzdgp, zza> implements zzdpm {
    private static volatile zzdpv<zzdgp> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgp zzgty = new zzdgp();
    private int zzgtw;
    private int zzgtx;

    private zzdgp() {
    }

    public static final class zza extends zzdob.zza<zzdgp, zza> implements zzdpm {
        private zza() {
            super(zzdgp.zzgty);
        }

        /* synthetic */ zza(zzdgq zzdgq) {
            this();
        }
    }

    public final zzdgj zzarp() {
        zzdgj zzel = zzdgj.zzel(this.zzgtw);
        return zzel == null ? zzdgj.UNRECOGNIZED : zzel;
    }

    public final int zzarq() {
        return this.zzgtx;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgq.zzdi[i - 1]) {
            case 1:
                return new zzdgp();
            case 2:
                return new zza((zzdgq) null);
            case 3:
                return zza((zzdpk) zzgty, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzgtw", "zzgtx"});
            case 4:
                return zzgty;
            case 5:
                zzdpv<zzdgp> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgp.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgty);
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

    public static zzdgp zzarr() {
        return zzgty;
    }

    static {
        zzdob.zza(zzdgp.class, zzgty);
    }
}
