package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdhk extends zzdob<zzdhk, zza> implements zzdpm {
    private static volatile zzdpv<zzdhk> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhk zzgvp = new zzdhk();
    private String zzgvn = "";
    private zzdgw zzgvo;

    private zzdhk() {
    }

    public static final class zza extends zzdob.zza<zzdhk, zza> implements zzdpm {
        private zza() {
            super(zzdhk.zzgvp);
        }

        /* synthetic */ zza(zzdhl zzdhl) {
            this();
        }
    }

    public final String zzatf() {
        return this.zzgvn;
    }

    public final zzdgw zzatg() {
        return this.zzgvo == null ? zzdgw.zzarz() : this.zzgvo;
    }

    public static zzdhk zzbs(zzdmr zzdmr) throws zzdok {
        return (zzdhk) zzdob.zza(zzgvp, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhl.zzdi[i - 1]) {
            case 1:
                return new zzdhk();
            case 2:
                return new zza((zzdhl) null);
            case 3:
                return zza((zzdpk) zzgvp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzgvn", "zzgvo"});
            case 4:
                return zzgvp;
            case 5:
                zzdpv<zzdhk> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhk.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvp);
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

    public static zzdhk zzath() {
        return zzgvp;
    }

    static {
        zzdob.zza(zzdhk.class, zzgvp);
    }
}
