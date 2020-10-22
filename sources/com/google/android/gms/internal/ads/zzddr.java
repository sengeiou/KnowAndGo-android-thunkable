package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzddr extends zzdob<zzddr, zza> implements zzdpm {
    private static volatile zzdpv<zzddr> zzdv;
    /* access modifiers changed from: private */
    public static final zzddr zzgqn = new zzddr();
    private int zzgqk;
    private zzdeb zzgql;
    private zzdgl zzgqm;

    private zzddr() {
    }

    public static final class zza extends zzdob.zza<zzddr, zza> implements zzdpm {
        private zza() {
            super(zzddr.zzgqn);
        }

        public final zza zzdu(int i) {
            zzaxw();
            ((zzddr) this.zzhhh).setVersion(i);
            return this;
        }

        public final zza zzb(zzdeb zzdeb) {
            zzaxw();
            ((zzddr) this.zzhhh).zza(zzdeb);
            return this;
        }

        public final zza zzb(zzdgl zzdgl) {
            zzaxw();
            ((zzddr) this.zzhhh).zza(zzdgl);
            return this;
        }

        /* synthetic */ zza(zzdds zzdds) {
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

    public final zzdeb zzaoa() {
        return this.zzgql == null ? zzdeb.zzaou() : this.zzgql;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdeb zzdeb) {
        if (zzdeb != null) {
            this.zzgql = zzdeb;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdgl zzaob() {
        return this.zzgqm == null ? zzdgl.zzarl() : this.zzgqm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdgl zzdgl) {
        if (zzdgl != null) {
            this.zzgqm = zzdgl;
            return;
        }
        throw new NullPointerException();
    }

    public static zzddr zzu(zzdmr zzdmr) throws zzdok {
        return (zzddr) zzdob.zza(zzgqn, zzdmr);
    }

    public static zza zzaoc() {
        return (zza) ((zzdob.zza) zzgqn.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdds.zzdi[i - 1]) {
            case 1:
                return new zzddr();
            case 2:
                return new zza((zzdds) null);
            case 3:
                return zza((zzdpk) zzgqn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzgqk", "zzgql", "zzgqm"});
            case 4:
                return zzgqn;
            case 5:
                zzdpv<zzddr> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzddr.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgqn);
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
        zzdob.zza(zzddr.class, zzgqn);
    }
}
