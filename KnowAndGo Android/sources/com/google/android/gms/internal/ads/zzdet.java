package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdet extends zzdob<zzdet, zza> implements zzdpm {
    private static volatile zzdpv<zzdet> zzdv;
    /* access modifiers changed from: private */
    public static final zzdet zzgro = new zzdet();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;

    private zzdet() {
    }

    public static final class zza extends zzdob.zza<zzdet, zza> implements zzdpm {
        private zza() {
            super(zzdet.zzgro);
        }

        public final zza zzdz(int i) {
            zzaxw();
            ((zzdet) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzak(zzdmr zzdmr) {
            zzaxw();
            ((zzdet) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdeu zzdeu) {
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

    public static zzdet zzaj(zzdmr zzdmr) throws zzdok {
        return (zzdet) zzdob.zza(zzgro, zzdmr);
    }

    public static zza zzapn() {
        return (zza) ((zzdob.zza) zzgro.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdeu.zzdi[i - 1]) {
            case 1:
                return new zzdet();
            case 2:
                return new zza((zzdeu) null);
            case 3:
                return zza((zzdpk) zzgro, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgro;
            case 5:
                zzdpv<zzdet> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdet.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgro);
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
        zzdob.zza(zzdet.class, zzgro);
    }
}
