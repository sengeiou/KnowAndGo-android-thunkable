package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzwg extends PushbackInputStream {
    private final /* synthetic */ zzwd zzbxj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzwg(zzwd zzwd, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbxj = zzwd;
    }

    public final synchronized void close() throws IOException {
        this.zzbxj.zzbxa.disconnect();
        super.close();
    }
}
