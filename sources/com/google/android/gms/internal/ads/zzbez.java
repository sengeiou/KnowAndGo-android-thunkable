package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzbez implements zzll {
    private long zzaca;
    private int zzbmh;
    private final zzrz zzegt;
    private long zzegu;
    private long zzegv;
    private long zzegw;
    private boolean zzegx;

    zzbez() {
        this(15000, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, 2500, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    private zzbez(int i, int i2, long j, long j2) {
        this.zzegt = new zzrz(true, 65536);
        this.zzaca = 15000000;
        this.zzegu = 30000000;
        this.zzegv = 2500000;
        this.zzegw = 5000000;
    }

    public final void zzhd() {
        zzk(false);
    }

    public final void zza(zzlo[] zzloArr, zzrb zzrb, zzro zzro) {
        this.zzbmh = 0;
        for (int i = 0; i < zzloArr.length; i++) {
            if (zzro.zzbi(i) != null) {
                this.zzbmh += zzsy.zzbt(zzloArr[i].getTrackType());
            }
        }
        this.zzegt.zzbl(this.zzbmh);
    }

    public final void onStopped() {
        zzk(true);
    }

    public final void zzee() {
        zzk(true);
    }

    public final zzrt zzhe() {
        return this.zzegt;
    }

    public final synchronized boolean zzf(long j, boolean z) {
        long j2;
        boolean z2;
        if (z) {
            try {
                j2 = this.zzegw;
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j2 = this.zzegv;
        }
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final synchronized boolean zzee(long j) {
        char c;
        boolean z = false;
        if (j > this.zzegu) {
            c = 0;
        } else {
            c = j < this.zzaca ? (char) 2 : 1;
        }
        boolean z2 = this.zzegt.zzga() >= this.zzbmh;
        if (c == 2 || (c == 1 && this.zzegx && !z2)) {
            z = true;
        }
        this.zzegx = z;
        return this.zzegx;
    }

    public final synchronized void zzdg(int i) {
        this.zzaca = ((long) i) * 1000;
    }

    public final synchronized void zzdh(int i) {
        this.zzegu = ((long) i) * 1000;
    }

    public final synchronized void zzda(int i) {
        this.zzegv = ((long) i) * 1000;
    }

    public final synchronized void zzdb(int i) {
        this.zzegw = ((long) i) * 1000;
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbmh = 0;
        this.zzegx = false;
        if (z) {
            this.zzegt.reset();
        }
    }
}
