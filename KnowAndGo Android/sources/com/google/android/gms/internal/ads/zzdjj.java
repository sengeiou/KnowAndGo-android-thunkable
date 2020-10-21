package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdjj implements zzdlk {
    private final SecretKeySpec zzgxn;
    private final int zzgxo;
    private final int zzgxp = zzdkx.zzhap.zzgt("AES/CTR/NoPadding").getBlockSize();

    public zzdjj(byte[] bArr, int i) throws GeneralSecurityException {
        zzdlx.zzfg(bArr.length);
        this.zzgxn = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzgxp) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzgxo = i;
    }

    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - this.zzgxo) {
            byte[] bArr2 = new byte[(this.zzgxo + bArr.length)];
            byte[] zzff = zzdlo.zzff(this.zzgxo);
            System.arraycopy(zzff, 0, bArr2, 0, this.zzgxo);
            int length = bArr.length;
            int i = this.zzgxo;
            Cipher zzgt = zzdkx.zzhap.zzgt("AES/CTR/NoPadding");
            byte[] bArr3 = new byte[this.zzgxp];
            System.arraycopy(zzff, 0, bArr3, 0, this.zzgxo);
            zzgt.init(1, this.zzgxn, new IvParameterSpec(bArr3));
            if (zzgt.doFinal(bArr, 0, length, bArr2, i) == length) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.zzgxo);
        throw new GeneralSecurityException(sb.toString());
    }
}
