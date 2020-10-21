package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzmi extends Thread {
    private final /* synthetic */ AudioTrack zzahd;
    private final /* synthetic */ zzmh zzaxb;

    zzmi(zzmh zzmh, AudioTrack audioTrack) {
        this.zzaxb = zzmh;
        this.zzahd = audioTrack;
    }

    public final void run() {
        try {
            this.zzahd.flush();
            this.zzahd.release();
        } finally {
            this.zzaxb.zzagd.open();
        }
    }
}
