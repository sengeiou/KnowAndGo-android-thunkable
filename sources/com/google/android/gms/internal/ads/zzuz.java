package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzuz {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbvu;

    @VisibleForTesting
    public zzuz(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbvu = i;
    }

    /* access modifiers changed from: package-private */
    public final float zzna() {
        return this.left;
    }

    /* access modifiers changed from: package-private */
    public final float zznb() {
        return this.top;
    }

    /* access modifiers changed from: package-private */
    public final float zznc() {
        return this.right;
    }

    /* access modifiers changed from: package-private */
    public final float zznd() {
        return this.bottom;
    }

    /* access modifiers changed from: package-private */
    public final int zzne() {
        return this.zzbvu;
    }
}
