package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgr extends zzdob<zzdgr, zza> implements zzdpm {
    private static volatile zzdpv<zzdgr> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgr zzguc = new zzdgr();
    private String zzgtz = "";
    private zzdmr zzgua = zzdmr.zzhcr;
    private int zzgub;

    public enum zzb implements zzdoe {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzdof<zzb> zzeg = null;
        private final int value;

        public final int zzac() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zzb zzen(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            zzeg = new zzdgt();
        }
    }

    private zzdgr() {
    }

    public static final class zza extends zzdob.zza<zzdgr, zza> implements zzdpm {
        private zza() {
            super(zzdgr.zzguc);
        }

        public final zza zzgk(String str) {
            zzaxw();
            ((zzdgr) this.zzhhh).zzgj(str);
            return this;
        }

        public final zza zzbo(zzdmr zzdmr) {
            zzaxw();
            ((zzdgr) this.zzhhh).zzbn(zzdmr);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzaxw();
            ((zzdgr) this.zzhhh).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdgs zzdgs) {
            this();
        }
    }

    public final String zzart() {
        return this.zzgtz;
    }

    /* access modifiers changed from: private */
    public final void zzgj(String str) {
        if (str != null) {
            this.zzgtz = str;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdmr zzaru() {
        return this.zzgua;
    }

    /* access modifiers changed from: private */
    public final void zzbn(zzdmr zzdmr) {
        if (zzdmr != null) {
            this.zzgua = zzdmr;
            return;
        }
        throw new NullPointerException();
    }

    public final zzb zzarv() {
        zzb zzen = zzb.zzen(this.zzgub);
        return zzen == null ? zzb.UNRECOGNIZED : zzen;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzgub = zzb2.zzac();
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzarw() {
        return (zza) ((zzdob.zza) zzguc.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgs.zzdi[i - 1]) {
            case 1:
                return new zzdgr();
            case 2:
                return new zza((zzdgs) null);
            case 3:
                return zza((zzdpk) zzguc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzgub"});
            case 4:
                return zzguc;
            case 5:
                zzdpv<zzdgr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzguc);
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

    public static zzdgr zzarx() {
        return zzguc;
    }

    static {
        zzdob.zza(zzdgr.class, zzguc);
    }
}
