package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzdod {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzhia;
    private static final ByteBuffer zzhib;
    private static final zzdnd zzhic;

    public static int zzbh(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzft(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static boolean zzn(zzdpk zzdpk) {
        return false;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzad(byte[] bArr) {
        return zzdrb.zzad(bArr);
    }

    public static String zzae(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzdpk) obj).zzaxt().zzi((zzdpk) obj2).zzaxz();
    }

    static {
        byte[] bArr = new byte[0];
        zzhia = bArr;
        zzhib = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzhia;
        zzhic = zzdnd.zzc(bArr2, 0, bArr2.length, false);
    }
}
