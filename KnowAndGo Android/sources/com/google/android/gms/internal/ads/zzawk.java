package com.google.android.gms.internal.ads;

import android.os.Bundle;

@zzard
final class zzawk {
    private long zzdte = -1;
    private long zzdtf = -1;
    private final /* synthetic */ zzawj zzdtg;

    public zzawk(zzawj zzawj) {
        this.zzdtg = zzawj;
    }

    public final long zzun() {
        return this.zzdtf;
    }

    public final void zzuo() {
        this.zzdtf = this.zzdtg.zzbsa.elapsedRealtime();
    }

    public final void zzup() {
        this.zzdte = this.zzdtg.zzbsa.elapsedRealtime();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzdte);
        bundle.putLong("tclose", this.zzdtf);
        return bundle;
    }
}
