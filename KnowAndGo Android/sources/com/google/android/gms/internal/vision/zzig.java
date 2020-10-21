package com.google.android.gms.internal.vision;

import com.google.android.exoplayer2.C1470C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzig<T> implements zzir<T> {
    private static final int[] zzys = new int[0];
    private static final Unsafe zzyt = zzjp.zzil();
    private final int[] zzyu;
    private final Object[] zzyv;
    private final int zzyw;
    private final int zzyx;
    private final zzic zzyy;
    private final boolean zzyz;
    private final boolean zzza;
    private final boolean zzzb;
    private final boolean zzzc;
    private final int[] zzzd;
    private final int zzze;
    private final int zzzf;
    private final zzik zzzg;
    private final zzhm zzzh;
    private final zzjj<?, ?> zzzi;
    private final zzgf<?> zzzj;
    private final zzhv zzzk;

    private zzig(int[] iArr, Object[] objArr, int i, int i2, zzic zzic, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzik zzik, zzhm zzhm, zzjj<?, ?> zzjj, zzgf<?> zzgf, zzhv zzhv) {
        this.zzyu = iArr;
        this.zzyv = objArr;
        this.zzyw = i;
        this.zzyx = i2;
        this.zzza = zzic instanceof zzgs;
        this.zzzb = z;
        this.zzyz = zzgf != null && zzgf.zze(zzic);
        this.zzzc = false;
        this.zzzd = iArr2;
        this.zzze = i3;
        this.zzzf = i4;
        this.zzzg = zzik;
        this.zzzh = zzhm;
        this.zzzi = zzjj;
        this.zzzj = zzgf;
        this.zzyy = zzic;
        this.zzzk = zzhv;
    }

    private static boolean zzbr(int i) {
        return (i & C1470C.ENCODING_PCM_A_LAW) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.vision.zzig<T> zza(java.lang.Class<T> r37, com.google.android.gms.internal.vision.zzia r38, com.google.android.gms.internal.vision.zzik r39, com.google.android.gms.internal.vision.zzhm r40, com.google.android.gms.internal.vision.zzjj<?, ?> r41, com.google.android.gms.internal.vision.zzgf<?> r42, com.google.android.gms.internal.vision.zzhv r43) {
        /*
            r0 = r38
            boolean r1 = r0 instanceof com.google.android.gms.internal.vision.zzip
            if (r1 == 0) goto L_0x0441
            com.google.android.gms.internal.vision.zzip r0 = (com.google.android.gms.internal.vision.zzip) r0
            int r1 = r0.zzhi()
            int r2 = com.google.android.gms.internal.vision.zzgs.zzf.zzwu
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzhp()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = r5
            r5 = 1
            r9 = 13
        L_0x002c:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x003c
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r8 = r8 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x002c
        L_0x003c:
            int r5 = r5 << r9
            r5 = r5 | r8
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x005f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004c:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004c
        L_0x005c:
            int r8 = r8 << r10
            r9 = r9 | r8
            goto L_0x0060
        L_0x005f:
            r12 = r8
        L_0x0060:
            if (r9 != 0) goto L_0x006e
            int[] r8 = zzys
            r16 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            goto L_0x01a1
        L_0x006e:
            int r8 = r12 + 1
            char r9 = r1.charAt(r12)
            if (r9 < r7) goto L_0x008e
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x007a:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x008a
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x007a
        L_0x008a:
            int r8 = r8 << r10
            r8 = r8 | r9
            r9 = r8
            goto L_0x008f
        L_0x008e:
            r12 = r8
        L_0x008f:
            int r8 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r7) goto L_0x00ae
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x009b:
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ab
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r12
            r10 = r10 | r8
            int r12 = r12 + 13
            r8 = r13
            goto L_0x009b
        L_0x00ab:
            int r8 = r8 << r12
            r10 = r10 | r8
            goto L_0x00af
        L_0x00ae:
            r13 = r8
        L_0x00af:
            int r8 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r7) goto L_0x00cf
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00bb:
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00cb
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r13
            r12 = r12 | r8
            int r13 = r13 + 13
            r8 = r14
            goto L_0x00bb
        L_0x00cb:
            int r8 = r8 << r13
            r8 = r8 | r12
            r12 = r8
            goto L_0x00d0
        L_0x00cf:
            r14 = r8
        L_0x00d0:
            int r8 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r7) goto L_0x00f0
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00dc:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ec
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r14
            r13 = r13 | r8
            int r14 = r14 + 13
            r8 = r15
            goto L_0x00dc
        L_0x00ec:
            int r8 = r8 << r14
            r8 = r8 | r13
            r13 = r8
            goto L_0x00f1
        L_0x00f0:
            r15 = r8
        L_0x00f1:
            int r8 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r7) goto L_0x0113
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00fd:
            int r16 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x010e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r15
            r14 = r14 | r8
            int r15 = r15 + 13
            r8 = r16
            goto L_0x00fd
        L_0x010e:
            int r8 = r8 << r15
            r8 = r8 | r14
            r14 = r8
            r8 = r16
        L_0x0113:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0136
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x011f:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0131
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r8 = r8 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x011f
        L_0x0131:
            int r15 = r15 << r16
            r8 = r8 | r15
            r15 = r17
        L_0x0136:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r36 = r16
            r16 = r15
            r15 = r36
        L_0x0148:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x015b
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x0148
        L_0x015b:
            int r15 = r15 << r17
            r15 = r16 | r15
            r3 = r18
            goto L_0x0164
        L_0x0162:
            r3 = r16
        L_0x0164:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x018f
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r36 = r16
            r16 = r3
            r3 = r36
        L_0x0176:
            int r18 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0189
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r17
            r16 = r16 | r3
            int r17 = r17 + 13
            r3 = r18
            goto L_0x0176
        L_0x0189:
            int r3 = r3 << r17
            r3 = r16 | r3
            r16 = r18
        L_0x018f:
            int r17 = r3 + r8
            int r15 = r17 + r15
            int[] r15 = new int[r15]
            int r17 = r9 << 1
            int r10 = r17 + r10
            r36 = r15
            r15 = r10
            r10 = r12
            r12 = r16
            r16 = r36
        L_0x01a1:
            sun.misc.Unsafe r6 = zzyt
            java.lang.Object[] r17 = r0.zzhq()
            com.google.android.gms.internal.vision.zzic r18 = r0.zzhk()
            java.lang.Class r7 = r18.getClass()
            r22 = r12
            int r12 = r14 * 3
            int[] r12 = new int[r12]
            int r14 = r14 << r4
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r18 = r3 + r8
            r20 = r15
            r23 = r18
            r8 = r22
            r15 = 0
            r19 = 0
            r22 = r3
        L_0x01c5:
            if (r8 >= r2) goto L_0x0413
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r4) goto L_0x01f9
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r36 = r24
            r24 = r8
            r8 = r36
        L_0x01dc:
            int r26 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r4) goto L_0x01f2
            r4 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r24 = r24 | r4
            int r25 = r25 + 13
            r8 = r26
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01dc
        L_0x01f2:
            int r4 = r8 << r25
            r8 = r24 | r4
            r4 = r26
            goto L_0x01fb
        L_0x01f9:
            r4 = r24
        L_0x01fb:
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            r27 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x022f
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r36 = r24
            r24 = r4
            r4 = r36
        L_0x0212:
            int r26 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x0228
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r25
            r24 = r24 | r2
            int r25 = r25 + 13
            r4 = r26
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0212
        L_0x0228:
            int r2 = r4 << r25
            r4 = r24 | r2
            r2 = r26
            goto L_0x0231
        L_0x022f:
            r2 = r24
        L_0x0231:
            r28 = r3
            r3 = r4 & 255(0xff, float:3.57E-43)
            r29 = r11
            r11 = r4 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0240
            int r11 = r15 + 1
            r16[r15] = r19
            r15 = r11
        L_0x0240:
            r11 = 51
            r30 = r15
            if (r3 < r11) goto L_0x02e4
            int r11 = r2 + 1
            char r2 = r1.charAt(r2)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x026f
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x0255:
            int r25 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r15) goto L_0x026a
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r24
            r2 = r2 | r11
            int r24 = r24 + 13
            r11 = r25
            r15 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0255
        L_0x026a:
            int r11 = r11 << r24
            r2 = r2 | r11
            r11 = r25
        L_0x026f:
            int r15 = r3 + -51
            r31 = r11
            r11 = 9
            if (r15 == r11) goto L_0x0296
            r11 = 17
            if (r15 != r11) goto L_0x027c
            goto L_0x0296
        L_0x027c:
            r11 = 12
            if (r15 != r11) goto L_0x0292
            r11 = r5 & 1
            r15 = 1
            if (r11 != r15) goto L_0x0292
            int r11 = r19 / 3
            int r11 = r11 << r15
            int r11 = r11 + r15
            int r15 = r20 + 1
            r20 = r17[r20]
            r14[r11] = r20
            r24 = r15
            goto L_0x0294
        L_0x0292:
            r24 = r20
        L_0x0294:
            r15 = 1
            goto L_0x02a1
        L_0x0296:
            int r11 = r19 / 3
            r15 = 1
            int r11 = r11 << r15
            int r11 = r11 + r15
            int r24 = r20 + 1
            r20 = r17[r20]
            r14[r11] = r20
        L_0x02a1:
            int r2 = r2 << r15
            r11 = r17[r2]
            boolean r15 = r11 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02ad
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
        L_0x02aa:
            r32 = r10
            goto L_0x02b6
        L_0x02ad:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza((java.lang.Class<?>) r7, (java.lang.String) r11)
            r17[r2] = r11
            goto L_0x02aa
        L_0x02b6:
            long r10 = r6.objectFieldOffset(r11)
            int r10 = (int) r10
            int r2 = r2 + 1
            r11 = r17[r2]
            boolean r15 = r11 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02c8
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
        L_0x02c5:
            r33 = r10
            goto L_0x02d1
        L_0x02c8:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza((java.lang.Class<?>) r7, (java.lang.String) r11)
            r17[r2] = r11
            goto L_0x02c5
        L_0x02d1:
            long r10 = r6.objectFieldOffset(r11)
            int r2 = (int) r10
            r34 = r13
            r35 = r14
            r20 = r24
            r13 = r31
            r11 = r33
            r14 = r2
            r2 = 0
            goto L_0x03dd
        L_0x02e4:
            r32 = r10
            int r10 = r20 + 1
            r11 = r17[r20]
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza((java.lang.Class<?>) r7, (java.lang.String) r11)
            r15 = 9
            if (r3 == r15) goto L_0x0366
            r15 = 17
            if (r3 != r15) goto L_0x02fa
            goto L_0x0366
        L_0x02fa:
            r15 = 27
            if (r3 == r15) goto L_0x0354
            r15 = 49
            if (r3 != r15) goto L_0x0303
            goto L_0x0354
        L_0x0303:
            r15 = 12
            if (r3 == r15) goto L_0x0342
            r15 = 30
            if (r3 == r15) goto L_0x0342
            r15 = 44
            if (r3 != r15) goto L_0x0310
            goto L_0x0342
        L_0x0310:
            r15 = 50
            if (r3 != r15) goto L_0x033e
            int r15 = r22 + 1
            r16[r22] = r19
            int r20 = r19 / 3
            r22 = 1
            int r20 = r20 << 1
            int r22 = r10 + 1
            r10 = r17[r10]
            r14[r20] = r10
            r10 = r4 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0335
            int r20 = r20 + 1
            int r10 = r22 + 1
            r22 = r17[r22]
            r14[r20] = r22
            r34 = r13
            r35 = r14
            goto L_0x033b
        L_0x0335:
            r34 = r13
            r35 = r14
            r10 = r22
        L_0x033b:
            r22 = r15
            goto L_0x0375
        L_0x033e:
            r34 = r13
            r13 = 1
            goto L_0x0373
        L_0x0342:
            r15 = r5 & 1
            r34 = r13
            r13 = 1
            if (r15 != r13) goto L_0x0373
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            int r20 = r10 + 1
            r10 = r17[r10]
            r14[r15] = r10
            goto L_0x0361
        L_0x0354:
            r34 = r13
            r13 = 1
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            int r20 = r10 + 1
            r10 = r17[r10]
            r14[r15] = r10
        L_0x0361:
            r35 = r14
            r10 = r20
            goto L_0x0375
        L_0x0366:
            r34 = r13
            r13 = 1
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            java.lang.Class r20 = r11.getType()
            r14[r15] = r20
        L_0x0373:
            r35 = r14
        L_0x0375:
            long r13 = r6.objectFieldOffset(r11)
            int r11 = (int) r13
            r13 = r5 & 1
            r14 = 1
            if (r13 != r14) goto L_0x03c7
            r13 = 17
            if (r3 > r13) goto L_0x03c7
            int r13 = r2 + 1
            char r2 = r1.charAt(r2)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r14) goto L_0x03a7
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0392:
            int r20 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r14) goto L_0x03a3
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r15
            r2 = r2 | r13
            int r15 = r15 + 13
            r13 = r20
            goto L_0x0392
        L_0x03a3:
            int r13 = r13 << r15
            r2 = r2 | r13
            r13 = r20
        L_0x03a7:
            r15 = 1
            int r20 = r9 << 1
            int r21 = r2 / 32
            int r20 = r20 + r21
            r14 = r17[r20]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x03b7
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x03bf
        L_0x03b7:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zza((java.lang.Class<?>) r7, (java.lang.String) r14)
            r17[r20] = r14
        L_0x03bf:
            long r14 = r6.objectFieldOffset(r14)
            int r14 = (int) r14
            int r2 = r2 % 32
            goto L_0x03ca
        L_0x03c7:
            r13 = r2
            r2 = 0
            r14 = 0
        L_0x03ca:
            r15 = 18
            if (r3 < r15) goto L_0x03db
            r15 = 49
            if (r3 > r15) goto L_0x03db
            int r15 = r23 + 1
            r16[r23] = r11
            r20 = r10
            r23 = r15
            goto L_0x03dd
        L_0x03db:
            r20 = r10
        L_0x03dd:
            int r10 = r19 + 1
            r12[r19] = r8
            int r8 = r10 + 1
            r15 = r4 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x03ea
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03eb
        L_0x03ea:
            r15 = 0
        L_0x03eb:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03f2
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03f3
        L_0x03f2:
            r4 = 0
        L_0x03f3:
            r4 = r4 | r15
            int r3 = r3 << 20
            r3 = r3 | r4
            r3 = r3 | r11
            r12[r10] = r3
            int r19 = r8 + 1
            int r2 = r2 << 20
            r2 = r2 | r14
            r12[r8] = r2
            r8 = r13
            r2 = r27
            r3 = r28
            r11 = r29
            r15 = r30
            r10 = r32
            r13 = r34
            r14 = r35
            r4 = 1
            goto L_0x01c5
        L_0x0413:
            r28 = r3
            r32 = r10
            r29 = r11
            r34 = r13
            r35 = r14
            com.google.android.gms.internal.vision.zzig r1 = new com.google.android.gms.internal.vision.zzig
            com.google.android.gms.internal.vision.zzic r10 = r0.zzhk()
            r0 = 0
            r5 = r1
            r6 = r12
            r7 = r35
            r8 = r32
            r9 = r34
            r12 = r0
            r13 = r16
            r14 = r28
            r15 = r18
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0441:
            com.google.android.gms.internal.vision.zzjg r0 = (com.google.android.gms.internal.vision.zzjg) r0
            int r0 = r0.zzhi()
            int r1 = com.google.android.gms.internal.vision.zzgs.zzf.zzwu
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Class, com.google.android.gms.internal.vision.zzia, com.google.android.gms.internal.vision.zzik, com.google.android.gms.internal.vision.zzhm, com.google.android.gms.internal.vision.zzjj, com.google.android.gms.internal.vision.zzgf, com.google.android.gms.internal.vision.zzhv):com.google.android.gms.internal.vision.zzig");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzzg.newInstance(this.zzyy);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzm(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzyu
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzbp(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzbq(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.zzjp.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.zzjp.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r9.zzzi
            java.lang.Object r0 = r0.zzv(r10)
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r9.zzzi
            java.lang.Object r2 = r2.zzv(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzyz
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r10 = r0.zze((java.lang.Object) r10)
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r11 = r0.zze((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int length = this.zzyu.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzbp = zzbp(i2);
            int i3 = this.zzyu[i2];
            long j = (long) (1048575 & zzbp);
            int i4 = 37;
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzgt.zzab(Double.doubleToLongBits(zzjp.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzjp.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzgt.zzab(zzjp.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzgt.zzab(zzjp.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzgt.zzab(zzjp.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzgt.zzm(zzjp.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzjp.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zzjp.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzjp.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzgt.zzab(zzjp.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzjp.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzgt.zzab(zzjp.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zzjp.zzp(t, j);
                    if (zzp2 != null) {
                        i4 = zzp2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzjp.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzjp.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(Double.doubleToLongBits(zzf(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzg(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(zzi(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(zzi(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(zzi(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzm(zzj(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zzjp.zzp(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzjp.zzp(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzjp.zzp(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(zzi(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzgt.zzab(zzi(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzjp.zzp(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzzi.zzv(t).hashCode();
        return this.zzyz ? (hashCode * 53) + this.zzzj.zze((Object) t).hashCode() : hashCode;
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzyu.length; i += 3) {
                int zzbp = zzbp(i);
                long j = (long) (1048575 & zzbp);
                int i2 = this.zzyu[i];
                switch ((zzbp & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb((Object) t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzzh.zza(t, t2, j);
                        break;
                    case 50:
                        zzit.zza(this.zzzk, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzzb) {
                zzit.zza(this.zzzi, t, t2);
                if (this.zzyz) {
                    zzit.zza(this.zzzj, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzbp = (long) (zzbp(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzjp.zzp(t, zzbp);
            Object zzp2 = zzjp.zzp(t2, zzbp);
            if (zzp != null && zzp2 != null) {
                zzjp.zza((Object) t, zzbp, zzgt.zzb(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzjp.zza((Object) t, zzbp, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbp = zzbp(i);
        int i2 = this.zzyu[i];
        long j = (long) (zzbp & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzjp.zzp(t, j);
            Object zzp2 = zzjp.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzjp.zza((Object) t, j, zzgt.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzjp.zza((Object) t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x09d2, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x0afd, code lost:
        r3 = r3 + 3;
        r9 = r18;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzr(T r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r0.zzzb
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x055f
            sun.misc.Unsafe r2 = zzyt
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzyu
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0557
            int r14 = r0.zzbp(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzyu
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.vision.zzgn r14 = com.google.android.gms.internal.vision.zzgn.DOUBLE_LIST_PACKED
            int r14 = r14.mo29354id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.vision.zzgn r14 = com.google.android.gms.internal.vision.zzgn.SINT64_LIST_PACKED
            int r14 = r14.mo29354id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzyu
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x0544;
                case 1: goto L_0x0538;
                case 2: goto L_0x0528;
                case 3: goto L_0x0518;
                case 4: goto L_0x0508;
                case 5: goto L_0x04fc;
                case 6: goto L_0x04f0;
                case 7: goto L_0x04e4;
                case 8: goto L_0x04c4;
                case 9: goto L_0x04af;
                case 10: goto L_0x049c;
                case 11: goto L_0x048b;
                case 12: goto L_0x047a;
                case 13: goto L_0x046d;
                case 14: goto L_0x0460;
                case 15: goto L_0x044f;
                case 16: goto L_0x043e;
                case 17: goto L_0x0427;
                case 18: goto L_0x041c;
                case 19: goto L_0x0411;
                case 20: goto L_0x0406;
                case 21: goto L_0x03fb;
                case 22: goto L_0x03f0;
                case 23: goto L_0x03e5;
                case 24: goto L_0x03da;
                case 25: goto L_0x03cf;
                case 26: goto L_0x03c4;
                case 27: goto L_0x03b5;
                case 28: goto L_0x03aa;
                case 29: goto L_0x039f;
                case 30: goto L_0x0394;
                case 31: goto L_0x0389;
                case 32: goto L_0x037e;
                case 33: goto L_0x0373;
                case 34: goto L_0x0368;
                case 35: goto L_0x0347;
                case 36: goto L_0x0326;
                case 37: goto L_0x0305;
                case 38: goto L_0x02e4;
                case 39: goto L_0x02c3;
                case 40: goto L_0x02a2;
                case 41: goto L_0x0281;
                case 42: goto L_0x0260;
                case 43: goto L_0x023f;
                case 44: goto L_0x021e;
                case 45: goto L_0x01fd;
                case 46: goto L_0x01dc;
                case 47: goto L_0x01bb;
                case 48: goto L_0x019a;
                case 49: goto L_0x018b;
                case 50: goto L_0x017a;
                case 51: goto L_0x016b;
                case 52: goto L_0x015e;
                case 53: goto L_0x014d;
                case 54: goto L_0x013c;
                case 55: goto L_0x012b;
                case 56: goto L_0x011e;
                case 57: goto L_0x0111;
                case 58: goto L_0x0104;
                case 59: goto L_0x00e4;
                case 60: goto L_0x00cf;
                case 61: goto L_0x00bc;
                case 62: goto L_0x00ab;
                case 63: goto L_0x009a;
                case 64: goto L_0x008d;
                case 65: goto L_0x0080;
                case 66: goto L_0x006f;
                case 67: goto L_0x005e;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0551
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzic r5 = (com.google.android.gms.internal.vision.zzic) r5
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzga.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x005e:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzf(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x006f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzn(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0080:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzh((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x008d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzp(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x009a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzq(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00ab:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzm(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00bc:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00cf:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzir) r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00e4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzfh
            if (r6 == 0) goto L_0x00fb
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00fb:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (java.lang.String) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0104:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (boolean) r8)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x011e:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzg((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x012b:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzl(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x013c:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zze(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x014d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzd((int) r3, (long) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x015e:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (float) r4)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x016b:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x0551
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (double) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x017a:
            com.google.android.gms.internal.vision.zzhv r14 = r0.zzzk
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            java.lang.Object r6 = r0.zzbn(r12)
            int r3 = r14.zzb(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x018b:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzd(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x019a:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzs(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01ae
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01ae:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01bb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzw(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01cf
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01cf:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01dc:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01f0
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f0:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x021e:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzt(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0232
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0232:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x023f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzv(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0253
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0253:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0260:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzz(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0274
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0274:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0281:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0295
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0295:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02a2:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02b6
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02b6:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02c3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzu(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02d7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02d7:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02e4:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzr(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02f8
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02f8:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0305:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzq(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0319
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0319:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0326:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x033a
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x033a:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0347:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x035b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x035b:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0368:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzq(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0373:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzu(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x037e:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0389:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzr(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x039f:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzt(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03aa:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzd(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03b5:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.vision.zzir) r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03c4:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03cf:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzx(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03da:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03e5:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03f0:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzs(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03fb:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzp(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0406:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzo(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0411:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x041c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0427:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzic r5 = (com.google.android.gms.internal.vision.zzic) r5
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzga.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x043e:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzf(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x044f:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzn(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0460:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzh((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x046d:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzp(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x047a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzq(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x048b:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzm(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x049c:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04af:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzir) r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04c4:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzfh
            if (r6 == 0) goto L_0x04db
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04db:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (java.lang.String) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04e4:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (boolean) r8)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04f0:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04fc:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzg((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0508:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzl(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0518:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zze(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0528:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzd((int) r3, (long) r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0538:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (float) r4)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0544:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x0551
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (double) r5)
            int r13 = r13 + r3
        L_0x0551:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0557:
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r0.zzzi
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x055f:
            sun.misc.Unsafe r2 = zzyt
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x0566:
            int[] r13 = r0.zzyu
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0b09
            int r13 = r0.zzbp(r3)
            int[] r14 = r0.zzyu
            r14 = r14[r3]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r15
            int r15 = r16 >>> 20
            r4 = 17
            if (r15 > r4) goto L_0x0592
            int[] r4 = r0.zzyu
            int r16 = r3 + 2
            r4 = r4[r16]
            r11 = r4 & r7
            int r16 = r4 >>> 20
            int r16 = r8 << r16
            if (r11 == r6) goto L_0x05b3
            long r8 = (long) r11
            int r12 = r2.getInt(r1, r8)
            r6 = r11
            goto L_0x05b3
        L_0x0592:
            boolean r4 = r0.zzzc
            if (r4 == 0) goto L_0x05b0
            com.google.android.gms.internal.vision.zzgn r4 = com.google.android.gms.internal.vision.zzgn.DOUBLE_LIST_PACKED
            int r4 = r4.mo29354id()
            if (r15 < r4) goto L_0x05b0
            com.google.android.gms.internal.vision.zzgn r4 = com.google.android.gms.internal.vision.zzgn.SINT64_LIST_PACKED
            int r4 = r4.mo29354id()
            if (r15 > r4) goto L_0x05b0
            int[] r4 = r0.zzyu
            int r8 = r3 + 2
            r4 = r4[r8]
            r11 = r4 & r7
            r4 = r11
            goto L_0x05b1
        L_0x05b0:
            r4 = 0
        L_0x05b1:
            r16 = 0
        L_0x05b3:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r15) {
                case 0: goto L_0x0aed;
                case 1: goto L_0x0adc;
                case 2: goto L_0x0aca;
                case 3: goto L_0x0ab8;
                case 4: goto L_0x0aa6;
                case 5: goto L_0x0a96;
                case 6: goto L_0x0a86;
                case 7: goto L_0x0a7a;
                case 8: goto L_0x0a5c;
                case 9: goto L_0x0a49;
                case 10: goto L_0x0a39;
                case 11: goto L_0x0a2b;
                case 12: goto L_0x0a1d;
                case 13: goto L_0x0a12;
                case 14: goto L_0x0a06;
                case 15: goto L_0x09f8;
                case 16: goto L_0x09ea;
                case 17: goto L_0x09d6;
                case 18: goto L_0x09c2;
                case 19: goto L_0x09b2;
                case 20: goto L_0x09a5;
                case 21: goto L_0x0998;
                case 22: goto L_0x098b;
                case 23: goto L_0x097e;
                case 24: goto L_0x0971;
                case 25: goto L_0x0964;
                case 26: goto L_0x0958;
                case 27: goto L_0x0947;
                case 28: goto L_0x093a;
                case 29: goto L_0x092c;
                case 30: goto L_0x091e;
                case 31: goto L_0x0910;
                case 32: goto L_0x0902;
                case 33: goto L_0x08f4;
                case 34: goto L_0x08e6;
                case 35: goto L_0x08c5;
                case 36: goto L_0x08a4;
                case 37: goto L_0x0883;
                case 38: goto L_0x0862;
                case 39: goto L_0x0841;
                case 40: goto L_0x0820;
                case 41: goto L_0x07ff;
                case 42: goto L_0x07de;
                case 43: goto L_0x07bd;
                case 44: goto L_0x079c;
                case 45: goto L_0x077b;
                case 46: goto L_0x075a;
                case 47: goto L_0x0739;
                case 48: goto L_0x0718;
                case 49: goto L_0x0707;
                case 50: goto L_0x06f6;
                case 51: goto L_0x06e7;
                case 52: goto L_0x06d9;
                case 53: goto L_0x06c8;
                case 54: goto L_0x06b7;
                case 55: goto L_0x06a6;
                case 56: goto L_0x0697;
                case 57: goto L_0x0689;
                case 58: goto L_0x067b;
                case 59: goto L_0x065b;
                case 60: goto L_0x0646;
                case 61: goto L_0x0633;
                case 62: goto L_0x0622;
                case 63: goto L_0x0611;
                case 64: goto L_0x0603;
                case 65: goto L_0x05f4;
                case 66: goto L_0x05e3;
                case 67: goto L_0x05d2;
                case 68: goto L_0x05bb;
                default: goto L_0x05b9;
            }
        L_0x05b9:
            goto L_0x09ce
        L_0x05bb:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzic r4 = (com.google.android.gms.internal.vision.zzic) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzga.zzc(r14, r4, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x05d2:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzf(r14, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x05e3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzn(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x05f4:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzh((int) r14, (long) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0603:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzp(r14, r4)
            int r5 = r5 + r8
            goto L_0x09ce
        L_0x0611:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzq(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0622:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzm(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0633:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0646:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x065b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzfh
            if (r8 == 0) goto L_0x0672
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0672:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (java.lang.String) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x067b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x09ce
        L_0x0689:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzo(r14, r4)
            int r5 = r5 + r8
            goto L_0x09ce
        L_0x0697:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzg((int) r14, (long) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x06a6:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzl(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x06b7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zze(r14, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x06c8:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzd((int) r14, (long) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x06d9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (float) r4)
            int r5 = r5 + r8
            goto L_0x09ce
        L_0x06e7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r3)
            if (r4 == 0) goto L_0x09ce
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (double) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x06f6:
            com.google.android.gms.internal.vision.zzhv r4 = r0.zzzk
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzbn(r3)
            int r4 = r4.zzb(r14, r8, r9)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0707:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzit.zzd(r14, r4, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0718:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzs(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x072c
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x072c:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0739:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzw(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x074d
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x074d:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x075a:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzy(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x076e
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x076e:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x077b:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzx(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x078f
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x078f:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x079c:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzt(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07b0
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x07b0:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x07bd:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzv(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07d1
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x07d1:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x07de:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzz(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07f2
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x07f2:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x07ff:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzx(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0813
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x0813:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0820:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzy(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0834
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x0834:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0841:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzu(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0855
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x0855:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0862:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzr(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0876
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x0876:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0883:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzq(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0897
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x0897:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x08a4:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzx(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x08b8
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x08b8:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x08c5:
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.android.gms.internal.vision.zzit.zzy(r8)
            if (r8 <= 0) goto L_0x09ce
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x08d9
            long r9 = (long) r4
            r2.putInt(r1, r9, r8)
        L_0x08d9:
            int r4 = com.google.android.gms.internal.vision.zzga.zzba(r14)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r8)
            int r4 = r4 + r9
            int r4 = r4 + r8
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x08e6:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.vision.zzit.zzq(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x08f4:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzu(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x0902:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x0910:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x091e:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzr(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x092c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzt(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x093a:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzd(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0947:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r14, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzir) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0958:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0964:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.vision.zzit.zzx(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x0971:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x097e:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x098b:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzs(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x0998:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzp(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x09a5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzo(r14, r4, r10)
            int r5 = r5 + r4
            goto L_0x09be
        L_0x09b2:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r14, r4, r10)
            int r5 = r5 + r4
        L_0x09be:
            r4 = 1
        L_0x09bf:
            r7 = 0
            goto L_0x09d2
        L_0x09c2:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r14, r4, r10)
            int r5 = r5 + r4
        L_0x09ce:
            r4 = 1
        L_0x09cf:
            r7 = 0
            r10 = 0
        L_0x09d2:
            r18 = 0
            goto L_0x0afd
        L_0x09d6:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzic r4 = (com.google.android.gms.internal.vision.zzic) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzga.zzc(r14, r4, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x09ea:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzf(r14, r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x09f8:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzn(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a06:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzh((int) r14, (long) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a12:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzp(r14, r4)
            int r5 = r5 + r8
            goto L_0x09ce
        L_0x0a1d:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzq(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a2b:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzga.zzm(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a39:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a49:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r3)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a5c:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzfh
            if (r8 == 0) goto L_0x0a71
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a71:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (java.lang.String) r4)
            int r5 = r5 + r4
            goto L_0x09ce
        L_0x0a7a:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ce
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x09cf
        L_0x0a86:
            r4 = 1
            r8 = r12 & r16
            if (r8 == 0) goto L_0x0a93
            r10 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzo(r14, r10)
            int r5 = r5 + r8
            goto L_0x09bf
        L_0x0a93:
            r10 = 0
            goto L_0x09bf
        L_0x0a96:
            r4 = 1
            r10 = 0
            r8 = r12 & r16
            if (r8 == 0) goto L_0x09bf
            r8 = 0
            int r11 = com.google.android.gms.internal.vision.zzga.zzg((int) r14, (long) r8)
            int r5 = r5 + r11
            r18 = r8
            goto L_0x0aea
        L_0x0aa6:
            r4 = 1
            r10 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0aea
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzga.zzl(r14, r8)
            int r5 = r5 + r8
            goto L_0x0aea
        L_0x0ab8:
            r4 = 1
            r10 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0aea
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzga.zze(r14, r8)
            int r5 = r5 + r8
            goto L_0x0aea
        L_0x0aca:
            r4 = 1
            r10 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0aea
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzga.zzd((int) r14, (long) r8)
            int r5 = r5 + r8
            goto L_0x0aea
        L_0x0adc:
            r4 = 1
            r10 = 0
            r18 = 0
            r8 = r12 & r16
            if (r8 == 0) goto L_0x0aea
            r8 = 0
            int r9 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (float) r8)
            int r5 = r5 + r9
        L_0x0aea:
            r7 = 0
            goto L_0x0afd
        L_0x0aed:
            r4 = 1
            r8 = 0
            r10 = 0
            r18 = 0
            r9 = r12 & r16
            if (r9 == 0) goto L_0x0aea
            r7 = 0
            int r9 = com.google.android.gms.internal.vision.zzga.zzb((int) r14, (double) r7)
            int r5 = r5 + r9
        L_0x0afd:
            int r3 = r3 + 3
            r9 = r18
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x0566
        L_0x0b09:
            r10 = 0
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r0.zzzi
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzyz
            if (r2 == 0) goto L_0x0b63
            com.google.android.gms.internal.vision.zzgf<?> r2 = r0.zzzj
            com.google.android.gms.internal.vision.zzgi r1 = r2.zze((java.lang.Object) r1)
            r2 = 0
        L_0x0b1c:
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r3 = r1.zztb
            int r3 = r3.zzhx()
            if (r10 >= r3) goto L_0x0b3c
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r3 = r1.zztb
            java.util.Map$Entry r3 = r3.zzbu(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.vision.zzgk r4 = (com.google.android.gms.internal.vision.zzgk) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.vision.zzgi.zzc(r4, r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0b1c
        L_0x0b3c:
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r1.zztb
            java.lang.Iterable r1 = r1.zzhy()
            java.util.Iterator r1 = r1.iterator()
        L_0x0b46:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0b62
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.vision.zzgk r4 = (com.google.android.gms.internal.vision.zzgk) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.vision.zzgi.zzc(r4, r3)
            int r2 = r2 + r3
            goto L_0x0b46
        L_0x0b62:
            int r5 = r5 + r2
        L_0x0b63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzr(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzjj<UT, UB> zzjj, T t) {
        return zzjj.zzr(zzjj.zzv(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzjp.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzkg r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzfj()
            int r1 = com.google.android.gms.internal.vision.zzgs.zzf.zzwx
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, (com.google.android.gms.internal.vision.zzkg) r15)
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzyu
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzbp(r7)
            int[] r9 = r13.zzyu
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzfh) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.vision.zzkg) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzfh) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.vision.zzgf<?> r14 = r13.zzzj
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzzb
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzyu
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzbp(r1)
            int[] r10 = r13.zzyu
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
            int r11 = r11.zza(r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0577
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x055b
        L_0x0577:
            r8 = r3
            goto L_0x055b
        L_0x0579:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a16;
                case 1: goto L_0x0a06;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e6;
                case 4: goto L_0x09d6;
                case 5: goto L_0x09c6;
                case 6: goto L_0x09b6;
                case 7: goto L_0x09a5;
                case 8: goto L_0x0994;
                case 9: goto L_0x097f;
                case 10: goto L_0x096c;
                case 11: goto L_0x095b;
                case 12: goto L_0x094a;
                case 13: goto L_0x0939;
                case 14: goto L_0x0928;
                case 15: goto L_0x0917;
                case 16: goto L_0x0906;
                case 17: goto L_0x08f1;
                case 18: goto L_0x08e0;
                case 19: goto L_0x08cf;
                case 20: goto L_0x08be;
                case 21: goto L_0x08ad;
                case 22: goto L_0x089c;
                case 23: goto L_0x088b;
                case 24: goto L_0x087a;
                case 25: goto L_0x0869;
                case 26: goto L_0x0858;
                case 27: goto L_0x0843;
                case 28: goto L_0x0832;
                case 29: goto L_0x0821;
                case 30: goto L_0x0810;
                case 31: goto L_0x07ff;
                case 32: goto L_0x07ee;
                case 33: goto L_0x07dd;
                case 34: goto L_0x07cc;
                case 35: goto L_0x07bb;
                case 36: goto L_0x07aa;
                case 37: goto L_0x0799;
                case 38: goto L_0x0788;
                case 39: goto L_0x0777;
                case 40: goto L_0x0766;
                case 41: goto L_0x0755;
                case 42: goto L_0x0744;
                case 43: goto L_0x0733;
                case 44: goto L_0x0722;
                case 45: goto L_0x0711;
                case 46: goto L_0x0700;
                case 47: goto L_0x06ef;
                case 48: goto L_0x06de;
                case 49: goto L_0x06c9;
                case 50: goto L_0x06be;
                case 51: goto L_0x06ad;
                case 52: goto L_0x069c;
                case 53: goto L_0x068b;
                case 54: goto L_0x067a;
                case 55: goto L_0x0669;
                case 56: goto L_0x0658;
                case 57: goto L_0x0647;
                case 58: goto L_0x0636;
                case 59: goto L_0x0625;
                case 60: goto L_0x0610;
                case 61: goto L_0x05fd;
                case 62: goto L_0x05ec;
                case 63: goto L_0x05db;
                case 64: goto L_0x05ca;
                case 65: goto L_0x05b9;
                case 66: goto L_0x05a8;
                case 67: goto L_0x0597;
                case 68: goto L_0x0582;
                default: goto L_0x0580;
            }
        L_0x0580:
            goto L_0x0a25
        L_0x0582:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzfh) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.vision.zzkg) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zzyu
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzfh) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.vision.zzgf<?> r1 = r13.zzzj
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a29
        L_0x0a3e:
            r8 = r3
            goto L_0x0a29
        L_0x0a40:
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, (com.google.android.gms.internal.vision.zzkg) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.vision.zzkg) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r20, com.google.android.gms.internal.vision.zzkg r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r3 = r0.zzyz
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.zzgf<?> r3 = r0.zzzj
            com.google.android.gms.internal.vision.zzgi r3 = r3.zze((java.lang.Object) r1)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r5 = r3.zztb
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzyu
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzyt
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x0527
            int r12 = r0.zzbp(r5)
            int[] r13 = r0.zzyu
            r13 = r13[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r12
            int r14 = r14 >>> 20
            boolean r15 = r0.zzzb
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 != 0) goto L_0x0063
            r15 = 17
            if (r14 > r15) goto L_0x0063
            int[] r15 = r0.zzyu
            int r17 = r5 + 2
            r15 = r15[r17]
            r9 = r15 & r16
            if (r9 == r6) goto L_0x005b
            r18 = r5
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
            goto L_0x005d
        L_0x005b:
            r18 = r5
        L_0x005d:
            int r4 = r15 >>> 20
            r5 = 1
            int r9 = r5 << r4
            goto L_0x0066
        L_0x0063:
            r18 = r5
            r9 = 0
        L_0x0066:
            if (r10 == 0) goto L_0x0085
            com.google.android.gms.internal.vision.zzgf<?> r4 = r0.zzzj
            int r4 = r4.zza(r10)
            if (r4 > r13) goto L_0x0085
            com.google.android.gms.internal.vision.zzgf<?> r4 = r0.zzzj
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0066
        L_0x0083:
            r10 = 0
            goto L_0x0066
        L_0x0085:
            r4 = r12 & r16
            long r4 = (long) r4
            switch(r14) {
                case 0: goto L_0x0516;
                case 1: goto L_0x0508;
                case 2: goto L_0x04fa;
                case 3: goto L_0x04ec;
                case 4: goto L_0x04de;
                case 5: goto L_0x04d0;
                case 6: goto L_0x04c2;
                case 7: goto L_0x04b4;
                case 8: goto L_0x04a5;
                case 9: goto L_0x0492;
                case 10: goto L_0x0481;
                case 11: goto L_0x0472;
                case 12: goto L_0x0463;
                case 13: goto L_0x0454;
                case 14: goto L_0x0445;
                case 15: goto L_0x0436;
                case 16: goto L_0x0427;
                case 17: goto L_0x0414;
                case 18: goto L_0x0402;
                case 19: goto L_0x03f0;
                case 20: goto L_0x03de;
                case 21: goto L_0x03cc;
                case 22: goto L_0x03ba;
                case 23: goto L_0x03a8;
                case 24: goto L_0x0396;
                case 25: goto L_0x0384;
                case 26: goto L_0x0373;
                case 27: goto L_0x035e;
                case 28: goto L_0x034d;
                case 29: goto L_0x033b;
                case 30: goto L_0x0329;
                case 31: goto L_0x0317;
                case 32: goto L_0x0305;
                case 33: goto L_0x02f3;
                case 34: goto L_0x02e1;
                case 35: goto L_0x02cf;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02ab;
                case 38: goto L_0x0299;
                case 39: goto L_0x0287;
                case 40: goto L_0x0275;
                case 41: goto L_0x0263;
                case 42: goto L_0x0251;
                case 43: goto L_0x023f;
                case 44: goto L_0x022d;
                case 45: goto L_0x021b;
                case 46: goto L_0x0209;
                case 47: goto L_0x01f7;
                case 48: goto L_0x01e5;
                case 49: goto L_0x01d0;
                case 50: goto L_0x01c5;
                case 51: goto L_0x01b4;
                case 52: goto L_0x01a3;
                case 53: goto L_0x0192;
                case 54: goto L_0x0181;
                case 55: goto L_0x0170;
                case 56: goto L_0x015f;
                case 57: goto L_0x014e;
                case 58: goto L_0x013d;
                case 59: goto L_0x012c;
                case 60: goto L_0x0117;
                case 61: goto L_0x0104;
                case 62: goto L_0x00f4;
                case 63: goto L_0x00e4;
                case 64: goto L_0x00d4;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b4;
                case 67: goto L_0x00a4;
                case 68: goto L_0x0090;
                default: goto L_0x008b;
            }
        L_0x008b:
            r12 = r18
        L_0x008d:
            r14 = 0
            goto L_0x0523
        L_0x0090:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            r2.zzb((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x008d
        L_0x00a4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            long r4 = zzi(r1, r4)
            r2.zzb((int) r13, (long) r4)
            goto L_0x008d
        L_0x00b4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzj((int) r13, (int) r4)
            goto L_0x008d
        L_0x00c4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            long r4 = zzi(r1, r4)
            r2.zzj((int) r13, (long) r4)
            goto L_0x008d
        L_0x00d4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x008d
        L_0x00e4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzs(r13, r4)
            goto L_0x008d
        L_0x00f4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzi((int) r13, (int) r4)
            goto L_0x008d
        L_0x0104:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza((int) r13, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x008d
        L_0x0117:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            r2.zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x008d
        L_0x012c:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x008d
        L_0x013d:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            boolean r4 = zzj(r1, r4)
            r2.zza((int) r13, (boolean) r4)
            goto L_0x008d
        L_0x014e:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzk(r13, r4)
            goto L_0x008d
        L_0x015f:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            long r4 = zzi(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x008d
        L_0x0170:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            int r4 = zzh(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x008d
        L_0x0181:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            long r4 = zzi(r1, r4)
            r2.zza((int) r13, (long) r4)
            goto L_0x008d
        L_0x0192:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            long r4 = zzi(r1, r4)
            r2.zzi((int) r13, (long) r4)
            goto L_0x008d
        L_0x01a3:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            float r4 = zzg(r1, r4)
            r2.zza((int) r13, (float) r4)
            goto L_0x008d
        L_0x01b4:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x008d
            double r4 = zzf(r1, r4)
            r2.zza((int) r13, (double) r4)
            goto L_0x008d
        L_0x01c5:
            r12 = r18
            java.lang.Object r4 = r8.getObject(r1, r4)
            r0.zza((com.google.android.gms.internal.vision.zzkg) r2, (int) r13, (java.lang.Object) r4, (int) r12)
            goto L_0x008d
        L_0x01d0:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x008d
        L_0x01e5:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 1
            com.google.android.gms.internal.vision.zzit.zze(r9, r4, r2, r13)
            goto L_0x008d
        L_0x01f7:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzj(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0209:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzg(r9, r4, r2, r13)
            goto L_0x008d
        L_0x021b:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzl(r9, r4, r2, r13)
            goto L_0x008d
        L_0x022d:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzm(r9, r4, r2, r13)
            goto L_0x008d
        L_0x023f:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzi(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0251:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzn(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0263:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzk(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0275:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzf(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0287:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzh(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0299:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzd(r9, r4, r2, r13)
            goto L_0x008d
        L_0x02ab:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzc(r9, r4, r2, r13)
            goto L_0x008d
        L_0x02bd:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r13)
            goto L_0x008d
        L_0x02cf:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r13)
            goto L_0x008d
        L_0x02e1:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 0
            com.google.android.gms.internal.vision.zzit.zze(r9, r4, r2, r13)
            goto L_0x008d
        L_0x02f3:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzj(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0305:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzg(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0317:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzl(r9, r4, r2, r13)
            goto L_0x008d
        L_0x0329:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzm(r9, r4, r2, r13)
            goto L_0x008d
        L_0x033b:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzi(r9, r4, r2, r13)
            goto L_0x008d
        L_0x034d:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzb(r9, r4, r2)
            goto L_0x008d
        L_0x035e:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x008d
        L_0x0373:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.String>) r4, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x008d
        L_0x0384:
            r12 = r18
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r14 = 0
            com.google.android.gms.internal.vision.zzit.zzn(r9, r4, r2, r14)
            goto L_0x0523
        L_0x0396:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzk(r9, r4, r2, r14)
            goto L_0x0523
        L_0x03a8:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzf(r9, r4, r2, r14)
            goto L_0x0523
        L_0x03ba:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzh(r9, r4, r2, r14)
            goto L_0x0523
        L_0x03cc:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzd(r9, r4, r2, r14)
            goto L_0x0523
        L_0x03de:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzc(r9, r4, r2, r14)
            goto L_0x0523
        L_0x03f0:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r14)
            goto L_0x0523
        L_0x0402:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzyu
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r14)
            goto L_0x0523
        L_0x0414:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            r2.zzb((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x0523
        L_0x0427:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            long r4 = r8.getLong(r1, r4)
            r2.zzb((int) r13, (long) r4)
            goto L_0x0523
        L_0x0436:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzj((int) r13, (int) r4)
            goto L_0x0523
        L_0x0445:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            long r4 = r8.getLong(r1, r4)
            r2.zzj((int) r13, (long) r4)
            goto L_0x0523
        L_0x0454:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x0523
        L_0x0463:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzs(r13, r4)
            goto L_0x0523
        L_0x0472:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzi((int) r13, (int) r4)
            goto L_0x0523
        L_0x0481:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza((int) r13, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x0523
        L_0x0492:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.vision.zzir r5 = r0.zzbm(r12)
            r2.zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r5)
            goto L_0x0523
        L_0x04a5:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x0523
        L_0x04b4:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r1, r4)
            r2.zza((int) r13, (boolean) r4)
            goto L_0x0523
        L_0x04c2:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzk(r13, r4)
            goto L_0x0523
        L_0x04d0:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            long r4 = r8.getLong(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x0523
        L_0x04de:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            int r4 = r8.getInt(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x0523
        L_0x04ec:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            long r4 = r8.getLong(r1, r4)
            r2.zza((int) r13, (long) r4)
            goto L_0x0523
        L_0x04fa:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            long r4 = r8.getLong(r1, r4)
            r2.zzi((int) r13, (long) r4)
            goto L_0x0523
        L_0x0508:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r1, r4)
            r2.zza((int) r13, (float) r4)
            goto L_0x0523
        L_0x0516:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0523
            double r4 = com.google.android.gms.internal.vision.zzjp.zzo(r1, r4)
            r2.zza((int) r13, (double) r4)
        L_0x0523:
            int r5 = r12 + 3
            goto L_0x002e
        L_0x0527:
            if (r10 == 0) goto L_0x053e
            com.google.android.gms.internal.vision.zzgf<?> r4 = r0.zzzj
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x053c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0527
        L_0x053c:
            r10 = 0
            goto L_0x0527
        L_0x053e:
            com.google.android.gms.internal.vision.zzjj<?, ?> r3 = r0.zzzi
            zza(r3, r1, (com.google.android.gms.internal.vision.zzkg) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    private final <K, V> void zza(zzkg zzkg, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkg.zza(i, this.zzzk.zzp(zzbn(i2)), this.zzzk.zzl(obj));
        }
    }

    private static <UT, UB> void zza(zzjj<UT, UB> zzjj, T t, zzkg zzkg) throws IOException {
        zzjj.zza(zzjj.zzv(t), zzkg);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.vision.zzis r14, com.google.android.gms.internal.vision.zzgd r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x05e0
            com.google.android.gms.internal.vision.zzjj<?, ?> r7 = r12.zzzi
            com.google.android.gms.internal.vision.zzgf<?> r8 = r12.zzzj
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x0009:
            int r1 = r14.zzdu()     // Catch:{ all -> 0x05c8 }
            int r2 = r12.zzbs(r1)     // Catch:{ all -> 0x05c8 }
            if (r2 >= 0) goto L_0x0079
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzze
        L_0x001a:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r7.zzg(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r2 = r12.zzyz     // Catch:{ all -> 0x05c8 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.vision.zzic r2 = r12.zzyy     // Catch:{ all -> 0x05c8 }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x05c8 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.vision.zzgi r0 = r8.zzf(r13)     // Catch:{ all -> 0x05c8 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r0 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05c8 }
            r10 = r0
            r0 = r11
            goto L_0x0009
        L_0x0052:
            r7.zza(r14)     // Catch:{ all -> 0x05c8 }
            if (r10 != 0) goto L_0x005c
            java.lang.Object r1 = r7.zzw(r13)     // Catch:{ all -> 0x05c8 }
            r10 = r1
        L_0x005c:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ all -> 0x05c8 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x0064:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0073
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0064
        L_0x0073:
            if (r10 == 0) goto L_0x0078
            r7.zzg(r13, r10)
        L_0x0078:
            return
        L_0x0079:
            int r3 = r12.zzbp(r2)     // Catch:{ all -> 0x05c8 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0574;
                case 1: goto L_0x0565;
                case 2: goto L_0x0556;
                case 3: goto L_0x0547;
                case 4: goto L_0x0538;
                case 5: goto L_0x0529;
                case 6: goto L_0x051a;
                case 7: goto L_0x050b;
                case 8: goto L_0x0503;
                case 9: goto L_0x04d2;
                case 10: goto L_0x04c3;
                case 11: goto L_0x04b4;
                case 12: goto L_0x0492;
                case 13: goto L_0x0483;
                case 14: goto L_0x0474;
                case 15: goto L_0x0465;
                case 16: goto L_0x0456;
                case 17: goto L_0x0425;
                case 18: goto L_0x0417;
                case 19: goto L_0x0409;
                case 20: goto L_0x03fb;
                case 21: goto L_0x03ed;
                case 22: goto L_0x03df;
                case 23: goto L_0x03d1;
                case 24: goto L_0x03c3;
                case 25: goto L_0x03b5;
                case 26: goto L_0x0393;
                case 27: goto L_0x0381;
                case 28: goto L_0x0373;
                case 29: goto L_0x0365;
                case 30: goto L_0x034f;
                case 31: goto L_0x0341;
                case 32: goto L_0x0333;
                case 33: goto L_0x0325;
                case 34: goto L_0x0317;
                case 35: goto L_0x0309;
                case 36: goto L_0x02fb;
                case 37: goto L_0x02ed;
                case 38: goto L_0x02df;
                case 39: goto L_0x02d1;
                case 40: goto L_0x02c3;
                case 41: goto L_0x02b5;
                case 42: goto L_0x02a7;
                case 43: goto L_0x0299;
                case 44: goto L_0x0284;
                case 45: goto L_0x0276;
                case 46: goto L_0x0268;
                case 47: goto L_0x025a;
                case 48: goto L_0x024c;
                case 49: goto L_0x023a;
                case 50: goto L_0x01f8;
                case 51: goto L_0x01e6;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01c2;
                case 54: goto L_0x01b0;
                case 55: goto L_0x019e;
                case 56: goto L_0x018c;
                case 57: goto L_0x017a;
                case 58: goto L_0x0168;
                case 59: goto L_0x0160;
                case 60: goto L_0x012f;
                case 61: goto L_0x0121;
                case 62: goto L_0x010f;
                case 63: goto L_0x00ea;
                case 64: goto L_0x00d8;
                case 65: goto L_0x00c6;
                case 66: goto L_0x00b4;
                case 67: goto L_0x00a2;
                case 68: goto L_0x0090;
                default: goto L_0x0088;
            }
        L_0x0088:
            if (r10 != 0) goto L_0x0584
            java.lang.Object r1 = r7.zzif()     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0583
        L_0x0090:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r5 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r5 = r14.zzc(r5, r15)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x00a2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzej()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x00b4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            int r5 = r14.zzei()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x00c6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzeh()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x00d8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            int r5 = r14.zzeg()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x00ea:
            int r4 = r14.zzef()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzgy r6 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r6 == 0) goto L_0x0101
            boolean r6 = r6.zzf(r4)     // Catch:{ zzhb -> 0x05a1 }
            if (r6 == 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0362
        L_0x0101:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x010f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            int r5 = r14.zzee()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0121:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzfh r5 = r14.zzed()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x012f:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r4 == 0) goto L_0x014b
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r6 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r6 = r14.zza(r6, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzgt.zzb(r5, r6)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x015b
        L_0x014b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r5 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r5 = r14.zza(r5, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
        L_0x015b:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0160:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0168:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            boolean r5 = r14.zzeb()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x017a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            int r5 = r14.zzea()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x018c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdz()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x019e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            int r5 = r14.zzdy()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x01b0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdw()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x01c2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdx()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x01d4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            float r5 = r14.readFloat()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x01e6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            double r5 = r14.readDouble()     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x01f8:
            java.lang.Object r1 = r12.zzbn(r2)     // Catch:{ zzhb -> 0x05a1 }
            int r2 = r12.zzbp(r2)     // Catch:{ zzhb -> 0x05a1 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r4 != 0) goto L_0x0212
            com.google.android.gms.internal.vision.zzhv r4 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r4 = r4.zzo(r1)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0229
        L_0x0212:
            com.google.android.gms.internal.vision.zzhv r5 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            boolean r5 = r5.zzm(r4)     // Catch:{ zzhb -> 0x05a1 }
            if (r5 == 0) goto L_0x0229
            com.google.android.gms.internal.vision.zzhv r5 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r5 = r5.zzo(r1)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzhv r6 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            r6.zzc(r5, r4)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a1 }
            r4 = r5
        L_0x0229:
            com.google.android.gms.internal.vision.zzhv r2 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            java.util.Map r2 = r2.zzk(r4)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzhv r3 = r12.zzzk     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzht r1 = r3.zzp(r1)     // Catch:{ zzhb -> 0x05a1 }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x023a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzb(r2, r1, r15)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x024c:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzp(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x025a:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzo(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0268:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzn(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0276:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzm(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0284:
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzl(r3)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzgy r2 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgy) r2, r10, r7)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0362
        L_0x0299:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzk(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02a7:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzh(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02b5:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzg(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02c3:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzf(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02d1:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zze(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02df:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzc(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02ed:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzd(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x02fb:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzb(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0309:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zza(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0317:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzp(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0325:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzo(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0333:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzn(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0341:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzm(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x034f:
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzl(r3)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzgy r2 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgy) r2, r10, r7)     // Catch:{ zzhb -> 0x05a1 }
        L_0x0362:
            r10 = r1
            goto L_0x0009
        L_0x0365:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzk(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0373:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzj(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0381:
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0393:
            boolean r1 = zzbr(r3)     // Catch:{ zzhb -> 0x05a1 }
            if (r1 == 0) goto L_0x03a7
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzi(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03a7:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.readStringList(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03b5:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzh(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03c3:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzg(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03d1:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzf(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03df:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zze(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03ed:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzc(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x03fb:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzd(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0409:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zzb(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0417:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a1 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a1 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a1 }
            r14.zza(r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0425:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r1 == 0) goto L_0x0443
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r2 = r14.zzc(r2, r15)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r2)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0443:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = r14.zzc(r1, r15)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0456:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzej()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0465:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            int r1 = r14.zzei()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0474:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzeh()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0483:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            int r1 = r14.zzeg()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0492:
            int r4 = r14.zzef()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzgy r6 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r6 == 0) goto L_0x04a9
            boolean r6 = r6.zzf(r4)     // Catch:{ zzhb -> 0x05a1 }
            if (r6 == 0) goto L_0x04a3
            goto L_0x04a9
        L_0x04a3:
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0362
        L_0x04a9:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x04b4:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            int r1 = r14.zzee()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x04c3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzfh r1 = r14.zzed()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x04d2:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            if (r1 == 0) goto L_0x04f0
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r2 = r14.zza(r2, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r2)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x04f0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a1 }
            java.lang.Object r1 = r14.zza(r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0503:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x050b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            boolean r1 = r14.zzeb()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x051a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            int r1 = r14.zzea()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0529:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdz()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0538:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            int r1 = r14.zzdy()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0547:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdw()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0556:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            long r5 = r14.zzdx()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0565:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            float r1 = r14.readFloat()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0574:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a1 }
            double r5 = r14.readDouble()     // Catch:{ zzhb -> 0x05a1 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzhb -> 0x05a1 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a1 }
            goto L_0x0009
        L_0x0583:
            r10 = r1
        L_0x0584:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a1 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x058c:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x059b
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x058c
        L_0x059b:
            if (r10 == 0) goto L_0x05a0
            r7.zzg(r13, r10)
        L_0x05a0:
            return
        L_0x05a1:
            r7.zza(r14)     // Catch:{ all -> 0x05c8 }
            if (r10 != 0) goto L_0x05ab
            java.lang.Object r1 = r7.zzw(r13)     // Catch:{ all -> 0x05c8 }
            r10 = r1
        L_0x05ab:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ all -> 0x05c8 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x05b3:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x05c2
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05b3
        L_0x05c2:
            if (r10 == 0) goto L_0x05c7
            r7.zzg(r13, r10)
        L_0x05c7:
            return
        L_0x05c8:
            r14 = move-exception
            int r15 = r12.zzze
        L_0x05cb:
            int r0 = r12.zzzf
            if (r15 >= r0) goto L_0x05da
            int[] r0 = r12.zzzd
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05cb
        L_0x05da:
            if (r10 == 0) goto L_0x05df
            r7.zzg(r13, r10)
        L_0x05df:
            throw r14
        L_0x05e0:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzis, com.google.android.gms.internal.vision.zzgd):void");
    }

    private static zzjm zzs(Object obj) {
        zzgs zzgs = (zzgs) obj;
        zzjm zzjm = zzgs.zzwd;
        if (zzjm != zzjm.zzig()) {
            return zzjm;
        }
        zzjm zzih = zzjm.zzih();
        zzgs.zzwd = zzih;
        return zzih;
    }

    private static int zza(byte[] bArr, int i, int i2, zzka zzka, Class<?> cls, zzfb zzfb) throws IOException {
        switch (zzif.zzrr[zzka.ordinal()]) {
            case 1:
                int zzb = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Boolean.valueOf(zzfb.zzrp != 0);
                return zzb;
            case 2:
                return zzez.zze(bArr, i, zzfb);
            case 3:
                zzfb.zzrq = Double.valueOf(zzez.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzfb.zzrq = Integer.valueOf(zzez.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzfb.zzrq = Long.valueOf(zzez.zzb(bArr, i));
                return i + 8;
            case 8:
                zzfb.zzrq = Float.valueOf(zzez.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzez.zza(bArr, i, zzfb);
                zzfb.zzrq = Integer.valueOf(zzfb.zzro);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Long.valueOf(zzfb.zzrp);
                return zzb2;
            case 14:
                return zzez.zza((zzir) zzin.zzho().zzf(cls), bArr, i, i2, zzfb);
            case 15:
                int zza2 = zzez.zza(bArr, i, zzfb);
                zzfb.zzrq = Integer.valueOf(zzft.zzau(zzfb.zzro));
                return zza2;
            case 16:
                int zzb3 = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Long.valueOf(zzft.zzr(zzfb.zzrp));
                return zzb3;
            case 17:
                return zzez.zzd(bArr, i, zzfb);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0364 A[SYNTHETIC] */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.vision.zzfb r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzyt
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzgz r11 = (com.google.android.gms.internal.vision.zzgz) r11
            boolean r12 = r11.zzdo()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.vision.zzgz r11 = r11.zzag(r12)
            sun.misc.Unsafe r12 = zzyt
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x033b;
                case 19: goto L_0x0313;
                case 20: goto L_0x02ea;
                case 21: goto L_0x02ea;
                case 22: goto L_0x02d0;
                case 23: goto L_0x02a7;
                case 24: goto L_0x027e;
                case 25: goto L_0x0246;
                case 26: goto L_0x018c;
                case 27: goto L_0x0172;
                case 28: goto L_0x0119;
                case 29: goto L_0x02d0;
                case 30: goto L_0x00e1;
                case 31: goto L_0x027e;
                case 32: goto L_0x02a7;
                case 33: goto L_0x00b0;
                case 34: goto L_0x007f;
                case 35: goto L_0x033b;
                case 36: goto L_0x0313;
                case 37: goto L_0x02ea;
                case 38: goto L_0x02ea;
                case 39: goto L_0x02d0;
                case 40: goto L_0x02a7;
                case 41: goto L_0x027e;
                case 42: goto L_0x0246;
                case 43: goto L_0x02d0;
                case 44: goto L_0x00e1;
                case 45: goto L_0x027e;
                case 46: goto L_0x02a7;
                case 47: goto L_0x00b0;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0363
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0363
            com.google.android.gms.internal.vision.zzir r1 = r0.zzbm(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.zzfb) r27)
            java.lang.Object r8 = r7.zzrq
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0363
            int r8 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r9 = r7.zzro
            if (r2 != r9) goto L_0x0363
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.zzfb) r27)
            java.lang.Object r8 = r7.zzrq
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x0087
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r3, r4, r11, r7)
            goto L_0x0364
        L_0x0087:
            if (r6 != 0) goto L_0x0363
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r11.zzac(r8)
        L_0x0098:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r11.zzac(r8)
            goto L_0x0098
        L_0x00b0:
            if (r6 != r10) goto L_0x00b8
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r3, r4, r11, r7)
            goto L_0x0364
        L_0x00b8:
            if (r6 != 0) goto L_0x0363
            com.google.android.gms.internal.vision.zzgu r11 = (com.google.android.gms.internal.vision.zzgu) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r11.zzbl(r4)
        L_0x00c9:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r11.zzbl(r4)
            goto L_0x00c9
        L_0x00e1:
            if (r6 != r10) goto L_0x00e8
            int r2 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzgz<?>) r11, (com.google.android.gms.internal.vision.zzfb) r7)
            goto L_0x00f9
        L_0x00e8:
            if (r6 != 0) goto L_0x0363
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.vision.zzez.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzgz<?>) r6, (com.google.android.gms.internal.vision.zzfb) r7)
        L_0x00f9:
            com.google.android.gms.internal.vision.zzgs r1 = (com.google.android.gms.internal.vision.zzgs) r1
            com.google.android.gms.internal.vision.zzjm r3 = r1.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0104
            r3 = 0
        L_0x0104:
            com.google.android.gms.internal.vision.zzgy r4 = r0.zzbo(r8)
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r0.zzzi
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzit.zza((int) r6, (java.util.List<java.lang.Integer>) r11, (com.google.android.gms.internal.vision.zzgy) r4, r3, r5)
            com.google.android.gms.internal.vision.zzjm r3 = (com.google.android.gms.internal.vision.zzjm) r3
            if (r3 == 0) goto L_0x0116
            r1.zzwd = r3
        L_0x0116:
            r1 = r2
            goto L_0x0364
        L_0x0119:
            if (r6 != r10) goto L_0x0363
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x016d
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0168
            if (r4 != 0) goto L_0x012f
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r11.add(r4)
            goto L_0x0137
        L_0x012f:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x0137:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0163
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015e
            if (r4 != 0) goto L_0x0155
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r11.add(r4)
            goto L_0x0137
        L_0x0155:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r11.add(r6)
            int r1 = r1 + r4
            goto L_0x0137
        L_0x015e:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x0163:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0168:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x016d:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0172:
            if (r6 != r10) goto L_0x0363
            com.google.android.gms.internal.vision.zzir r1 = r0.zzbm(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0364
        L_0x018c:
            if (r6 != r10) goto L_0x0363
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x01e2
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01dd
            if (r4 != 0) goto L_0x01a7
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x01b2
        L_0x01a7:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r6.<init>(r3, r1, r4, r8)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x01b2:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01d8
            if (r4 != 0) goto L_0x01cc
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x01b2
        L_0x01cc:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r6.<init>(r3, r1, r4, r8)
            r11.add(r6)
            int r1 = r1 + r4
            goto L_0x01b2
        L_0x01d8:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01dd:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01e2:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0241
            if (r4 != 0) goto L_0x01f2
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x0205
        L_0x01f2:
            int r6 = r1 + r4
            boolean r8 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r6)
            if (r8 == 0) goto L_0x023c
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x0204:
            r1 = r6
        L_0x0205:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0237
            if (r4 != 0) goto L_0x021f
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x0205
        L_0x021f:
            int r6 = r1 + r4
            boolean r8 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r6)
            if (r8 == 0) goto L_0x0232
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x0204
        L_0x0232:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0237:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x023c:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0241:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0246:
            if (r6 != r10) goto L_0x024e
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r3, r4, r11, r7)
            goto L_0x0364
        L_0x024e:
            if (r6 != 0) goto L_0x0363
            com.google.android.gms.internal.vision.zzff r11 = (com.google.android.gms.internal.vision.zzff) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r4 = 0
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x025f
            r6 = 1
            goto L_0x0260
        L_0x025f:
            r6 = 0
        L_0x0260:
            r11.addBoolean(r6)
        L_0x0263:
            if (r1 >= r5) goto L_0x0364
            int r6 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r6, r7)
            long r8 = r7.zzrp
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0279
            r6 = 1
            goto L_0x027a
        L_0x0279:
            r6 = 0
        L_0x027a:
            r11.addBoolean(r6)
            goto L_0x0263
        L_0x027e:
            if (r6 != r10) goto L_0x0286
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4, r11, r7)
            goto L_0x0364
        L_0x0286:
            if (r6 != r9) goto L_0x0363
            com.google.android.gms.internal.vision.zzgu r11 = (com.google.android.gms.internal.vision.zzgu) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r18, r19)
            r11.zzbl(r1)
            int r1 = r4 + 4
        L_0x0293:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4)
            r11.zzbl(r1)
            int r1 = r4 + 4
            goto L_0x0293
        L_0x02a7:
            if (r6 != r10) goto L_0x02af
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4, r11, r7)
            goto L_0x0364
        L_0x02af:
            if (r6 != r13) goto L_0x0363
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r18, r19)
            r11.zzac(r8)
            int r1 = r4 + 8
        L_0x02bc:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4)
            r11.zzac(r8)
            int r1 = r4 + 8
            goto L_0x02bc
        L_0x02d0:
            if (r6 != r10) goto L_0x02d8
            int r1 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzgz<?>) r11, (com.google.android.gms.internal.vision.zzfb) r7)
            goto L_0x0364
        L_0x02d8:
            if (r6 != 0) goto L_0x0363
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.vision.zzez.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.vision.zzgz<?>) r25, (com.google.android.gms.internal.vision.zzfb) r26)
            goto L_0x0364
        L_0x02ea:
            if (r6 != r10) goto L_0x02f2
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11, r7)
            goto L_0x0364
        L_0x02f2:
            if (r6 != 0) goto L_0x0363
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r11.zzac(r8)
        L_0x02ff:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r11.zzac(r8)
            goto L_0x02ff
        L_0x0313:
            if (r6 != r10) goto L_0x031a
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r3, r4, r11, r7)
            goto L_0x0364
        L_0x031a:
            if (r6 != r9) goto L_0x0363
            com.google.android.gms.internal.vision.zzgo r11 = (com.google.android.gms.internal.vision.zzgo) r11
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r18, r19)
            r11.zzu(r1)
            int r1 = r4 + 4
        L_0x0327:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4)
            r11.zzu(r1)
            int r1 = r4 + 4
            goto L_0x0327
        L_0x033b:
            if (r6 != r10) goto L_0x0342
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r3, r4, r11, r7)
            goto L_0x0364
        L_0x0342:
            if (r6 != r13) goto L_0x0363
            com.google.android.gms.internal.vision.zzgb r11 = (com.google.android.gms.internal.vision.zzgb) r11
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r18, r19)
            r11.zzc(r8)
            int r1 = r4 + 8
        L_0x034f:
            if (r1 >= r5) goto L_0x0364
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0364
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4)
            r11.zzc(r8)
            int r1 = r4 + 8
            goto L_0x034f
        L_0x0363:
            r1 = r4
        L_0x0364:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.zzfb r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzyt
            java.lang.Object r12 = r7.zzbn(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            boolean r2 = r2.zzm(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            java.lang.Object r2 = r2.zzo(r12)
            com.google.android.gms.internal.vision.zzhv r3 = r7.zzzk
            r3.zzc(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzhv r8 = r7.zzzk
            com.google.android.gms.internal.vision.zzht r8 = r8.zzp(r12)
            com.google.android.gms.internal.vision.zzhv r12 = r7.zzzk
            java.util.Map r12 = r12.zzk(r1)
            int r10 = com.google.android.gms.internal.vision.zzez.zza(r9, r10, r15)
            int r13 = r15.zzro
            if (r13 < 0) goto L_0x0094
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0094
            int r13 = r13 + r10
            K r14 = r8.zzyn
            V r0 = r8.zzgc
        L_0x003e:
            if (r10 >= r13) goto L_0x0089
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.vision.zzez.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.vision.zzfb) r15)
            int r10 = r15.zzro
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            switch(r1) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0084
        L_0x0055:
            com.google.android.gms.internal.vision.zzka r1 = r8.zzyo
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0084
            com.google.android.gms.internal.vision.zzka r4 = r8.zzyo
            V r10 = r8.zzgc
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            java.lang.Object r0 = r15.zzrq
            goto L_0x003e
        L_0x006f:
            com.google.android.gms.internal.vision.zzka r1 = r8.zzym
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0084
            com.google.android.gms.internal.vision.zzka r4 = r8.zzym
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            java.lang.Object r14 = r15.zzrq
            goto L_0x003e
        L_0x0084:
            int r10 = com.google.android.gms.internal.vision.zzez.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.vision.zzfb) r15)
            goto L_0x003e
        L_0x0089:
            if (r10 != r13) goto L_0x008f
            r12.put(r14, r0)
            return r13
        L_0x008f:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r8
        L_0x0094:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a1, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.vision.zzfb r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzyt
            int[] r7 = r0.zzyu
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0191;
                case 52: goto L_0x0181;
                case 53: goto L_0x0171;
                case 54: goto L_0x0171;
                case 55: goto L_0x0161;
                case 56: goto L_0x0150;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x0161;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x0150;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a5
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a5
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.vision.zzir r2 = r0.zzbm(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.vision.zzfb) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0055:
            java.lang.Object r3 = r11.zzrq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzgt.zzb(r15, r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0060:
            if (r5 != 0) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            long r3 = com.google.android.gms.internal.vision.zzft.zzr(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0075:
            if (r5 != 0) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r3 = r11.zzro
            int r3 = com.google.android.gms.internal.vision.zzft.zzau(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x008a:
            if (r5 != 0) goto L_0x01a5
            int r3 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r4 = r11.zzro
            com.google.android.gms.internal.vision.zzgy r5 = r0.zzbo(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzf(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.vision.zzjm r1 = zzs(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x01a6
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x01a1
        L_0x00b8:
            if (r5 != r15) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x00c5:
            if (r5 != r15) goto L_0x01a5
            com.google.android.gms.internal.vision.zzir r2 = r0.zzbm(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzfb) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzrq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzgt.zzb(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a6
        L_0x00f3:
            if (r5 != r15) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r4 = r11.zzro
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a6
        L_0x0127:
            if (r5 != 0) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0140:
            if (r5 != r7) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a1
        L_0x0150:
            r2 = 1
            if (r5 != r2) goto L_0x01a5
            long r2 = com.google.android.gms.internal.vision.zzez.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
            goto L_0x01a1
        L_0x0161:
            if (r5 != 0) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r3 = r11.zzro
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0171:
            if (r5 != 0) goto L_0x01a5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x01a1
        L_0x0181:
            if (r5 != r7) goto L_0x01a5
            float r2 = com.google.android.gms.internal.vision.zzez.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x01a1
        L_0x0191:
            r2 = 1
            if (r5 != r2) goto L_0x01a5
            double r2 = com.google.android.gms.internal.vision.zzez.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x01a1:
            r12.putInt(r1, r13, r8)
            goto L_0x01a6
        L_0x01a5:
            r2 = r4
        L_0x01a6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    private final zzir zzbm(int i) {
        int i2 = (i / 3) << 1;
        zzir zzir = (zzir) this.zzyv[i2];
        if (zzir != null) {
            return zzir;
        }
        zzir zzf = zzin.zzho().zzf((Class) this.zzyv[i2 + 1]);
        this.zzyv[i2] = zzf;
        return zzf;
    }

    private final Object zzbn(int i) {
        return this.zzyv[(i / 3) << 1];
    }

    private final zzgy zzbo(int i) {
        return (zzgy) this.zzyv[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v89, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v121, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x036e, code lost:
        if (r0 == r15) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0372, code lost:
        r6 = r18;
        r2 = r26;
        r7 = r27;
        r3 = r31;
        r1 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03bd, code lost:
        if (r0 == r15) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0513, code lost:
        r2 = r1;
        r34 = r7;
        r7 = r40;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        r11 = r42;
        r12 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0219, code lost:
        r3 = r7;
        r1 = r8;
        r2 = r9;
        r9 = r11;
        r7 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x021f, code lost:
        r11 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0244, code lost:
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ba, code lost:
        r3 = r7;
        r1 = r8;
        r2 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02c6, code lost:
        r18 = r6;
        r6 = r7;
        r32 = r8;
        r26 = r9;
        r33 = r10;
        r2 = r13;
        r7 = r27;
        r0 = r41;
        r21 = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.vision.zzfb r42) throws java.io.IOException {
        /*
            r36 = this;
            r15 = r36
            r14 = r37
            r12 = r38
            r13 = r40
            r11 = r41
            r9 = r42
            sun.misc.Unsafe r10 = zzyt
            r16 = 0
            r0 = r39
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            r17 = 0
            if (r0 >= r13) goto L_0x06e1
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzfb) r9)
            int r3 = r9.zzro
            r4 = r0
            r5 = r3
            goto L_0x002c
        L_0x002a:
            r5 = r0
            r4 = r3
        L_0x002c:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzt(r3, r2)
        L_0x0038:
            r2 = r1
            goto L_0x003f
        L_0x003a:
            int r1 = r15.zzbs(r3)
            goto L_0x0038
        L_0x003f:
            r19 = 0
            r8 = -1
            if (r2 != r8) goto L_0x0053
            r32 = r3
            r2 = r4
            r18 = r6
            r33 = r10
            r0 = r11
            r21 = 1
            r26 = 0
            r6 = r5
            goto L_0x03e5
        L_0x0053:
            int[] r8 = r15.zzyu
            int r22 = r2 + 1
            r8 = r8[r22]
            r22 = 267386880(0xff00000, float:2.3665827E-29)
            r22 = r8 & r22
            int r1 = r22 >>> 20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r24 = r5
            r5 = r8 & r22
            long r11 = (long) r5
            r5 = 17
            r25 = r8
            if (r1 > r5) goto L_0x02d8
            int[] r5 = r15.zzyu
            int r26 = r2 + 2
            r5 = r5[r26]
            int r26 = r5 >>> 20
            r23 = 1
            int r26 = r23 << r26
            r5 = r5 & r22
            if (r5 == r7) goto L_0x008a
            r8 = -1
            if (r7 == r8) goto L_0x0084
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0084:
            long r6 = (long) r5
            int r6 = r10.getInt(r14, r6)
            r7 = r5
        L_0x008a:
            r5 = 5
            switch(r1) {
                case 0: goto L_0x02a0;
                case 1: goto L_0x0284;
                case 2: goto L_0x0262;
                case 3: goto L_0x0262;
                case 4: goto L_0x0247;
                case 5: goto L_0x0223;
                case 6: goto L_0x0201;
                case 7: goto L_0x01e1;
                case 8: goto L_0x01bc;
                case 9: goto L_0x018b;
                case 10: goto L_0x0170;
                case 11: goto L_0x0247;
                case 12: goto L_0x013b;
                case 13: goto L_0x0201;
                case 14: goto L_0x0223;
                case 15: goto L_0x011d;
                case 16: goto L_0x00ea;
                case 17: goto L_0x009c;
                default: goto L_0x008e;
            }
        L_0x008e:
            r9 = r2
            r8 = r3
            r13 = r4
            r27 = r7
            r7 = r24
        L_0x0095:
            r4 = 1
            r11 = r42
            r12 = r38
            goto L_0x02c6
        L_0x009c:
            r1 = 3
            if (r0 != r1) goto L_0x00e2
            int r0 = r3 << 3
            r5 = r0 | 4
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r2)
            r1 = r38
            r9 = r2
            r2 = r4
            r8 = r3
            r3 = r40
            r4 = r5
            r27 = r7
            r7 = r24
            r5 = r42
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            r1 = r6 & r26
            if (r1 != 0) goto L_0x00c5
            r5 = r42
            java.lang.Object r1 = r5.zzrq
            r10.putObject(r14, r11, r1)
            goto L_0x00d4
        L_0x00c5:
            r5 = r42
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r5.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00d4:
            r6 = r6 | r26
            r3 = r7
            r1 = r8
            r2 = r9
            r7 = r27
            r11 = r41
            r12 = r38
            r9 = r5
            goto L_0x0017
        L_0x00e2:
            r9 = r2
            r8 = r3
            r27 = r7
            r7 = r24
            r13 = r4
            goto L_0x0095
        L_0x00ea:
            r9 = r2
            r8 = r3
            r27 = r7
            r7 = r24
            r5 = r42
            if (r0 != 0) goto L_0x0118
            r2 = r11
            r12 = r38
            int r11 = com.google.android.gms.internal.vision.zzez.zzb(r12, r4, r5)
            long r0 = r5.zzrp
            long r17 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            r0 = r10
            r1 = r37
            r28 = r11
            r11 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r26
            r3 = r7
            r1 = r8
            r2 = r9
            r9 = r11
            r7 = r27
            r0 = r28
            goto L_0x021f
        L_0x0118:
            r11 = r5
            r12 = r38
            goto L_0x0244
        L_0x011d:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != 0) goto L_0x0244
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r4, r11)
            int r1 = r11.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r10.putInt(r14, r2, r1)
            r6 = r6 | r26
            goto L_0x0219
        L_0x013b:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != 0) goto L_0x0244
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r4, r11)
            int r1 = r11.zzro
            com.google.android.gms.internal.vision.zzgy r4 = r15.zzbo(r9)
            if (r4 == 0) goto L_0x0169
            boolean r4 = r4.zzf(r1)
            if (r4 == 0) goto L_0x015b
            goto L_0x0169
        L_0x015b:
            com.google.android.gms.internal.vision.zzjm r2 = zzs(r37)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r7, r1)
            goto L_0x0219
        L_0x0169:
            r10.putInt(r14, r2, r1)
            r6 = r6 | r26
            goto L_0x0219
        L_0x0170:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r1 = 2
            r11 = r42
            r12 = r38
            if (r0 != r1) goto L_0x0244
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzrq
            r10.putObject(r14, r2, r1)
            r6 = r6 | r26
            goto L_0x0219
        L_0x018b:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r1 = 2
            r11 = r42
            r12 = r38
            if (r0 != r1) goto L_0x0244
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r9)
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzfb) r11)
            r1 = r6 & r26
            if (r1 != 0) goto L_0x01ab
            java.lang.Object r1 = r11.zzrq
            r10.putObject(r14, r2, r1)
            goto L_0x01b8
        L_0x01ab:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r11.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x01b8:
            r6 = r6 | r26
            goto L_0x0219
        L_0x01bc:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r1 = 2
            r11 = r42
            r12 = r38
            if (r0 != r1) goto L_0x0244
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r25 & r0
            if (r0 != 0) goto L_0x01d5
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r4, r11)
            goto L_0x01d9
        L_0x01d5:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r4, r11)
        L_0x01d9:
            java.lang.Object r1 = r11.zzrq
            r10.putObject(r14, r2, r1)
            r6 = r6 | r26
            goto L_0x0219
        L_0x01e1:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != 0) goto L_0x0244
            int r0 = com.google.android.gms.internal.vision.zzez.zzb(r12, r4, r11)
            long r4 = r11.zzrp
            int r1 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01fa
            r1 = 1
            goto L_0x01fb
        L_0x01fa:
            r1 = 0
        L_0x01fb:
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (boolean) r1)
            r6 = r6 | r26
            goto L_0x0219
        L_0x0201:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != r5) goto L_0x0244
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            r6 = r6 | r26
        L_0x0219:
            r3 = r7
            r1 = r8
            r2 = r9
            r9 = r11
            r7 = r27
        L_0x021f:
            r11 = r41
            goto L_0x0017
        L_0x0223:
            r9 = r2
            r8 = r3
            r27 = r7
            r2 = r11
            r7 = r24
            r1 = 1
            r11 = r42
            r12 = r38
            if (r0 != r1) goto L_0x0244
            long r17 = com.google.android.gms.internal.vision.zzez.zzb(r12, r4)
            r0 = r10
            r1 = r37
            r13 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r13 + 8
            r6 = r6 | r26
            goto L_0x02ba
        L_0x0244:
            r13 = r4
            goto L_0x029e
        L_0x0247:
            r9 = r2
            r8 = r3
            r13 = r4
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != 0) goto L_0x029e
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r13, r11)
            int r1 = r11.zzro
            r10.putInt(r14, r2, r1)
            r6 = r6 | r26
            goto L_0x02ba
        L_0x0262:
            r9 = r2
            r8 = r3
            r13 = r4
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != 0) goto L_0x029e
            int r13 = com.google.android.gms.internal.vision.zzez.zzb(r12, r13, r11)
            long r4 = r11.zzrp
            r0 = r10
            r1 = r37
            r0.putLong(r1, r2, r4)
            r6 = r6 | r26
            r3 = r7
            r1 = r8
            r2 = r9
            r9 = r11
            r0 = r13
            goto L_0x02be
        L_0x0284:
            r9 = r2
            r8 = r3
            r13 = r4
            r27 = r7
            r2 = r11
            r7 = r24
            r11 = r42
            r12 = r38
            if (r0 != r5) goto L_0x029e
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r13)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r13 + 4
            r6 = r6 | r26
            goto L_0x02ba
        L_0x029e:
            r4 = 1
            goto L_0x02c6
        L_0x02a0:
            r9 = r2
            r8 = r3
            r13 = r4
            r27 = r7
            r2 = r11
            r7 = r24
            r4 = 1
            r11 = r42
            r12 = r38
            if (r0 != r4) goto L_0x02c6
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r13)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (double) r0)
            int r0 = r13 + 8
            r6 = r6 | r26
        L_0x02ba:
            r3 = r7
            r1 = r8
            r2 = r9
            r9 = r11
        L_0x02be:
            r7 = r27
            r11 = r41
            r13 = r40
            goto L_0x0017
        L_0x02c6:
            r18 = r6
            r6 = r7
            r32 = r8
            r26 = r9
            r33 = r10
            r2 = r13
            r7 = r27
            r0 = r41
            r21 = 1
            goto L_0x03e5
        L_0x02d8:
            r8 = r3
            r13 = r4
            r27 = r7
            r7 = r24
            r4 = 1
            r35 = r9
            r9 = r2
            r2 = r11
            r12 = r38
            r11 = r35
            r5 = 27
            if (r1 != r5) goto L_0x0335
            r5 = 2
            if (r0 != r5) goto L_0x0326
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r1 = r0.zzdo()
            if (r1 != 0) goto L_0x030c
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0303
            r1 = 10
            goto L_0x0305
        L_0x0303:
            int r1 = r1 << 1
        L_0x0305:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r1)
            r10.putObject(r14, r2, r0)
        L_0x030c:
            r5 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r9)
            r1 = r7
            r2 = r38
            r3 = r13
            r4 = r40
            r18 = r6
            r6 = r42
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
            r3 = r7
            r1 = r8
            r2 = r9
            r9 = r11
            r6 = r18
            goto L_0x02be
        L_0x0326:
            r18 = r6
            r31 = r7
            r32 = r8
            r26 = r9
            r33 = r10
            r15 = r13
            r21 = 1
            goto L_0x03c0
        L_0x0335:
            r18 = r6
            r5 = 49
            if (r1 > r5) goto L_0x038c
            r6 = r25
            long r5 = (long) r6
            r29 = r0
            r0 = r36
            r4 = r1
            r21 = 1
            r1 = r37
            r22 = r2
            r2 = r38
            r3 = r13
            r30 = r4
            r4 = r40
            r24 = r5
            r5 = r7
            r6 = r8
            r31 = r7
            r7 = r29
            r32 = r8
            r8 = r9
            r26 = r9
            r33 = r10
            r9 = r24
            r15 = r41
            r11 = r30
            r15 = r13
            r12 = r22
            r14 = r42
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzfb) r14)
            if (r0 != r15) goto L_0x0372
        L_0x0370:
            r2 = r0
            goto L_0x03c1
        L_0x0372:
            r6 = r18
            r2 = r26
            r7 = r27
            r3 = r31
            r1 = r32
        L_0x037c:
            r10 = r33
            r9 = r42
            r11 = r41
            r12 = r38
            r13 = r40
            r14 = r37
            r15 = r36
            goto L_0x0017
        L_0x038c:
            r29 = r0
            r30 = r1
            r22 = r2
            r31 = r7
            r32 = r8
            r26 = r9
            r33 = r10
            r15 = r13
            r6 = r25
            r21 = 1
            r0 = 50
            r9 = r30
            if (r9 != r0) goto L_0x03c8
            r7 = r29
            r0 = 2
            if (r7 != r0) goto L_0x03c0
            r0 = r36
            r1 = r37
            r2 = r38
            r3 = r15
            r4 = r40
            r5 = r26
            r6 = r22
            r8 = r42
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzfb) r8)
            if (r0 != r15) goto L_0x0372
            goto L_0x0370
        L_0x03c0:
            r2 = r15
        L_0x03c1:
            r7 = r27
            r6 = r31
            r0 = r41
            goto L_0x03e5
        L_0x03c8:
            r7 = r29
            r0 = r36
            r1 = r37
            r2 = r38
            r3 = r15
            r4 = r40
            r5 = r31
            r8 = r6
            r6 = r32
            r10 = r22
            r12 = r26
            r13 = r42
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzfb) r13)
            if (r0 != r15) goto L_0x06d3
            goto L_0x0370
        L_0x03e5:
            if (r6 != r0) goto L_0x03f8
            if (r0 != 0) goto L_0x03ea
            goto L_0x03f8
        L_0x03ea:
            r9 = r0
            r3 = r6
            r0 = r7
            r1 = r18
            r4 = -1
            r7 = r40
            r8 = r36
            r13 = r37
            goto L_0x06f1
        L_0x03f8:
            r9 = r0
            r8 = r36
            boolean r0 = r8.zzyz
            if (r0 == 0) goto L_0x06a6
            r10 = r42
            com.google.android.gms.internal.vision.zzgd r0 = r10.zzcm
            com.google.android.gms.internal.vision.zzgd r1 = com.google.android.gms.internal.vision.zzgd.zzfl()
            if (r0 == r1) goto L_0x069f
            com.google.android.gms.internal.vision.zzic r0 = r8.zzyy
            com.google.android.gms.internal.vision.zzjj<?, ?> r1 = r8.zzzi
            com.google.android.gms.internal.vision.zzgd r3 = r10.zzcm
            r11 = r32
            com.google.android.gms.internal.vision.zzgs$zzg r12 = r3.zza(r0, r11)
            if (r12 != 0) goto L_0x0430
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r37)
            r0 = r6
            r1 = r38
            r3 = r40
            r5 = r42
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            r34 = r7
            r7 = r40
            r13 = r37
            r15 = r38
            goto L_0x06c1
        L_0x0430:
            r13 = r37
            r0 = r13
            com.google.android.gms.internal.vision.zzgs$zze r0 = (com.google.android.gms.internal.vision.zzgs.zze) r0
            r0.zzgk()
            com.google.android.gms.internal.vision.zzgi<com.google.android.gms.internal.vision.zzgs$zzd> r14 = r0.zzwk
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r12.zzxb
            boolean r3 = r3.zzwi
            if (r3 == 0) goto L_0x051a
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r12.zzxb
            boolean r3 = r3.zzwj
            if (r3 == 0) goto L_0x051a
            int[] r3 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r4 = r12.zzxb
            com.google.android.gms.internal.vision.zzka r4 = r4.zzwh
            int r4 = r4.ordinal()
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0508;
                case 2: goto L_0x04fc;
                case 3: goto L_0x04f0;
                case 4: goto L_0x04f0;
                case 5: goto L_0x04e4;
                case 6: goto L_0x04e4;
                case 7: goto L_0x04d8;
                case 8: goto L_0x04d8;
                case 9: goto L_0x04cc;
                case 10: goto L_0x04cc;
                case 11: goto L_0x04c0;
                case 12: goto L_0x04b4;
                case 13: goto L_0x04a8;
                case 14: goto L_0x047e;
                default: goto L_0x0455;
            }
        L_0x0455:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Type cannot be packed: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x047e:
            com.google.android.gms.internal.vision.zzgu r3 = new com.google.android.gms.internal.vision.zzgu
            r3.<init>()
            r15 = r38
            int r2 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r15, (int) r2, (com.google.android.gms.internal.vision.zzgz<?>) r3, (com.google.android.gms.internal.vision.zzfb) r10)
            com.google.android.gms.internal.vision.zzjm r4 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r5 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r4 != r5) goto L_0x0493
            r4 = r17
        L_0x0493:
            com.google.android.gms.internal.vision.zzgs$zzd r5 = r12.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r5 = r5.zzwg
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r11, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgv<?>) r5, r4, r1)
            com.google.android.gms.internal.vision.zzjm r1 = (com.google.android.gms.internal.vision.zzjm) r1
            if (r1 == 0) goto L_0x04a1
            r0.zzwd = r1
        L_0x04a1:
            com.google.android.gms.internal.vision.zzgs$zzd r0 = r12.zzxb
            r14.zza(r0, (java.lang.Object) r3)
            goto L_0x0547
        L_0x04a8:
            r15 = r38
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04b4:
            r15 = r38
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04c0:
            r15 = r38
            com.google.android.gms.internal.vision.zzff r0 = new com.google.android.gms.internal.vision.zzff
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04cc:
            r15 = r38
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04d8:
            r15 = r38
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04e4:
            r15 = r38
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r15, (int) r2, (com.google.android.gms.internal.vision.zzgz<?>) r0, (com.google.android.gms.internal.vision.zzfb) r10)
            goto L_0x0513
        L_0x04f0:
            r15 = r38
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r15, r2, r0, r10)
            goto L_0x0513
        L_0x04fc:
            r15 = r38
            com.google.android.gms.internal.vision.zzgo r0 = new com.google.android.gms.internal.vision.zzgo
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r15, r2, r0, r10)
            goto L_0x0513
        L_0x0508:
            r15 = r38
            com.google.android.gms.internal.vision.zzgb r0 = new com.google.android.gms.internal.vision.zzgb
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r15, r2, r0, r10)
        L_0x0513:
            r2 = r1
            r34 = r7
            r7 = r40
            goto L_0x0698
        L_0x051a:
            r15 = r38
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r12.zzxb
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            com.google.android.gms.internal.vision.zzka r4 = com.google.android.gms.internal.vision.zzka.ENUM
            if (r3 != r4) goto L_0x055b
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r15, r2, r10)
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r12.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r3 = r3.zzwg
            int r4 = r10.zzro
            com.google.android.gms.internal.vision.zzgw r3 = r3.zzg(r4)
            if (r3 != 0) goto L_0x054d
            com.google.android.gms.internal.vision.zzjm r3 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0542
            com.google.android.gms.internal.vision.zzjm r3 = com.google.android.gms.internal.vision.zzjm.zzih()
            r0.zzwd = r3
        L_0x0542:
            int r0 = r10.zzro
            com.google.android.gms.internal.vision.zzit.zza((int) r11, (int) r0, r3, r1)
        L_0x0547:
            r34 = r7
            r7 = r40
            goto L_0x069d
        L_0x054d:
            int r0 = r10.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            r34 = r7
            r0 = r17
            r7 = r40
            goto L_0x0670
        L_0x055b:
            int[] r0 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0660;
                case 2: goto L_0x0650;
                case 3: goto L_0x0640;
                case 4: goto L_0x0640;
                case 5: goto L_0x0630;
                case 6: goto L_0x0630;
                case 7: goto L_0x0620;
                case 8: goto L_0x0620;
                case 9: goto L_0x0610;
                case 10: goto L_0x0610;
                case 11: goto L_0x05f9;
                case 12: goto L_0x05e5;
                case 13: goto L_0x05d2;
                case 14: goto L_0x05ca;
                case 15: goto L_0x05be;
                case 16: goto L_0x05b2;
                case 17: goto L_0x058d;
                case 18: goto L_0x0572;
                default: goto L_0x056a;
            }
        L_0x056a:
            r34 = r7
            r7 = r40
        L_0x056e:
            r0 = r17
            goto L_0x0670
        L_0x0572:
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r12.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r5 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r15, (int) r2, (int) r5, (com.google.android.gms.internal.vision.zzfb) r10)
            java.lang.Object r0 = r10.zzrq
            r34 = r7
            r7 = r5
            goto L_0x0670
        L_0x058d:
            r5 = r40
            int r0 = r11 << 3
            r4 = r0 | 4
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r12.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r1 = r38
            r3 = r40
            r34 = r7
            r7 = r5
            r5 = r42
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            java.lang.Object r0 = r10.zzrq
            goto L_0x0670
        L_0x05b2:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zzc(r15, r2, r10)
            java.lang.Object r0 = r10.zzrq
            goto L_0x0670
        L_0x05be:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zze(r15, r2, r10)
            java.lang.Object r0 = r10.zzrq
            goto L_0x0670
        L_0x05ca:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x05d2:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r15, r2, r10)
            long r0 = r10.zzrp
            long r0 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x056e
        L_0x05e5:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r15, r2, r10)
            int r0 = r10.zzro
            int r0 = com.google.android.gms.internal.vision.zzft.zzau(r0)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x056e
        L_0x05f9:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r15, r2, r10)
            long r0 = r10.zzrp
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0608
            goto L_0x060a
        L_0x0608:
            r21 = 0
        L_0x060a:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r21)
            goto L_0x056e
        L_0x0610:
            r34 = r7
            r7 = r40
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r15, r2)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            int r2 = r2 + 4
            goto L_0x056e
        L_0x0620:
            r34 = r7
            r7 = r40
            long r0 = com.google.android.gms.internal.vision.zzez.zzb(r15, r2)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            int r2 = r2 + 8
            goto L_0x056e
        L_0x0630:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r15, r2, r10)
            int r0 = r10.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x056e
        L_0x0640:
            r34 = r7
            r7 = r40
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r15, r2, r10)
            long r0 = r10.zzrp
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x056e
        L_0x0650:
            r34 = r7
            r7 = r40
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r15, r2)
            java.lang.Float r17 = java.lang.Float.valueOf(r0)
            int r2 = r2 + 4
            goto L_0x056e
        L_0x0660:
            r34 = r7
            r7 = r40
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r15, r2)
            java.lang.Double r17 = java.lang.Double.valueOf(r0)
            int r2 = r2 + 8
            goto L_0x056e
        L_0x0670:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            boolean r1 = r1.zzwi
            if (r1 == 0) goto L_0x067c
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            r14.zzb(r1, (java.lang.Object) r0)
            goto L_0x069d
        L_0x067c:
            int[] r1 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r12.zzxb
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            int r3 = r3.ordinal()
            r1 = r1[r3]
            switch(r1) {
                case 17: goto L_0x068c;
                case 18: goto L_0x068c;
                default: goto L_0x068b;
            }
        L_0x068b:
            goto L_0x0698
        L_0x068c:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            java.lang.Object r1 = r14.zza(r1)
            if (r1 == 0) goto L_0x0698
            java.lang.Object r0 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r0)
        L_0x0698:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r12.zzxb
            r14.zza(r1, (java.lang.Object) r0)
        L_0x069d:
            r0 = r2
            goto L_0x06c1
        L_0x069f:
            r34 = r7
            r11 = r32
            r7 = r40
            goto L_0x06ae
        L_0x06a6:
            r34 = r7
            r11 = r32
            r7 = r40
            r10 = r42
        L_0x06ae:
            r13 = r37
            r15 = r38
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r37)
            r0 = r6
            r1 = r38
            r3 = r40
            r5 = r42
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
        L_0x06c1:
            r3 = r6
            r1 = r11
            r14 = r13
            r12 = r15
            r6 = r18
            r2 = r26
            r13 = r7
            r15 = r8
            r11 = r9
            r9 = r10
            r10 = r33
            r7 = r34
            goto L_0x0017
        L_0x06d3:
            r6 = r31
            r11 = r32
            r3 = r6
            r1 = r11
            r6 = r18
            r2 = r26
            r7 = r27
            goto L_0x037c
        L_0x06e1:
            r18 = r6
            r27 = r7
            r33 = r10
            r9 = r11
            r7 = r13
            r13 = r14
            r8 = r15
            r2 = r0
            r1 = r18
            r0 = r27
            r4 = -1
        L_0x06f1:
            if (r0 == r4) goto L_0x06f9
            long r4 = (long) r0
            r0 = r33
            r0.putInt(r13, r4, r1)
        L_0x06f9:
            int r0 = r8.zzze
            r1 = r17
        L_0x06fd:
            int r4 = r8.zzzf
            if (r0 >= r4) goto L_0x0710
            int[] r4 = r8.zzzd
            r4 = r4[r0]
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r8.zzzi
            java.lang.Object r1 = r8.zza((java.lang.Object) r13, (int) r4, r1, r5)
            com.google.android.gms.internal.vision.zzjm r1 = (com.google.android.gms.internal.vision.zzjm) r1
            int r0 = r0 + 1
            goto L_0x06fd
        L_0x0710:
            if (r1 == 0) goto L_0x0717
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r8.zzzi
            r0.zzg(r13, r1)
        L_0x0717:
            if (r9 != 0) goto L_0x0721
            if (r2 != r7) goto L_0x071c
            goto L_0x0725
        L_0x071c:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0721:
            if (r2 > r7) goto L_0x0726
            if (r3 != r9) goto L_0x0726
        L_0x0725:
            return r2
        L_0x0726:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0167, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016c, code lost:
        r25 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e4, code lost:
        if (r0 == r15) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0212, code lost:
        if (r0 == r15) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0231, code lost:
        if (r0 == r15) goto L_0x01e6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r29, byte[] r30, int r31, int r32, com.google.android.gms.internal.vision.zzfb r33) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            boolean r0 = r15.zzzb
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = zzyt
            r10 = -1
            r16 = 0
            r0 = r31
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0257
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzfb) r11)
            int r3 = r11.zzro
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x003a
            int r2 = r2 / 3
            int r0 = r15.zzt(r7, r2)
        L_0x0038:
            r4 = r0
            goto L_0x003f
        L_0x003a:
            int r0 = r15.zzbs(r7)
            goto L_0x0038
        L_0x003f:
            if (r4 != r10) goto L_0x004c
            r25 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r27 = -1
            goto L_0x0234
        L_0x004c:
            int[] r0 = r15.zzyu
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0175
            r0 = 1
            switch(r3) {
                case 0: goto L_0x015a;
                case 1: goto L_0x014b;
                case 2: goto L_0x0139;
                case 3: goto L_0x0139;
                case 4: goto L_0x012b;
                case 5: goto L_0x0119;
                case 6: goto L_0x0108;
                case 7: goto L_0x00f2;
                case 8: goto L_0x00db;
                case 9: goto L_0x00ba;
                case 10: goto L_0x00ad;
                case 11: goto L_0x012b;
                case 12: goto L_0x009e;
                case 13: goto L_0x0108;
                case 14: goto L_0x0119;
                case 15: goto L_0x008b;
                case 16: goto L_0x0070;
                default: goto L_0x0065;
            }
        L_0x0065:
            r19 = r4
            r25 = r7
            r15 = r8
            r18 = r9
        L_0x006c:
            r27 = -1
            goto L_0x0215
        L_0x0070:
            if (r6 != 0) goto L_0x0065
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            r20 = r1
            long r0 = r11.zzrp
            long r22 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            r0 = r9
            r2 = r20
            r1 = r29
            r10 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            goto L_0x0149
        L_0x008b:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x016c
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x0167
        L_0x009e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x016c
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x0167
        L_0x00ad:
            r2 = r1
            if (r6 != r10) goto L_0x0065
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x0115
        L_0x00ba:
            r2 = r1
            if (r6 != r10) goto L_0x0065
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.vision.zzfb) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00d1
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x0115
        L_0x00d1:
            java.lang.Object r5 = r11.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x0115
        L_0x00db:
            r2 = r1
            if (r6 != r10) goto L_0x0065
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00e8
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8, r11)
            goto L_0x00ec
        L_0x00e8:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8, r11)
        L_0x00ec:
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x0115
        L_0x00f2:
            r2 = r1
            if (r6 != 0) goto L_0x0065
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r5 = r11.zzrp
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r0 = 0
        L_0x0103:
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x0115
        L_0x0108:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x0065
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x0115:
            r2 = r4
            r1 = r7
            goto L_0x0169
        L_0x0119:
            r2 = r1
            if (r6 != r0) goto L_0x0065
            long r5 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8)
            r0 = r9
            r1 = r29
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0167
        L_0x012b:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x016c
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x0167
        L_0x0139:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x016c
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r4 = r11.zzrp
            r0 = r9
            r1 = r29
            r0.putLong(r1, r2, r4)
        L_0x0149:
            r0 = r6
            goto L_0x0167
        L_0x014b:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x016c
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x0167
        L_0x015a:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x016c
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (double) r0)
            int r0 = r8 + 8
        L_0x0167:
            r1 = r7
            r2 = r10
        L_0x0169:
            r10 = -1
            goto L_0x0017
        L_0x016c:
            r25 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x006c
        L_0x0175:
            r0 = 27
            if (r3 != r0) goto L_0x01b1
            if (r6 != r10) goto L_0x0065
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r3 = r0.zzdo()
            if (r3 != 0) goto L_0x0199
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0190
            r3 = 10
            goto L_0x0192
        L_0x0190:
            int r3 = r3 << 1
        L_0x0192:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r3)
            r9.putObject(r14, r1, r0)
        L_0x0199:
            r5 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            r1 = r17
            r2 = r30
            r3 = r8
            r19 = r4
            r4 = r32
            r6 = r33
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0169
        L_0x01b1:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e8
            long r4 = (long) r5
            r0 = r28
            r20 = r1
            r1 = r29
            r2 = r30
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r32
            r5 = r17
            r24 = r6
            r6 = r7
            r25 = r7
            r7 = r24
            r15 = r8
            r8 = r19
            r18 = r9
            r26 = r10
            r27 = -1
            r9 = r22
            r11 = r26
            r12 = r20
            r14 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzfb) r14)
            if (r0 != r15) goto L_0x0244
        L_0x01e6:
            r2 = r0
            goto L_0x0234
        L_0x01e8:
            r20 = r1
            r26 = r3
            r24 = r6
            r25 = r7
            r15 = r8
            r18 = r9
            r27 = -1
            r0 = 50
            r9 = r26
            if (r9 != r0) goto L_0x0217
            r7 = r24
            if (r7 != r10) goto L_0x0215
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r20
            r8 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzfb) r8)
            if (r0 != r15) goto L_0x0244
            goto L_0x01e6
        L_0x0215:
            r2 = r15
            goto L_0x0234
        L_0x0217:
            r7 = r24
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r8 = r5
            r5 = r17
            r6 = r25
            r10 = r20
            r12 = r19
            r13 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzfb) r13)
            if (r0 != r15) goto L_0x0244
            goto L_0x01e6
        L_0x0234:
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r29)
            r0 = r17
            r1 = r30
            r3 = r32
            r5 = r33
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
        L_0x0244:
            r14 = r29
            r12 = r30
            r11 = r33
            r9 = r18
            r2 = r19
            r1 = r25
            r10 = -1
            r13 = r32
            r15 = r28
            goto L_0x0017
        L_0x0257:
            r4 = r13
            if (r0 != r4) goto L_0x025b
            return
        L_0x025b:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0260:
            r4 = r13
            r5 = 0
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r6 = r33
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfb):void");
    }

    public final void zzg(T t) {
        for (int i = this.zzze; i < this.zzzf; i++) {
            long zzbp = (long) (zzbp(this.zzzd[i]) & 1048575);
            Object zzp = zzjp.zzp(t, zzbp);
            if (zzp != null) {
                zzjp.zza((Object) t, zzbp, this.zzzk.zzn(zzp));
            }
        }
        int length = this.zzzd.length;
        for (int i2 = this.zzzf; i2 < length; i2++) {
            this.zzzh.zzb(t, (long) this.zzzd[i2]);
        }
        this.zzzi.zzg(t);
        if (this.zzyz) {
            this.zzzj.zzg(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzjj<UT, UB> zzjj) {
        zzgy zzbo;
        int i2 = this.zzyu[i];
        Object zzp = zzjp.zzp(obj, (long) (zzbp(i) & 1048575));
        if (zzp == null || (zzbo = zzbo(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzzk.zzk(zzp), zzbo, ub, zzjj);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzgy zzgy, UB ub, zzjj<UT, UB> zzjj) {
        zzht<?, ?> zzp = this.zzzk.zzp(zzbn(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzgy.zzf(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzjj.zzif();
                }
                zzfp zzap = zzfh.zzap(zzhu.zza(zzp, next.getKey(), next.getValue()));
                try {
                    zzhu.zza(zzap.zzew(), zzp, next.getKey(), next.getValue());
                    zzjj.zza(ub, i2, zzap.zzev());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0104, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(T r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = -1
            r1 = 0
            r2 = -1
            r3 = 0
        L_0x0005:
            int r4 = r13.zzze
            r5 = 1
            if (r1 >= r4) goto L_0x0108
            int[] r4 = r13.zzzd
            r4 = r4[r1]
            int[] r6 = r13.zzyu
            r6 = r6[r4]
            int r7 = r13.zzbp(r4)
            boolean r8 = r13.zzzb
            r9 = 1048575(0xfffff, float:1.469367E-39)
            if (r8 != 0) goto L_0x0035
            int[] r8 = r13.zzyu
            int r10 = r4 + 2
            r8 = r8[r10]
            r10 = r8 & r9
            int r8 = r8 >>> 20
            int r8 = r5 << r8
            if (r10 == r2) goto L_0x0036
            sun.misc.Unsafe r2 = zzyt
            long r11 = (long) r10
            int r2 = r2.getInt(r14, r11)
            r3 = r2
            r2 = r10
            goto L_0x0036
        L_0x0035:
            r8 = 0
        L_0x0036:
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r10 = r10 & r7
            if (r10 == 0) goto L_0x003d
            r10 = 1
            goto L_0x003e
        L_0x003d:
            r10 = 0
        L_0x003e:
            if (r10 == 0) goto L_0x0047
            boolean r10 = r13.zza(r14, (int) r4, (int) r3, (int) r8)
            if (r10 != 0) goto L_0x0047
            return r0
        L_0x0047:
            r10 = 267386880(0xff00000, float:2.3665827E-29)
            r10 = r10 & r7
            int r10 = r10 >>> 20
            r11 = 9
            if (r10 == r11) goto L_0x00f3
            r11 = 17
            if (r10 == r11) goto L_0x00f3
            r8 = 27
            if (r10 == r8) goto L_0x00c7
            r8 = 60
            if (r10 == r8) goto L_0x00b6
            r8 = 68
            if (r10 == r8) goto L_0x00b6
            switch(r10) {
                case 49: goto L_0x00c7;
                case 50: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0104
        L_0x0065:
            com.google.android.gms.internal.vision.zzhv r6 = r13.zzzk
            r7 = r7 & r9
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r7)
            java.util.Map r6 = r6.zzl(r7)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00b3
            java.lang.Object r4 = r13.zzbn(r4)
            com.google.android.gms.internal.vision.zzhv r7 = r13.zzzk
            com.google.android.gms.internal.vision.zzht r4 = r7.zzp(r4)
            com.google.android.gms.internal.vision.zzka r4 = r4.zzyo
            com.google.android.gms.internal.vision.zzkd r4 = r4.zzip()
            com.google.android.gms.internal.vision.zzkd r7 = com.google.android.gms.internal.vision.zzkd.MESSAGE
            if (r4 != r7) goto L_0x00b3
            r4 = 0
            java.util.Collection r6 = r6.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x0094:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b3
            java.lang.Object r7 = r6.next()
            if (r4 != 0) goto L_0x00ac
            com.google.android.gms.internal.vision.zzin r4 = com.google.android.gms.internal.vision.zzin.zzho()
            java.lang.Class r8 = r7.getClass()
            com.google.android.gms.internal.vision.zzir r4 = r4.zzf(r8)
        L_0x00ac:
            boolean r7 = r4.zzt(r7)
            if (r7 != 0) goto L_0x0094
            r5 = 0
        L_0x00b3:
            if (r5 != 0) goto L_0x0104
            return r0
        L_0x00b6:
            boolean r5 = r13.zza(r14, (int) r6, (int) r4)
            if (r5 == 0) goto L_0x0104
            com.google.android.gms.internal.vision.zzir r4 = r13.zzbm(r4)
            boolean r4 = zza((java.lang.Object) r14, (int) r7, (com.google.android.gms.internal.vision.zzir) r4)
            if (r4 != 0) goto L_0x0104
            return r0
        L_0x00c7:
            r6 = r7 & r9
            long r6 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r6)
            java.util.List r6 = (java.util.List) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00f0
            com.google.android.gms.internal.vision.zzir r4 = r13.zzbm(r4)
            r7 = 0
        L_0x00db:
            int r8 = r6.size()
            if (r7 >= r8) goto L_0x00f0
            java.lang.Object r8 = r6.get(r7)
            boolean r8 = r4.zzt(r8)
            if (r8 != 0) goto L_0x00ed
            r5 = 0
            goto L_0x00f0
        L_0x00ed:
            int r7 = r7 + 1
            goto L_0x00db
        L_0x00f0:
            if (r5 != 0) goto L_0x0104
            return r0
        L_0x00f3:
            boolean r5 = r13.zza(r14, (int) r4, (int) r3, (int) r8)
            if (r5 == 0) goto L_0x0104
            com.google.android.gms.internal.vision.zzir r4 = r13.zzbm(r4)
            boolean r4 = zza((java.lang.Object) r14, (int) r7, (com.google.android.gms.internal.vision.zzir) r4)
            if (r4 != 0) goto L_0x0104
            return r0
        L_0x0104:
            int r1 = r1 + 1
            goto L_0x0005
        L_0x0108:
            boolean r1 = r13.zzyz
            if (r1 == 0) goto L_0x0119
            com.google.android.gms.internal.vision.zzgf<?> r1 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r14 = r1.zze((java.lang.Object) r14)
            boolean r14 = r14.isInitialized()
            if (r14 != 0) goto L_0x0119
            return r0
        L_0x0119:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzt(java.lang.Object):boolean");
    }

    private static boolean zza(Object obj, int i, zzir zzir) {
        return zzir.zzt(zzjp.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzkg zzkg) throws IOException {
        if (obj instanceof String) {
            zzkg.zza(i, (String) obj);
        } else {
            zzkg.zza(i, (zzfh) obj);
        }
    }

    private final void zza(Object obj, int i, zzis zzis) throws IOException {
        if (zzbr(i)) {
            zzjp.zza(obj, (long) (i & 1048575), (Object) zzis.zzec());
        } else if (this.zzza) {
            zzjp.zza(obj, (long) (i & 1048575), (Object) zzis.readString());
        } else {
            zzjp.zza(obj, (long) (i & 1048575), (Object) zzis.zzed());
        }
    }

    private final int zzbp(int i) {
        return this.zzyu[i + 1];
    }

    private final int zzbq(int i) {
        return this.zzyu[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzjp.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzjp.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzjp.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzjp.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzjp.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzzb) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzzb) {
            int zzbp = zzbp(i);
            long j = (long) (zzbp & 1048575);
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    return zzjp.zzo(t, j) != 0.0d;
                case 1:
                    return zzjp.zzn(t, j) != 0.0f;
                case 2:
                    return zzjp.zzl(t, j) != 0;
                case 3:
                    return zzjp.zzl(t, j) != 0;
                case 4:
                    return zzjp.zzk(t, j) != 0;
                case 5:
                    return zzjp.zzl(t, j) != 0;
                case 6:
                    return zzjp.zzk(t, j) != 0;
                case 7:
                    return zzjp.zzm(t, j);
                case 8:
                    Object zzp = zzjp.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzfh) {
                        return !zzfh.zzrx.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzjp.zzp(t, j) != null;
                case 10:
                    return !zzfh.zzrx.equals(zzjp.zzp(t, j));
                case 11:
                    return zzjp.zzk(t, j) != 0;
                case 12:
                    return zzjp.zzk(t, j) != 0;
                case 13:
                    return zzjp.zzk(t, j) != 0;
                case 14:
                    return zzjp.zzl(t, j) != 0;
                case 15:
                    return zzjp.zzk(t, j) != 0;
                case 16:
                    return zzjp.zzl(t, j) != 0;
                case 17:
                    return zzjp.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbq = zzbq(i);
            return (zzjp.zzk(t, (long) (zzbq & 1048575)) & (1 << (zzbq >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzzb) {
            int zzbq = zzbq(i);
            long j = (long) (zzbq & 1048575);
            zzjp.zzb((Object) t, j, zzjp.zzk(t, j) | (1 << (zzbq >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzjp.zzk(t, (long) (zzbq(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzjp.zzb((Object) t, (long) (zzbq(i2) & 1048575), i);
    }

    private final int zzbs(int i) {
        if (i < this.zzyw || i > this.zzyx) {
            return -1;
        }
        return zzu(i, 0);
    }

    private final int zzt(int i, int i2) {
        if (i < this.zzyw || i > this.zzyx) {
            return -1;
        }
        return zzu(i, i2);
    }

    private final int zzu(int i, int i2) {
        int length = (this.zzyu.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzyu[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
