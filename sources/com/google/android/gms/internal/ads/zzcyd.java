package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

final /* synthetic */ class zzcyd implements Runnable {
    private final InputStream zzglm;
    private final ParcelFileDescriptor zzgln;

    zzcyd(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzglm = inputStream;
        this.zzgln = parcelFileDescriptor;
    }

    public final void run() {
        zzcyc.zza(this.zzglm, this.zzgln);
    }
}
