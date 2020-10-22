package com.uxcam.internals;

import com.google.android.exoplayer2.extractor.p012ts.PsExtractor;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.MBType;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnit;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnitType;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.PictureParameterSet;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.RefPicMarkingIDR;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SeqParameterSet;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SliceHeader;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SliceType;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.gi */
public final class C3212gi {

    /* renamed from: a */
    public int[][] f2428a;

    /* renamed from: b */
    public int[][] f2429b;

    /* renamed from: c */
    private C3218go[] f2430c;

    /* renamed from: d */
    private C3217gn f2431d;

    public C3212gi() {
        this(new C3216gm());
    }

    private C3212gi(C3217gn gnVar) {
        this.f2431d = gnVar;
    }

    /* renamed from: a */
    private int m2121a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return 128;
        }
        return i2 == 0 ? (C3222gs.m2188a(this.f2428a[0]) + 8) >> 4 : i == 0 ? (C3222gs.m2189a(this.f2429b[0], i) + 8) >> 4 : ((C3222gs.m2188a(this.f2428a[0]) + C3222gs.m2189a(this.f2429b[0], i)) + 16) >> 5;
    }

    /* renamed from: a */
    private int m2122a(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return m2124a(this.f2428a[i], this.f2429b[i], i4, i2);
        }
        if (i2 != 0) {
            return m2123a(this.f2428a[i], i4);
        }
        if (i3 != 0) {
            return m2123a(this.f2429b[i], i2);
        }
        return 128;
    }

    /* renamed from: a */
    private static int m2123a(int[] iArr, int i) {
        return ((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + 2) >> 2;
    }

    /* renamed from: a */
    private static int m2124a(int[] iArr, int[] iArr2, int i, int i2) {
        return ((((((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + iArr2[i2]) + iArr2[i2 + 1]) + iArr2[i2 + 2]) + iArr2[i2 + 3]) + 4) >> 3;
    }

    /* renamed from: a */
    private void m2125a(int i, C3232hc hcVar, int i2, int i3, int[] iArr) {
        if (iArr.length == 4) {
            C3215gl.m2168l(iArr);
            C3215gl.m2166j(iArr);
            this.f2430c[i].mo38504a(hcVar, iArr, C3211gh.f2422f, iArr.length, new int[]{0, 1, 2, 3});
        } else if (iArr.length == 8) {
            C3215gl.m2155b();
            C3215gl.m2153a();
            this.f2430c[i].mo38504a(hcVar, iArr, C3211gh.f2423g, iArr.length, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        } else {
            C3215gl.m2169m(iArr);
            C3215gl.m2164h(iArr);
            C3215gl.m2160d(iArr);
            C3218go goVar = this.f2430c[i];
            MBType mBType = MBType.I_16x16;
            goVar.mo38505b(hcVar, i2, i3, mBType, mBType, iArr, C3211gh.f2421e, C3215gl.f2432a);
        }
    }

    /* renamed from: a */
    private void m2126a(int i, C3232hc hcVar, int i2, int i3, int[][] iArr) {
        int[][] iArr2 = iArr;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            C3215gl.m2162f(iArr2[i4]);
            MBType mBType = MBType.I_16x16;
            this.f2430c[i].mo38503a(hcVar, i2 + C3211gh.f2426j[i4], i3 + C3211gh.f2427k[i4], mBType, mBType, iArr2[i4], C3211gh.f2421e, C3215gl.f2432a);
        }
    }

    /* renamed from: a */
    private static void m2127a(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5) {
        if (i3 + 4 >= i || i4 + 4 >= i2) {
            m2137b(iArr, i, i2, i3, i4, iArr2, i5);
        } else {
            m2128a(iArr, i, i3, i4, iArr2, i5);
        }
    }

    /* renamed from: a */
    private static void m2128a(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4) {
        int i5 = (i3 * i) + i2;
        int i6 = 0;
        int i7 = i5;
        int i8 = 0;
        while (i6 < 4) {
            iArr2[i8] = iArr[i7] - i4;
            iArr2[i8 + 1] = iArr[i7 + 1] - i4;
            iArr2[i8 + 2] = iArr[i7 + 2] - i4;
            iArr2[i8 + 3] = iArr[i7 + 3] - i4;
            i6++;
            i7 += i;
            i8 += 4;
        }
    }

    /* renamed from: a */
    private void m2129a(int[] iArr, int i, int i2, int i3, int[][] iArr2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        m2131a(iArr, m2122a(i4, i5, i6), iArr2[0], 3, 0, 0);
        int[] iArr3 = iArr;
        m2131a(iArr3, m2136b(i4, i5, i6), iArr2[1], 3, 4, 0);
        m2131a(iArr, m2138c(i4, i5, i6), iArr2[2], 3, 0, 4);
        m2131a(iArr3, m2139d(i4, i5, i6), iArr2[3], 3, 4, 4);
    }

    /* renamed from: a */
    private static void m2130a(int[] iArr, int i, int i2, int[] iArr2) {
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            iArr2[i3] = iArr[i];
            i += i2;
        }
    }

    /* renamed from: a */
    private static void m2131a(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = 1 << i2;
        int i6 = (i4 << i2) + i3;
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            iArr[i6] = C3245ho.m2229a(iArr2[i7] + i);
            iArr[i6 + 1] = C3245ho.m2229a(iArr2[i7 + 1] + i);
            iArr[i6 + 2] = C3245ho.m2229a(iArr2[i7 + 2] + i);
            iArr[i6 + 3] = C3245ho.m2229a(iArr2[i7 + 3] + i);
            i7 += 4;
            i6 += i5;
        }
    }

    /* renamed from: a */
    private static void m2132a(int[] iArr, int[][] iArr2) {
        if (iArr.length == 4) {
            C3215gl.m2165i(iArr);
            C3215gl.m2167k(iArr);
        } else if (iArr.length == 8) {
            C3215gl.m2157c();
            C3215gl.m2159d();
        } else {
            C3215gl.m2158c(iArr);
            C3215gl.m2163g(iArr);
            C3215gl.m2169m(iArr);
        }
        for (int i = 0; i < iArr2.length; i++) {
            C3215gl.m2161e(iArr2[i]);
            iArr2[i][0] = iArr[i];
            C3215gl.m2154a(iArr2[i]);
        }
    }

    /* renamed from: a */
    private static int[] m2133a(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i][0];
            iArr[i][0] = 0;
        }
        return iArr2;
    }

    /* renamed from: a */
    public static C3237hg[] m2134a() {
        return new C3237hg[]{C3237hg.YUV420J};
    }

    /* renamed from: a */
    private int[][] m2135a(C3239hi hiVar, int i, int i2, int i3, int i4, int i5) {
        C3239hi hiVar2 = hiVar;
        int i6 = i;
        int i7 = i4;
        int i8 = i5;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{16 >> (i2 + i3), 16});
        int i9 = i5;
        m2127a(hiVar2.f2535d[i6], hiVar.mo38528a(i), hiVar.mo38529b(i), i4, i9, iArr[0], m2122a(i6, i7, i8));
        C3215gl.m2156b(iArr[0]);
        int i10 = i7 + 4;
        m2127a(hiVar2.f2535d[i6], hiVar.mo38528a(i), hiVar.mo38529b(i), i10, i9, iArr[1], m2136b(i6, i7, i8));
        C3215gl.m2156b(iArr[1]);
        int i11 = i8 + 4;
        m2127a(hiVar2.f2535d[i6], hiVar.mo38528a(i), hiVar.mo38529b(i), i4, i11, iArr[2], m2138c(i6, i7, i8));
        C3215gl.m2156b(iArr[2]);
        m2127a(hiVar2.f2535d[i6], hiVar.mo38528a(i), hiVar.mo38529b(i), i10, i11, iArr[3], m2139d(i6, i7, i8));
        C3215gl.m2156b(iArr[3]);
        return iArr;
    }

    /* renamed from: b */
    private int m2136b(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i3 != 0) {
            return m2123a(this.f2429b[i], i2 + 4);
        }
        if (i2 != 0) {
            return m2123a(this.f2428a[i], i4);
        }
        return 128;
    }

    /* renamed from: b */
    private static void m2137b(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = i4;
        int i10 = 0;
        while (true) {
            i6 = i4 + 4;
            if (i9 >= Math.min(i6, i2)) {
                break;
            }
            int min = (i9 * i) + Math.min(i3, i);
            int i11 = i10;
            int i12 = i3;
            while (true) {
                i8 = i3 + 4;
                if (i12 >= Math.min(i8, i)) {
                    break;
                }
                iArr2[i11] = iArr[min] - i5;
                i12++;
                i11++;
                min++;
            }
            int i13 = min - 1;
            while (i12 < i8) {
                iArr2[i11] = iArr[i13] - i5;
                i12++;
                i11++;
            }
            i9++;
            i10 = i11;
        }
        while (i9 < i6) {
            int min2 = ((i2 * i) - i) + Math.min(i3, i);
            int i14 = i3;
            while (true) {
                i7 = i3 + 4;
                if (i14 >= Math.min(i7, i)) {
                    break;
                }
                iArr2[i10] = iArr[min2] - i5;
                i14++;
                i10++;
                min2++;
            }
            int i15 = min2 - 1;
            while (i14 < i7) {
                iArr2[i10] = iArr[i15] - i5;
                i14++;
                i10++;
            }
            i9++;
        }
    }

    /* renamed from: c */
    private int m2138c(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0) {
            return m2123a(this.f2428a[i], i4 + 4);
        }
        if (i3 != 0) {
            return m2123a(this.f2429b[i], i2);
        }
        return 128;
    }

    /* renamed from: d */
    private int m2139d(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return m2124a(this.f2428a[i], this.f2429b[i], i4 + 4, i2 + 4);
        }
        if (i2 != 0) {
            return m2123a(this.f2428a[i], i4 + 4);
        }
        if (i3 != 0) {
            return m2123a(this.f2429b[i], i2 + 4);
        }
        return 128;
    }

    /* renamed from: a */
    public final void mo38502a(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, C3239hi hiVar, ByteBuffer byteBuffer) {
        SeqParameterSet seqParameterSet2 = seqParameterSet;
        C3239hi hiVar2 = hiVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i = 1;
        this.f2430c = new C3218go[]{new C3218go(seqParameterSet2, 2, 2), new C3218go(seqParameterSet2, 1, 1), new C3218go(seqParameterSet2, 1, 1)};
        byteBuffer2.putInt(1);
        new NALUnit(NALUnitType.IDR_SLICE, 2).write(byteBuffer2);
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.slice_type = SliceType.I;
        sliceHeader.refPicMarkingIDR = new RefPicMarkingIDR(false, false);
        sliceHeader.pps = pictureParameterSet;
        sliceHeader.sps = seqParameterSet2;
        sliceHeader.pic_order_cnt_lsb = 0;
        C3232hc hcVar = new C3232hc(ByteBuffer.allocate(hiVar2.f2533b * hiVar2.f2534c));
        new C3220gq();
        SeqParameterSet seqParameterSet3 = sliceHeader.sps;
        PictureParameterSet pictureParameterSet2 = sliceHeader.pps;
        C3219gp.m2181a(hcVar, sliceHeader.first_mb_in_slice);
        C3219gp.m2181a(hcVar, sliceHeader.slice_type.ordinal() + (sliceHeader.slice_type_restr ? 5 : 0));
        C3219gp.m2181a(hcVar, sliceHeader.pic_parameter_set_id);
        hcVar.mo38523a(sliceHeader.frame_num, seqParameterSet3.log2_max_frame_num_minus4 + 4);
        if (!seqParameterSet3.frame_mbs_only_flag) {
            C3219gp.m2183a(hcVar, sliceHeader.field_pic_flag);
            if (sliceHeader.field_pic_flag) {
                C3219gp.m2183a(hcVar, sliceHeader.bottom_field_flag);
            }
        }
        C3219gp.m2181a(hcVar, sliceHeader.idr_pic_id);
        if (seqParameterSet3.pic_order_cnt_type == 0) {
            hcVar.mo38523a(sliceHeader.pic_order_cnt_lsb, seqParameterSet3.log2_max_pic_order_cnt_lsb_minus4 + 4);
            if (pictureParameterSet2.pic_order_present_flag && !seqParameterSet3.field_pic_flag) {
                C3219gp.m2184b(hcVar, sliceHeader.delta_pic_order_cnt_bottom);
            }
        }
        if (seqParameterSet3.pic_order_cnt_type == 1 && !seqParameterSet3.delta_pic_order_always_zero_flag) {
            C3219gp.m2184b(hcVar, sliceHeader.delta_pic_order_cnt[0]);
            if (pictureParameterSet2.pic_order_present_flag && !seqParameterSet3.field_pic_flag) {
                C3219gp.m2184b(hcVar, sliceHeader.delta_pic_order_cnt[1]);
            }
        }
        if (pictureParameterSet2.redundant_pic_cnt_present_flag) {
            C3219gp.m2181a(hcVar, sliceHeader.redundant_pic_cnt);
        }
        if (sliceHeader.slice_type == SliceType.B) {
            C3219gp.m2183a(hcVar, sliceHeader.direct_spatial_mv_pred_flag);
        }
        if (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.B) {
            C3219gp.m2183a(hcVar, sliceHeader.num_ref_idx_active_override_flag);
            if (sliceHeader.num_ref_idx_active_override_flag) {
                C3219gp.m2181a(hcVar, sliceHeader.num_ref_idx_active_minus1[0]);
                if (sliceHeader.slice_type == SliceType.B) {
                    C3219gp.m2181a(hcVar, sliceHeader.num_ref_idx_active_minus1[1]);
                }
            }
        }
        if (sliceHeader.slice_type.isInter()) {
            C3219gp.m2183a(hcVar, sliceHeader.refPicReordering[0] != null);
            C3220gq.m2186a(sliceHeader.refPicReordering[0], hcVar);
        }
        if (sliceHeader.slice_type == SliceType.B) {
            C3219gp.m2183a(hcVar, sliceHeader.refPicReordering[1] != null);
            C3220gq.m2186a(sliceHeader.refPicReordering[1], hcVar);
        }
        if ((pictureParameterSet2.weighted_pred_flag && (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP)) || (pictureParameterSet2.weighted_bipred_idc == 1 && sliceHeader.slice_type == SliceType.B)) {
            SeqParameterSet seqParameterSet4 = sliceHeader.sps;
            C3219gp.m2181a(hcVar, sliceHeader.pred_weight_table.luma_log2_weight_denom);
            if (seqParameterSet4.chroma_format_idc != C3237hg.MONO) {
                C3219gp.m2181a(hcVar, sliceHeader.pred_weight_table.chroma_log2_weight_denom);
            }
            C3220gq.m2185a(sliceHeader, hcVar, 0);
            if (sliceHeader.slice_type == SliceType.B) {
                C3220gq.m2185a(sliceHeader, hcVar, 1);
            }
        }
        RefPicMarkingIDR refPicMarkingIDR = sliceHeader.refPicMarkingIDR;
        C3219gp.m2183a(hcVar, refPicMarkingIDR.isDiscardDecodedPics());
        C3219gp.m2183a(hcVar, refPicMarkingIDR.isUseForlongTerm());
        if (pictureParameterSet2.entropy_coding_mode_flag && sliceHeader.slice_type.isInter()) {
            C3219gp.m2181a(hcVar, sliceHeader.cabac_init_idc);
        }
        C3219gp.m2184b(hcVar, sliceHeader.slice_qp_delta);
        if (sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.SI) {
            if (sliceHeader.slice_type == SliceType.SP) {
                C3219gp.m2183a(hcVar, sliceHeader.sp_for_switch_flag);
            }
            C3219gp.m2184b(hcVar, sliceHeader.slice_qs_delta);
        }
        if (pictureParameterSet2.deblocking_filter_control_present_flag) {
            C3219gp.m2181a(hcVar, sliceHeader.disable_deblocking_filter_idc);
            if (sliceHeader.disable_deblocking_filter_idc != 1) {
                C3219gp.m2184b(hcVar, sliceHeader.slice_alpha_c0_offset_div2);
                C3219gp.m2184b(hcVar, sliceHeader.slice_beta_offset_div2);
            }
        }
        if (pictureParameterSet2.num_slice_groups_minus1 > 0 && pictureParameterSet2.slice_group_map_type >= 3 && pictureParameterSet2.slice_group_map_type <= 5) {
            int i2 = ((seqParameterSet3.pic_height_in_map_units_minus1 + 1) * (seqParameterSet3.pic_width_in_mbs_minus1 + 1)) / (pictureParameterSet2.slice_group_change_rate_minus1 + 1);
            if (((seqParameterSet3.pic_height_in_map_units_minus1 + 1) * (seqParameterSet3.pic_width_in_mbs_minus1 + 1)) % (pictureParameterSet2.slice_group_change_rate_minus1 + 1) > 0) {
                i2++;
            }
            int i3 = (i2 + 1) - 1;
            int i4 = 0;
            while (i3 != 0) {
                i3 >>= 1;
                i4++;
            }
            hcVar.mo38523a(sliceHeader.slice_group_change_cycle, i4);
        }
        int i5 = 16;
        C3239hi b = C3239hi.m2225b(16, 16, C3237hg.YUV420);
        int i6 = 0;
        while (i6 < seqParameterSet2.pic_height_in_map_units_minus1 + i) {
            C3232hc hcVar2 = hcVar;
            int i7 = 0;
            while (i7 < seqParameterSet2.pic_width_in_mbs_minus1 + i) {
                C3219gp.m2181a(hcVar2, 23);
                C3232hc hcVar3 = new C3232hc(hcVar2.f2478a.duplicate(), hcVar2.f2480c, hcVar2.f2479b, hcVar2.f2481d);
                C3219gp.m2181a(hcVar3, 0);
                C3219gp.m2181a(hcVar3, C3245ho.m2231c(0));
                int i8 = i7 << 4;
                int i9 = i6 << 4;
                int a = m2121a(i8, i9);
                int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i5, i5});
                int i10 = 0;
                while (i10 < iArr.length) {
                    int[] iArr2 = iArr[i10];
                    m2127a(hiVar2.f2535d[0], hiVar2.mo38528a(0), hiVar2.mo38529b(0), i8 + C3211gh.f2424h[i10], i9 + C3211gh.f2425i[i10], iArr2, a);
                    C3215gl.m2156b(iArr2);
                    i10++;
                    hcVar2 = hcVar2;
                }
                C3232hc hcVar4 = hcVar2;
                int[] a2 = m2133a(iArr);
                int i11 = i9;
                C3232hc hcVar5 = hcVar3;
                C3232hc hcVar6 = hcVar3;
                int i12 = i7 << 2;
                int i13 = i11;
                C3232hc hcVar7 = hcVar4;
                int i14 = i6 << 2;
                int i15 = i7;
                m2125a(0, hcVar5, i12, i14, a2);
                m2126a(0, hcVar6, i12, i14, iArr);
                m2132a(a2, iArr);
                int[] iArr3 = b.f2535d[0];
                int a3 = m2121a(i8, i13);
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    m2131a(iArr3, a3, iArr[i16], 4, C3211gh.f2424h[i16], C3211gh.f2425i[i16]);
                }
                int i17 = hiVar2.f2532a.f2522n[1];
                int i18 = hiVar2.f2532a.f2523o[1];
                int i19 = i15 << (4 - i17);
                int i20 = i6 << (4 - i18);
                C3239hi hiVar3 = hiVar;
                int i21 = i17;
                int i22 = i18;
                int i23 = i19;
                int i24 = i6;
                int[][] a4 = m2135a(hiVar3, 1, i21, i22, i23, i20);
                int[][] a5 = m2135a(hiVar3, 2, i21, i22, i23, i20);
                int[] a6 = m2133a(a4);
                C3232hc hcVar8 = hcVar6;
                int i25 = i15 << 1;
                int i26 = i24 << 1;
                int[] a7 = m2133a(a5);
                m2125a(1, hcVar8, i25, i26, a6);
                m2125a(2, hcVar8, i25, i26, a7);
                m2126a(1, hcVar8, i25, i26, a4);
                m2126a(2, hcVar8, i25, i26, a5);
                m2132a(a6, a4);
                int i27 = i20;
                m2129a(b.f2535d[1], 1, i19, i27, a4);
                m2132a(a7, a5);
                m2129a(b.f2535d[2], 2, i19, i27, a5);
                hcVar6.mo38524b();
                hcVar7.mo38524b();
                System.arraycopy(b.f2535d[0], PsExtractor.VIDEO_STREAM_MASK, this.f2429b[0], i8, 16);
                int i28 = i15 << 3;
                System.arraycopy(b.f2535d[1], 56, this.f2429b[1], i28, 8);
                System.arraycopy(b.f2535d[2], 56, this.f2429b[2], i28, 8);
                m2130a(b.f2535d[0], 15, 16, this.f2428a[0]);
                m2130a(b.f2535d[1], 7, 8, this.f2428a[1]);
                m2130a(b.f2535d[2], 7, 8, this.f2428a[2]);
                i7 = i15 + 1;
                hcVar2 = hcVar6;
                i6 = i24;
                i = 1;
                i5 = 16;
            }
            i6++;
            hcVar = hcVar2;
            i = 1;
            i5 = 16;
        }
        hcVar.mo38522a(1);
        hcVar.mo38521a();
        ByteBuffer byteBuffer3 = hcVar.f2478a;
        byteBuffer3.flip();
        C3213gj.m2144a(byteBuffer3, byteBuffer2);
    }
}
