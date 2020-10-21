package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
final class zzvd {
    @VisibleForTesting
    private ByteArrayOutputStream zzbwa = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream zzbwb = new Base64OutputStream(this.zzbwa, 10);

    public final void write(byte[] bArr) throws IOException {
        this.zzbwb.write(bArr);
    }

    public final String toString() {
        try {
            this.zzbwb.close();
        } catch (IOException e) {
            zzawz.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbwa.close();
            return this.zzbwa.toString();
        } catch (IOException e2) {
            zzawz.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.zzbwa = null;
            this.zzbwb = null;
        }
    }
}
