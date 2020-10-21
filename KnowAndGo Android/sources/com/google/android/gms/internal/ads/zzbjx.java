package com.google.android.gms.internal.ads;

public final class zzbjx implements zzdti<zzbai> {
    private final zzbjn zzeof;

    public zzbjx(zzbjn zzbjn) {
        this.zzeof = zzbjn;
    }

    public static zzbai zzb(zzbjn zzbjn) {
        return (zzbai) zzdto.zza(zzbjn.zzacq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzeof);
    }
}
