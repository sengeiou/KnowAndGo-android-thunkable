package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final class zzcao implements zzbam<zzp, Bitmap> {
    private final /* synthetic */ double zzfqt;
    private final /* synthetic */ boolean zzfqu;
    private final /* synthetic */ zzcan zzfqv;

    zzcao(zzcan zzcan, double d, boolean z) {
        this.zzfqv = zzcan;
        this.zzfqt = d;
        this.zzfqu = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzfqv.zza(((zzp) obj).data, this.zzfqt, this.zzfqu);
    }
}
