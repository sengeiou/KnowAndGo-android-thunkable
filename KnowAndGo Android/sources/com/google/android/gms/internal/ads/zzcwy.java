package com.google.android.gms.internal.ads;

public final class zzcwy implements zzdti<String> {
    private final zzcwx zzgjo;

    public zzcwy(zzcwx zzcwx) {
        this.zzgjo = zzcwx;
    }

    public static String zzb(zzcwx zzcwx) {
        return (String) zzdto.zza(zzcwx.zzamc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzgjo);
    }
}
