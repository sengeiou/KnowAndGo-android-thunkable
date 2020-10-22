package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
final class zznb {
    private final MediaCodec.CryptoInfo zzabn;
    private final MediaCodec.CryptoInfo.Pattern zzayz;

    private zznb(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzabn = cryptoInfo;
        this.zzayz = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzayz.set(i, i2);
        this.zzabn.setPattern(this.zzayz);
    }
}
