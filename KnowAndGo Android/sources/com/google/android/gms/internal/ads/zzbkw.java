package com.google.android.gms.internal.ads;

@zzard
public class zzbkw {
    private zza zzfec;

    public static abstract class zza {
        public abstract zzbgd zzacu();

        public abstract zzbcp zzacv();

        public abstract zzwo zzacw();

        public abstract zzavd zzacx();
    }

    public zzbkw(zza zza2) {
        this.zzfec = zza2;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzauw, com.google.android.gms.internal.ads.zzavc] */
    public final com.google.android.gms.ads.internal.zza zzaeo() {
        zza zza2 = this.zzfec;
        return new com.google.android.gms.ads.internal.zza(zza2.zzacu(), zza2.zzacv(), new zzauw(zza2.zzacx()), zza2.zzacw());
    }

    public final zzavd zzacx() {
        return this.zzfec.zzacx();
    }
}
