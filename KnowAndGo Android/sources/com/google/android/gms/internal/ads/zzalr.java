package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzalr {
    @VisibleForTesting
    private static final zzayp<zzajw> zzddl = new zzals();
    @VisibleForTesting
    private static final zzayp<zzajw> zzddm = new zzalt();
    private final zzakh zzddn;

    public zzalr(Context context, zzbai zzbai, String str) {
        this.zzddn = new zzakh(context, zzbai, str, zzddl, zzddm);
    }

    public final <I, O> zzalj<I, O> zza(String str, zzalm<I> zzalm, zzall<O> zzall) {
        return new zzalu(this.zzddn, str, zzalm, zzall);
    }

    public final zzaly zzsc() {
        return new zzaly(this.zzddn);
    }
}
