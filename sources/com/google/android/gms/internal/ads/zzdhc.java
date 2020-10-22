package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdhc extends zzdob<zzdhc, zza> implements zzdpm {
    private static volatile zzdpv<zzdhc> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhc zzgvf = new zzdhc();
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzgve = zzaxs();

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzgvg = new zzb();
        private String zzgtz = "";
        private int zzguq;
        private int zzgvb;
        private int zzgvc;

        private zzb() {
        }

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvg);
            }

            public final zza zzgq(String str) {
                zzaxw();
                ((zzb) this.zzhhh).zzgj(str);
                return this;
            }

            public final zza zzc(zzdgu zzdgu) {
                zzaxw();
                ((zzb) this.zzhhh).zza(zzdgu);
                return this;
            }

            public final zza zzew(int i) {
                zzaxw();
                ((zzb) this.zzhhh).zzet(i);
                return this;
            }

            public final zza zzc(zzdhm zzdhm) {
                zzaxw();
                ((zzb) this.zzhhh).zza(zzdhm);
                return this;
            }

            /* synthetic */ zza(zzdhd zzdhd) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzgj(String str) {
            if (str != null) {
                this.zzgtz = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzdgu zzdgu) {
            if (zzdgu != null) {
                this.zzgvb = zzdgu.zzac();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzet(int i) {
            this.zzgvc = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdhm zzdhm) {
            if (zzdhm != null) {
                this.zzguq = zzdhm.zzac();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzasu() {
            return (zza) ((zzdob.zza) zzgvg.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdhd.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzdhd) null);
                case 3:
                    return zza((zzdpk) zzgvg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgtz", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvg;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzgvg);
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
            zzdob.zza(zzb.class, zzgvg);
        }
    }

    private zzdhc() {
    }

    public static final class zza extends zzdob.zza<zzdhc, zza> implements zzdpm {
        private zza() {
            super(zzdhc.zzgvf);
        }

        public final zza zzev(int i) {
            zzaxw();
            ((zzdhc) this.zzhhh).zzer(i);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzaxw();
            ((zzdhc) this.zzhhh).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdhd zzdhd) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzer(int i) {
        this.zzgux = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            if (!this.zzgve.zzavi()) {
                zzdoj<zzb> zzdoj = this.zzgve;
                int size = zzdoj.size();
                this.zzgve = zzdoj.zzfl(size == 0 ? 10 : size << 1);
            }
            this.zzgve.add(zzb2);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzass() {
        return (zza) ((zzdob.zza) zzgvf.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhd.zzdi[i - 1]) {
            case 1:
                return new zzdhc();
            case 2:
                return new zza((zzdhd) null);
            case 3:
                return zza((zzdpk) zzgvf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzgve", zzb.class});
            case 4:
                return zzgvf;
            case 5:
                zzdpv<zzdhc> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdhc.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzgvf);
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
        zzdob.zza(zzdhc.class, zzgvf);
    }
}
