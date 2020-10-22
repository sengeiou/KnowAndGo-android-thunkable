package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzdjk implements zzdbj {
    private final SecretKeySpec zzgxn;
    private final byte[] zzgxq;
    private final byte[] zzgxr;
    private final int zzgxs;

    public zzdjk(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzgxs = i;
            zzdlx.zzfg(bArr.length);
            this.zzgxn = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.zzgxn);
            this.zzgxq = zzp(instance.doFinal(new byte[16]));
            this.zzgxr = zzp(this.zzgxq);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzp(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & UByte.MAX_VALUE) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 0) {
            i = TsExtractor.TS_STREAM_TYPE_E_AC3;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzgxq));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        byte[] bArr4 = doFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzgxq);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzgxr, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ ByteCompanionObject.MIN_VALUE);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(bArr4, bArr2));
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        if (bArr3.length <= (Integer.MAX_VALUE - this.zzgxs) - 16) {
            byte[] bArr4 = new byte[(this.zzgxs + bArr3.length + 16)];
            byte[] zzff = zzdlo.zzff(this.zzgxs);
            System.arraycopy(zzff, 0, bArr4, 0, this.zzgxs);
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, this.zzgxn);
            byte[] zza = zza(instance, 0, zzff, 0, zzff.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(instance, 1, bArr5, 0, bArr5.length);
            Cipher instance2 = Cipher.getInstance("AES/CTR/NOPADDING");
            instance2.init(1, this.zzgxn, new IvParameterSpec(zza));
            instance2.doFinal(bArr, 0, bArr3.length, bArr4, this.zzgxs);
            byte[] zza3 = zza(instance, 2, bArr4, this.zzgxs, bArr3.length);
            int length = bArr3.length + this.zzgxs;
            for (int i = 0; i < 16; i++) {
                bArr4[length + i] = (byte) ((zza2[i] ^ zza[i]) ^ zza3[i]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
