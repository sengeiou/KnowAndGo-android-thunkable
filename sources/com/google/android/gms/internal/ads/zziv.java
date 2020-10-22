package com.google.android.gms.internal.ads;

import java.util.Stack;

public final class zziv implements zzid, zzio {
    private final zzkm zzamg = new zzkm(zzkj.zzaqt);
    private final zzkm zzamh = new zzkm(4);
    private final zzkm zzami = new zzkm(16);
    private final Stack<zzir> zzamj = new Stack<>();
    private int zzamk = 0;
    private long zzaml;
    private int zzamm;
    private long zzamn;
    private int zzamo;
    private zzkm zzamp;
    private int zzamq;
    private int zzamr;
    private int zzams;
    private zzif zzamt;
    private zziw[] zzamu;

    public final boolean zzfc() {
        return true;
    }

    public final void zza(zzif zzif) {
        this.zzamt = zzif;
    }

    public final void zzfh() {
        this.zzaml = 0;
        this.zzamr = 0;
        this.zzams = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0012 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x001e A[SYNTHETIC] */
    public final int zza(com.google.android.gms.internal.ads.zzie r44, com.google.android.gms.internal.ads.zzij r45) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r43 = this;
            r0 = r43
        L_0x0002:
            r1 = r44
        L_0x0004:
            r2 = r45
            int r3 = r0.zzamk
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r9 = 262144(0x40000, double:1.295163E-318)
            r15 = 0
            switch(r3) {
                case 0: goto L_0x037f;
                case 1: goto L_0x001e;
                default: goto L_0x0012;
            }
        L_0x0012:
            r3 = r0
            r4 = r1
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r0
            r0 = 0
            r1 = -1
            goto L_0x04ab
        L_0x001e:
            r0.zzamk = r15
            long r5 = r0.zzaml
            long r11 = r0.zzamn
            int r3 = r0.zzamo
            long r13 = (long) r3
            long r11 = r11 - r13
            long r5 = r5 + r11
            r0.zzaml = r5
            long r5 = r0.zzamn
            int r3 = r0.zzamo
            long r11 = (long) r3
            long r5 = r5 - r11
            com.google.android.gms.internal.ads.zzkm r3 = r0.zzamp
            if (r3 != 0) goto L_0x0043
            long r11 = r0.zzamn
            int r3 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x0041
            long r9 = r0.zzamn
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0043
        L_0x0041:
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r3 == 0) goto L_0x004b
            long r5 = r0.zzaml
            r2.zzahv = r5
            goto L_0x007c
        L_0x004b:
            com.google.android.gms.internal.ads.zzkm r7 = r0.zzamp
            if (r7 == 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzkm r7 = r0.zzamp
            byte[] r7 = r7.data
            int r8 = r0.zzamo
            int r5 = (int) r5
            r1.readFully(r7, r8, r5)
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r5 = r0.zzamj
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x007c
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r5 = r0.zzamj
            java.lang.Object r5 = r5.peek()
            com.google.android.gms.internal.ads.zzir r5 = (com.google.android.gms.internal.ads.zzir) r5
            com.google.android.gms.internal.ads.zzis r6 = new com.google.android.gms.internal.ads.zzis
            int r7 = r0.zzamm
            com.google.android.gms.internal.ads.zzkm r8 = r0.zzamp
            r6.<init>(r7, r8)
            java.util.List<com.google.android.gms.internal.ads.zzis> r5 = r5.zzama
            r5.add(r6)
            goto L_0x007c
        L_0x0078:
            int r5 = (int) r5
            r1.zzr(r5)
        L_0x007c:
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r5 = r0.zzamj
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0375
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r5 = r0.zzamj
            java.lang.Object r5 = r5.peek()
            com.google.android.gms.internal.ads.zzir r5 = (com.google.android.gms.internal.ads.zzir) r5
            long r5 = r5.zzalz
            long r7 = r0.zzaml
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0375
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r5 = r0.zzamj
            java.lang.Object r5 = r5.pop()
            com.google.android.gms.internal.ads.zzir r5 = (com.google.android.gms.internal.ads.zzir) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zziq.zzako
            if (r6 != r7) goto L_0x034f
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = 0
        L_0x00a8:
            java.util.List<com.google.android.gms.internal.ads.zzir> r8 = r5.zzamb
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0332
            java.util.List<com.google.android.gms.internal.ads.zzir> r8 = r5.zzamb
            java.lang.Object r8 = r8.get(r7)
            com.google.android.gms.internal.ads.zzir r8 = (com.google.android.gms.internal.ads.zzir) r8
            int r9 = r8.type
            int r10 = com.google.android.gms.internal.ads.zziq.zzakq
            if (r9 != r10) goto L_0x031c
            int r9 = com.google.android.gms.internal.ads.zziq.zzakp
            com.google.android.gms.internal.ads.zzis r9 = r5.zzv(r9)
            com.google.android.gms.internal.ads.zzix r9 = com.google.android.gms.internal.ads.zzit.zza(r8, r9)
            if (r9 == 0) goto L_0x031c
            int r10 = r9.type
            r11 = 1936684398(0x736f756e, float:1.8971874E31)
            if (r10 == r11) goto L_0x00d8
            int r10 = r9.type
            r11 = 1986618469(0x76696465, float:1.1834389E33)
            if (r10 != r11) goto L_0x031c
        L_0x00d8:
            int r10 = com.google.android.gms.internal.ads.zziq.zzakr
            com.google.android.gms.internal.ads.zzir r8 = r8.zzw(r10)
            int r10 = com.google.android.gms.internal.ads.zziq.zzaks
            com.google.android.gms.internal.ads.zzir r8 = r8.zzw(r10)
            int r10 = com.google.android.gms.internal.ads.zziq.zzakt
            com.google.android.gms.internal.ads.zzir r8 = r8.zzw(r10)
            int r10 = com.google.android.gms.internal.ads.zziq.zzalw
            com.google.android.gms.internal.ads.zzis r10 = r8.zzv(r10)
            com.google.android.gms.internal.ads.zzkm r10 = r10.zzamc
            int r11 = com.google.android.gms.internal.ads.zziq.zzalx
            com.google.android.gms.internal.ads.zzis r11 = r8.zzv(r11)
            if (r11 != 0) goto L_0x0100
            int r11 = com.google.android.gms.internal.ads.zziq.zzaly
            com.google.android.gms.internal.ads.zzis r11 = r8.zzv(r11)
        L_0x0100:
            com.google.android.gms.internal.ads.zzkm r12 = r11.zzamc
            int r13 = com.google.android.gms.internal.ads.zziq.zzalv
            com.google.android.gms.internal.ads.zzis r13 = r8.zzv(r13)
            com.google.android.gms.internal.ads.zzkm r13 = r13.zzamc
            int r14 = com.google.android.gms.internal.ads.zziq.zzals
            com.google.android.gms.internal.ads.zzis r14 = r8.zzv(r14)
            com.google.android.gms.internal.ads.zzkm r14 = r14.zzamc
            int r4 = com.google.android.gms.internal.ads.zziq.zzalt
            com.google.android.gms.internal.ads.zzis r4 = r8.zzv(r4)
            if (r4 == 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzkm r4 = r4.zzamc
            goto L_0x011e
        L_0x011d:
            r4 = 0
        L_0x011e:
            int r15 = com.google.android.gms.internal.ads.zziq.zzalu
            com.google.android.gms.internal.ads.zzis r8 = r8.zzv(r15)
            if (r8 == 0) goto L_0x0129
            com.google.android.gms.internal.ads.zzkm r8 = r8.zzamc
            goto L_0x012a
        L_0x0129:
            r8 = 0
        L_0x012a:
            r15 = 12
            r10.setPosition(r15)
            int r17 = r10.zzgg()
            int r15 = r10.zzgg()
            int[] r2 = new int[r15]
            long[] r1 = new long[r15]
            r19 = r3
            long[] r3 = new long[r15]
            r20 = r5
            int[] r5 = new int[r15]
            r21 = r6
            r6 = 12
            r12.setPosition(r6)
            r22 = r7
            int r7 = r12.zzgg()
            r13.setPosition(r6)
            int r6 = r13.zzgg()
            r0 = 1
            int r6 = r6 - r0
            r23 = r9
            int r9 = r13.readInt()
            if (r9 != r0) goto L_0x0163
            r9 = 1
            goto L_0x0164
        L_0x0163:
            r9 = 0
        L_0x0164:
            if (r9 == 0) goto L_0x030e
            int r9 = r13.zzgg()
            r0 = 4
            r13.zzac(r0)
            if (r6 <= 0) goto L_0x017d
            int r0 = r13.zzgg()
            r16 = 1
            int r0 = r0 + -1
            r25 = r0
            r0 = 12
            goto L_0x0183
        L_0x017d:
            r16 = 1
            r0 = 12
            r25 = -1
        L_0x0183:
            r14.setPosition(r0)
            int r18 = r14.zzgg()
            int r18 = r18 + -1
            int r24 = r14.zzgg()
            int r26 = r14.zzgg()
            if (r8 == 0) goto L_0x01a8
            r8.setPosition(r0)
            int r27 = r8.zzgg()
            int r27 = r27 + -1
            int r28 = r8.zzgg()
            int r29 = r8.readInt()
            goto L_0x01ae
        L_0x01a8:
            r27 = 0
            r28 = 0
            r29 = 0
        L_0x01ae:
            if (r4 == 0) goto L_0x01c0
            r4.setPosition(r0)
            int r0 = r4.zzgg()
            int r30 = r4.zzgg()
            int r30 = r30 + -1
            r31 = r0
            goto L_0x01c4
        L_0x01c0:
            r30 = -1
            r31 = 0
        L_0x01c4:
            int r0 = r11.type
            r32 = r6
            int r6 = com.google.android.gms.internal.ads.zziq.zzalx
            if (r0 != r6) goto L_0x01d1
            long r33 = r12.zzge()
            goto L_0x01d5
        L_0x01d1:
            long r33 = r12.zzgh()
        L_0x01d5:
            r36 = r12
            r35 = r13
            r37 = r25
            r12 = r26
            r6 = r29
            r13 = r30
            r0 = 0
            r29 = 0
            r30 = r9
            r26 = r18
            r18 = r30
            r9 = r24
            r24 = 0
        L_0x01ee:
            if (r0 >= r15) goto L_0x02a8
            r3[r0] = r33
            if (r17 != 0) goto L_0x01f9
            int r38 = r10.zzgg()
            goto L_0x01fb
        L_0x01f9:
            r38 = r17
        L_0x01fb:
            r2[r0] = r38
            r39 = r2
            r40 = r3
            long r2 = (long) r6
            long r2 = r24 + r2
            r1[r0] = r2
            if (r4 != 0) goto L_0x020a
            r2 = 1
            goto L_0x020b
        L_0x020a:
            r2 = 0
        L_0x020b:
            r5[r0] = r2
            if (r0 != r13) goto L_0x021c
            r2 = 1
            r5[r0] = r2
            int r31 = r31 + -1
            if (r31 <= 0) goto L_0x021c
            int r3 = r4.zzgg()
            int r3 = r3 - r2
            r13 = r3
        L_0x021c:
            long r2 = (long) r12
            long r24 = r24 + r2
            int r9 = r9 + -1
            if (r9 != 0) goto L_0x0231
            if (r26 <= 0) goto L_0x0231
            int r2 = r14.zzgg()
            int r3 = r14.zzgg()
            int r26 = r26 + -1
            r9 = r2
            r12 = r3
        L_0x0231:
            if (r8 == 0) goto L_0x0246
            int r28 = r28 + -1
            if (r28 != 0) goto L_0x0246
            if (r27 <= 0) goto L_0x0246
            int r2 = r8.zzgg()
            int r3 = r8.readInt()
            int r27 = r27 + -1
            r28 = r2
            r6 = r3
        L_0x0246:
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x0291
            int r2 = r29 + 1
            if (r2 >= r7) goto L_0x0260
            int r3 = r11.type
            r41 = r4
            int r4 = com.google.android.gms.internal.ads.zziq.zzalx
            if (r3 != r4) goto L_0x025b
            long r33 = r36.zzge()
            goto L_0x0262
        L_0x025b:
            long r33 = r36.zzgh()
            goto L_0x0262
        L_0x0260:
            r41 = r4
        L_0x0262:
            r3 = r37
            if (r2 != r3) goto L_0x0281
            int r30 = r35.zzgg()
            r42 = r3
            r4 = r35
            r3 = 4
            r4.zzac(r3)
            int r32 = r32 + -1
            if (r32 <= 0) goto L_0x0285
            int r3 = r4.zzgg()
            r16 = 1
            int r37 = r3 + -1
            r42 = r37
            goto L_0x0285
        L_0x0281:
            r42 = r3
            r4 = r35
        L_0x0285:
            if (r2 >= r7) goto L_0x028c
            r29 = r2
            r18 = r30
            goto L_0x028e
        L_0x028c:
            r29 = r2
        L_0x028e:
            r37 = r42
            goto L_0x029c
        L_0x0291:
            r41 = r4
            r4 = r35
            r42 = r37
            r2 = r39[r0]
            long r2 = (long) r2
            long r33 = r33 + r2
        L_0x029c:
            int r0 = r0 + 1
            r35 = r4
            r2 = r39
            r3 = r40
            r4 = r41
            goto L_0x01ee
        L_0x02a8:
            r39 = r2
            r40 = r3
            r2 = 1000000(0xf4240, double:4.940656E-318)
            r0 = r23
            long r6 = r0.zzcs
            com.google.android.gms.internal.ads.zzkq.zza((long[]) r1, (long) r2, (long) r6)
            if (r31 != 0) goto L_0x02ba
            r2 = 1
            goto L_0x02bb
        L_0x02ba:
            r2 = 0
        L_0x02bb:
            com.google.android.gms.internal.ads.zzkh.checkArgument(r2)
            if (r9 != 0) goto L_0x02c2
            r2 = 1
            goto L_0x02c3
        L_0x02c2:
            r2 = 0
        L_0x02c3:
            com.google.android.gms.internal.ads.zzkh.checkArgument(r2)
            if (r18 != 0) goto L_0x02ca
            r2 = 1
            goto L_0x02cb
        L_0x02ca:
            r2 = 0
        L_0x02cb:
            com.google.android.gms.internal.ads.zzkh.checkArgument(r2)
            if (r26 != 0) goto L_0x02d2
            r2 = 1
            goto L_0x02d3
        L_0x02d2:
            r2 = 0
        L_0x02d3:
            com.google.android.gms.internal.ads.zzkh.checkArgument(r2)
            if (r27 != 0) goto L_0x02da
            r2 = 1
            goto L_0x02db
        L_0x02da:
            r2 = 0
        L_0x02db:
            com.google.android.gms.internal.ads.zzkh.checkArgument(r2)
            com.google.android.gms.internal.ads.zziz r2 = new com.google.android.gms.internal.ads.zziz
            r3 = r39
            r4 = r40
            r2.<init>(r4, r3, r1, r5)
            int r1 = r2.zzand
            if (r1 == 0) goto L_0x0307
            com.google.android.gms.internal.ads.zziw r1 = new com.google.android.gms.internal.ads.zziw
            r3 = r43
            com.google.android.gms.internal.ads.zzif r4 = r3.zzamt
            r15 = r22
            com.google.android.gms.internal.ads.zzip r4 = r4.zzs(r15)
            r1.<init>(r0, r2, r4)
            com.google.android.gms.internal.ads.zzip r2 = r1.zzamx
            com.google.android.gms.internal.ads.zzhj r0 = r0.zzame
            r2.zza(r0)
            r0 = r21
            r0.add(r1)
            goto L_0x0323
        L_0x0307:
            r0 = r21
            r15 = r22
            r3 = r43
            goto L_0x0323
        L_0x030e:
            r3 = r43
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "stsc first chunk must be 1"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.<init>(r1)
            throw r0
        L_0x031c:
            r19 = r3
            r20 = r5
            r15 = r7
            r3 = r0
            r0 = r6
        L_0x0323:
            int r7 = r15 + 1
            r6 = r0
            r0 = r3
            r3 = r19
            r5 = r20
            r1 = r44
            r2 = r45
            r15 = 0
            goto L_0x00a8
        L_0x0332:
            r19 = r3
            r1 = 0
            r3 = r0
            r0 = r6
            com.google.android.gms.internal.ads.zziw[] r2 = new com.google.android.gms.internal.ads.zziw[r1]
            java.lang.Object[] r0 = r0.toArray(r2)
            com.google.android.gms.internal.ads.zziw[] r0 = (com.google.android.gms.internal.ads.zziw[]) r0
            r3.zzamu = r0
            com.google.android.gms.internal.ads.zzif r0 = r3.zzamt
            r0.zzfi()
            com.google.android.gms.internal.ads.zzif r0 = r3.zzamt
            r0.zza(r3)
            r0 = 2
            r3.zzamk = r0
            goto L_0x036b
        L_0x034f:
            r19 = r3
            r20 = r5
            r3 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r0 = r3.zzamj
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x036b
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r0 = r3.zzamj
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzir r0 = (com.google.android.gms.internal.ads.zzir) r0
            java.util.List<com.google.android.gms.internal.ads.zzir> r0 = r0.zzamb
            r5 = r20
            r0.add(r5)
        L_0x036b:
            r0 = r3
            r3 = r19
            r1 = r44
            r2 = r45
            r15 = 0
            goto L_0x007c
        L_0x0375:
            r19 = r3
            r3 = r0
            if (r19 == 0) goto L_0x037c
            r0 = 1
            return r0
        L_0x037c:
            r0 = r3
            goto L_0x0002
        L_0x037f:
            r3 = r0
            r0 = 1
            com.google.android.gms.internal.ads.zzkm r1 = r3.zzami
            byte[] r1 = r1.data
            r2 = 8
            r4 = r44
            r5 = 0
            boolean r1 = r4.zza(r1, r5, r2, r0)
            if (r1 != 0) goto L_0x0392
            goto L_0x04a3
        L_0x0392:
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            r0.setPosition(r5)
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            long r0 = r0.zzge()
            r3.zzamn = r0
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            int r0 = r0.readInt()
            r3.zzamm = r0
            long r0 = r3.zzamn
            r5 = 1
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x03ca
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            byte[] r0 = r0.data
            r4.readFully(r0, r2, r2)
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            long r0 = r0.readLong()
            r3.zzamn = r0
            long r0 = r3.zzaml
            r9 = 16
            long r0 = r0 + r9
            r3.zzaml = r0
            r0 = 16
            r3.zzamo = r0
            goto L_0x03d3
        L_0x03ca:
            long r0 = r3.zzaml
            r9 = 8
            long r0 = r0 + r9
            r3.zzaml = r0
            r3.zzamo = r2
        L_0x03d3:
            int r0 = r3.zzamm
            int r1 = com.google.android.gms.internal.ads.zziq.zzako
            if (r0 == r1) goto L_0x03ec
            int r1 = com.google.android.gms.internal.ads.zziq.zzakq
            if (r0 == r1) goto L_0x03ec
            int r1 = com.google.android.gms.internal.ads.zziq.zzakr
            if (r0 == r1) goto L_0x03ec
            int r1 = com.google.android.gms.internal.ads.zziq.zzaks
            if (r0 == r1) goto L_0x03ec
            int r1 = com.google.android.gms.internal.ads.zziq.zzakt
            if (r0 != r1) goto L_0x03ea
            goto L_0x03ec
        L_0x03ea:
            r0 = 0
            goto L_0x03ed
        L_0x03ec:
            r0 = 1
        L_0x03ed:
            if (r0 == 0) goto L_0x0426
            long r0 = r3.zzamn
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x040c
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r0 = r3.zzamj
            com.google.android.gms.internal.ads.zzir r1 = new com.google.android.gms.internal.ads.zzir
            int r2 = r3.zzamm
            long r5 = r3.zzaml
            long r7 = r3.zzamn
            long r5 = r5 + r7
            int r7 = r3.zzamo
            long r7 = (long) r7
            long r5 = r5 - r7
            r1.<init>(r2, r5)
            r0.add(r1)
        L_0x040a:
            r0 = 0
            goto L_0x0422
        L_0x040c:
            java.util.Stack<com.google.android.gms.internal.ads.zzir> r0 = r3.zzamj
            com.google.android.gms.internal.ads.zzir r1 = new com.google.android.gms.internal.ads.zzir
            int r2 = r3.zzamm
            long r5 = r3.zzaml
            long r7 = r3.zzamn
            long r5 = r5 + r7
            int r7 = r3.zzamo
            long r7 = (long) r7
            long r5 = r5 - r7
            r1.<init>(r2, r5)
            r0.add(r1)
            goto L_0x040a
        L_0x0422:
            r3.zzamk = r0
            goto L_0x04a2
        L_0x0426:
            int r0 = r3.zzamm
            int r1 = com.google.android.gms.internal.ads.zziq.zzakz
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzakp
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzala
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalp
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalq
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalb
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzaka
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzaku
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzake
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzakc
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzals
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalt
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalu
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalv
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalw
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzalx
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzaly
            if (r0 == r1) goto L_0x0473
            int r1 = com.google.android.gms.internal.ads.zziq.zzaky
            if (r0 != r1) goto L_0x0471
            goto L_0x0473
        L_0x0471:
            r0 = 0
            goto L_0x0474
        L_0x0473:
            r0 = 1
        L_0x0474:
            if (r0 == 0) goto L_0x049c
            long r0 = r3.zzamn
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x047e
            r0 = 1
            goto L_0x047f
        L_0x047e:
            r0 = 0
        L_0x047f:
            com.google.android.gms.internal.ads.zzkh.checkState(r0)
            com.google.android.gms.internal.ads.zzkm r0 = new com.google.android.gms.internal.ads.zzkm
            long r5 = r3.zzamn
            int r1 = (int) r5
            r0.<init>((int) r1)
            r3.zzamp = r0
            com.google.android.gms.internal.ads.zzkm r0 = r3.zzami
            byte[] r0 = r0.data
            com.google.android.gms.internal.ads.zzkm r1 = r3.zzamp
            byte[] r1 = r1.data
            r5 = 0
            java.lang.System.arraycopy(r0, r5, r1, r5, r2)
            r0 = 1
            r3.zzamk = r0
            goto L_0x04a2
        L_0x049c:
            r0 = 1
            r1 = 0
            r3.zzamp = r1
            r3.zzamk = r0
        L_0x04a2:
            r5 = 1
        L_0x04a3:
            if (r5 != 0) goto L_0x04a7
            r0 = -1
            return r0
        L_0x04a7:
            r0 = r3
            r1 = r4
            goto L_0x0004
        L_0x04ab:
            com.google.android.gms.internal.ads.zziw[] r2 = r3.zzamu
            int r2 = r2.length
            if (r0 >= r2) goto L_0x04cb
            com.google.android.gms.internal.ads.zziw[] r2 = r3.zzamu
            r2 = r2[r0]
            int r7 = r2.zzamy
            com.google.android.gms.internal.ads.zziz r8 = r2.zzamw
            int r8 = r8.zzand
            if (r7 == r8) goto L_0x04c8
            com.google.android.gms.internal.ads.zziz r2 = r2.zzamw
            long[] r2 = r2.zzahq
            r7 = r2[r7]
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x04c8
            r1 = r0
            r5 = r7
        L_0x04c8:
            int r0 = r0 + 1
            goto L_0x04ab
        L_0x04cb:
            r0 = -1
            if (r1 != r0) goto L_0x04cf
            return r0
        L_0x04cf:
            com.google.android.gms.internal.ads.zziw[] r0 = r3.zzamu
            r0 = r0[r1]
            int r1 = r0.zzamy
            com.google.android.gms.internal.ads.zziz r2 = r0.zzamw
            long[] r2 = r2.zzahq
            r5 = r2[r1]
            long r7 = r44.getPosition()
            long r7 = r5 - r7
            int r2 = r3.zzamr
            long r11 = (long) r2
            long r7 = r7 + r11
            r11 = 0
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x05a7
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 < 0) goto L_0x04f4
            r0 = r45
            r2 = 1
            goto L_0x05aa
        L_0x04f4:
            int r2 = (int) r7
            r4.zzr(r2)
            com.google.android.gms.internal.ads.zziz r2 = r0.zzamw
            int[] r2 = r2.zzahp
            r2 = r2[r1]
            r3.zzamq = r2
            com.google.android.gms.internal.ads.zzix r2 = r0.zzamv
            int r2 = r2.zzamf
            r5 = -1
            if (r2 == r5) goto L_0x056a
            com.google.android.gms.internal.ads.zzkm r2 = r3.zzamh
            byte[] r2 = r2.data
            r5 = 0
            r2[r5] = r5
            r6 = 1
            r2[r6] = r5
            r6 = 2
            r2[r6] = r5
            com.google.android.gms.internal.ads.zzix r2 = r0.zzamv
            int r2 = r2.zzamf
            com.google.android.gms.internal.ads.zzix r5 = r0.zzamv
            int r5 = r5.zzamf
            r6 = 4
            int r12 = 4 - r5
        L_0x051f:
            int r5 = r3.zzamr
            int r6 = r3.zzamq
            if (r5 >= r6) goto L_0x0586
            int r5 = r3.zzams
            if (r5 != 0) goto L_0x0556
            com.google.android.gms.internal.ads.zzkm r5 = r3.zzamh
            byte[] r5 = r5.data
            r4.readFully(r5, r12, r2)
            com.google.android.gms.internal.ads.zzkm r5 = r3.zzamh
            r6 = 0
            r5.setPosition(r6)
            com.google.android.gms.internal.ads.zzkm r5 = r3.zzamh
            int r5 = r5.zzgg()
            r3.zzams = r5
            com.google.android.gms.internal.ads.zzkm r5 = r3.zzamg
            r5.setPosition(r6)
            com.google.android.gms.internal.ads.zzip r5 = r0.zzamx
            com.google.android.gms.internal.ads.zzkm r6 = r3.zzamg
            r7 = 4
            r5.zza((com.google.android.gms.internal.ads.zzkm) r6, (int) r7)
            int r5 = r3.zzamr
            int r5 = r5 + r7
            r3.zzamr = r5
            int r5 = r3.zzamq
            int r5 = r5 + r12
            r3.zzamq = r5
            goto L_0x051f
        L_0x0556:
            r7 = 4
            com.google.android.gms.internal.ads.zzip r5 = r0.zzamx
            int r6 = r3.zzams
            int r5 = r5.zza((com.google.android.gms.internal.ads.zzie) r4, (int) r6)
            int r6 = r3.zzamr
            int r6 = r6 + r5
            r3.zzamr = r6
            int r6 = r3.zzams
            int r6 = r6 - r5
            r3.zzams = r6
            goto L_0x051f
        L_0x056a:
            int r2 = r3.zzamr
            int r5 = r3.zzamq
            if (r2 >= r5) goto L_0x0586
            com.google.android.gms.internal.ads.zzip r2 = r0.zzamx
            int r5 = r3.zzamq
            int r6 = r3.zzamr
            int r5 = r5 - r6
            int r2 = r2.zza((com.google.android.gms.internal.ads.zzie) r4, (int) r5)
            int r5 = r3.zzamr
            int r5 = r5 + r2
            r3.zzamr = r5
            int r5 = r3.zzams
            int r5 = r5 - r2
            r3.zzams = r5
            goto L_0x056a
        L_0x0586:
            com.google.android.gms.internal.ads.zzip r6 = r0.zzamx
            com.google.android.gms.internal.ads.zziz r2 = r0.zzamw
            long[] r2 = r2.zzane
            r7 = r2[r1]
            com.google.android.gms.internal.ads.zziz r2 = r0.zzamw
            int[] r2 = r2.zzajr
            r9 = r2[r1]
            int r10 = r3.zzamq
            r11 = 0
            r12 = 0
            r6.zza(r7, r9, r10, r11, r12)
            int r1 = r0.zzamy
            r2 = 1
            int r1 = r1 + r2
            r0.zzamy = r1
            r0 = 0
            r3.zzamr = r0
            r3.zzams = r0
            return r0
        L_0x05a7:
            r2 = 1
            r0 = r45
        L_0x05aa:
            r0.zzahv = r5
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zziv.zza(com.google.android.gms.internal.ads.zzie, com.google.android.gms.internal.ads.zzij):int");
    }

    public final long zzdq(long j) {
        int i;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.zzamu.length; i2++) {
            zziz zziz = this.zzamu[i2].zzamw;
            int zza = zzkq.zza(zziz.zzane, j, true, false);
            while (true) {
                if (zza >= 0) {
                    if (zziz.zzane[zza] <= j && (zziz.zzajr[zza] & 1) != 0) {
                        break;
                    }
                    zza--;
                } else {
                    zza = -1;
                    break;
                }
            }
            if (i == -1) {
                i = zzkq.zzb(zziz.zzane, j, true, false);
                while (true) {
                    if (i < zziz.zzane.length) {
                        if (zziz.zzane[i] >= j && (zziz.zzajr[i] & 1) != 0) {
                            break;
                        }
                        i++;
                    } else {
                        i = -1;
                        break;
                    }
                }
            }
            this.zzamu[i2].zzamy = i;
            long j3 = zziz.zzahq[this.zzamu[i2].zzamy];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
