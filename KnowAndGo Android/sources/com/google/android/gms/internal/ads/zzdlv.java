package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class zzdlv {
    public static String zza(zzdlg zzdlg) throws GeneralSecurityException {
        zzdlx.zzc(zzdlg);
        String valueOf = String.valueOf(zzdlg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
        sb.append(valueOf);
        sb.append("withECDSA");
        return sb.toString();
    }

    public static String zzb(zzdlg zzdlg) throws GeneralSecurityException {
        switch (zzdlw.zzhbp[zzdlg.ordinal()]) {
            case 1:
                return MessageDigestAlgorithms.SHA_1;
            case 2:
                return MessageDigestAlgorithms.SHA_256;
            case 3:
                return MessageDigestAlgorithms.SHA_512;
            default:
                String valueOf = String.valueOf(zzdlg);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
                sb.append("Unsupported hash ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static boolean zzavd() {
        try {
            Class.forName("android.app.Application", false, (ClassLoader) null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static BigInteger zzx(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zza(BigInteger bigInteger, int i) throws GeneralSecurityException {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        int i2 = i + 1;
        if (byteArray.length > i2) {
            throw new GeneralSecurityException("integer too large");
        } else if (byteArray.length != i2) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
            return bArr;
        } else if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        } else {
            throw new GeneralSecurityException("integer too large");
        }
    }

    public static byte[] zza(byte[] bArr, int i, zzdlg zzdlg) throws GeneralSecurityException {
        MessageDigest zzgt = zzdkx.zzhas.zzgt(zzb(zzdlg));
        int digestLength = zzgt.getDigestLength();
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 <= (i - 1) / digestLength; i3++) {
            zzgt.reset();
            zzgt.update(bArr);
            zzgt.update(zza(BigInteger.valueOf((long) i3), 4));
            byte[] digest = zzgt.digest();
            System.arraycopy(digest, 0, bArr2, i2, Math.min(digest.length, bArr2.length - i2));
            i2 += digest.length;
        }
        return bArr2;
    }
}
