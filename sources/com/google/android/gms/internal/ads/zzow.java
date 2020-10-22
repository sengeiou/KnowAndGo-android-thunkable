package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C1470C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zzow implements zznn, zznu {
    private static final zznq zzazt = new zzox();
    private static final int zzbfz = zzsy.zzay("qt  ");
    private long zzack;
    private final Stack<zzok> zzamj = new Stack<>();
    private int zzamk;
    private int zzamm;
    private long zzamn;
    private int zzamr;
    private int zzams;
    private final zzst zzbaa = new zzst(zzsq.zzaqt);
    private final zzst zzbab = new zzst(4);
    private zznp zzbbf;
    private final zzst zzbga = new zzst(16);
    private int zzbgb;
    private zzst zzbgc;
    private zzoy[] zzbgd;
    private boolean zzbge;

    public final void release() {
    }

    public final boolean zzfc() {
        return true;
    }

    public final boolean zza(zzno zzno) throws IOException, InterruptedException {
        return zzoz.zzd(zzno);
    }

    public final void zza(zznp zznp) {
        this.zzbbf = zznp;
    }

    public final void zzd(long j, long j2) {
        this.zzamj.clear();
        this.zzbgb = 0;
        this.zzamr = 0;
        this.zzams = 0;
        if (j == 0) {
            zzip();
        } else if (this.zzbgd != null) {
            for (zzoy zzoy : this.zzbgd) {
                zzpc zzpc = zzoy.zzbgg;
                int zzej = zzpc.zzej(j2);
                if (zzej == -1) {
                    zzej = zzpc.zzek(j2);
                }
                zzoy.zzamy = zzej;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x01a0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzno r25, com.google.android.gms.internal.ads.zznt r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
        L_0x0006:
            int r3 = r0.zzamk
            r5 = 262144(0x40000, double:1.295163E-318)
            r8 = -1
            r9 = 8
            r10 = 1
            switch(r3) {
                case 0: goto L_0x01a2;
                case 1: goto L_0x0119;
                case 2: goto L_0x0018;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0018:
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r9 = -1
        L_0x001f:
            com.google.android.gms.internal.ads.zzoy[] r14 = r0.zzbgd
            int r14 = r14.length
            if (r3 >= r14) goto L_0x003f
            com.google.android.gms.internal.ads.zzoy[] r14 = r0.zzbgd
            r14 = r14[r3]
            int r15 = r14.zzamy
            com.google.android.gms.internal.ads.zzpc r7 = r14.zzbgg
            int r7 = r7.zzand
            if (r15 == r7) goto L_0x003c
            com.google.android.gms.internal.ads.zzpc r7 = r14.zzbgg
            long[] r7 = r7.zzahq
            r14 = r7[r15]
            int r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x003c
            r9 = r3
            r12 = r14
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x003f:
            if (r9 != r8) goto L_0x0042
            return r8
        L_0x0042:
            com.google.android.gms.internal.ads.zzoy[] r3 = r0.zzbgd
            r3 = r3[r9]
            com.google.android.gms.internal.ads.zznw r7 = r3.zzbgh
            int r8 = r3.zzamy
            com.google.android.gms.internal.ads.zzpc r9 = r3.zzbgg
            long[] r9 = r9.zzahq
            r12 = r9[r8]
            com.google.android.gms.internal.ads.zzpc r9 = r3.zzbgg
            int[] r9 = r9.zzahp
            r9 = r9[r8]
            com.google.android.gms.internal.ads.zzpa r14 = r3.zzbgf
            int r14 = r14.zzbgk
            if (r14 != r10) goto L_0x0061
            r14 = 8
            long r12 = r12 + r14
            int r9 = r9 + -8
        L_0x0061:
            long r14 = r25.getPosition()
            long r14 = r12 - r14
            int r4 = r0.zzamr
            long r10 = (long) r4
            long r14 = r14 + r10
            r10 = 0
            int r4 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x0115
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0077
            goto L_0x0115
        L_0x0077:
            int r2 = (int) r14
            r1.zzr(r2)
            com.google.android.gms.internal.ads.zzpa r2 = r3.zzbgf
            int r2 = r2.zzamf
            if (r2 == 0) goto L_0x00da
            com.google.android.gms.internal.ads.zzst r2 = r0.zzbab
            byte[] r2 = r2.data
            r4 = 0
            r2[r4] = r4
            r5 = 1
            r2[r5] = r4
            r5 = 2
            r2[r5] = r4
            com.google.android.gms.internal.ads.zzpa r2 = r3.zzbgf
            int r2 = r2.zzamf
            com.google.android.gms.internal.ads.zzpa r4 = r3.zzbgf
            int r4 = r4.zzamf
            r5 = 4
            int r4 = 4 - r4
        L_0x0099:
            int r5 = r0.zzamr
            if (r5 >= r9) goto L_0x00f2
            int r5 = r0.zzams
            if (r5 != 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbab
            byte[] r5 = r5.data
            r1.readFully(r5, r4, r2)
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbab
            r6 = 0
            r5.setPosition(r6)
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbab
            int r5 = r5.zzgg()
            r0.zzams = r5
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbaa
            r5.setPosition(r6)
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbaa
            r10 = 4
            r7.zza(r5, r10)
            int r5 = r0.zzamr
            int r5 = r5 + r10
            r0.zzamr = r5
            int r9 = r9 + r4
            goto L_0x0099
        L_0x00c8:
            r6 = 0
            int r5 = r0.zzams
            int r5 = r7.zza(r1, r5, r6)
            int r6 = r0.zzamr
            int r6 = r6 + r5
            r0.zzamr = r6
            int r6 = r0.zzams
            int r6 = r6 - r5
            r0.zzams = r6
            goto L_0x0099
        L_0x00da:
            int r2 = r0.zzamr
            if (r2 >= r9) goto L_0x00f2
            int r2 = r0.zzamr
            int r2 = r9 - r2
            r4 = 0
            int r2 = r7.zza(r1, r2, r4)
            int r4 = r0.zzamr
            int r4 = r4 + r2
            r0.zzamr = r4
            int r4 = r0.zzams
            int r4 = r4 - r2
            r0.zzams = r4
            goto L_0x00da
        L_0x00f2:
            r20 = r9
            com.google.android.gms.internal.ads.zzpc r1 = r3.zzbgg
            long[] r1 = r1.zzane
            r17 = r1[r8]
            com.google.android.gms.internal.ads.zzpc r1 = r3.zzbgg
            int[] r1 = r1.zzajr
            r19 = r1[r8]
            r21 = 0
            r22 = 0
            r16 = r7
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzamy
            r4 = 1
            int r1 = r1 + r4
            r3.zzamy = r1
            r1 = 0
            r0.zzamr = r1
            r0.zzams = r1
            return r1
        L_0x0115:
            r4 = 1
            r2.zzahv = r12
            return r4
        L_0x0119:
            long r3 = r0.zzamn
            int r7 = r0.zzbgb
            long r7 = (long) r7
            long r3 = r3 - r7
            long r7 = r25.getPosition()
            long r7 = r7 + r3
            com.google.android.gms.internal.ads.zzst r10 = r0.zzbgc
            if (r10 == 0) goto L_0x017d
            com.google.android.gms.internal.ads.zzst r5 = r0.zzbgc
            byte[] r5 = r5.data
            int r6 = r0.zzbgb
            int r3 = (int) r3
            r1.readFully(r5, r6, r3)
            int r3 = r0.zzamm
            int r4 = com.google.android.gms.internal.ads.zzoj.zzajz
            if (r3 != r4) goto L_0x015e
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbgc
            r3.setPosition(r9)
            int r4 = r3.readInt()
            int r5 = zzbfz
            if (r4 != r5) goto L_0x0147
        L_0x0145:
            r3 = 1
            goto L_0x015b
        L_0x0147:
            r4 = 4
            r3.zzac(r4)
        L_0x014b:
            int r4 = r3.zzjz()
            if (r4 <= 0) goto L_0x015a
            int r4 = r3.readInt()
            int r5 = zzbfz
            if (r4 != r5) goto L_0x014b
            goto L_0x0145
        L_0x015a:
            r3 = 0
        L_0x015b:
            r0.zzbge = r3
            goto L_0x0185
        L_0x015e:
            java.util.Stack<com.google.android.gms.internal.ads.zzok> r3 = r0.zzamj
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0185
            java.util.Stack<com.google.android.gms.internal.ads.zzok> r3 = r0.zzamj
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzok r3 = (com.google.android.gms.internal.ads.zzok) r3
            com.google.android.gms.internal.ads.zzol r4 = new com.google.android.gms.internal.ads.zzol
            int r5 = r0.zzamm
            com.google.android.gms.internal.ads.zzst r6 = r0.zzbgc
            r4.<init>(r5, r6)
            java.util.List<com.google.android.gms.internal.ads.zzol> r3 = r3.zzama
            r3.add(r4)
            goto L_0x0185
        L_0x017d:
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0187
            int r3 = (int) r3
            r1.zzr(r3)
        L_0x0185:
            r3 = 0
            goto L_0x018f
        L_0x0187:
            long r5 = r25.getPosition()
            long r5 = r5 + r3
            r2.zzahv = r5
            r3 = 1
        L_0x018f:
            r0.zzei(r7)
            if (r3 == 0) goto L_0x019c
            int r3 = r0.zzamk
            r4 = 2
            if (r3 == r4) goto L_0x019c
            r23 = 1
            goto L_0x019e
        L_0x019c:
            r23 = 0
        L_0x019e:
            if (r23 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x01a2:
            r3 = 1
            int r4 = r0.zzbgb
            if (r4 != 0) goto L_0x01cc
            com.google.android.gms.internal.ads.zzst r4 = r0.zzbga
            byte[] r4 = r4.data
            r5 = 0
            boolean r4 = r1.zza(r4, r5, r9, r3)
            if (r4 != 0) goto L_0x01b5
            r3 = 0
            goto L_0x02b3
        L_0x01b5:
            r0.zzbgb = r9
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            r3.setPosition(r5)
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            long r3 = r3.zzge()
            r0.zzamn = r3
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            int r3 = r3.readInt()
            r0.zzamm = r3
        L_0x01cc:
            long r3 = r0.zzamn
            r5 = 1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x01e8
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            byte[] r3 = r3.data
            r1.readFully(r3, r9, r9)
            int r3 = r0.zzbgb
            int r3 = r3 + r9
            r0.zzbgb = r3
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            long r3 = r3.zzgh()
            r0.zzamn = r3
        L_0x01e8:
            int r3 = r0.zzamm
            int r4 = com.google.android.gms.internal.ads.zzoj.zzako
            if (r3 == r4) goto L_0x0205
            int r4 = com.google.android.gms.internal.ads.zzoj.zzakq
            if (r3 == r4) goto L_0x0205
            int r4 = com.google.android.gms.internal.ads.zzoj.zzakr
            if (r3 == r4) goto L_0x0205
            int r4 = com.google.android.gms.internal.ads.zzoj.zzaks
            if (r3 == r4) goto L_0x0205
            int r4 = com.google.android.gms.internal.ads.zzoj.zzakt
            if (r3 == r4) goto L_0x0205
            int r4 = com.google.android.gms.internal.ads.zzoj.zzbcy
            if (r3 != r4) goto L_0x0203
            goto L_0x0205
        L_0x0203:
            r3 = 0
            goto L_0x0206
        L_0x0205:
            r3 = 1
        L_0x0206:
            if (r3 == 0) goto L_0x0232
            long r3 = r25.getPosition()
            long r5 = r0.zzamn
            long r3 = r3 + r5
            int r5 = r0.zzbgb
            long r5 = (long) r5
            long r3 = r3 - r5
            java.util.Stack<com.google.android.gms.internal.ads.zzok> r5 = r0.zzamj
            com.google.android.gms.internal.ads.zzok r6 = new com.google.android.gms.internal.ads.zzok
            int r7 = r0.zzamm
            r6.<init>(r7, r3)
            r5.add(r6)
            long r5 = r0.zzamn
            int r7 = r0.zzbgb
            long r9 = (long) r7
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x022e
            r0.zzei(r3)
        L_0x022b:
            r3 = 1
            goto L_0x02b3
        L_0x022e:
            r24.zzip()
            goto L_0x022b
        L_0x0232:
            int r3 = r0.zzamm
            int r4 = com.google.android.gms.internal.ads.zzoj.zzakz
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzakp
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzala
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalb
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzals
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalt
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalu
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzbcz
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalv
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalw
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzbdd
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzalx
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzaly
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzaky
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzajz
            if (r3 == r4) goto L_0x0277
            int r4 = com.google.android.gms.internal.ads.zzoj.zzbdk
            if (r3 != r4) goto L_0x0275
            goto L_0x0277
        L_0x0275:
            r3 = 0
            goto L_0x0278
        L_0x0277:
            r3 = 1
        L_0x0278:
            if (r3 == 0) goto L_0x02ad
            int r3 = r0.zzbgb
            if (r3 != r9) goto L_0x0280
            r3 = 1
            goto L_0x0281
        L_0x0280:
            r3 = 0
        L_0x0281:
            com.google.android.gms.internal.ads.zzsk.checkState(r3)
            long r3 = r0.zzamn
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x028f
            r3 = 1
            goto L_0x0290
        L_0x028f:
            r3 = 0
        L_0x0290:
            com.google.android.gms.internal.ads.zzsk.checkState(r3)
            com.google.android.gms.internal.ads.zzst r3 = new com.google.android.gms.internal.ads.zzst
            long r4 = r0.zzamn
            int r4 = (int) r4
            r3.<init>((int) r4)
            r0.zzbgc = r3
            com.google.android.gms.internal.ads.zzst r3 = r0.zzbga
            byte[] r3 = r3.data
            com.google.android.gms.internal.ads.zzst r4 = r0.zzbgc
            byte[] r4 = r4.data
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r4, r5, r9)
            r3 = 1
            r0.zzamk = r3
            goto L_0x02b3
        L_0x02ad:
            r3 = 1
            r4 = 0
            r0.zzbgc = r4
            r0.zzamk = r3
        L_0x02b3:
            if (r3 != 0) goto L_0x0006
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzow.zza(com.google.android.gms.internal.ads.zzno, com.google.android.gms.internal.ads.zznt):int");
    }

    public final long getDurationUs() {
        return this.zzack;
    }

    public final long zzdq(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzoy zzoy : this.zzbgd) {
            zzpc zzpc = zzoy.zzbgg;
            int zzej = zzpc.zzej(j);
            if (zzej == -1) {
                zzej = zzpc.zzek(j);
            }
            long j3 = zzpc.zzahq[zzej];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzip() {
        this.zzamk = 0;
        this.zzbgb = 0;
    }

    private final void zzei(long j) throws zzlm {
        zzpa zza;
        while (!this.zzamj.isEmpty() && this.zzamj.peek().zzbdz == j) {
            zzok pop = this.zzamj.pop();
            if (pop.type == zzoj.zzako) {
                long j2 = C1470C.TIME_UNSET;
                ArrayList arrayList = new ArrayList();
                zzpo zzpo = null;
                zznr zznr = new zznr();
                zzol zzay = pop.zzay(zzoj.zzbdk);
                if (!(zzay == null || (zzpo = zzom.zza(zzay, this.zzbge)) == null)) {
                    zznr.zzb(zzpo);
                }
                for (int i = 0; i < pop.zzamb.size(); i++) {
                    zzok zzok = pop.zzamb.get(i);
                    if (zzok.type == zzoj.zzakq && (zza = zzom.zza(zzok, pop.zzay(zzoj.zzakp), (long) C1470C.TIME_UNSET, (zzne) null, this.zzbge)) != null) {
                        zzpc zza2 = zzom.zza(zza, zzok.zzaz(zzoj.zzakr).zzaz(zzoj.zzaks).zzaz(zzoj.zzakt), zznr);
                        if (zza2.zzand != 0) {
                            zzoy zzoy = new zzoy(zza, zza2, this.zzbbf.zzd(i, zza.type));
                            zzlh zzae = zza.zzaue.zzae(zza2.zzbet + 30);
                            if (zza.type == 1) {
                                if (zznr.zzii()) {
                                    zzae = zzae.zzc(zznr.zzaty, zznr.zzatz);
                                }
                                if (zzpo != null) {
                                    zzae = zzae.zza(zzpo);
                                }
                            }
                            zzoy.zzbgh.zze(zzae);
                            j2 = Math.max(j2, zza.zzack);
                            arrayList.add(zzoy);
                        }
                    }
                }
                this.zzack = j2;
                this.zzbgd = (zzoy[]) arrayList.toArray(new zzoy[arrayList.size()]);
                this.zzbbf.zzfi();
                this.zzbbf.zza(this);
                this.zzamj.clear();
                this.zzamk = 2;
            } else if (!this.zzamj.isEmpty()) {
                this.zzamj.peek().zzamb.add(pop);
            }
        }
        if (this.zzamk != 2) {
            zzip();
        }
    }
}
