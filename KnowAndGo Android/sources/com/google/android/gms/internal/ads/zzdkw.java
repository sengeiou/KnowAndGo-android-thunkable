package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdkw implements zzdbj {
    private final zzdlk zzhal;
    private final zzdby zzham;
    private final int zzhan;

    public zzdkw(zzdlk zzdlk, zzdby zzdby, int i) {
        this.zzhal = zzdlk;
        this.zzham = zzdby;
        this.zzhan = i;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzo = this.zzhal.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzdjs.zza(zzo, this.zzham.zzk(zzdjs.zza(bArr2, zzo, copyOf)));
    }
}
