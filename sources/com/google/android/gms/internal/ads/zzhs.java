package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

class zzhs {
    private int zzafv;
    protected AudioTrack zzagg;
    private boolean zzahf;
    private long zzahg;
    private long zzahh;
    private long zzahi;

    private zzhs() {
    }

    public boolean zzex() {
        return false;
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzagg = audioTrack;
        this.zzahf = z;
        this.zzahg = 0;
        this.zzahh = 0;
        this.zzahi = 0;
        if (audioTrack != null) {
            this.zzafv = audioTrack.getSampleRate();
        }
    }

    public final boolean zzeu() {
        return zzkq.SDK_INT <= 22 && this.zzahf && this.zzagg.getPlayState() == 2 && this.zzagg.getPlaybackHeadPosition() == 0;
    }

    public final long zzev() {
        long playbackHeadPosition = ((long) this.zzagg.getPlaybackHeadPosition()) & 4294967295L;
        if (zzkq.SDK_INT <= 22 && this.zzahf) {
            if (this.zzagg.getPlayState() == 1) {
                this.zzahg = playbackHeadPosition;
            } else if (this.zzagg.getPlayState() == 2 && playbackHeadPosition == 0) {
                this.zzahi = this.zzahg;
            }
            playbackHeadPosition += this.zzahi;
        }
        if (this.zzahg > playbackHeadPosition) {
            this.zzahh++;
        }
        this.zzahg = playbackHeadPosition;
        return playbackHeadPosition + (this.zzahh << 32);
    }

    public final long zzew() {
        return (zzev() * 1000000) / ((long) this.zzafv);
    }

    public long zzey() {
        throw new UnsupportedOperationException();
    }

    public long zzez() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzhs(zzhr zzhr) {
        this();
    }
}
