package com.uxcam.internals;

import com.uxcam.video.screen.codec.codecs.h264.p018io.model.MBType;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SeqParameterSet;

/* renamed from: com.uxcam.internals.go */
public final class C3218go {

    /* renamed from: a */
    private C3237hg f2438a;

    /* renamed from: b */
    private C3233hd f2439b;

    /* renamed from: c */
    private int[] f2440c;

    /* renamed from: d */
    private int[] f2441d;

    /* renamed from: e */
    private int f2442e;

    /* renamed from: f */
    private int f2443f;

    public C3218go(SeqParameterSet seqParameterSet, int i, int i2) {
        this.f2438a = seqParameterSet.chroma_format_idc;
        this.f2439b = this.f2438a == C3237hg.YUV420 ? C3211gh.f2418b : this.f2438a == C3237hg.YUV422 ? C3211gh.f2419c : this.f2438a == C3237hg.YUV444 ? C3211gh.f2417a[0] : null;
        this.f2442e = seqParameterSet.pic_width_in_mbs_minus1 + 1;
        this.f2443f = (1 << i2) - 1;
        this.f2440c = new int[4];
        this.f2441d = new int[(this.f2442e << i)];
    }

    /* renamed from: a */
    private static int m2170a(int i) {
        int i2 = i >> 31;
        return ((((i ^ i2) - i2) << 1) + (i >>> 31)) - 2;
    }

    /* renamed from: a */
    private static int m2171a(C3232hc hcVar, int[] iArr, C3233hd[] hdVarArr, int i, int i2, int[] iArr2, C3233hd hdVar) {
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = iArr[iArr2[i6 + i]];
            if (i7 == 0) {
                iArr3[i4] = iArr3[i4] + 1;
                i5++;
            } else {
                iArr4[i4] = i7;
                i4++;
            }
        }
        if (i4 < i2) {
            i5 -= iArr3[i4];
        }
        while (i3 < i4 && i3 < 3 && Math.abs(iArr4[(i4 - i3) - 1]) == 1) {
            i3++;
        }
        int i8 = (i4 << 4) | i3;
        hdVar.mo38525a(hcVar, i8);
        if (i4 > 0) {
            m2173a(hcVar, iArr4, i4, i3);
            m2175b(hcVar, iArr4, i4, i3);
            if (i4 < i2) {
                hdVarArr[i4 - 1].mo38525a(hcVar, i5);
                m2176c(hcVar, iArr3, i4, i5);
            }
        }
        return i8;
    }

    /* renamed from: a */
    private static C3233hd m2172a(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        return C3211gh.f2417a[Math.min(m2174b(z, mBType, i, z2, mBType2, i2), 8)];
    }

    /* renamed from: a */
    private static void m2173a(C3232hc hcVar, int[] iArr, int i, int i2) {
        for (int i3 = i - 1; i3 >= i - i2; i3--) {
            hcVar.mo38522a(iArr[i3] >>> 31);
        }
    }

    /* renamed from: b */
    private static int m2174b(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        int i3 = mBType == null ? 0 : i >> 4;
        int i4 = mBType2 == null ? 0 : i2 >> 4;
        if (z && z2) {
            return ((i3 + i4) + 1) >> 1;
        }
        if (z) {
            return i3;
        }
        if (z2) {
            return i4;
        }
        return 0;
    }

    /* renamed from: b */
    private static void m2175b(C3232hc hcVar, int[] iArr, int i, int i2) {
        int i3;
        int i4 = (i <= 10 || i2 >= 3) ? 0 : 1;
        int i5 = (i - i2) - 1;
        int i6 = i4;
        for (int i7 = i5; i7 >= 0; i7--) {
            int a = m2170a(iArr[i7]);
            if (i7 == i5 && i2 < 3) {
                a -= 2;
            }
            int i8 = a >> i6;
            if ((i6 == 0 && i8 < 14) || (i6 > 0 && i8 < 15)) {
                hcVar.mo38523a(1, i8 + 1);
                hcVar.mo38523a(a, i6);
            } else if (i6 != 0 || a >= 30) {
                if (i6 == 0) {
                    a -= 15;
                }
                int i9 = 12;
                while (true) {
                    int i10 = 1 << i9;
                    i3 = ((a - ((i9 + 3) << i6)) - i10) + 4096;
                    if (i3 < i10) {
                        break;
                    }
                    i9++;
                }
                hcVar.mo38523a(1, i9 + 4);
                hcVar.mo38523a(i3, i9);
            } else {
                hcVar.mo38523a(1, 15);
                hcVar.mo38523a(a - 14, 4);
            }
            if (i6 == 0) {
                i6 = 1;
            }
            if (C3245ho.m2230b(iArr[i7]) > (3 << (i6 - 1)) && i6 < 6) {
                i6++;
            }
        }
    }

    /* renamed from: c */
    private static void m2176c(C3232hc hcVar, int[] iArr, int i, int i2) {
        for (int i3 = i - 1; i3 > 0 && i2 > 0; i3--) {
            C3211gh.f2420d[Math.min(6, i2 - 1)].mo38525a(hcVar, iArr[i3]);
            i2 -= iArr[i3];
        }
    }

    /* renamed from: a */
    public final void mo38503a(C3232hc hcVar, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, C3233hd[] hdVarArr, int[] iArr2) {
        int a = m2171a(hcVar, iArr, hdVarArr, 1, 15, iArr2, m2172a(i != 0, mBType, this.f2440c[i2 & this.f2443f], i2 != 0, mBType2, this.f2441d[i]));
        this.f2440c[i2 & this.f2443f] = a;
        this.f2441d[i] = a;
    }

    /* renamed from: a */
    public final void mo38504a(C3232hc hcVar, int[] iArr, C3233hd[] hdVarArr, int i, int[] iArr2) {
        m2171a(hcVar, iArr, hdVarArr, 0, i, iArr2, this.f2439b);
    }

    /* renamed from: b */
    public final void mo38505b(C3232hc hcVar, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, C3233hd[] hdVarArr, int[] iArr2) {
        m2171a(hcVar, iArr, hdVarArr, 0, 16, iArr2, m2172a(i != 0, mBType, this.f2440c[i2 & this.f2443f], i2 != 0, mBType2, this.f2441d[i]));
    }
}
