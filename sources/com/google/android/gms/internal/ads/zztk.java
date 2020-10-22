package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;

@TargetApi(23)
final class zztk implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzth zzbpc;

    private zztk(zzth zzth, MediaCodec mediaCodec) {
        this.zzbpc = zzth;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        if (this == this.zzbpc.zzboy) {
            this.zzbpc.zzkj();
        }
    }
}
