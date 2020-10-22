package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzaaj extends zzaah {
    private final MuteThisAdListener zzcip;

    public zzaaj(MuteThisAdListener muteThisAdListener) {
        this.zzcip = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.zzcip.onAdMuted();
    }
}
