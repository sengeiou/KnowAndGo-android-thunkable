package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfx extends zzdob<zzdfx, zza> implements zzdpm {
    private static volatile zzdpv<zzdfx> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfx zzgsz = new zzdfx();
    private int zzgqk;
    private zzdmr zzgsh = zzdmr.zzhcr;
    private zzdmr zzgsi = zzdmr.zzhcr;
    private zzdft zzgsr;

    private zzdfx() {
    }

    public static final class zza extends zzdob.zza<zzdfx, zza> implements zzdpm {
        private zza() {
            super(zzdfx.zzgsz);
        }

        public final zza zzeh(int i) {
            zzaxw();
            ((zzdfx) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzc(zzdft zzdft) {
            zzaxw();
            ((zzdfx) this.zzhhh).zzb(zzdft);
            return this;
        }

        public final zza zzbd(zzdmr zzdmr) {
            zzaxw();
            ((zzdfx) this.zzhhh).zzau(zzdmr);
            return this;
        }

        public final zza zzbe(zzdmr zzdmr) {
            zzaxw();
            ((zzdfx) this.zzhhh).zzav(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdfy zzdfy) {
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

    public final zzdft zzaqn() {
        return this.zzgsr == null ? zzdft.zzaqs() : this.zzgsr;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdft zzdft) {
        if (zzdft != null) {
            this.zzgsr = zzdft;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdmr zzaqf() {
        return this.zzgsh;
    }

    /* access modifiers changed from: private */
    public final void zzau(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgsh = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdmr zzaqg() {
        return this.zzgsi;
    }

    /* access modifiers changed from: private */
    public final void zzav(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgsi = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdfx zzbc(zzdmr zzdmr) throws zzdok {
        return (zzdfx) zzdob.zza(zzgsz, zzdmr);
    }

    public static zza zzaqx() {
        return (zza) ((zzdob.zza) zzgsz.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfy.zzdi[i - 1]) {
            case 1:
                return new zzdfx();
            case 2:
                return new zza((zzdfy) null);
            case 3:
                return zza((zzdpk) zzgsz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzgqk", "zzgsr", "zzgsh", "zzgsi"});
            case 4:
                return zzgsz;
            case 5:
                zzdpv<zzdfx> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfx.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgsz);
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

    public static zzdfx zzaqy() {
        return zzgsz;
    }

    static {
        zzdob.zza(zzdfx.class, zzgsz);
    }
}
