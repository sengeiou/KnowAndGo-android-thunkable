package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

public final class zzdgy extends zzdob<zzdgy, zza> implements zzdpm {
    private static volatile zzdpv<zzdgy> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgy zzguw = new zzdgy();
    private String zzgtz = "";
    private String zzgus = "";
    private int zzgut;
    private boolean zzguu;
    private String zzguv = "";

    private zzdgy() {
    }

    public static final class zza extends zzdob.zza<zzdgy, zza> implements zzdpm {
        private zza() {
            super(zzdgy.zzguw);
        }

        public final zza zzgn(String str) {
            zzaxw();
            ((zzdgy) this.zzhhh).zzgl(str);
            return this;
        }

        public final zza zzgo(String str) {
            zzaxw();
            ((zzdgy) this.zzhhh).zzgj(str);
            return this;
        }

        public final zza zzeq(int i) {
            zzaxw();
            ((zzdgy) this.zzhhh).zzep(0);
            return this;
        }

        public final zza zzbe(boolean z) {
            zzaxw();
            ((zzdgy) this.zzhhh).zzbd(true);
            return this;
        }

        public final zza zzgp(String str) {
            zzaxw();
            ((zzdgy) this.zzhhh).zzgm(str);
            return this;
        }

        /* synthetic */ zza(zzdgz zzdgz) {
            this();
        }
    }

    public final String zzasb() {
        return this.zzgus;
    }

    /* access modifiers changed from: private */
    public final void zzgl(String str) {
        if (str != null) {
            this.zzgus = str;
            return;
        }
        throw new NullPointerException();
    }

    public final String zzart() {
        return this.zzgtz;
    }

    /* access modifiers changed from: private */
    public final void zzgj(String str) {
        if (str != null) {
            this.zzgtz = str;
            return;
        }
        throw new NullPointerException();
    }

    public final int zzasc() {
        return this.zzgut;
    }

    /* access modifiers changed from: private */
    public final void zzep(int i) {
        this.zzgut = i;
    }

    public final boolean zzasd() {
        return this.zzguu;
    }

    /* access modifiers changed from: private */
    public final void zzbd(boolean z) {
        this.zzguu = z;
    }

    public final String zzase() {
        return this.zzguv;
    }

    /* access modifiers changed from: private */
    public final void zzgm(String str) {
        if (str != null) {
            this.zzguv = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzasf() {
        return (zza) ((zzdob.zza) zzguw.zza(zzdob.zze.zzhho, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgz.zzdi[i - 1]) {
            case 1:
                return new zzdgy();
            case 2:
                return new zza((zzdgz) null);
            case 3:
                return zza((zzdpk) zzguw, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzgus", "zzgtz", "zzgut", "zzguu", "zzguv"});
            case 4:
                return zzguw;
            case 5:
                zzdpv<zzdgy> zzdpv = zzdv;
                if (zzdpv == null) {
                    synchronized (zzdgy.class) {
                        zzdpv = zzdv;
                        if (zzdpv == null) {
                            zzdpv = new zzdob.zzb<>(zzguw);
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
        zzdob.zza(zzdgy.class, zzguw);
    }
}
