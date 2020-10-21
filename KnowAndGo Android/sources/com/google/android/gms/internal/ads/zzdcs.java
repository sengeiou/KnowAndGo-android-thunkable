package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdcs implements zzdbj {
    private static final byte[] zzgpx = new byte[0];
    private final zzdgw zzgpy;
    private final zzdbj zzgpz;

    public zzdcs(zzdgw zzdgw, zzdbj zzdbj) {
        this.zzgpy = zzdgw;
        this.zzgpz = zzdbj;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdcf.zzb(this.zzgpy).toByteArray();
        byte[] zzc = this.zzgpz.zzc(byteArray, zzgpx);
        byte[] zzc2 = ((zzdbj) zzdcf.zza(this.zzgpy.zzart(), byteArray, zzdbj.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
