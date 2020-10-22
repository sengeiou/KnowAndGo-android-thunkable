package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzddt extends zzdob<zzddt, zza> implements zzdpm {
    private static volatile zzdpv<zzddt> zzdv;
    /* access modifiers changed from: private */
    public static final zzddt zzgqq = new zzddt();
    private zzded zzgqo;
    private zzdgn zzgqp;

    private zzddt() {
    }

    public static final class zza extends zzdob.zza<zzddt, zza> implements zzdpm {
        private zza() {
            super(zzddt.zzgqq);
        }

        /* synthetic */ zza(zzddu zzddu) {
            this();
        }
    }

    public final zzded zzaoe() {
        return this.zzgqo == null ? zzded.zzaow() : this.zzgqo;
    }

    public final zzdgn zzaof() {
        return this.zzgqp == null ? zzdgn.zzarn() : this.zzgqp;
    }

    public static zzddt zzv(zzdmr zzdmr) throws zzdok {
        return (zzddt) zzdob.zza(zzgqq, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzddu.zzdi[i - 1]) {
            case 1:
                return new zzddt();
            case 2:
                return new zza((zzddu) null);
            case 3:
                return zza((zzdpk) zzgqq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzgqo", "zzgqp"});
            case 4:
                return zzgqq;
            case 5:
                zzdpv<zzddt> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzddt.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgqq);
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
        zzdob.zza(zzddt.class, zzgqq);
    }
}
