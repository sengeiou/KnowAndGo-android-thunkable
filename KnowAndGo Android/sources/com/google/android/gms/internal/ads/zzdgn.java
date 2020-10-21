package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgn extends zzdob<zzdgn, zza> implements zzdpm {
    private static volatile zzdpv<zzdgn> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgn zzgtv = new zzdgn();
    private int zzgqu;
    private zzdgp zzgtt;

    private zzdgn() {
    }

    public static final class zza extends zzdob.zza<zzdgn, zza> implements zzdpm {
        private zza() {
            super(zzdgn.zzgtv);
        }

        /* synthetic */ zza(zzdgo zzdgo) {
            this();
        }
    }

    public final zzdgp zzarj() {
        return this.zzgtt == null ? zzdgp.zzarr() : this.zzgtt;
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdgn zzbm(zzdmr zzdmr) throws zzdok {
        return (zzdgn) zzdob.zza(zzgtv, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgo.zzdi[i - 1]) {
            case 1:
                return new zzdgn();
            case 2:
                return new zza((zzdgo) null);
            case 3:
                return zza((zzdpk) zzgtv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgtt", "zzgqu"});
            case 4:
                return zzgtv;
            case 5:
                zzdpv<zzdgn> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgn.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgtv);
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

    public static zzdgn zzarn() {
        return zzgtv;
    }

    static {
        zzdob.zza(zzdgn.class, zzgtv);
    }
}
