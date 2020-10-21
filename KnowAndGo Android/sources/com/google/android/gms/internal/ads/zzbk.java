package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzbk {

    public static final class zza extends zzdob<zza, C4377zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzdy = new zza();
        private int zzdj;
        private zzb zzdw;
        private zzc zzdx;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbk$zza$zza  reason: collision with other inner class name */
        public static final class C4377zza extends zzdob.zza<zza, C4377zza> implements zzdpm {
            private C4377zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C4377zza(zzbl zzbl) {
                this();
            }
        }

        public final boolean zzu() {
            return (this.zzdj & 1) == 1;
        }

        public final zzb zzv() {
            return this.zzdw == null ? zzb.zzaa() : this.zzdw;
        }

        public final boolean zzw() {
            return (this.zzdj & 2) == 2;
        }

        public final zzc zzx() {
            return this.zzdx == null ? zzc.zzag() : this.zzdx;
        }

        public static zza zza(byte[] bArr, zzdno zzdno) throws zzdok {
            return (zza) zzdob.zza(zzdy, bArr, zzdno);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbl.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C4377zza((zzbl) null);
                case 3:
                    return zza((zzdpk) zzdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzdw", "zzdx"});
                case 4:
                    return zzdy;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzdy);
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
            zzdob.zza(zza.class, zzdy);
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzea = new zzb();
        private int zzdj;
        private int zzdz = 2;

        private zzb() {
        }

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzea);
            }

            /* synthetic */ zza(zzbl zzbl) {
                this();
            }
        }

        public final zzbm zzz() {
            zzbm zze = zzbm.zze(this.zzdz);
            return zze == null ? zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD : zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbl.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbl) null);
                case 3:
                    return zza((zzdpk) zzea, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdj", "zzdz", zzbm.zzad()});
                case 4:
                    return zzea;
                case 5:
                    zzdpv<zzb> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzb.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzea);
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

        public static zzb zzaa() {
            return zzea;
        }

        static {
            zzdob.zza(zzb.class, zzea);
        }
    }

    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static volatile zzdpv<zzc> zzdv;
        /* access modifiers changed from: private */
        public static final zzc zzep = new zzc();
        private int zzdj;
        private String zzej = "";
        private String zzek = "";
        private String zzel = "";
        private String zzem = "";
        private String zzen = "";
        private String zzeo = "";

        private zzc() {
        }

        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzep);
            }

            /* synthetic */ zza(zzbl zzbl) {
                this();
            }
        }

        public final String zzae() {
            return this.zzej;
        }

        public final String zzaf() {
            return this.zzeo;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbl.zzdi[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbl) null);
                case 3:
                    return zza((zzdpk) zzep, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdj", "zzej", "zzek", "zzel", "zzem", "zzen", "zzeo"});
                case 4:
                    return zzep;
                case 5:
                    zzdpv<zzc> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zzc.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzep);
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

        public static zzc zzag() {
            return zzep;
        }

        static {
            zzdob.zza(zzc.class, zzep);
        }
    }
}
