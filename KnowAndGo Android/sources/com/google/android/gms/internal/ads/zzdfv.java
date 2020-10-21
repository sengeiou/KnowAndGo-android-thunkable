package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfv extends zzdob<zzdfv, zza> implements zzdpm {
    private static volatile zzdpv<zzdfv> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfv zzgsy = new zzdfv();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdfx zzgsx;

    private zzdfv() {
    }

    public static final class zza extends zzdob.zza<zzdfv, zza> implements zzdpm {
        private zza() {
            super(zzdfv.zzgsy);
        }

        public final zza zzeg(int i) {
            zzaxw();
            ((zzdfv) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzb(zzdfx zzdfx) {
            zzaxw();
            ((zzdfv) this.zzhhh).zza(zzdfx);
            return this;
        }

        public final zza zzbb(zzdmr zzdmr) {
            zzaxw();
            ((zzdfv) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdfw zzdfw) {
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

    public final zzdfx zzaqu() {
        return this.zzgsx == null ? zzdfx.zzaqy() : this.zzgsx;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdfx zzdfx) {
        if (zzdfx != null) {
            this.zzgsx = zzdfx;
            return;
        }
        throw new NullPointerException();
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

    public static zzdfv zzba(zzdmr zzdmr) throws zzdok {
        return (zzdfv) zzdob.zza(zzgsy, zzdmr);
    }

    public static zza zzaqv() {
        return (zza) ((zzdob.zza) zzgsy.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfw.zzdi[i - 1]) {
            case 1:
                return new zzdfv();
            case 2:
                return new zza((zzdfw) null);
            case 3:
                return zza((zzdpk) zzgsy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgsx", "zzgqs"});
            case 4:
                return zzgsy;
            case 5:
                zzdpv<zzdfv> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfv.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgsy);
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
        zzdob.zza(zzdfv.class, zzgsy);
    }
}
