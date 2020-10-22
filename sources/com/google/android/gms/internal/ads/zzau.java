package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

final class zzau extends FilterInputStream {
    private final HttpURLConnection zzcl;

    zzau(HttpURLConnection httpURLConnection) {
        super(zzat.zza(httpURLConnection));
        this.zzcl = httpURLConnection;
    }

    public final void close() throws IOException {
        super.close();
        this.zzcl.disconnect();
    }
}
