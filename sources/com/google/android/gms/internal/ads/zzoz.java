package com.google.android.gms.internal.ads;

final class zzoz {
    private static final int[] zzbgi = {zzsy.zzay("isom"), zzsy.zzay("iso2"), zzsy.zzay("iso3"), zzsy.zzay("iso4"), zzsy.zzay("iso5"), zzsy.zzay("iso6"), zzsy.zzay("avc1"), zzsy.zzay("hvc1"), zzsy.zzay("hev1"), zzsy.zzay("mp41"), zzsy.zzay("mp42"), zzsy.zzay("3g2a"), zzsy.zzay("3g2b"), zzsy.zzay("3gr6"), zzsy.zzay("3gs6"), zzsy.zzay("3ge6"), zzsy.zzay("3gg6"), zzsy.zzay("M4V "), zzsy.zzay("M4A "), zzsy.zzay("f4v "), zzsy.zzay("kddi"), zzsy.zzay("M4VP"), zzsy.zzay("qt  "), zzsy.zzay("MSNV")};

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b6, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b7, code lost:
        if (r5 == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b9, code lost:
        if (r0 != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bb, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzd(com.google.android.gms.internal.ads.zzno r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r15
            long r1 = r15.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0011
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0012
        L_0x0011:
            r1 = r3
        L_0x0012:
            int r1 = (int) r1
            com.google.android.gms.internal.ads.zzst r2 = new com.google.android.gms.internal.ads.zzst
            r3 = 64
            r2.<init>((int) r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x001d:
            if (r4 >= r1) goto L_0x00b6
            r7 = 8
            r2.reset(r7)
            byte[] r8 = r2.data
            r15.zzc(r8, r3, r7)
            long r8 = r2.zzge()
            int r10 = r2.readInt()
            r11 = 1
            r13 = 16
            int r11 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r11 != 0) goto L_0x0046
            byte[] r8 = r2.data
            r15.zzc(r8, r7, r7)
            r2.zzbo(r13)
            long r8 = r2.zzgh()
            goto L_0x0048
        L_0x0046:
            r13 = 8
        L_0x0048:
            long r11 = (long) r13
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x00bd
            int r4 = r4 + r13
            int r13 = com.google.android.gms.internal.ads.zzoj.zzako
            if (r10 == r13) goto L_0x001d
            int r13 = com.google.android.gms.internal.ads.zzoj.zzakv
            if (r10 == r13) goto L_0x00b4
            int r13 = com.google.android.gms.internal.ads.zzoj.zzakx
            if (r10 != r13) goto L_0x005b
            goto L_0x00b4
        L_0x005b:
            long r13 = (long) r4
            long r13 = r13 + r8
            long r13 = r13 - r11
            long r6 = (long) r1
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x00b6
            long r8 = r8 - r11
            int r6 = (int) r8
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.zzoj.zzajz
            if (r10 != r7) goto L_0x00ad
            r7 = 8
            if (r6 < r7) goto L_0x00bd
            r2.reset(r6)
            byte[] r7 = r2.data
            r15.zzc(r7, r3, r6)
            int r6 = r6 / 4
            r7 = 0
        L_0x0079:
            if (r7 >= r6) goto L_0x00a9
            r8 = 1
            if (r7 != r8) goto L_0x0083
            r8 = 4
            r2.zzac(r8)
            goto L_0x00a6
        L_0x0083:
            int r8 = r2.readInt()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzsy.zzay(r10)
            if (r9 != r10) goto L_0x0093
        L_0x0091:
            r8 = 1
            goto L_0x00a2
        L_0x0093:
            int[] r9 = zzbgi
            int r10 = r9.length
            r11 = 0
        L_0x0097:
            if (r11 >= r10) goto L_0x00a1
            r12 = r9[r11]
            if (r12 != r8) goto L_0x009e
            goto L_0x0091
        L_0x009e:
            int r11 = r11 + 1
            goto L_0x0097
        L_0x00a1:
            r8 = 0
        L_0x00a2:
            if (r8 == 0) goto L_0x00a6
            r5 = 1
            goto L_0x00a9
        L_0x00a6:
            int r7 = r7 + 1
            goto L_0x0079
        L_0x00a9:
            if (r5 == 0) goto L_0x00bd
            goto L_0x001d
        L_0x00ad:
            if (r6 == 0) goto L_0x001d
            r15.zzar(r6)
            goto L_0x001d
        L_0x00b4:
            r0 = 1
            goto L_0x00b7
        L_0x00b6:
            r0 = 0
        L_0x00b7:
            if (r5 == 0) goto L_0x00bd
            if (r0 != 0) goto L_0x00bd
            r0 = 1
            return r0
        L_0x00bd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoz.zzd(com.google.android.gms.internal.ads.zzno):boolean");
    }
}
