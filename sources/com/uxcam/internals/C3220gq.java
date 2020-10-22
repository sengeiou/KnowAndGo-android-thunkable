package com.uxcam.internals;

import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SeqParameterSet;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SliceHeader;

/* renamed from: com.uxcam.internals.gq */
public final class C3220gq {
    /* renamed from: a */
    public static void m2185a(SliceHeader sliceHeader, C3232hc hcVar, int i) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        int i2 = 1 << sliceHeader.pred_weight_table.luma_log2_weight_denom;
        int i3 = 1 << sliceHeader.pred_weight_table.chroma_log2_weight_denom;
        for (int i4 = 0; i4 < sliceHeader.pred_weight_table.luma_weight[i].length; i4++) {
            boolean z = (sliceHeader.pred_weight_table.luma_weight[i][i4] == i2 && sliceHeader.pred_weight_table.luma_offset[i][i4] == 0) ? false : true;
            C3219gp.m2183a(hcVar, z);
            if (z) {
                C3219gp.m2184b(hcVar, sliceHeader.pred_weight_table.luma_weight[i][i4]);
                C3219gp.m2184b(hcVar, sliceHeader.pred_weight_table.luma_offset[i][i4]);
            }
            if (seqParameterSet.chroma_format_idc != C3237hg.MONO) {
                boolean z2 = (sliceHeader.pred_weight_table.chroma_weight[i][0][i4] == i3 && sliceHeader.pred_weight_table.chroma_offset[i][0][i4] == 0 && sliceHeader.pred_weight_table.chroma_weight[i][1][i4] == i3 && sliceHeader.pred_weight_table.chroma_offset[i][1][i4] == 0) ? false : true;
                C3219gp.m2183a(hcVar, z2);
                if (z2) {
                    for (int i5 = 0; i5 < 2; i5++) {
                        C3219gp.m2184b(hcVar, sliceHeader.pred_weight_table.chroma_weight[i][i5][i4]);
                        C3219gp.m2184b(hcVar, sliceHeader.pred_weight_table.chroma_offset[i][i5][i4]);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2186a(int[][] iArr, C3232hc hcVar) {
        if (iArr != null) {
            for (int i = 0; i < iArr[0].length; i++) {
                C3219gp.m2181a(hcVar, iArr[0][i]);
                C3219gp.m2181a(hcVar, iArr[1][i]);
            }
            C3219gp.m2181a(hcVar, 3);
        }
    }
}
