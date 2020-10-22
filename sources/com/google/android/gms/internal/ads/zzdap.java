package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdap extends zzdob<zzdap, zzb> implements zzdpm {
    private static volatile zzdpv<zzdap> zzdv;
    private static final zzdoi<Integer, zza> zzgof = new zzdaq();
    /* access modifiers changed from: private */
    public static final zzdap zzgoj = new zzdap();
    private int zzdj;
    private zzdoh zzgoe = zzaxr();
    private String zzgog = "";
    private String zzgoh = "";
    private String zzgoi = "";

    public enum zza implements zzdoe {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzdof<zza> zzeg = null;
        private final int value;

        public final int zzac() {
            return this.value;
        }

        public static zza zzds(int i) {
            switch (i) {
                case 1:
                    return BLOCKED_REASON_UNKNOWN;
                case 2:
                    return BLOCKED_REASON_BACKGROUND;
                default:
                    return null;
            }
        }

        public static zzdog zzad() {
            return zzdat.zzei;
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            zzeg = new zzdas();
        }
    }

    private zzdap() {
    }

    public static final class zzb extends zzdob.zza<zzdap, zzb> implements zzdpm {
        private zzb() {
            super(zzdap.zzgoj);
        }

        public final zzb zzb(zza zza) {
            zzaxw();
            ((zzdap) this.zzhhh).zza(zza);
            return this;
        }

        public final zzb zzgd(String str) {
            zzaxw();
            ((zzdap) this.zzhhh).zzgc(str);
            return this;
        }

        /* synthetic */ zzb(zzdaq zzdaq) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        if (zza2 != null) {
            if (!this.zzgoe.zzavi()) {
                zzdoh zzdoh = this.zzgoe;
                int size = zzdoh.size();
                this.zzgoe = zzdoh.zzgo(size == 0 ? 10 : size << 1);
            }
            this.zzgoe.zzgp(zza2.zzac());
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzgc(String str) {
        if (str != null) {
            this.zzdj |= 1;
            this.zzgog = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zzb zzani() {
        return (zzb) ((zzdob.zza) zzgoj.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdar.zzdi[i - 1]) {
            case 1:
                return new zzdap();
            case 2:
                return new zzb((zzdaq) null);
            case 3:
                return zza((zzdpk) zzgoj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdj", "zzgoe", zza.zzad(), "zzgog", "zzgoh", "zzgoi"});
            case 4:
                return zzgoj;
            case 5:
                zzdpv<zzdap> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdap.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgoj);
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
        zzdob.zza(zzdap.class, zzgoj);
    }
}
