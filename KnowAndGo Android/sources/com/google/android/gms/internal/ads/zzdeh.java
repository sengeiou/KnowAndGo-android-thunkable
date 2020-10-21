package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdeh extends zzdob<zzdeh, zza> implements zzdpm {
    private static volatile zzdpv<zzdeh> zzdv;
    /* access modifiers changed from: private */
    public static final zzdeh zzgrh = new zzdeh();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdel zzgrg;

    private zzdeh() {
    }

    public static final class zza extends zzdob.zza<zzdeh, zza> implements zzdpm {
        private zza() {
            super(zzdeh.zzgrh);
        }

        public final zza zzdx(int i) {
            zzaxw();
            ((zzdeh) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzb(zzdel zzdel) {
            zzaxw();
            ((zzdeh) this.zzhhh).zza(zzdel);
            return this;
        }

        public final zza zzae(zzdmr zzdmr) {
            zzaxw();
            ((zzdeh) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdei zzdei) {
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

    public final zzdel zzapb() {
        return this.zzgrg == null ? zzdel.zzapf() : this.zzgrg;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdel zzdel) {
        if (zzdel != null) {
            this.zzgrg = zzdel;
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

    public static zzdeh zzad(zzdmr zzdmr) throws zzdok {
        return (zzdeh) zzdob.zza(zzgrh, zzdmr);
    }

    public static zza zzapc() {
        return (zza) ((zzdob.zza) zzgrh.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdei.zzdi[i - 1]) {
            case 1:
                return new zzdeh();
            case 2:
                return new zza((zzdei) null);
            case 3:
                return zza((zzdpk) zzgrh, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrg", "zzgqs"});
            case 4:
                return zzgrh;
            case 5:
                zzdpv<zzdeh> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdeh.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrh);
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
        zzdob.zza(zzdeh.class, zzgrh);
    }
}
