package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdig extends zzdob<zzdig, zza> implements zzdpm {
    private static volatile zzdpv<zzdig> zzdv;
    /* access modifiers changed from: private */
    public static final zzdig zzgwz = new zzdig();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdig() {
    }

    public static final class zza extends zzdob.zza<zzdig, zza> implements zzdpm {
        private zza() {
            super(zzdig.zzgwz);
        }

        public final zza zzfe(int i) {
            zzaxw();
            ((zzdig) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzcy(zzdmr zzdmr) {
            zzaxw();
            ((zzdig) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdih zzdih) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzgqk;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgqk = i;
    }

    public final zzdmr zzaoi() {
        return this.zzgqs;
    }

    /* access modifiers changed from: private */
    public final void zzw(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgqs = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdig zzcx(zzdmr zzdmr) throws zzdok {
        return (zzdig) zzdob.zza(zzgwz, zzdmr);
    }

    public static zza zzaus() {
        return (zza) ((zzdob.zza) zzgwz.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdih.zzdi[i - 1]) {
            case 1:
                return new zzdig();
            case 2:
                return new zza((zzdih) null);
            case 3:
                return zza((zzdpk) zzgwz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgwz;
            case 5:
                zzdpv<zzdig> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdig.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgwz);
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
        zzdob.zza(zzdig.class, zzgwz);
    }
}
