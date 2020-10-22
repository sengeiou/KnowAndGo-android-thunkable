package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdev extends zzdob<zzdev, zza> implements zzdpm {
    private static volatile zzdpv<zzdev> zzdv;
    /* access modifiers changed from: private */
    public static final zzdev zzgrp = new zzdev();
    private int zzgqu;

    private zzdev() {
    }

    public static final class zza extends zzdob.zza<zzdev, zza> implements zzdpm {
        private zza() {
            super(zzdev.zzgrp);
        }

        /* synthetic */ zza(zzdew zzdew) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzgqu;
    }

    public static zzdev zzal(zzdmr zzdmr) throws zzdok {
        return (zzdev) zzdob.zza(zzgrp, zzdmr);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdew.zzdi[i - 1]) {
            case 1:
                return new zzdev();
            case 2:
                return new zza((zzdew) null);
            case 3:
                return zza((zzdpk) zzgrp, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzgqu"});
            case 4:
                return zzgrp;
            case 5:
                zzdpv<zzdev> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdev.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgrp);
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
        zzdob.zza(zzdev.class, zzgrp);
    }
}
