package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfb extends zzdob<zzdfb, zza> implements zzdpm {
    private static volatile zzdpv<zzdfb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfb zzgrs = new zzdfb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdfb() {
    }

    public static final class zza extends zzdob.zza<zzdfb, zza> implements zzdpm {
        private zza() {
            super(zzdfb.zzgrs);
        }

        public final zza zzeb(int i) {
            zzaxw();
            ((zzdfb) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzaq(zzdmr zzdmr) {
            zzaxw();
            ((zzdfb) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdfc zzdfc) {
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

    public static zzdfb zzap(zzdmr zzdmr) throws zzdok {
        return (zzdfb) zzdob.zza(zzgrs, zzdmr);
    }

    public static zza zzapt() {
        return (zza) ((zzdob.zza) zzgrs.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfc.zzdi[i - 1]) {
            case 1:
                return new zzdfb();
            case 2:
                return new zza((zzdfc) null);
            case 3:
                return zza((zzdpk) zzgrs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgrs;
            case 5:
                zzdpv<zzdfb> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfb.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrs);
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
        zzdob.zza(zzdfb.class, zzgrs);
    }
}
