package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzbi {

    public static final class zza extends zzdob<zza, C4376zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zza zzdu = new zza();
        private static volatile zzdpv<zza> zzdv;
        private int zzdj;
        private String zzdk = "";
        private long zzdl;
        private String zzdm = "";
        private String zzdn = "";
        private String zzdo = "";
        private long zzdp;
        private long zzdq;
        private String zzdr = "";
        private long zzds;
        private String zzdt = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbi$zza$zza  reason: collision with other inner class name */
        public static final class C4376zza extends zzdob.zza<zza, C4376zza> implements zzdpm {
            private C4376zza() {
                super(zza.zzdu);
            }

            public final C4376zza zzl(String str) {
                zzaxw();
                ((zza) this.zzhhh).zzi(str);
                return this;
            }

            public final C4376zza zzd(long j) {
                zzaxw();
                ((zza) this.zzhhh).zzc(j);
                return this;
            }

            public final C4376zza zzm(String str) {
                zzaxw();
                ((zza) this.zzhhh).zzj(str);
                return this;
            }

            public final C4376zza zzn(String str) {
                zzaxw();
                ((zza) this.zzhhh).zzk(str);
                return this;
            }

            /* synthetic */ C4376zza(zzbj zzbj) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzdj |= 1;
                this.zzdk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzdj |= 2;
            this.zzdl = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzdj |= 4;
                this.zzdm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            if (str != null) {
                this.zzdj |= 8;
                this.zzdn = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C4376zza zzs() {
            return (C4376zza) ((zzdob.zza) zzdu.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbj.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C4376zza((zzbj) null);
                case 3:
                    return zza((zzdpk) zzdu, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t", new Object[]{"zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt"});
                case 4:
                    return zzdu;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzdu);
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
            zzdob.zza(zza.class, zzdu);
        }
    }
}
