package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgh extends zzdob<zzdgh, zza> implements zzdpm {
    private static volatile zzdpv<zzdgh> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgh zzgtm = new zzdgh();

    private zzdgh() {
    }

    public static final class zza extends zzdob.zza<zzdgh, zza> implements zzdpm {
        private zza() {
            super(zzdgh.zzgtm);
        }

        /* synthetic */ zza(zzdgi zzdgi) {
            this();
        }
    }

    public static zzdgh zzbj(zzdmr zzdmr) throws zzdok {
        return (zzdgh) zzdob.zza(zzgtm, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgi.zzdi[i - 1]) {
            case 1:
                return new zzdgh();
            case 2:
                return new zza((zzdgi) null);
            case 3:
                return zza((zzdpk) zzgtm, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzgtm;
            case 5:
                zzdpv<zzdgh> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgh.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgtm);
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
        zzdob.zza(zzdgh.class, zzgtm);
    }
}
