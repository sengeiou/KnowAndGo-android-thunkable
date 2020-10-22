package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

final class zzgt implements Runnable {
    private final /* synthetic */ zzgr zzaej;
    private final /* synthetic */ MediaCodec.CryptoException zzaek;

    zzgt(zzgr zzgr, MediaCodec.CryptoException cryptoException) {
        this.zzaej = zzgr;
        this.zzaek = cryptoException;
    }

    public final void run() {
        this.zzaej.zzadn.zzb(this.zzaek);
    }
}
