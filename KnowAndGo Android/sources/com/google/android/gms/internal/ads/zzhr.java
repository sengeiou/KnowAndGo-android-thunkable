package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzhr extends Thread {
    private final /* synthetic */ AudioTrack zzahd;
    private final /* synthetic */ zzhq zzahe;

    zzhr(zzhq zzhq, AudioTrack audioTrack) {
        this.zzahe = zzhq;
        this.zzahd = audioTrack;
    }

    public final void run() {
        try {
            this.zzahd.release();
        } finally {
            this.zzahe.zzagd.open();
        }
    }
}
