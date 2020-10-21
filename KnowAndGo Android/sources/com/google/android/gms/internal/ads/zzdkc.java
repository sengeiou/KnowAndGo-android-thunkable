package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

public final class zzdkc implements zzdbq {
    private static final byte[] zzgpx = new byte[0];
    private final String zzgyq;
    private final byte[] zzgyr;
    private final zzdkv zzgys;
    private final zzdka zzgyt;
    private final zzdke zzgyu;

    public zzdkc(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdkv zzdkv, zzdka zzdka) throws GeneralSecurityException {
        zzdkr.zza(eCPublicKey);
        this.zzgyu = new zzdke(eCPublicKey);
        this.zzgyr = bArr;
        this.zzgyq = str;
        this.zzgys = zzdkv;
        this.zzgyt = zzdka;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdkf zza = this.zzgyu.zza(this.zzgyq, this.zzgyr, bArr2, this.zzgyt.zzanz(), this.zzgys);
        byte[] zzc = this.zzgyt.zzm(zza.zzaux()).zzc(bArr, zzgpx);
        byte[] zzauw = zza.zzauw();
        return ByteBuffer.allocate(zzauw.length + zzc.length).put(zzauw).put(zzc).array();
    }
}
