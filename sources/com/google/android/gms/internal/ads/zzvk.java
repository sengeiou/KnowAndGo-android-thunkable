package com.google.android.gms.internal.ads;

@zzard
public final class zzvk {
    private final int zzbvx;
    private final zzva zzbvz;
    private String zzbwg;
    private String zzbwh;
    private final boolean zzbwi = false;
    private final int zzbwj;
    private final int zzbwk;

    public zzvk(int i, int i2, int i3) {
        this.zzbvx = i;
        if (i2 > 64 || i2 < 0) {
            this.zzbwj = 64;
        } else {
            this.zzbwj = i2;
        }
        if (i3 <= 0) {
            this.zzbwk = 1;
        } else {
            this.zzbwk = i3;
        }
        this.zzbvz = new zzvj(this.zzbwj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
        if (r2.size() < r1.zzbvx) goto L_0x0109;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0109 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(java.util.ArrayList<java.lang.String> r17, java.util.ArrayList<com.google.android.gms.internal.ads.zzuz> r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            com.google.android.gms.internal.ads.zzvl r2 = new com.google.android.gms.internal.ads.zzvl
            r2.<init>(r1)
            java.util.Collections.sort(r0, r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = 0
        L_0x0012:
            int r5 = r18.size()
            if (r4 >= r5) goto L_0x0113
            java.lang.Object r5 = r0.get(r4)
            com.google.android.gms.internal.ads.zzuz r5 = (com.google.android.gms.internal.ads.zzuz) r5
            int r5 = r5.zzne()
            r6 = r17
            java.lang.Object r5 = r6.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.text.Normalizer$Form r7 = java.text.Normalizer.Form.NFKC
            java.lang.String r5 = java.text.Normalizer.normalize(r5, r7)
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r7)
            java.lang.String r7 = "\n"
            java.lang.String[] r5 = r5.split(r7)
            int r7 = r5.length
            r8 = 1
            if (r7 == 0) goto L_0x010d
            r7 = 0
        L_0x0041:
            int r9 = r5.length
            if (r7 >= r9) goto L_0x010d
            r9 = r5[r7]
            java.lang.String r10 = "'"
            int r10 = r9.indexOf(r10)
            r11 = -1
            if (r10 == r11) goto L_0x00a6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            r11 = 1
            r12 = 0
        L_0x0056:
            int r13 = r11 + 2
            int r14 = r10.length()
            if (r13 > r14) goto L_0x0099
            char r14 = r10.charAt(r11)
            r15 = 39
            if (r14 != r15) goto L_0x0097
            int r12 = r11 + -1
            char r12 = r10.charAt(r12)
            r14 = 32
            if (r12 == r14) goto L_0x0093
            int r12 = r11 + 1
            char r15 = r10.charAt(r12)
            r3 = 115(0x73, float:1.61E-43)
            if (r15 == r3) goto L_0x0082
            char r3 = r10.charAt(r12)
            r12 = 83
            if (r3 != r12) goto L_0x0093
        L_0x0082:
            int r3 = r10.length()
            if (r13 == r3) goto L_0x008e
            char r3 = r10.charAt(r13)
            if (r3 != r14) goto L_0x0093
        L_0x008e:
            r10.insert(r11, r14)
            r11 = r13
            goto L_0x0096
        L_0x0093:
            r10.setCharAt(r11, r14)
        L_0x0096:
            r12 = 1
        L_0x0097:
            int r11 = r11 + r8
            goto L_0x0056
        L_0x0099:
            if (r12 == 0) goto L_0x00a0
            java.lang.String r3 = r10.toString()
            goto L_0x00a1
        L_0x00a0:
            r3 = 0
        L_0x00a1:
            if (r3 == 0) goto L_0x00a6
            r1.zzbwh = r3
            goto L_0x00a7
        L_0x00a6:
            r3 = r9
        L_0x00a7:
            java.lang.String[] r3 = com.google.android.gms.internal.ads.zzve.zzg(r3, r8)
            int r9 = r3.length
            int r10 = r1.zzbwk
            if (r9 < r10) goto L_0x0109
            r9 = 0
        L_0x00b1:
            int r10 = r3.length
            if (r9 >= r10) goto L_0x00ff
            java.lang.String r10 = ""
            r11 = r10
            r10 = 0
        L_0x00b8:
            int r12 = r1.zzbwk
            if (r10 >= r12) goto L_0x00ed
            int r12 = r9 + r10
            int r13 = r3.length
            if (r12 < r13) goto L_0x00c3
            r10 = 0
            goto L_0x00ee
        L_0x00c3:
            if (r10 <= 0) goto L_0x00cf
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r13 = " "
            java.lang.String r11 = r11.concat(r13)
        L_0x00cf:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r12 = r3[r12]
            java.lang.String r12 = java.lang.String.valueOf(r12)
            int r13 = r12.length()
            if (r13 == 0) goto L_0x00e4
            java.lang.String r11 = r11.concat(r12)
            goto L_0x00ea
        L_0x00e4:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r11)
            r11 = r12
        L_0x00ea:
            int r10 = r10 + 1
            goto L_0x00b8
        L_0x00ed:
            r10 = 1
        L_0x00ee:
            if (r10 == 0) goto L_0x00ff
            r2.add(r11)
            int r10 = r2.size()
            int r11 = r1.zzbvx
            if (r10 < r11) goto L_0x00fc
            goto L_0x0107
        L_0x00fc:
            int r9 = r9 + 1
            goto L_0x00b1
        L_0x00ff:
            int r3 = r2.size()
            int r9 = r1.zzbvx
            if (r3 < r9) goto L_0x0109
        L_0x0107:
            r8 = 0
            goto L_0x010d
        L_0x0109:
            int r7 = r7 + 1
            goto L_0x0041
        L_0x010d:
            if (r8 == 0) goto L_0x0113
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0113:
            com.google.android.gms.internal.ads.zzvd r3 = new com.google.android.gms.internal.ads.zzvd
            r3.<init>()
            java.lang.String r0 = ""
            r1.zzbwg = r0
            java.util.Iterator r0 = r2.iterator()
        L_0x0120:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x013c
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzva r4 = r1.zzbvz     // Catch:{ IOException -> 0x0136 }
            byte[] r2 = r4.zzbl(r2)     // Catch:{ IOException -> 0x0136 }
            r3.write(r2)     // Catch:{ IOException -> 0x0136 }
            goto L_0x0120
        L_0x0136:
            r0 = move-exception
            java.lang.String r2 = "Error while writing hash to byteStream"
            com.google.android.gms.internal.ads.zzawz.zzc(r2, r0)
        L_0x013c:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.zza(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
