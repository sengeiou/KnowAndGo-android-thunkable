package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzdkb implements zzdbp {
    private static final byte[] zzgpx = new byte[0];
    private final ECPrivateKey zzgyo;
    private final zzdkd zzgyp;
    private final String zzgyq;
    private final byte[] zzgyr;
    private final zzdkv zzgys;
    private final zzdka zzgyt;

    public zzdkb(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdkv zzdkv, zzdka zzdka) throws GeneralSecurityException {
        this.zzgyo = eCPrivateKey;
        this.zzgyp = new zzdkd(eCPrivateKey);
        this.zzgyr = bArr;
        this.zzgyq = str;
        this.zzgys = zzdkv;
        this.zzgyt = zzdka;
    }
}
