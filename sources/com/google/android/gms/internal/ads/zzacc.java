package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

public final class zzacc extends zzaav {
    private final VideoController.VideoLifecycleCallbacks zzaaw;

    public zzacc(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzaaw = videoLifecycleCallbacks;
    }

    public final void onVideoStart() {
        this.zzaaw.onVideoStart();
    }

    public final void onVideoPlay() {
        this.zzaaw.onVideoPlay();
    }

    public final void onVideoPause() {
        this.zzaaw.onVideoPause();
    }

    public final void onVideoEnd() {
        this.zzaaw.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.zzaaw.onVideoMute(z);
    }
}
