package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdap;
import com.google.android.gms.internal.ads.zzdob;

public final class zzdau extends zzdob<zzdau, zza> implements zzdpm {
    private static volatile zzdpv<zzdau> zzdv;
    /* access modifiers changed from: private */
    public static final zzdau zzgoq = new zzdau();
    private int zzdj;
    private String zzdk = "";
    private int zzgon;
    private String zzgoo = "";
    private zzdap zzgop;

    public enum zzb implements zzdoe {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzdof<zzb> zzeg = null;
        private final int value;

        public final int zzac() {
            return this.value;
        }

        public static zzb zzdt(int i) {
            switch (i) {
                case 0:
                    return EVENT_TYPE_UNKNOWN;
                case 1:
                    return BLOCKED_IMPRESSION;
                default:
                    return null;
            }
        }

        public static zzdog zzad() {
            return zzdax.zzei;
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            zzeg = new zzdaw();
        }
    }

    private zzdau() {
    }

    public static final class zza extends zzdob.zza<zzdau, zza> implements zzdpm {
        private zza() {
            super(zzdau.zzgoq);
        }

        public final zza zzb(zzb zzb) {
            zzaxw();
            ((zzdau) this.zzhhh).zza(zzb);
            return this;
        }

        public final zza zzge(String str) {
            zzaxw();
            ((zzdau) this.zzhhh).zzi(str);
            return this;
        }

        public final zza zzb(zzdap.zzb zzb) {
            zzaxw();
            ((zzdau) this.zzhhh).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdav zzdav) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzdj |= 1;
            this.zzgon = zzb2.zzac();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzi(String str) {
        if (str != null) {
            this.zzdj |= 2;
            this.zzdk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zza(zzdap.zzb zzb2) {
        this.zzgop = (zzdap) ((zzdob) zzb2.zzaya());
        this.zzdj |= 8;
    }

    public static zza zzank() {
        return (zza) ((zzdob.zza) zzgoq.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdav.zzdi[i - 1]) {
            case 1:
                return new zzdau();
            case 2:
                return new zza((zzdav) null);
            case 3:
                return zza((zzdpk) zzgoq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdj", "zzgon", zzb.zzad(), "zzdk", "zzgoo", "zzgop"});
            case 4:
                return zzgoq;
            case 5:
                zzdpv<zzdau> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdau.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgoq);
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
        zzdob.zza(zzdau.class, zzgoq);
    }
}
