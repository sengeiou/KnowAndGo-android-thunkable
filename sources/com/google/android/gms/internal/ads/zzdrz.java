package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdrz {

    public static final class zza extends zzdob<zza, C4381zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzhoq = new zza();
        private int zzdj;
        private int zzhoj;
        private zzb zzhok;
        private zzdmr zzhol = zzdmr.zzhcr;
        private zzdmr zzhom = zzdmr.zzhcr;
        private boolean zzhon;
        private boolean zzhoo;
        private byte zzhop = 2;

        public static final class zzb extends zzdob<zzb, C4382zza> implements zzdpm {
            private static volatile zzdpv<zzb> zzdv;
            /* access modifiers changed from: private */
            public static final zzb zzhov = new zzb();
            private int zzdj;
            private String zzhor = "";
            private String zzhos = "";
            private String zzhot = "";
            private int zzhou;

            private zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zzb$zza */
            public static final class C4382zza extends zzdob.zza<zzb, C4382zza> implements zzdpm {
                private C4382zza() {
                    super(zzb.zzhov);
                }

                /* synthetic */ C4382zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C4382zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhov, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdj", "zzhor", "zzhos", "zzhot", "zzhou"});
                    case 4:
                        return zzhov;
                    case 5:
                        zzdpv<zzb> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzb.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhov);
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
                zzdob.zza(zzb.class, zzhov);
            }
        }

        public enum zzc implements zzdoe {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzdof<zzc> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzc zzhg(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzdsc.zzei;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzdsb();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zza */
        public static final class C4381zza extends zzdob.zza<zza, C4381zza> implements zzdpm {
            private C4381zza() {
                super(zza.zzhoq);
            }

            /* synthetic */ C4381zza(zzdsa zzdsa) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzdsa.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C4381zza((zzdsa) null);
                case 3:
                    return zza((zzdpk) zzhoq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdj", "zzhoj", zzc.zzad(), "zzhok", "zzhol", "zzhom", "zzhon", "zzhoo"});
                case 4:
                    return zzhoq;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzhoq);
                                zzdv = zzdpv;
                            }
                        }
                    }
                    return zzdpv;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhop = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.zza(zza.class, zzhoq);
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzhpr = new zzb();
        private int zzbzi;
        private int zzdj;
        private zzdmr zzhol = zzdmr.zzhcr;
        private byte zzhop = 2;
        private String zzhos = "";
        private int zzhpc;
        private String zzhpd = "";
        private String zzhpe = "";
        private C4383zzb zzhpf;
        private zzdoj<zzh> zzhpg = zzaxs();
        private String zzhph = "";
        private zzf zzhpi;
        private boolean zzhpj;
        private zzdoj<String> zzhpk = zzdob.zzaxs();
        private String zzhpl = "";
        private boolean zzhpm;
        private boolean zzhpn;
        private zzi zzhpo;
        private zzdoj<String> zzhpp = zzdob.zzaxs();
        private zzdoj<String> zzhpq = zzdob.zzaxs();

        /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb */
        public static final class C4383zzb extends zzdob<C4383zzb, zza> implements zzdpm {
            private static volatile zzdpv<C4383zzb> zzdv;
            /* access modifiers changed from: private */
            public static final C4383zzb zzhpt = new C4383zzb();
            private int zzdj;
            private String zzhps = "";

            private C4383zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb$zza */
            public static final class zza extends zzdob.zza<C4383zzb, zza> implements zzdpm {
                private zza() {
                    super(C4383zzb.zzhpt);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new C4383zzb();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhpt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzhps"});
                    case 4:
                        return zzhpt;
                    case 5:
                        zzdpv<C4383zzb> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (C4383zzb.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhpt);
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
                zzdob.zza(C4383zzb.class, zzhpt);
            }
        }

        public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
            private static volatile zzdpv<zzc> zzdv;
            /* access modifiers changed from: private */
            public static final zzc zzhpv = new zzc();
            private int zzdj;
            private zzdmr zzgua = zzdmr.zzhcr;
            private byte zzhop = 2;
            private zzdmr zzhpu = zzdmr.zzhcr;

            private zzc() {
            }

            public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
                private zza() {
                    super(zzc.zzhpv);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhpv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzhpu", "zzgua"});
                    case 4:
                        return zzhpv;
                    case 5:
                        zzdpv<zzc> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzc.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhpv);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.zza(zzc.class, zzhpv);
            }
        }

        public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
            private static volatile zzdpv<zzd> zzdv;
            /* access modifiers changed from: private */
            public static final zzd zzhqb = new zzd();
            private int zzdj;
            private byte zzhop = 2;
            private C4384zzb zzhpw;
            private zzdoj<zzc> zzhpx = zzaxs();
            private zzdmr zzhpy = zzdmr.zzhcr;
            private zzdmr zzhpz = zzdmr.zzhcr;
            private int zzhqa;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb */
            public static final class C4384zzb extends zzdob<C4384zzb, zza> implements zzdpm {
                private static volatile zzdpv<C4384zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C4384zzb zzhqf = new C4384zzb();
                private int zzdj;
                private zzdmr zzhqc = zzdmr.zzhcr;
                private zzdmr zzhqd = zzdmr.zzhcr;
                private zzdmr zzhqe = zzdmr.zzhcr;

                private C4384zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb$zza */
                public static final class zza extends zzdob.zza<C4384zzb, zza> implements zzdpm {
                    private zza() {
                        super(C4384zzb.zzhqf);
                    }

                    /* synthetic */ zza(zzdsa zzdsa) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzdsa.zzdi[i - 1]) {
                        case 1:
                            return new C4384zzb();
                        case 2:
                            return new zza((zzdsa) null);
                        case 3:
                            return zza((zzdpk) zzhqf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqc", "zzhqd", "zzhqe"});
                        case 4:
                            return zzhqf;
                        case 5:
                            zzdpv<C4384zzb> zzdpv = zzdv;
                            if (zzdpv == null) {
                                synchronized (C4384zzb.class) {
                                    zzdpv = zzdv;
                                    if (zzdpv == null) {
                                        zzdpv = new zzdob.zzb<>(zzhqf);
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
                    zzdob.zza(C4384zzb.class, zzhqf);
                }
            }

            private zzd() {
            }

            public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
                private zza() {
                    super(zzd.zzhqb);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhqb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdj", "zzhpw", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa"});
                    case 4:
                        return zzhqb;
                    case 5:
                        zzdpv<zzd> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzd.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhqb);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.zza(zzd.class, zzhqb);
            }
        }

        public static final class zze extends zzdob<zze, zza> implements zzdpm {
            private static volatile zzdpv<zze> zzdv;
            /* access modifiers changed from: private */
            public static final zze zzhqi = new zze();
            private int zzdj;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = zzaxs();
            private zzdmr zzhpy = zzdmr.zzhcr;
            private zzdmr zzhpz = zzdmr.zzhcr;
            private int zzhqa;
            private C4385zzb zzhqg;
            private zzdmr zzhqh = zzdmr.zzhcr;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb */
            public static final class C4385zzb extends zzdob<C4385zzb, zza> implements zzdpm {
                private static volatile zzdpv<C4385zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C4385zzb zzhql = new C4385zzb();
                private int zzdj;
                private zzdmr zzhqe = zzdmr.zzhcr;
                private int zzhqj;
                private zzdmr zzhqk = zzdmr.zzhcr;

                private C4385zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb$zza */
                public static final class zza extends zzdob.zza<C4385zzb, zza> implements zzdpm {
                    private zza() {
                        super(C4385zzb.zzhql);
                    }

                    /* synthetic */ zza(zzdsa zzdsa) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzdsa.zzdi[i - 1]) {
                        case 1:
                            return new C4385zzb();
                        case 2:
                            return new zza((zzdsa) null);
                        case 3:
                            return zza((zzdpk) zzhql, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqj", "zzhqk", "zzhqe"});
                        case 4:
                            return zzhql;
                        case 5:
                            zzdpv<C4385zzb> zzdpv = zzdv;
                            if (zzdpv == null) {
                                synchronized (C4385zzb.class) {
                                    zzdpv = zzdv;
                                    if (zzdpv == null) {
                                        zzdpv = new zzdob.zzb<>(zzhql);
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
                    zzdob.zza(C4385zzb.class, zzhql);
                }
            }

            private zze() {
            }

            public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
                private zza() {
                    super(zze.zzhqi);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhqi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdj", "zzhqg", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa", "zzhqh"});
                    case 4:
                        return zzhqi;
                    case 5:
                        zzdpv<zze> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zze.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhqi);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.zza(zze.class, zzhqi);
            }
        }

        public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
            private static volatile zzdpv<zzf> zzdv;
            /* access modifiers changed from: private */
            public static final zzf zzhqo = new zzf();
            private int zzbzi;
            private int zzdj;
            private String zzhqm = "";
            private zzdmr zzhqn = zzdmr.zzhcr;

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzf$zzb */
            public enum C4386zzb implements zzdoe {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzdof<C4386zzb> zzeg = null;
                private final int value;

                public final int zzac() {
                    return this.value;
                }

                public static C4386zzb zzhh(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static zzdog zzad() {
                    return zzdse.zzei;
                }

                private C4386zzb(int i) {
                    this.value = i;
                }

                static {
                    zzeg = new zzdsd();
                }
            }

            private zzf() {
            }

            public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
                private zza() {
                    super(zzf.zzhqo);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhqo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzbzi", C4386zzb.zzad(), "zzhqm", "zzhqn"});
                    case 4:
                        return zzhqo;
                    case 5:
                        zzdpv<zzf> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzf.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhqo);
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
                zzdob.zza(zzf.class, zzhqo);
            }
        }

        public enum zzg implements zzdoe {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzdof<zzg> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            public static zzg zzhi(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzdog zzad() {
                return zzdsg.zzei;
            }

            private zzg(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzdsf();
            }
        }

        public static final class zzh extends zzdob<zzh, C4387zzb> implements zzdpm {
            private static volatile zzdpv<zzh> zzdv;
            /* access modifiers changed from: private */
            public static final zzh zzhrl = new zzh();
            private int zzdj;
            private byte zzhop = 2;
            private String zzhos = "";
            private int zzhrd;
            private zzd zzhre;
            private zze zzhrf;
            private int zzhrg;
            private zzdoh zzhrh = zzaxr();
            private String zzhri = "";
            private int zzhrj;
            private zzdoj<String> zzhrk = zzdob.zzaxs();

            public enum zza implements zzdoe {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzdof<zza> zzeg = null;
                private final int value;

                public final int zzac() {
                    return this.value;
                }

                public static zza zzhj(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static zzdog zzad() {
                    return zzdsi.zzei;
                }

                private zza(int i) {
                    this.value = i;
                }

                static {
                    zzeg = new zzdsh();
                }
            }

            private zzh() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzh$zzb */
            public static final class C4387zzb extends zzdob.zza<zzh, C4387zzb> implements zzdpm {
                private C4387zzb() {
                    super(zzh.zzhrl);
                }

                /* synthetic */ C4387zzb(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C4387zzb((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhrl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdj", "zzhrd", "zzhos", "zzhre", "zzhrf", "zzhrg", "zzhrh", "zzhri", "zzhrj", zza.zzad(), "zzhrk"});
                    case 4:
                        return zzhrl;
                    case 5:
                        zzdpv<zzh> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzh.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhrl);
                                    zzdv = zzdpv;
                                }
                            }
                        }
                        return zzdpv;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhop = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzdob.zza(zzh.class, zzhrl);
            }
        }

        public static final class zzi extends zzdob<zzi, zza> implements zzdpm {
            private static volatile zzdpv<zzi> zzdv;
            /* access modifiers changed from: private */
            public static final zzi zzhru = new zzi();
            private int zzdj;
            private String zzhrr = "";
            private long zzhrs;
            private boolean zzhrt;

            private zzi() {
            }

            public static final class zza extends zzdob.zza<zzi, zza> implements zzdpm {
                private zza() {
                    super(zzi.zzhru);
                }

                /* synthetic */ zza(zzdsa zzdsa) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzdsa.zzdi[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza((zzdsa) null);
                    case 3:
                        return zza((zzdpk) zzhru, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdj", "zzhrr", "zzhrs", "zzhrt"});
                    case 4:
                        return zzhru;
                    case 5:
                        zzdpv<zzi> zzdpv = zzdv;
                        if (zzdpv == null) {
                            synchronized (zzi.class) {
                                zzdpv = zzdv;
                                if (zzdpv == null) {
                                    zzdpv = new zzdob.zzb<>(zzhru);
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
                zzdob.zza(zzi.class, zzhru);
            }
        }

        private zzb() {
        }

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzhpr);
            }

            /* synthetic */ zza(zzdsa zzdsa) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzdsa.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzdsa) null);
                case 3:
                    return zza((zzdpk) zzhpr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdj", "zzhos", "zzhpd", "zzhpe", "zzhpg", zzh.class, "zzhpj", "zzhpk", "zzhpl", "zzhpm", "zzhpn", "zzbzi", zzg.zzad(), "zzhpc", zza.zzc.zzad(), "zzhpf", "zzhph", "zzhpi", "zzhol", "zzhpo", "zzhpp", "zzhpq"});
                case 4:
                    return zzhpr;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzhpr);
                                zzdv = zzdpv;
                            }
                        }
                    }
                    return zzdpv;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhop = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.zza(zzb.class, zzhpr);
        }
    }
}
