package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzadg {
    private final long time;
    @Nullable
    private final String zzcxm;
    @Nullable
    private final zzadg zzcxn;

    public zzadg(long j, @Nullable String str, @Nullable zzadg zzadg) {
        this.time = j;
        this.zzcxm = str;
        this.zzcxn = zzadg;
    }

    public final long getTime() {
        return this.time;
    }

    public final String zzqu() {
        return this.zzcxm;
    }

    @Nullable
    public final zzadg zzqv() {
        return this.zzcxn;
    }
}
