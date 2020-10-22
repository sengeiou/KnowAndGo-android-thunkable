package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbjq implements zzdti<Context> {
    private final zzbjn zzeof;

    public zzbjq(zzbjn zzbjn) {
        this.zzeof = zzbjn;
    }

    public static Context zza(zzbjn zzbjn) {
        return (Context) zzdto.zza(zzbjn.zzaco(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeof);
    }
}
