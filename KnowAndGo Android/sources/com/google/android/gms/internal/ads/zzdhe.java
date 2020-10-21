package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdhe extends zzdob<zzdhe, zza> implements zzdpm {
    private static volatile zzdpv<zzdhe> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhe zzgvi = new zzdhe();
    private int zzgqk;
    private zzdhg zzgvh;

    private zzdhe() {
    }

    public static final class zza extends zzdob.zza<zzdhe, zza> implements zzdpm {
        private zza() {
            super(zzdhe.zzgvi);
        }

        public final zza zzex(int i) {
            zzaxw();
            ((zzdhe) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzb(zzdhg zzdhg) {
            zzaxw();
            ((zzdhe) this.zzhhh).zza(zzdhg);
            return this;
        }

        /* synthetic */ zza(zzdhf zzdhf) {
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

    public final zzdhg zzasw() {
        return this.zzgvh == null ? zzdhg.zzata() : this.zzgvh;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdhg zzdhg) {
        if (zzdhg != null) {
            this.zzgvh = zzdhg;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdhe zzbp(zzdmr zzdmr) throws zzdok {
        return (zzdhe) zzdob.zza(zzgvi, zzdmr);
    }

    public static zza zzasx() {
        return (zza) ((zzdob.zza) zzgvi.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhf.zzdi[i - 1]) {
            case 1:
                return new zzdhe();
            case 2:
                return new zza((zzdhf) null);
            case 3:
                return zza((zzdpk) zzgvi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgqk", "zzgvh"});
            case 4:
                return zzgvi;
            case 5:
                zzdpv<zzdhe> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhe.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvi);
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
        zzdob.zza(zzdhe.class, zzgvi);
    }
}
