package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdeb extends zzdob<zzdeb, zza> implements zzdpm {
    private static volatile zzdpv<zzdeb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdeb zzgrc = new zzdeb();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdef zzgrb;

    private zzdeb() {
    }

    public static final class zza extends zzdob.zza<zzdeb, zza> implements zzdpm {
        private zza() {
            super(zzdeb.zzgrc);
        }

        public final zza zzdw(int i) {
            zzaxw();
            ((zzdeb) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzc(zzdef zzdef) {
            zzaxw();
            ((zzdeb) this.zzhhh).zzb(zzdef);
            return this;
        }

        public final zza zzab(zzdmr zzdmr) {
            zzaxw();
            ((zzdeb) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdec zzdec) {
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

    public final zzdef zzaos() {
        return this.zzgrb == null ? zzdef.zzaoz() : this.zzgrb;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdef zzdef) {
        if (zzdef != null) {
            this.zzgrb = zzdef;
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

    public static zzdeb zzaa(zzdmr zzdmr) throws zzdok {
        return (zzdeb) zzdob.zza(zzgrc, zzdmr);
    }

    public static zza zzaot() {
        return (zza) ((zzdob.zza) zzgrc.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdec.zzdi[i - 1]) {
            case 1:
                return new zzdeb();
            case 2:
                return new zza((zzdec) null);
            case 3:
                return zza((zzdpk) zzgrc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrb", "zzgqs"});
            case 4:
                return zzgrc;
            case 5:
                zzdpv<zzdeb> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdeb.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrc);
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

    public static zzdeb zzaou() {
        return zzgrc;
    }

    static {
        zzdob.zza(zzdeb.class, zzgrc);
    }
}
