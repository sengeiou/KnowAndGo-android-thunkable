package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzdjh implements zzdby {
    private final SecretKey zzgxc;
    private final int zzgxd = 16;
    private byte[] zzgxe;
    private byte[] zzgxf;

    private static Cipher zzauu() throws GeneralSecurityException {
        return zzdkx.zzhap.zzgt("AES/ECB/NoPadding");
    }

    public zzdjh(byte[] bArr, int i) throws GeneralSecurityException {
        zzdlx.zzfg(bArr.length);
        this.zzgxc = new SecretKeySpec(bArr, "AES");
        Cipher zzauu = zzauu();
        zzauu.init(1, this.zzgxc);
        this.zzgxe = zzdjo.zzq(zzauu.doFinal(new byte[16]));
        this.zzgxf = zzdjo.zzq(this.zzgxe);
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher zzauu = zzauu();
        zzauu.init(1, this.zzgxc);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if ((max << 4) == bArr.length) {
            bArr2 = zzdjs.zza(bArr, (max - 1) << 4, this.zzgxe, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = ByteCompanionObject.MIN_VALUE;
                bArr2 = zzdjs.zzd(copyOf, this.zzgxf);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = zzauu.doFinal(zzdjs.zza(bArr3, 0, bArr, i << 4, 16));
        }
        byte[] zzd = zzdjs.zzd(bArr2, bArr3);
        byte[] bArr4 = new byte[this.zzgxd];
        System.arraycopy(zzauu.doFinal(zzd), 0, bArr4, 0, this.zzgxd);
        return bArr4;
    }
}
