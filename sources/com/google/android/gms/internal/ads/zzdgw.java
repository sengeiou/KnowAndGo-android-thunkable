package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgw extends zzdob<zzdgw, zza> implements zzdpm {
    private static volatile zzdpv<zzdgw> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgw zzgur = new zzdgw();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.zzhcr;
    private int zzguq;

    private zzdgw() {
    }

    public static final class zza extends zzdob.zza<zzdgw, zza> implements zzdpm {
        private zza() {
            super(zzdgw.zzgur);
        }

        /* synthetic */ zza(zzdgx zzdgx) {
            this();
        }
    }

    public final String zzart() {
        return this.zzgtz;
    }

    public final zzdmr zzaru() {
        return this.zzgua;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgx.zzdi[i - 1]) {
            case 1:
                return new zzdgw();
            case 2:
                return new zza((zzdgx) null);
            case 3:
                return zza((zzdpk) zzgur, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzguq"});
            case 4:
                return zzgur;
            case 5:
                zzdpv<zzdgw> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgw.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgur);
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

    public static zzdgw zzarz() {
        return zzgur;
    }

    static {
        zzdob.zza(zzdgw.class, zzgur);
    }
}
