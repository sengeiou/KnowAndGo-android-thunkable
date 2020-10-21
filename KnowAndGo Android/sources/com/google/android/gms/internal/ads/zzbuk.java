package com.google.android.gms.internal.ads;

public final class zzbuk implements zzdti<zzbtv> {
    private final zzbtv zzfky;

    private zzbuk(zzbtv zzbtv) {
        this.zzfky = zzbtv;
    }

    public static zzbuk zzr(zzbtv zzbtv) {
        return new zzbuk(zzbtv);
    }

    public final /* synthetic */ Object get() {
        zzbtv zzbtv = this.zzfky;
        if (zzbtv != null) {
            return (zzbtv) zzdto.zza(zzbtv, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
