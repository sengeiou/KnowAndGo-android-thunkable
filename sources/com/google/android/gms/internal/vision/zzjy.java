package com.google.android.gms.internal.vision;

import com.google.android.exoplayer2.extractor.p012ts.PsExtractor;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjy extends zzjt {
    zzjy() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bb, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
            r17 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r5 = 3
            r6 = 0
            if (r3 < 0) goto L_0x00bc
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r1 = (int) r1
            r2 = 16
            r9 = 1
            if (r1 >= r2) goto L_0x001c
            r2 = 0
            goto L_0x002e
        L_0x001c:
            r11 = r7
            r2 = 0
        L_0x001e:
            if (r2 >= r1) goto L_0x002d
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.vision.zzjp.zza(r0, r11)
            if (r3 >= 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r2 = r2 + 1
            r11 = r13
            goto L_0x001e
        L_0x002d:
            r2 = r1
        L_0x002e:
            int r1 = r1 - r2
            long r2 = (long) r2
            long r7 = r7 + r2
        L_0x0031:
            r2 = 0
        L_0x0032:
            if (r1 <= 0) goto L_0x0045
            long r2 = r7 + r9
            byte r7 = com.google.android.gms.internal.vision.zzjp.zza(r0, r7)
            if (r7 < 0) goto L_0x0042
            int r1 = r1 + -1
            r15 = r2
            r2 = r7
            r7 = r15
            goto L_0x0032
        L_0x0042:
            r15 = r2
            r2 = r7
            r7 = r15
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            return r6
        L_0x0048:
            int r1 = r1 + -1
            r3 = -32
            r11 = -65
            r12 = -1
            if (r2 >= r3) goto L_0x0066
            if (r1 != 0) goto L_0x0054
            return r2
        L_0x0054:
            int r1 = r1 + -1
            r3 = -62
            if (r2 < r3) goto L_0x0065
            long r2 = r7 + r9
            byte r7 = com.google.android.gms.internal.vision.zzjp.zza(r0, r7)
            if (r7 <= r11) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = r2
            goto L_0x0031
        L_0x0065:
            return r12
        L_0x0066:
            r13 = -16
            if (r2 >= r13) goto L_0x0091
            if (r1 >= r4) goto L_0x0071
            int r0 = zza(r0, r2, r7, r1)
            return r0
        L_0x0071:
            int r1 = r1 + -2
            long r13 = r7 + r9
            byte r7 = com.google.android.gms.internal.vision.zzjp.zza(r0, r7)
            if (r7 > r11) goto L_0x0090
            r8 = -96
            if (r2 != r3) goto L_0x0081
            if (r7 < r8) goto L_0x0090
        L_0x0081:
            r3 = -19
            if (r2 != r3) goto L_0x0087
            if (r7 >= r8) goto L_0x0090
        L_0x0087:
            r2 = 0
            long r7 = r13 + r9
            byte r2 = com.google.android.gms.internal.vision.zzjp.zza(r0, r13)
            if (r2 <= r11) goto L_0x0031
        L_0x0090:
            return r12
        L_0x0091:
            if (r1 >= r5) goto L_0x0098
            int r0 = zza(r0, r2, r7, r1)
            return r0
        L_0x0098:
            int r1 = r1 + -3
            long r13 = r7 + r9
            byte r3 = com.google.android.gms.internal.vision.zzjp.zza(r0, r7)
            if (r3 > r11) goto L_0x00bb
            int r2 = r2 << 28
            int r3 = r3 + 112
            int r2 = r2 + r3
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x00bb
            long r2 = r13 + r9
            byte r7 = com.google.android.gms.internal.vision.zzjp.zza(r0, r13)
            if (r7 > r11) goto L_0x00bb
            long r7 = r2 + r9
            byte r2 = com.google.android.gms.internal.vision.zzjp.zza(r0, r2)
            if (r2 <= r11) goto L_0x0031
        L_0x00bb:
            return r12
        L_0x00bc:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r1 = 1
            r5[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            r5[r4] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjy.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzh(byte[] bArr, int i, int i2) throws zzhc {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte zza = zzjp.zza(bArr, (long) r13);
                if (!zzju.zzd(zza)) {
                    break;
                }
                i = r13 + 1;
                zzju.zza(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte zza2 = zzjp.zza(bArr, (long) r13);
                if (zzju.zzd(zza2)) {
                    int i7 = i5 + 1;
                    zzju.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzjp.zza(bArr, (long) i6);
                        if (!zzju.zzd(zza3)) {
                            break;
                        }
                        i6++;
                        zzju.zza(zza3, cArr, i7);
                        i7++;
                    }
                    r13 = i6;
                    i5 = i7;
                } else if (zzju.zze(zza2)) {
                    if (i6 < i3) {
                        int i8 = i6 + 1;
                        zzju.zza(zza2, zzjp.zza(bArr, (long) i6), cArr, i5);
                        r13 = i8;
                        i5++;
                    } else {
                        throw zzhc.zzgt();
                    }
                } else if (zzju.zzf(zza2)) {
                    if (i6 < i3 - 1) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzju.zza(zza2, zzjp.zza(bArr, (long) i6), zzjp.zza(bArr, (long) i9), cArr, i5);
                        r13 = i10;
                        i5++;
                    } else {
                        throw zzhc.zzgt();
                    }
                } else if (i6 < i3 - 2) {
                    int i11 = i6 + 1;
                    byte zza4 = zzjp.zza(bArr, (long) i6);
                    int i12 = i11 + 1;
                    zzju.zza(zza2, zza4, zzjp.zza(bArr, (long) i11), zzjp.zza(bArr, (long) i12), cArr, i5);
                    r13 = i12 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzhc.zzgt();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        long j2;
        char charAt;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        long j3 = (long) i4;
        long j4 = ((long) i5) + j3;
        int length = charSequence.length();
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt2 = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (i6 < length && (charAt = charSequence2.charAt(i6)) < 128) {
            zzjp.zza(bArr2, j, (byte) charAt);
            i6++;
            j3 = 1 + j;
        }
        if (i6 == length) {
            return (int) j;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < 128 && j < j4) {
                j2 = j + 1;
                zzjp.zza(bArr2, j, (byte) charAt3);
            } else if (charAt3 < 2048 && j <= j4 - 2) {
                long j5 = j + 1;
                zzjp.zza(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j5 + 1;
                zzjp.zza(bArr2, j5, (byte) ((charAt3 & '?') | 128));
                i6++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j4 - 3) {
                long j6 = j + 1;
                zzjp.zza(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                long j7 = j6 + 1;
                zzjp.zza(bArr2, j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                j2 = j7 + 1;
                zzjp.zza(bArr2, j7, (byte) ((charAt3 & '?') | 128));
            } else if (j <= j4 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j8 = j + 1;
                        zzjp.zza(bArr2, j, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                        long j9 = j8 + 1;
                        zzjp.zza(bArr2, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j10 = j9 + 1;
                        zzjp.zza(bArr2, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j10 + 1;
                        zzjp.zza(bArr2, j10, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                    }
                } else {
                    i7 = i6;
                }
                throw new zzjv(i7 - 1, length);
            } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i6 + 1) != length && Character.isSurrogatePair(charAt3, charSequence2.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzjv(i6, length);
            }
            j = j2;
            i6++;
        }
        return (int) j;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzjs.zzbw(i);
            case 1:
                return zzjs.zzv(i, zzjp.zza(bArr, j));
            case 2:
                return zzjs.zzd(i, zzjp.zza(bArr, j), zzjp.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
