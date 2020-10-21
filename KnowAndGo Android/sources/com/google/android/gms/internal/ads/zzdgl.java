package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgl extends zzdob<zzdgl, zza> implements zzdpm {
    private static volatile zzdpv<zzdgl> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgl zzgtu = new zzdgl();
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.zzhcr;
    private zzdgp zzgtt;

    private zzdgl() {
    }

    public static final class zza extends zzdob.zza<zzdgl, zza> implements zzdpm {
        private zza() {
            super(zzdgl.zzgtu);
        }

        public final zza zzem(int i) {
            zzaxw();
            ((zzdgl) this.zzhhh).setVersion(0);
            return this;
        }

        public final zza zzc(zzdgp zzdgp) {
            zzaxw();
            ((zzdgl) this.zzhhh).zzb(zzdgp);
            return this;
        }

        public final zza zzbl(zzdmr zzdmr) {
            zzaxw();
            ((zzdgl) this.zzhhh).zzw(zzdmr);
            return this;
        }

        /* synthetic */ zza(zzdgm zzdgm) {
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

    public final zzdgp zzarj() {
        return this.zzgtt == null ? zzdgp.zzarr() : this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdgp zzdgp) {
        if (zzdgp != null) {
            this.zzgtt = zzdgp;
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

    public static zzdgl zzbk(zzdmr zzdmr) throws zzdok {
        return (zzdgl) zzdob.zza(zzgtu, zzdmr);
    }

    public static zza zzark() {
        return (zza) ((zzdob.zza) zzgtu.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgm.zzdi[i - 1]) {
            case 1:
                return new zzdgl();
            case 2:
                return new zza((zzdgm) null);
            case 3:
                return zza((zzdpk) zzgtu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgtt", "zzgqs"});
            case 4:
                return zzgtu;
            case 5:
                zzdpv<zzdgl> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgl.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgtu);
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

    public static zzdgl zzarl() {
        return zzgtu;
    }

    static {
        zzdob.zza(zzdgl.class, zzgtu);
    }
}
