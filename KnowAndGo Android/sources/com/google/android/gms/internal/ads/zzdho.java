package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.List;

public final class zzdho extends zzdob<zzdho, zza> implements zzdpm {
    private static volatile zzdpv<zzdho> zzdv;
    /* access modifiers changed from: private */
    public static final zzdho zzgvz = new zzdho();
    private int zzdj;
    private String zzgvx = "";
    private zzdoj<zzdgy> zzgvy = zzaxs();

    private zzdho() {
    }

    public static final class zza extends zzdob.zza<zzdho, zza> implements zzdpm {
        private zza() {
            super(zzdho.zzgvz);
        }

        public final zza zzgs(String str) {
            zzaxw();
            ((zzdho) this.zzhhh).zzgr(str);
            return this;
        }

        public final zza zzb(zzdgy zzdgy) {
            zzaxw();
            ((zzdho) this.zzhhh).zza(zzdgy);
            return this;
        }

        /* synthetic */ zza(zzdhp zzdhp) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzgr(String str) {
        if (str != null) {
            this.zzgvx = str;
            return;
        }
        throw new NullPointerException();
    }

    public final List<zzdgy> zzatj() {
        return this.zzgvy;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdgy zzdgy) {
        if (zzdgy != null) {
            if (!this.zzgvy.zzavi()) {
                zzdoj<zzdgy> zzdoj = this.zzgvy;
                int size = zzdoj.size();
                this.zzgvy = zzdoj.zzfl(size == 0 ? 10 : size << 1);
            }
            this.zzgvy.add(zzdgy);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzatk() {
        return (zza) ((zzdob.zza) zzgvz.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhp.zzdi[i - 1]) {
            case 1:
                return new zzdho();
            case 2:
                return new zza((zzdhp) null);
            case 3:
                return zza((zzdpk) zzgvz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzdj", "zzgvx", "zzgvy", zzdgy.class});
            case 4:
                return zzgvz;
            case 5:
                zzdpv<zzdho> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdho.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvz);
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
        zzdob.zza(zzdho.class, zzgvz);
    }
}
