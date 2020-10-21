package com.uxcam.internals;

import com.uxcam.internals.C3263if;
import com.uxcam.internals.C3294jh;
import com.uxcam.internals.C3298jk;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.ju */
public class C3312ju extends C3310jt {

    /* renamed from: A */
    private int f2827A;

    /* renamed from: B */
    private boolean f2828B = true;

    /* renamed from: C */
    private C3314jw f2829C;

    /* renamed from: D */
    private C3230ha f2830D;

    /* renamed from: o */
    private List f2831o = new ArrayList();

    /* renamed from: p */
    private long f2832p = 0;

    /* renamed from: q */
    private long f2833q = -1;

    /* renamed from: r */
    private C3228gy f2834r = new C3228gy();

    /* renamed from: s */
    private C3225gv f2835s = new C3225gv();

    /* renamed from: t */
    private C3225gv f2836t = new C3225gv();

    /* renamed from: u */
    private List f2837u = new ArrayList();

    /* renamed from: v */
    private int f2838v = 0;

    /* renamed from: w */
    private int f2839w = 0;

    /* renamed from: x */
    private long f2840x = 0;

    /* renamed from: y */
    private int f2841y = -1;

    /* renamed from: z */
    private long f2842z;

    public C3312ju(C3230ha haVar, int i, C3251hu huVar) {
        super(i, huVar);
        this.f2830D = haVar;
        mo38553a(new C3240hj(1, 1), C3244hn.f2550a);
    }

    /* renamed from: a */
    private void m2345a(int i) {
        if (this.f2818g.size() != 0) {
            C3228gy gyVar = this.f2834r;
            long a = this.f2830D.mo38507a();
            if (gyVar.f2472b >= gyVar.f2471a.length) {
                long[] jArr = new long[(gyVar.f2471a.length + gyVar.f2473c)];
                System.arraycopy(gyVar.f2471a, 0, jArr, 0, gyVar.f2471a.length);
                gyVar.f2471a = jArr;
            }
            long[] jArr2 = gyVar.f2471a;
            int i2 = gyVar.f2472b;
            gyVar.f2472b = i2 + 1;
            jArr2[i2] = a;
            for (ByteBuffer byteBuffer : this.f2818g) {
                this.f2835s.mo38513a(byteBuffer.remaining());
                this.f2830D.write(byteBuffer);
            }
            if (this.f2820i == -1 || this.f2820i != this.f2818g.size()) {
                this.f2819h.add(new C3294jh.C3295aa((long) (this.f2821j + 1), this.f2818g.size(), i));
            }
            this.f2820i = this.f2818g.size();
            this.f2821j++;
            this.f2817f = 0;
            this.f2818g.clear();
        }
    }

    /* renamed from: a */
    private void m2346a(C3286ja jaVar) {
        if (this.f2837u.size() > 0) {
            this.f2837u.add(new C3263if.C3264aa(this.f2839w, this.f2838v));
            int i = Integer.MAX_VALUE;
            for (C3263if.C3264aa aaVar : this.f2837u) {
                if (aaVar.f2636b < i) {
                    i = aaVar.f2636b;
                }
            }
            if (i > 0) {
                for (C3263if.C3264aa aaVar2 : this.f2837u) {
                    aaVar2.f2636b -= i;
                }
            }
            C3263if.C3264aa aaVar3 = (C3263if.C3264aa) this.f2837u.get(0);
            if (aaVar3.f2636b > 0) {
                if (this.f2824m == null) {
                    this.f2824m = new ArrayList();
                    this.f2824m.add(new C3268ii(this.f2842z, (long) aaVar3.f2636b));
                } else {
                    for (C3268ii iiVar : this.f2824m) {
                        iiVar.f2640b += (long) aaVar3.f2636b;
                    }
                }
            }
            jaVar.mo38546a((C3255hx) new C3263if((C3263if.C3264aa[]) this.f2837u.toArray(new C3263if.C3264aa[0])));
        }
    }

    /* renamed from: a */
    public final long mo38551a() {
        return this.f2842z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: com.uxcam.internals.jq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.uxcam.internals.ji} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.uxcam.internals.jq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: com.uxcam.internals.jq} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.uxcam.internals.C3255hx mo38552a(com.uxcam.internals.C3284iy r18) {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.f2822k
            if (r1 != 0) goto L_0x0207
            int r1 = r0.f2841y
            r0.m2345a((int) r1)
            long r1 = r0.f2832p
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0023
            java.util.List r1 = r0.f2831o
            com.uxcam.internals.jk$aa r2 = new com.uxcam.internals.jk$aa
            long r5 = r0.f2832p
            int r5 = (int) r5
            long r6 = r0.f2833q
            int r6 = (int) r6
            r2.<init>(r5, r6)
            r1.add(r2)
        L_0x0023:
            r1 = 1
            r0.f2822k = r1
            com.uxcam.internals.jo r2 = new com.uxcam.internals.jo
            r2.<init>()
            com.uxcam.internals.hl r5 = r17.mo38559d()
            com.uxcam.internals.jn r14 = new com.uxcam.internals.jn
            int r7 = r0.f2812a
            r6 = r18
            int r6 = r6.f2676c
            long r8 = (long) r6
            long r10 = r0.f2842z
            long r8 = r8 * r10
            int r6 = r0.f2814c
            long r10 = (long) r6
            long r8 = r8 / r10
            int r6 = r5.f2543a
            float r10 = (float) r6
            int r5 = r5.f2544b
            float r11 = (float) r5
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            long r12 = r5.getTime()
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            long r15 = r5.getTime()
            r5 = 9
            int[] r5 = new int[r5]
            r5 = {65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824} // fill-array
            r6 = r14
            r3 = r14
            r14 = r15
            r16 = r5
            r6.<init>(r7, r8, r10, r11, r12, r14, r16)
            r4 = 15
            r3.mo38543a((int) r4)
            r2.mo38546a((com.uxcam.internals.C3255hx) r3)
            r0.mo38555a((com.uxcam.internals.C3304jo) r2)
            com.uxcam.internals.iu r3 = new com.uxcam.internals.iu
            r3.<init>()
            r2.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.iv r12 = new com.uxcam.internals.iv
            int r5 = r0.f2814c
            long r6 = r0.f2842z
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            long r8 = r4.getTime()
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            long r10 = r4.getTime()
            r4 = r12
            r4.<init>(r5, r6, r8, r10)
            r3.mo38546a((com.uxcam.internals.C3255hx) r12)
            com.uxcam.internals.iq r4 = new com.uxcam.internals.iq
            java.lang.String r5 = "mhlr"
            com.uxcam.internals.hu r6 = r0.f2813b
            java.lang.String r6 = r6.f2568e
            java.lang.String r7 = "appl"
            r4.<init>(r5, r6, r7)
            r3.mo38546a((com.uxcam.internals.C3255hx) r4)
            com.uxcam.internals.iw r4 = new com.uxcam.internals.iw
            r4.<init>()
            r3.mo38546a((com.uxcam.internals.C3255hx) r4)
            com.uxcam.internals.hu r3 = r0.f2813b
            int[] r5 = com.uxcam.internals.C3310jt.C33111.f2826a
            int r6 = r3.ordinal()
            r5 = r5[r6]
            r6 = 0
            switch(r5) {
                case 1: goto L_0x011f;
                case 2: goto L_0x0116;
                case 3: goto L_0x00da;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Handler "
            r2.<init>(r4)
            java.lang.String r3 = r3.f2568e
            r2.append(r3)
            java.lang.String r3 = " not supported"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00da:
            com.uxcam.internals.ja r1 = new com.uxcam.internals.ja
            com.uxcam.internals.ir r3 = new com.uxcam.internals.ir
            java.lang.String r5 = "gmhd"
            r3.<init>(r5)
            r1.<init>(r3)
            com.uxcam.internals.ip r3 = new com.uxcam.internals.ip
            r3.<init>()
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.ja r3 = new com.uxcam.internals.ja
            com.uxcam.internals.ir r5 = new com.uxcam.internals.ir
            java.lang.String r7 = "tmcd"
            r5.<init>(r7)
            r3.<init>(r5)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.jl r5 = new com.uxcam.internals.jl
            r7 = 3
            short[] r8 = new short[r7]
            r8 = {0, 0, 0} // fill-array
            short[] r7 = new short[r7]
            r7 = {255, 255, 255} // fill-array
            java.lang.String r9 = "Lucida Grande"
            r5.<init>(r8, r7, r9)
            r3.mo38546a((com.uxcam.internals.C3255hx) r5)
            r4.mo38546a((com.uxcam.internals.C3255hx) r1)
            goto L_0x012a
        L_0x0116:
            com.uxcam.internals.ji r3 = new com.uxcam.internals.ji
            r3.<init>()
            r3.mo38543a((int) r1)
            goto L_0x0127
        L_0x011f:
            com.uxcam.internals.jq r3 = new com.uxcam.internals.jq
            r3.<init>(r6)
            r3.mo38543a((int) r1)
        L_0x0127:
            r4.mo38546a((com.uxcam.internals.C3255hx) r3)
        L_0x012a:
            com.uxcam.internals.iq r1 = new com.uxcam.internals.iq
            java.lang.String r3 = "dhlr"
            java.lang.String r5 = "url "
            java.lang.String r7 = "appl"
            r1.<init>(r3, r5, r7)
            r4.mo38546a((com.uxcam.internals.C3255hx) r1)
            com.uxcam.internals.ig r1 = new com.uxcam.internals.ig
            r1.<init>()
            r4.mo38546a((com.uxcam.internals.C3255hx) r1)
            com.uxcam.internals.ih r3 = new com.uxcam.internals.ih
            r3.<init>()
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.is r1 = new com.uxcam.internals.is
            com.uxcam.internals.ir r5 = new com.uxcam.internals.ir
            java.lang.String r7 = "alis"
            r8 = 0
            r5.<init>(r7, r8)
            r7 = 4
            byte[] r7 = new byte[r7]
            r7 = {0, 0, 0, 1} // fill-array
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r7)
            r1.<init>(r5, r7)
            r3.mo38546a((com.uxcam.internals.C3255hx) r1)
            com.uxcam.internals.ja r1 = new com.uxcam.internals.ja
            com.uxcam.internals.ir r3 = new com.uxcam.internals.ir
            java.lang.String r5 = "stbl"
            r3.<init>(r5)
            r1.<init>(r3)
            r4.mo38546a((com.uxcam.internals.C3255hx) r1)
            r0.m2346a((com.uxcam.internals.C3286ja) r1)
            r0.mo38557b(r2)
            java.lang.String r3 = r0.f2825n
            if (r3 == 0) goto L_0x0195
            com.uxcam.internals.ja r3 = new com.uxcam.internals.ja
            com.uxcam.internals.ir r4 = new com.uxcam.internals.ir
            java.lang.String r5 = "udta"
            r4.<init>(r5)
            r3.<init>(r4)
            com.uxcam.internals.iz r4 = new com.uxcam.internals.iz
            java.lang.String r5 = r0.f2825n
            r4.<init>(r5)
            r3.mo38546a((com.uxcam.internals.C3255hx) r4)
            r2.mo38546a((com.uxcam.internals.C3255hx) r3)
        L_0x0195:
            com.uxcam.internals.je r3 = new com.uxcam.internals.je
            java.util.List r4 = r0.f2823l
            com.uxcam.internals.jf[] r5 = new com.uxcam.internals.C3292jf[r6]
            java.lang.Object[] r4 = r4.toArray(r5)
            com.uxcam.internals.jf[] r4 = (com.uxcam.internals.C3292jf[]) r4
            r3.<init>((com.uxcam.internals.C3292jf[]) r4)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.jh r3 = new com.uxcam.internals.jh
            java.util.List r4 = r0.f2819h
            com.uxcam.internals.jh$aa[] r5 = new com.uxcam.internals.C3294jh.C3295aa[r6]
            java.lang.Object[] r4 = r4.toArray(r5)
            com.uxcam.internals.jh$aa[] r4 = (com.uxcam.internals.C3294jh.C3295aa[]) r4
            r3.<init>(r4)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.jg r3 = new com.uxcam.internals.jg
            com.uxcam.internals.gv r4 = r0.f2835s
            int[] r4 = r4.mo38515a()
            r3.<init>(r4)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.jk r3 = new com.uxcam.internals.jk
            java.util.List r4 = r0.f2831o
            com.uxcam.internals.jk$aa[] r5 = new com.uxcam.internals.C3298jk.C3299aa[r6]
            java.lang.Object[] r4 = r4.toArray(r5)
            com.uxcam.internals.jk$aa[] r4 = (com.uxcam.internals.C3298jk.C3299aa[]) r4
            r3.<init>(r4)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            com.uxcam.internals.hz r3 = new com.uxcam.internals.hz
            com.uxcam.internals.gy r4 = r0.f2834r
            int r5 = r4.f2472b
            long[] r5 = new long[r5]
            long[] r7 = r4.f2471a
            int r4 = r4.f2472b
            java.lang.System.arraycopy(r7, r6, r5, r6, r4)
            r3.<init>(r5)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
            boolean r3 = r0.f2828B
            if (r3 != 0) goto L_0x0206
            com.uxcam.internals.gv r3 = r0.f2836t
            int r3 = r3.f2467b
            if (r3 <= 0) goto L_0x0206
            com.uxcam.internals.jj r3 = new com.uxcam.internals.jj
            com.uxcam.internals.gv r4 = r0.f2836t
            int[] r4 = r4.mo38515a()
            r3.<init>((int[]) r4)
            r1.mo38546a((com.uxcam.internals.C3255hx) r3)
        L_0x0206:
            return r2
        L_0x0207:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "The muxer track has finished muxing"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3312ju.mo38552a(com.uxcam.internals.iy):com.uxcam.internals.hx");
    }

    /* renamed from: a */
    public final void mo38560a(C3248hr hrVar) {
        if (!this.f2822k) {
            boolean z = true;
            int i = hrVar.f2559g + 1;
            int i2 = (int) (hrVar.f2525b - this.f2840x);
            if (i2 != this.f2838v) {
                if (this.f2839w > 0) {
                    this.f2837u.add(new C3263if.C3264aa(this.f2839w, this.f2838v));
                }
                this.f2838v = i2;
                this.f2839w = 0;
            }
            this.f2839w++;
            this.f2840x += hrVar.f2526c;
            if (!(this.f2841y == -1 || this.f2841y == i)) {
                m2345a(this.f2841y);
                this.f2820i = -1;
            }
            this.f2818g.add(hrVar.f2524a);
            if (hrVar.f2527d) {
                this.f2836t.mo38513a(this.f2827A + 1);
            } else {
                this.f2828B = false;
            }
            this.f2827A++;
            this.f2817f += hrVar.f2526c;
            if (!(this.f2833q == -1 || hrVar.f2526c == this.f2833q)) {
                this.f2831o.add(new C3298jk.C3299aa((int) this.f2832p, (int) this.f2833q));
                this.f2832p = 0;
            }
            this.f2833q = hrVar.f2526c;
            this.f2832p++;
            this.f2842z += hrVar.f2526c;
            if (!(this.f2816e == C3244hn.f2550a || this.f2816e == C3244hn.f2551b)) {
                z = false;
            }
            if (z) {
                if ((this.f2816e == C3244hn.f2550a && this.f2818g.size() * this.f2815d.f2538b == this.f2815d.f2537a) || (this.f2816e == C3244hn.f2551b && this.f2817f > 0 && this.f2817f * ((long) this.f2815d.f2538b) >= ((long) (this.f2815d.f2537a * this.f2814c)))) {
                    m2345a(i);
                }
                if (this.f2829C != null) {
                    C3314jw jwVar = this.f2829C;
                    if (hrVar.f2527d) {
                        jwVar.mo38563e();
                    }
                    jwVar.f2847o.add(new C3238hh(hrVar));
                }
                this.f2841y = i;
                return;
            }
            throw new AssertionError();
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }
}
