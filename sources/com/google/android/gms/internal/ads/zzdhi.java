package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdhi extends zzdob<zzdhi, zza> implements zzdpm {
    private static volatile zzdpv<zzdhi> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhi zzgvm = new zzdhi();
    private int zzgqk;
    private zzdhk zzgvl;

    private zzdhi() {
    }

    public static final class zza extends zzdob.zza<zzdhi, zza> implements zzdpm {
        private zza() {
            super(zzdhi.zzgvm);
        }

        public final zza zzey(int i) {
            zzaxw();
            ((zzdhi) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzb(zzdhk zzdhk) {
            zzaxw();
            ((zzdhi) this.zzhhh).zza(zzdhk);
            return this;
        }

        /* synthetic */ zza(zzdhj zzdhj) {
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

    public final zzdhk zzatc() {
        return this.zzgvl == null ? zzdhk.zzath() : this.zzgvl;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdhk zzdhk) {
        if (zzdhk != null) {
            this.zzgvl = zzdhk;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdhi zzbr(zzdmr zzdmr) throws zzdok {
        return (zzdhi) zzdob.zza(zzgvm, zzdmr);
    }

    public static zza zzatd() {
        return (zza) ((zzdob.zza) zzgvm.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhj.zzdi[i - 1]) {
            case 1:
                return new zzdhi();
            case 2:
                return new zza((zzdhj) null);
            case 3:
                return zza((zzdpk) zzgvm, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvl"});
            case 4:
                return zzgvm;
            case 5:
                zzdpv<zzdhi> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhi.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvm);
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
        zzdob.zza(zzdhi.class, zzgvm);
    }
}
