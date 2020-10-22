package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class zzht extends zzhs {
    private final AudioTimestamp zzahj = new AudioTimestamp();
    private long zzahk;
    private long zzahl;
    private long zzahm;

    public zzht() {
        super((zzhr) null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzahk = 0;
        this.zzahl = 0;
        this.zzahm = 0;
    }

    public final boolean zzex() {
        boolean timestamp = this.zzagg.getTimestamp(this.zzahj);
        if (timestamp) {
            long j = this.zzahj.framePosition;
            if (this.zzahl > j) {
                this.zzahk++;
            }
            this.zzahl = j;
            this.zzahm = j + (this.zzahk << 32);
        }
        return timestamp;
    }

    public final long zzey() {
        return this.zzahj.nanoTime;
    }

    public final long zzez() {
        return this.zzahm;
    }
}
