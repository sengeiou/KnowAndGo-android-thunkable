package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzdrw {
    protected volatile int zzhnx = -1;

    public void zza(zzdrp zzdrp) throws IOException {
    }

    /* access modifiers changed from: protected */
    public int zzor() {
        return 0;
    }

    public final int zzaxj() {
        int zzor = zzor();
        this.zzhnx = zzor;
        return zzor;
    }

    public static final byte[] zza(zzdrw zzdrw) {
        byte[] bArr = new byte[zzdrw.zzaxj()];
        try {
            zzdrp zzp = zzdrp.zzp(bArr, 0, bArr.length);
            zzdrw.zza(zzp);
            zzp.zzawv();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzdrx.zzb(this);
    }

    /* renamed from: zzbal */
    public zzdrw clone() throws CloneNotSupportedException {
        return (zzdrw) super.clone();
    }
}
