package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdhg extends zzdob<zzdhg, zza> implements zzdpm {
    private static volatile zzdpv<zzdhg> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhg zzgvk = new zzdhg();
    private String zzgvj = "";

    private zzdhg() {
    }

    public static final class zza extends zzdob.zza<zzdhg, zza> implements zzdpm {
        private zza() {
            super(zzdhg.zzgvk);
        }

        /* synthetic */ zza(zzdhh zzdhh) {
            this();
        }
    }

    public final String zzasz() {
        return this.zzgvj;
    }

    public static zzdhg zzbq(zzdmr zzdmr) throws zzdok {
        return (zzdhg) zzdob.zza(zzgvk, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhh.zzdi[i - 1]) {
            case 1:
                return new zzdhg();
            case 2:
                return new zza((zzdhh) null);
            case 3:
                return zza((zzdpk) zzgvk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzgvj"});
            case 4:
                return zzgvk;
            case 5:
                zzdpv<zzdhg> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhg.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvk);
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

    public static zzdhg zzata() {
        return zzgvk;
    }

    static {
        zzdob.zza(zzdhg.class, zzgvk);
    }
}
