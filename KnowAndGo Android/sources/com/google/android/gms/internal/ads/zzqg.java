package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzqg implements zzqw {
    /* access modifiers changed from: private */
    public final int track;
    private final /* synthetic */ zzpz zzbis;

    public zzqg(zzpz zzpz, int i) {
        this.zzbis = zzpz;
        this.track = i;
    }

    public final boolean isReady() {
        return this.zzbis.zzbd(this.track);
    }

    public final void zzjb() throws IOException {
        this.zzbis.zzjb();
    }

    public final int zzb(zzlj zzlj, zznd zznd, boolean z) {
        return this.zzbis.zza(this.track, zzlj, zznd, z);
    }

    public final void zzeo(long j) {
        this.zzbis.zzf(this.track, j);
    }
}
