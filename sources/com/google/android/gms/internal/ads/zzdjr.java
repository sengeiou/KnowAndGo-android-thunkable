package com.google.android.gms.internal.ads;

final class zzdjr extends zzdjq {
    private static final int[] zzgyb = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] zzgyc = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int state;
    private int value;
    private final int[] zzgyd;

    public zzdjr(int i, byte[] bArr) {
        this.zzgxz = bArr;
        this.zzgyd = (i & 8) == 0 ? zzgyb : zzgyc;
        this.state = 0;
        this.value = 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(byte[] r11, int r12, int r13, boolean r14) {
        /*
            r10 = this;
            int r12 = r10.state
            r14 = 0
            r0 = 6
            if (r12 != r0) goto L_0x0007
            return r14
        L_0x0007:
            int r12 = r10.state
            byte[] r1 = r10.zzgxz
            int[] r2 = r10.zzgyd
            r3 = 4
            r4 = r12
            r12 = 0
            r5 = 0
            r6 = 0
        L_0x0012:
            if (r12 >= r13) goto L_0x00e2
            if (r4 != 0) goto L_0x0059
        L_0x0016:
            int r7 = r12 + 4
            if (r7 > r13) goto L_0x0057
            byte r5 = r11[r12]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r2[r5]
            int r5 = r5 << 18
            int r8 = r12 + 1
            byte r8 = r11[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r2[r8]
            int r8 = r8 << 12
            r5 = r5 | r8
            int r8 = r12 + 2
            byte r8 = r11[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r2[r8]
            int r8 = r8 << r0
            r5 = r5 | r8
            int r8 = r12 + 3
            byte r8 = r11[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r2[r8]
            r5 = r5 | r8
            if (r5 < 0) goto L_0x0057
            int r12 = r6 + 2
            byte r8 = (byte) r5
            r1[r12] = r8
            int r12 = r6 + 1
            int r8 = r5 >> 8
            byte r8 = (byte) r8
            r1[r12] = r8
            int r12 = r5 >> 16
            byte r12 = (byte) r12
            r1[r6] = r12
            int r6 = r6 + 3
            r12 = r7
            goto L_0x0016
        L_0x0057:
            if (r12 >= r13) goto L_0x00e2
        L_0x0059:
            int r7 = r12 + 1
            byte r12 = r11[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r2[r12]
            r8 = -2
            r9 = -1
            switch(r4) {
                case 0: goto L_0x00d4;
                case 1: goto L_0x00c7;
                case 2: goto L_0x00ac;
                case 3: goto L_0x0078;
                case 4: goto L_0x006d;
                case 5: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x00df
        L_0x0068:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x006d:
            if (r12 != r8) goto L_0x0073
            int r4 = r4 + 1
            goto L_0x00df
        L_0x0073:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x0078:
            if (r12 < 0) goto L_0x0095
            int r4 = r5 << 6
            r5 = r4 | r12
            int r12 = r6 + 2
            byte r4 = (byte) r5
            r1[r12] = r4
            int r12 = r6 + 1
            int r4 = r5 >> 8
            byte r4 = (byte) r4
            r1[r12] = r4
            int r12 = r5 >> 16
            byte r12 = (byte) r12
            r1[r6] = r12
            int r6 = r6 + 3
            r12 = r7
            r4 = 0
            goto L_0x0012
        L_0x0095:
            if (r12 != r8) goto L_0x00a7
            int r12 = r6 + 1
            int r4 = r5 >> 2
            byte r4 = (byte) r4
            r1[r12] = r4
            int r12 = r5 >> 10
            byte r12 = (byte) r12
            r1[r6] = r12
            int r6 = r6 + 2
            r4 = 5
            goto L_0x00df
        L_0x00a7:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x00ac:
            if (r12 < 0) goto L_0x00b4
            int r5 = r5 << 6
            r5 = r5 | r12
            int r4 = r4 + 1
            goto L_0x00df
        L_0x00b4:
            if (r12 != r8) goto L_0x00c2
            int r12 = r6 + 1
            int r4 = r5 >> 4
            byte r4 = (byte) r4
            r1[r6] = r4
            r6 = r12
            r12 = r7
            r4 = 4
            goto L_0x0012
        L_0x00c2:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x00c7:
            if (r12 < 0) goto L_0x00cf
            int r5 = r5 << 6
            r5 = r5 | r12
            int r4 = r4 + 1
            goto L_0x00df
        L_0x00cf:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x00d4:
            if (r12 < 0) goto L_0x00da
            int r4 = r4 + 1
            r5 = r12
            goto L_0x00df
        L_0x00da:
            if (r12 == r9) goto L_0x00df
            r10.state = r0
            return r14
        L_0x00df:
            r12 = r7
            goto L_0x0012
        L_0x00e2:
            switch(r4) {
                case 0: goto L_0x0104;
                case 1: goto L_0x0101;
                case 2: goto L_0x00f8;
                case 3: goto L_0x00e9;
                case 4: goto L_0x00e6;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            goto L_0x0104
        L_0x00e6:
            r10.state = r0
            return r14
        L_0x00e9:
            int r11 = r6 + 1
            int r12 = r5 >> 10
            byte r12 = (byte) r12
            r1[r6] = r12
            int r6 = r11 + 1
            int r12 = r5 >> 2
            byte r12 = (byte) r12
            r1[r11] = r12
            goto L_0x0104
        L_0x00f8:
            int r11 = r6 + 1
            int r12 = r5 >> 4
            byte r12 = (byte) r12
            r1[r6] = r12
            r6 = r11
            goto L_0x0104
        L_0x0101:
            r10.state = r0
            return r14
        L_0x0104:
            r10.state = r4
            r10.zzgya = r6
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdjr.zzb(byte[], int, int, boolean):boolean");
    }
}
