package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzwt {

    public static final class zza extends zzdob<zza, zzb> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zza zzbzk = new zza();
        private static volatile zzdpv<zza> zzdv;
        private int zzbzi;
        private zzl zzbzj;
        private int zzdj;

        /* renamed from: com.google.android.gms.internal.ads.zzwt$zza$zza */
        public enum C4389zza implements zzdoe {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);
            
            private static final zzdof<C4389zza> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static C4389zza zzbz(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzww.zzei;
            }

            private C4389zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzwv();
            }
        }

        private zza() {
        }

        public static final class zzb extends zzdob.zza<zza, zzb> implements zzdpm {
            private zzb() {
                super(zza.zzbzk);
            }

            /* synthetic */ zzb(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzwu) null);
                case 3:
                    return zza((zzdpk) zzbzk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbzi", C4389zza.zzad(), "zzbzj"});
                case 4:
                    return zzbzk;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzbzk);
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
            zzdob.zza(zza.class, zzbzk);
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzb zzcaa = new zzb();
        private static volatile zzdpv<zzb> zzdv;
        private String zzbzx = "";
        private zzdoj<zza> zzbzy = zzaxs();
        private int zzbzz;
        private int zzdj;

        private zzb() {
        }

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzcaa);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcaa, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdj", "zzbzx", "zzbzy", zza.class, "zzbzz", zzwx.zzad()});
                case 4:
                    return zzcaa;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcaa);
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
            zzdob.zza(zzb.class, zzcaa);
        }
    }

    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzc zzcah = new zzc();
        private static volatile zzdpv<zzc> zzdv;
        private int zzcab;
        private zzn zzcac;
        private zzn zzcad;
        private zzn zzcae;
        private zzdoj<zzn> zzcaf = zzaxs();
        private int zzcag;
        private int zzdj;

        private zzc() {
        }

        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzcah);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcah, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdj", "zzcab", "zzcac", "zzcad", "zzcae", "zzcaf", zzn.class, "zzcag"});
                case 4:
                    return zzcah;
                case 5:
                    zzdpv<zzc> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzc.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcah);
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
            zzdob.zza(zzc.class, zzcah);
        }
    }

    public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzd zzcaq = new zzd();
        private static volatile zzdpv<zzd> zzdv;
        private String zzcam = "";
        private int zzcan;
        private zzdoh zzcao = zzaxr();
        private zzn zzcap;
        private int zzdj;

        private zzd() {
        }

        public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
            private zza() {
                super(zzd.zzcaq);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcaq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.zzad(), "zzcao", "zzcap"});
                case 4:
                    return zzcaq;
                case 5:
                    zzdpv<zzd> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzd.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcaq);
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
            zzdob.zza(zzd.class, zzcaq);
        }
    }

    public static final class zze extends zzdob<zze, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zze zzcas = new zze();
        private static volatile zzdpv<zze> zzdv;
        private zzdoh zzcao = zzaxr();
        private int zzcar;
        private int zzdj;

        private zze() {
        }

        public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
            private zza() {
                super(zze.zzcas);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcas, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcao"});
                case 4:
                    return zzcas;
                case 5:
                    zzdpv<zze> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zze.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcas);
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
            zzdob.zza(zze.class, zzcas);
        }
    }

    public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzf zzcav = new zzf();
        private static volatile zzdpv<zzf> zzdv;
        private zzn zzcap;
        private int zzcar;
        private zzd zzcat;
        private zzdoj<zzm> zzcau = zzaxs();
        private int zzdj;

        private zzf() {
        }

        public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
            private zza() {
                super(zzf.zzcav);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcav, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdj", "zzcat", "zzcau", zzm.class, "zzcar", zzwx.zzad(), "zzcap"});
                case 4:
                    return zzcav;
                case 5:
                    zzdpv<zzf> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzf.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcav);
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
            zzdob.zza(zzf.class, zzcav);
        }
    }

    public static final class zzg extends zzdob<zzg, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzg zzcax = new zzg();
        private static volatile zzdpv<zzg> zzdv;
        private int zzbzi;
        private int zzcaw;
        private int zzdj;

        public enum zzb implements zzdoe {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);
            
            private static final zzdof<zzb> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzb zzcb(int i) {
                if (i == 4) {
                    return LTE;
                }
                switch (i) {
                    case 0:
                        return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    case 1:
                        return TWO_G;
                    case 2:
                        return THREE_G;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzxb.zzei;
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzxa();
            }
        }

        public enum zzc implements zzdoe {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);
            
            private static final zzdof<zzc> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzc zzcc(int i) {
                switch (i) {
                    case 0:
                        return NETWORKTYPE_UNSPECIFIED;
                    case 1:
                        return CELL;
                    case 2:
                        return WIFI;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzxd.zzei;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzxc();
            }
        }

        private zzg() {
        }

        public static final class zza extends zzdob.zza<zzg, zza> implements zzdpm {
            private zza() {
                super(zzg.zzcax);
            }

            public final zza zzb(zzc zzc) {
                zzaxw();
                ((zzg) this.zzhhh).zza(zzc);
                return this;
            }

            public final zza zzb(zzb zzb) {
                zzaxw();
                ((zzg) this.zzhhh).zza(zzb);
                return this;
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            if (zzc2 != null) {
                this.zzdj |= 1;
                this.zzbzi = zzc2.zzac();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzb zzb2) {
            if (zzb2 != null) {
                this.zzdj |= 2;
                this.zzcaw = zzb2.zzac();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zznv() {
            return (zza) ((zzdob.zza) zzcax.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcax, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdj", "zzbzi", zzc.zzad(), "zzcaw", zzb.zzad()});
                case 4:
                    return zzcax;
                case 5:
                    zzdpv<zzg> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzg.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcax);
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
            zzdob.zza(zzg.class, zzcax);
        }
    }

    public static final class zzh extends zzdob<zzh, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzh zzcbj = new zzh();
        private static volatile zzdpv<zzh> zzdv;
        private int zzcbh;
        private zzn zzcbi;
        private int zzdj;

        private zzh() {
        }

        public static final class zza extends zzdob.zza<zzh, zza> implements zzdpm {
            private zza() {
                super(zzh.zzcbj);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcbj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcbh", zzwx.zzad(), "zzcbi"});
                case 4:
                    return zzcbj;
                case 5:
                    zzdpv<zzh> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzh.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcbj);
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
            zzdob.zza(zzh.class, zzcbj);
        }
    }

    public static final class zzi extends zzdob<zzi, zzb> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzi zzcbq = new zzi();
        private static volatile zzdpv<zzi> zzdv;
        private zzdoj<zza> zzcbk = zzaxs();
        private int zzcbl;
        private int zzcbm;
        private long zzcbn;
        private String zzcbo = "";
        private long zzcbp;
        private int zzdj;
        private String zzdk = "";

        public static final class zza extends zzdob<zza, C4390zza> implements zzdpm {
            private static final zzdoi<Integer, zza.C4389zza> zzcbw = new zzxe();
            /* access modifiers changed from: private */
            public static final zza zzcce = new zza();
            private static volatile zzdpv<zza> zzdv;
            private long zzcbr;
            private int zzcbs;
            private long zzcbt;
            private long zzcbu;
            private zzdoh zzcbv = zzaxr();
            private zzg zzcbx;
            private int zzcby;
            private int zzcbz;
            private int zzcca;
            private int zzccb;
            private int zzccc;
            private int zzccd;
            private int zzdj;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzwt$zzi$zza$zza */
            public static final class C4390zza extends zzdob.zza<zza, C4390zza> implements zzdpm {
                private C4390zza() {
                    super(zza.zzcce);
                }

                public final C4390zza zzew(long j) {
                    zzaxw();
                    ((zza) this.zzhhh).setTimestamp(j);
                    return this;
                }

                public final C4390zza zzf(zzwx zzwx) {
                    zzaxw();
                    ((zza) this.zzhhh).zza(zzwx);
                    return this;
                }

                public final C4390zza zzex(long j) {
                    zzaxw();
                    ((zza) this.zzhhh).zzeu(j);
                    return this;
                }

                public final C4390zza zzey(long j) {
                    zzaxw();
                    ((zza) this.zzhhh).zzev(j);
                    return this;
                }

                public final C4390zza zzc(Iterable<? extends zza.C4389zza> iterable) {
                    zzaxw();
                    ((zza) this.zzhhh).zzb(iterable);
                    return this;
                }

                public final C4390zza zzb(zzg zzg) {
                    zzaxw();
                    ((zza) this.zzhhh).zza(zzg);
                    return this;
                }

                public final C4390zza zzg(zzwx zzwx) {
                    zzaxw();
                    ((zza) this.zzhhh).zzb(zzwx);
                    return this;
                }

                public final C4390zza zzh(zzwx zzwx) {
                    zzaxw();
                    ((zza) this.zzhhh).zzc(zzwx);
                    return this;
                }

                public final C4390zza zzi(zzwx zzwx) {
                    zzaxw();
                    ((zza) this.zzhhh).zzd(zzwx);
                    return this;
                }

                public final C4390zza zzcg(int i) {
                    zzaxw();
                    ((zza) this.zzhhh).zzcf(i);
                    return this;
                }

                public final C4390zza zzj(zzwx zzwx) {
                    zzaxw();
                    ((zza) this.zzhhh).zze(zzwx);
                    return this;
                }

                public final C4390zza zzb(zzc zzc) {
                    zzaxw();
                    ((zza) this.zzhhh).zza(zzc);
                    return this;
                }

                /* synthetic */ C4390zza(zzwu zzwu) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void setTimestamp(long j) {
                this.zzdj |= 1;
                this.zzcbr = j;
            }

            /* access modifiers changed from: private */
            public final void zza(zzwx zzwx) {
                if (zzwx != null) {
                    this.zzdj |= 2;
                    this.zzcbs = zzwx.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzeu(long j) {
                this.zzdj |= 4;
                this.zzcbt = j;
            }

            /* access modifiers changed from: private */
            public final void zzev(long j) {
                this.zzdj |= 8;
                this.zzcbu = j;
            }

            /* access modifiers changed from: private */
            public final void zzb(Iterable<? extends zza.C4389zza> iterable) {
                if (!this.zzcbv.zzavi()) {
                    zzdoh zzdoh = this.zzcbv;
                    int size = zzdoh.size();
                    this.zzcbv = zzdoh.zzgo(size == 0 ? 10 : size << 1);
                }
                for (zza.C4389zza zzac : iterable) {
                    this.zzcbv.zzgp(zzac.zzac());
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zzg zzg) {
                if (zzg != null) {
                    this.zzcbx = zzg;
                    this.zzdj |= 16;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzb(zzwx zzwx) {
                if (zzwx != null) {
                    this.zzdj |= 32;
                    this.zzcby = zzwx.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzc(zzwx zzwx) {
                if (zzwx != null) {
                    this.zzdj |= 64;
                    this.zzcbz = zzwx.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzd(zzwx zzwx) {
                if (zzwx != null) {
                    this.zzdj |= 128;
                    this.zzcca = zzwx.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzcf(int i) {
                this.zzdj |= 256;
                this.zzccb = i;
            }

            /* access modifiers changed from: private */
            public final void zze(zzwx zzwx) {
                if (zzwx != null) {
                    this.zzdj |= 512;
                    this.zzccc = zzwx.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                if (zzc != null) {
                    this.zzdj |= 1024;
                    this.zzccd = zzc.zzac();
                    return;
                }
                throw new NullPointerException();
            }

            public static zza zzh(byte[] bArr) throws zzdok {
                return (zza) zzdob.zza(zzcce, bArr);
            }

            public static C4390zza zzoa() {
                return (C4390zza) ((zzdob.zza) zzcce.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzwu.zzdi[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C4390zza((zzwu) null);
                    case 3:
                        return zza((zzdpk) zzcce, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdj", "zzcbr", "zzcbs", zzwx.zzad(), "zzcbt", "zzcbu", "zzcbv", zza.C4389zza.zzad(), "zzcbx", "zzcby", zzwx.zzad(), "zzcbz", zzwx.zzad(), "zzcca", zzwx.zzad(), "zzccb", "zzccc", zzwx.zzad(), "zzccd", zzc.zzad()});
                    case 4:
                        return zzcce;
                    case 5:
                        zzdpv<zza> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zza.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzcce);
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
                zzdob.zza(zza.class, zzcce);
            }
        }

        public enum zzc implements zzdoe {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);
            
            private static final zzdof<zzc> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzc zzcj(int i) {
                switch (i) {
                    case 0:
                        return UNSPECIFIED;
                    case 1:
                        return CONNECTING;
                    case 2:
                        return CONNECTED;
                    case 3:
                        return DISCONNECTING;
                    case 4:
                        return DISCONNECTED;
                    case 5:
                        return SUSPENDED;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzxg.zzei;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzxf();
            }
        }

        private zzi() {
        }

        public static final class zzb extends zzdob.zza<zzi, zzb> implements zzdpm {
            private zzb() {
                super(zzi.zzcbq);
            }

            public final zzb zzd(Iterable<? extends zza> iterable) {
                zzaxw();
                ((zzi) this.zzhhh).zza(iterable);
                return this;
            }

            public final zzb zzch(int i) {
                zzaxw();
                ((zzi) this.zzhhh).zzcd(i);
                return this;
            }

            public final zzb zzci(int i) {
                zzaxw();
                ((zzi) this.zzhhh).zzce(i);
                return this;
            }

            public final zzb zzez(long j) {
                zzaxw();
                ((zzi) this.zzhhh).zzet(j);
                return this;
            }

            public final zzb zzbq(String str) {
                zzaxw();
                ((zzi) this.zzhhh).zzi(str);
                return this;
            }

            public final zzb zzbr(String str) {
                zzaxw();
                ((zzi) this.zzhhh).zzbp(str);
                return this;
            }

            /* synthetic */ zzb(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zza> iterable) {
            if (!this.zzcbk.zzavi()) {
                zzdoj<zza> zzdoj = this.zzcbk;
                int size = zzdoj.size();
                this.zzcbk = zzdoj.zzfl(size == 0 ? 10 : size << 1);
            }
            zzdmi.zza(iterable, this.zzcbk);
        }

        /* access modifiers changed from: private */
        public final void zzcd(int i) {
            this.zzdj |= 1;
            this.zzcbl = i;
        }

        /* access modifiers changed from: private */
        public final void zzce(int i) {
            this.zzdj |= 2;
            this.zzcbm = i;
        }

        /* access modifiers changed from: private */
        public final void zzet(long j) {
            this.zzdj |= 4;
            this.zzcbn = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzdj |= 8;
                this.zzdk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzbp(String str) {
            if (str != null) {
                this.zzdj |= 16;
                this.zzcbo = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zzny() {
            return (zzb) ((zzdob.zza) zzcbq.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcbq, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdj", "zzcbk", zza.class, "zzcbl", "zzcbm", "zzcbn", "zzdk", "zzcbo", "zzcbp"});
                case 4:
                    return zzcbq;
                case 5:
                    zzdpv<zzi> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzi.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcbq);
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
            zzdob.zza(zzi.class, zzcbq);
        }
    }

    public static final class zzj extends zzdob<zzj, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzj zzccx = new zzj();
        private static volatile zzdpv<zzj> zzdv;
        private int zzccm = 1000;
        private int zzccn = 1000;
        private int zzcco;
        private int zzccp;
        private int zzccq;
        private int zzccr;
        private int zzccs;
        private int zzcct;
        private int zzccu;
        private int zzccv;
        private zzk zzccw;
        private int zzdj;

        private zzj() {
        }

        public static final class zza extends zzdob.zza<zzj, zza> implements zzdpm {
            private zza() {
                super(zzj.zzccx);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzccx, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdj", "zzccm", zzwx.zzad(), "zzccn", zzwx.zzad(), "zzcco", "zzccp", "zzccq", "zzccr", "zzccs", "zzcct", "zzccu", "zzccv", "zzccw"});
                case 4:
                    return zzccx;
                case 5:
                    zzdpv<zzj> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzj.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzccx);
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
            zzdob.zza(zzj.class, zzccx);
        }
    }

    public static final class zzk extends zzdob<zzk, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzk zzcda = new zzk();
        private static volatile zzdpv<zzk> zzdv;
        private int zzccy;
        private int zzccz;
        private int zzdj;

        private zzk() {
        }

        public static final class zza extends zzdob.zza<zzk, zza> implements zzdpm {
            private zza() {
                super(zzk.zzcda);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzccy", "zzccz"});
                case 4:
                    return zzcda;
                case 5:
                    zzdpv<zzk> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzk.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcda);
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
            zzdob.zza(zzk.class, zzcda);
        }
    }

    public static final class zzl extends zzdob<zzl, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzl zzcdd = new zzl();
        private static volatile zzdpv<zzl> zzdv;
        private int zzcdb;
        private int zzcdc;
        private int zzdj;

        private zzl() {
        }

        public static final class zza extends zzdob.zza<zzl, zza> implements zzdpm {
            private zza() {
                super(zzl.zzcdd);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdb", "zzcdc"});
                case 4:
                    return zzcdd;
                case 5:
                    zzdpv<zzl> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzl.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdd);
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
            zzdob.zza(zzl.class, zzcdd);
        }
    }

    public static final class zzm extends zzdob<zzm, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzm zzcde = new zzm();
        private static volatile zzdpv<zzm> zzdv;
        private String zzcam = "";
        private int zzcan;
        private zzn zzcap;
        private int zzdj;

        private zzm() {
        }

        public static final class zza extends zzdob.zza<zzm, zza> implements zzdpm {
            private zza() {
                super(zzm.zzcde);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcde, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.zzad(), "zzcap"});
                case 4:
                    return zzcde;
                case 5:
                    zzdpv<zzm> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzm.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcde);
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
            zzdob.zza(zzm.class, zzcde);
        }
    }

    public static final class zzn extends zzdob<zzn, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzn zzcdh = new zzn();
        private static volatile zzdpv<zzn> zzdv;
        private int zzcdf;
        private int zzcdg;
        private int zzdj;

        private zzn() {
        }

        public static final class zza extends zzdob.zza<zzn, zza> implements zzdpm {
            private zza() {
                super(zzn.zzcdh);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdf", "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    zzdpv<zzn> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzn.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdh);
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
            zzdob.zza(zzn.class, zzcdh);
        }
    }

    public static final class zzo extends zzdob<zzo, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzo zzcdk = new zzo();
        private static volatile zzdpv<zzo> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzo() {
        }

        public static final class zza extends zzdob.zza<zzo, zza> implements zzdpm {
            private zza() {
                super(zzo.zzcdk);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdk;
                case 5:
                    zzdpv<zzo> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzo.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdk);
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
            zzdob.zza(zzo.class, zzcdk);
        }
    }

    public static final class zzp extends zzdob<zzp, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzp zzcdm = new zzp();
        private static volatile zzdpv<zzp> zzdv;
        private int zzcdl;
        private int zzdj;

        public enum zzb implements zzdoe {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);
            
            private static final zzdof<zzb> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzb zzck(int i) {
                switch (i) {
                    case 0:
                        return VIDEO_ERROR_CODE_UNSPECIFIED;
                    case 1:
                        return OPENGL_RENDERING_FAILED;
                    case 2:
                        return CACHE_LOAD_FAILED;
                    case 3:
                        return ANDROID_TARGET_API_TOO_LOW;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzxi.zzei;
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzxh();
            }
        }

        private zzp() {
        }

        public static final class zza extends zzdob.zza<zzp, zza> implements zzdpm {
            private zza() {
                super(zzp.zzcdm);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdm, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdj", "zzcdl", zzb.zzad()});
                case 4:
                    return zzcdm;
                case 5:
                    zzdpv<zzp> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzp.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdm);
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
            zzdob.zza(zzp.class, zzcdm);
        }
    }

    public static final class zzq extends zzdob<zzq, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzq zzcdv = new zzq();
        private static volatile zzdpv<zzq> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private int zzdj;

        private zzq() {
        }

        public static final class zza extends zzdob.zza<zzq, zza> implements zzdpm {
            private zza() {
                super(zzq.zzcdv);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdv, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcds", "zzcdt", "zzcdu"});
                case 4:
                    return zzcdv;
                case 5:
                    zzdpv<zzq> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzq.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdv);
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
            zzdob.zza(zzq.class, zzcdv);
        }
    }

    public static final class zzr extends zzdob<zzr, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzr zzcdw = new zzr();
        private static volatile zzdpv<zzr> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzr() {
        }

        public static final class zza extends zzdob.zza<zzr, zza> implements zzdpm {
            private zza() {
                super(zzr.zzcdw);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdw;
                case 5:
                    zzdpv<zzr> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzr.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdw);
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
            zzdob.zza(zzr.class, zzcdw);
        }
    }

    public static final class zzs extends zzdob<zzs, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzs zzcdy = new zzs();
        private static volatile zzdpv<zzs> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private long zzcdx;
        private int zzdj;

        private zzs() {
        }

        public static final class zza extends zzdob.zza<zzs, zza> implements zzdpm {
            private zza() {
                super(zzs.zzcdy);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdy, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcds", "zzcdt", "zzcdu", "zzcdx"});
                case 4:
                    return zzcdy;
                case 5:
                    zzdpv<zzs> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzs.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdy);
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
            zzdob.zza(zzs.class, zzcdy);
        }
    }

    public static final class zzt extends zzdob<zzt, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzt zzcdz = new zzt();
        private static volatile zzdpv<zzt> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        private zzt() {
        }

        public static final class zza extends zzdob.zza<zzt, zza> implements zzdpm {
            private zza() {
                super(zzt.zzcdz);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcdz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdz;
                case 5:
                    zzdpv<zzt> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzt.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcdz);
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
            zzdob.zza(zzt.class, zzcdz);
        }
    }

    public static final class zzu extends zzdob<zzu, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzu zzcea = new zzu();
        private static volatile zzdpv<zzu> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzdj;

        private zzu() {
        }

        public static final class zza extends zzdob.zza<zzu, zza> implements zzdpm {
            private zza() {
                super(zzu.zzcea);
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzcea, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcar", zzwx.zzad(), "zzcdi"});
                case 4:
                    return zzcea;
                case 5:
                    zzdpv<zzu> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzu.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzcea);
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
            zzdob.zza(zzu.class, zzcea);
        }
    }

    public static final class zzv extends zzdob<zzv, zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zzv zzced = new zzv();
        private static volatile zzdpv<zzv> zzdv;
        private boolean zzceb;
        private int zzcec;
        private int zzdj;

        private zzv() {
        }

        public static final class zza extends zzdob.zza<zzv, zza> implements zzdpm {
            private zza() {
                super(zzv.zzced);
            }

            public final boolean zzoo() {
                return ((zzv) this.zzhhh).zzoo();
            }

            public final zza zzr(boolean z) {
                zzaxw();
                ((zzv) this.zzhhh).zzq(z);
                return this;
            }

            public final zza zzcm(int i) {
                zzaxw();
                ((zzv) this.zzhhh).zzcl(i);
                return this;
            }

            /* synthetic */ zza(zzwu zzwu) {
                this();
            }
        }

        public final boolean zzoo() {
            return this.zzceb;
        }

        /* access modifiers changed from: private */
        public final void zzq(boolean z) {
            this.zzdj |= 1;
            this.zzceb = z;
        }

        /* access modifiers changed from: private */
        public final void zzcl(int i) {
            this.zzdj |= 2;
            this.zzcec = i;
        }

        public static zza zzop() {
            return (zza) ((zzdob.zza) zzced.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwu.zzdi[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((zzwu) null);
                case 3:
                    return zza((zzdpk) zzced, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzceb", "zzcec"});
                case 4:
                    return zzced;
                case 5:
                    zzdpv<zzv> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzv.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzced);
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
            zzdob.zza(zzv.class, zzced);
        }
    }
}
