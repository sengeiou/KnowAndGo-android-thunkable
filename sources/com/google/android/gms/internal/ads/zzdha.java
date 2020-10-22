package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.List;

public final class zzdha extends zzdob<zzdha, zza> implements zzdpm {
    private static volatile zzdpv<zzdha> zzdv;
    /* access modifiers changed from: private */
    public static final zzdha zzguz = new zzdha();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzguy = zzaxs();

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzgvd = new zzb();
        private int zzguq;
        private zzdgr zzgva;
        private int zzgvb;
        private int zzgvc;

        private zzb() {
        }

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvd);
            }

            public final zza zzb(zzdgr zzdgr) {
                zzaxw();
                ((zzb) this.zzhhh).zza(zzdgr);
                return this;
            }

            public final zza zzb(zzdgu zzdgu) {
                zzaxw();
                ((zzb) this.zzhhh).zza(zzdgu);
                return this;
            }

            public final zza zzeu(int i) {
                zzaxw();
                ((zzb) this.zzhhh).zzet(i);
                return this;
            }

            public final zza zzb(zzdhm zzdhm) {
                zzaxw();
                ((zzb) this.zzhhh).zza(zzdhm);
                return this;
            }

            /* synthetic */ zza(zzdhb zzdhb) {
                this();
            }
        }

        public final boolean zzasm() {
            return this.zzgva != null;
        }

        public final zzdgr zzasn() {
            return this.zzgva == null ? zzdgr.zzarx() : this.zzgva;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdgr zzdgr) {
            if (zzdgr != null) {
                this.zzgva = zzdgr;
                return;
            }
            throw new NullPointerException();
        }

        public final zzdgu zzaso() {
            zzdgu zzeo = zzdgu.zzeo(this.zzgvb);
            return zzeo == null ? zzdgu.UNRECOGNIZED : zzeo;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdgu zzdgu) {
            if (zzdgu != null) {
                this.zzgvb = zzdgu.zzac();
                return;
            }
            throw new NullPointerException();
        }

        public final int zzasp() {
            return this.zzgvc;
        }

        /* access modifiers changed from: private */
        public final void zzet(int i) {
            this.zzgvc = i;
        }

        public final zzdhm zzanw() {
            zzdhm zzez = zzdhm.zzez(this.zzguq);
            return zzez == null ? zzdhm.UNRECOGNIZED : zzez;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdhm zzdhm) {
            if (zzdhm != null) {
                this.zzguq = zzdhm.zzac();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzasq() {
            return (zza) ((zzdob.zza) zzgvd.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdhb.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzdhb) null);
                case 3:
                    return zza((zzdpk) zzgvd, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgva", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvd;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzgvd);
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
            zzdob.zza(zzb.class, zzgvd);
        }
    }

    private zzdha() {
    }

    public static final class zza extends zzdob.zza<zzdha, zza> implements zzdpm {
        private zza() {
            super(zzdha.zzguz);
        }

        public final zza zzes(int i) {
            zzaxw();
            ((zzdha) this.zzhhh).zzer(i);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzaxw();
            ((zzdha) this.zzhhh).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdhb zzdhb) {
            this();
        }
    }

    public final int zzash() {
        return this.zzgux;
    }

    /* access modifiers changed from: private */
    public final void zzer(int i) {
        this.zzgux = i;
    }

    public final List<zzb> zzasi() {
        return this.zzguy;
    }

    public final int zzasj() {
        return this.zzguy.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            if (!this.zzguy.zzavi()) {
                zzdoj<zzb> zzdoj = this.zzguy;
                int size = zzdoj.size();
                this.zzguy = zzdoj.zzfl(size == 0 ? 10 : size << 1);
            }
            this.zzguy.add(zzb2);
            return;
        }
        throw new NullPointerException();
    }

    public static zzdha zzn(byte[] bArr) throws zzdok {
        return (zzdha) zzdob.zza(zzguz, bArr);
    }

    public static zza zzask() {
        return (zza) ((zzdob.zza) zzguz.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhb.zzdi[i - 1]) {
            case 1:
                return new zzdha();
            case 2:
                return new zza((zzdhb) null);
            case 3:
                return zza((zzdpk) zzguz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzguy", zzb.class});
            case 4:
                return zzguz;
            case 5:
                zzdpv<zzdha> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdha.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzguz);
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
        zzdob.zza(zzdha.class, zzguz);
    }
}
