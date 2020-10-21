package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzdrb {
    private static final zzdrd zzhmg;

    public static boolean zzad(byte[] bArr) {
        return zzhmg.zzl(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int zzam(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    public static int zzh(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    public static int zzhb(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean zzl(byte[] bArr, int i, int i2) {
        return zzhmg.zzl(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    public static int zzm(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzhb(b);
            case 1:
                return zzam(b, bArr[i]);
            case 2:
                return zzh(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzdrf(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzhmg.zzb(charSequence, bArr, i, i2);
    }

    static String zzn(byte[] bArr, int i, int i2) throws zzdok {
        return zzhmg.zzn(bArr, i, i2);
    }

    static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzdrd zzdrd = zzhmg;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            zzdrd.zzb(charSequence, byteBuffer);
        } else {
            zzdrd.zzc(charSequence, byteBuffer);
        }
    }

    static {
        zzdrd zzdrd;
        if (!(zzdqz.zzbac() && zzdqz.zzbad()) || zzdmm.zzavl()) {
            zzdrd = new zzdre();
        } else {
            zzdrd = new zzdrg();
        }
        zzhmg = zzdrd;
    }
}
