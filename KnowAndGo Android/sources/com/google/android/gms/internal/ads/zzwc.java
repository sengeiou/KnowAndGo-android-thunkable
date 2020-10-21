package com.google.android.gms.internal.ads;

import java.io.InputStream;

final class zzwc extends zzbbr<InputStream> {
    private final /* synthetic */ zzwb zzbxa;

    zzwc(zzwb zzwb) {
        this.zzbxa = zzwb;
    }

    public final boolean cancel(boolean z) {
        this.zzbxa.disconnect();
        return super.cancel(z);
    }
}
