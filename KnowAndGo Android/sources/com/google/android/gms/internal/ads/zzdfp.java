package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdfp extends zzdob<zzdfp, zza> implements zzdpm {
    private static volatile zzdpv<zzdfp> zzdv;
    /* access modifiers changed from: private */
    public static final zzdfp zzgsq = new zzdfp();
    private zzdgw zzgsp;

    private zzdfp() {
    }

    public static final class zza extends zzdob.zza<zzdfp, zza> implements zzdpm {
        private zza() {
            super(zzdfp.zzgsq);
        }

        /* synthetic */ zza(zzdfq zzdfq) {
            this();
        }
    }

    public final zzdgw zzaqk() {
        return this.zzgsp == null ? zzdgw.zzarz() : this.zzgsp;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdfq.zzdi[i - 1]) {
            case 1:
                return new zzdfp();
            case 2:
                return new zza((zzdfq) null);
            case 3:
                return zza((zzdpk) zzgsq, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgsp"});
            case 4:
                return zzgsq;
            case 5:
                zzdpv<zzdfp> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdfp.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgsq);
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

    public static zzdfp zzaql() {
        return zzgsq;
    }

    static {
        zzdob.zza(zzdfp.class, zzgsq);
    }
}
