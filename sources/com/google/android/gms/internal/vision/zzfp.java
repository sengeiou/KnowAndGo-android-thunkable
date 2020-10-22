package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfp {
    private final byte[] buffer;
    private final zzga zzsd;

    private zzfp(int i) {
        this.buffer = new byte[i];
        this.zzsd = zzga.zze(this.buffer);
    }

    public final zzfh zzev() {
        this.zzsd.zzfh();
        return new zzfr(this.buffer);
    }

    public final zzga zzew() {
        return this.zzsd;
    }

    /* synthetic */ zzfp(int i, zzfk zzfk) {
        this(i);
    }
}
