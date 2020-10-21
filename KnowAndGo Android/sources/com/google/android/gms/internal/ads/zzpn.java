package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
final class zzpn implements zzpl {
    private final int zzaes;
    private MediaCodecInfo[] zzaet;

    public zzpn(boolean z) {
        this.zzaes = z ? 1 : 0;
    }

    public final boolean zzeh() {
        return true;
    }

    public final int getCodecCount() {
        zzei();
        return this.zzaet.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzei();
        return this.zzaet[i];
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void zzei() {
        if (this.zzaet == null) {
            this.zzaet = new MediaCodecList(this.zzaes).getCodecInfos();
        }
    }
}
