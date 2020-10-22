package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

import com.uxcam.internals.C3214gk;
import com.uxcam.internals.C3219gp;
import com.uxcam.internals.C3231hb;
import com.uxcam.internals.C3232hc;
import com.uxcam.internals.C3237hg;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.VUIParameters;
import java.nio.ByteBuffer;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet */
public class SeqParameterSet {
    public int bit_depth_chroma_minus8;
    public int bit_depth_luma_minus8;
    public C3237hg chroma_format_idc;
    public boolean constraint_set_0_flag;
    public boolean constraint_set_1_flag;
    public boolean constraint_set_2_flag;
    public boolean constraint_set_3_flag;
    public boolean delta_pic_order_always_zero_flag;
    public boolean direct_8x8_inference_flag;
    public boolean field_pic_flag;
    public int frame_crop_bottom_offset;
    public int frame_crop_left_offset;
    public int frame_crop_right_offset;
    public int frame_crop_top_offset;
    public boolean frame_cropping_flag;
    public boolean frame_mbs_only_flag;
    public boolean gaps_in_frame_num_value_allowed_flag;
    public int level_idc;
    public int log2_max_frame_num_minus4;
    public int log2_max_pic_order_cnt_lsb_minus4;
    public boolean mb_adaptive_frame_field_flag;
    public int num_ref_frames;
    public int num_ref_frames_in_pic_order_cnt_cycle;
    public int[] offsetForRefFrame;
    public int offset_for_non_ref_pic;
    public int offset_for_top_to_bottom_field;
    public int pic_height_in_map_units_minus1;
    public int pic_order_cnt_type;
    public int pic_width_in_mbs_minus1;
    public int profile_idc;
    public boolean qpprime_y_zero_transform_bypass_flag;
    public boolean residual_color_transform_flag;
    public ScalingMatrix scalingMatrix;
    public int seq_parameter_set_id;
    public VUIParameters vuiParams;

    public static int fromColor(C3237hg hgVar) {
        switch (hgVar) {
            case MONO:
                return 0;
            case YUV420:
                return 1;
            case YUV422:
                return 2;
            case YUV444:
                return 3;
            default:
                throw new RuntimeException("Colorspace not supported");
        }
    }

    public static C3237hg getColor(int i) {
        switch (i) {
            case 0:
                return C3237hg.MONO;
            case 1:
                return C3237hg.YUV420;
            case 2:
                return C3237hg.YUV422;
            case 3:
                return C3237hg.YUV444;
            default:
                throw new RuntimeException("Colorspace not supported");
        }
    }

    public static SeqParameterSet read(ByteBuffer byteBuffer) {
        C3231hb hbVar = new C3231hb(byteBuffer);
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.profile_idc = hbVar.mo38518a(8);
        seqParameterSet.constraint_set_0_flag = C3214gk.m2152d(hbVar);
        seqParameterSet.constraint_set_1_flag = C3214gk.m2152d(hbVar);
        seqParameterSet.constraint_set_2_flag = C3214gk.m2152d(hbVar);
        seqParameterSet.constraint_set_3_flag = C3214gk.m2152d(hbVar);
        hbVar.mo38518a(4);
        seqParameterSet.level_idc = hbVar.mo38518a(8);
        seqParameterSet.seq_parameter_set_id = C3214gk.m2149a(hbVar);
        if (seqParameterSet.profile_idc == 100 || seqParameterSet.profile_idc == 110 || seqParameterSet.profile_idc == 122 || seqParameterSet.profile_idc == 144) {
            seqParameterSet.chroma_format_idc = getColor(C3214gk.m2149a(hbVar));
            if (seqParameterSet.chroma_format_idc == C3237hg.YUV444) {
                seqParameterSet.residual_color_transform_flag = C3214gk.m2152d(hbVar);
            }
            seqParameterSet.bit_depth_luma_minus8 = C3214gk.m2149a(hbVar);
            seqParameterSet.bit_depth_chroma_minus8 = C3214gk.m2149a(hbVar);
            seqParameterSet.qpprime_y_zero_transform_bypass_flag = C3214gk.m2152d(hbVar);
            if (C3214gk.m2152d(hbVar)) {
                readScalingListMatrix(hbVar, seqParameterSet);
            }
        } else {
            seqParameterSet.chroma_format_idc = C3237hg.YUV420;
        }
        seqParameterSet.log2_max_frame_num_minus4 = C3214gk.m2149a(hbVar);
        seqParameterSet.pic_order_cnt_type = C3214gk.m2149a(hbVar);
        if (seqParameterSet.pic_order_cnt_type == 0) {
            seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 = C3214gk.m2149a(hbVar);
        } else if (seqParameterSet.pic_order_cnt_type == 1) {
            seqParameterSet.delta_pic_order_always_zero_flag = C3214gk.m2152d(hbVar);
            seqParameterSet.offset_for_non_ref_pic = C3214gk.m2151c(hbVar);
            seqParameterSet.offset_for_top_to_bottom_field = C3214gk.m2151c(hbVar);
            seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle = C3214gk.m2149a(hbVar);
            seqParameterSet.offsetForRefFrame = new int[seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle];
            for (int i = 0; i < seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle; i++) {
                int[] iArr = seqParameterSet.offsetForRefFrame;
                StringBuilder sb = new StringBuilder("SPS: offsetForRefFrame [");
                sb.append(i);
                sb.append("]");
                iArr[i] = C3214gk.m2151c(hbVar);
            }
        }
        seqParameterSet.num_ref_frames = C3214gk.m2150b(hbVar);
        seqParameterSet.gaps_in_frame_num_value_allowed_flag = C3214gk.m2152d(hbVar);
        seqParameterSet.pic_width_in_mbs_minus1 = C3214gk.m2150b(hbVar);
        seqParameterSet.pic_height_in_map_units_minus1 = C3214gk.m2150b(hbVar);
        seqParameterSet.frame_mbs_only_flag = C3214gk.m2152d(hbVar);
        if (!seqParameterSet.frame_mbs_only_flag) {
            seqParameterSet.mb_adaptive_frame_field_flag = C3214gk.m2152d(hbVar);
        }
        seqParameterSet.direct_8x8_inference_flag = C3214gk.m2152d(hbVar);
        seqParameterSet.frame_cropping_flag = C3214gk.m2152d(hbVar);
        if (seqParameterSet.frame_cropping_flag) {
            seqParameterSet.frame_crop_left_offset = C3214gk.m2150b(hbVar);
            seqParameterSet.frame_crop_right_offset = C3214gk.m2150b(hbVar);
            seqParameterSet.frame_crop_top_offset = C3214gk.m2150b(hbVar);
            seqParameterSet.frame_crop_bottom_offset = C3214gk.m2150b(hbVar);
        }
        if (C3214gk.m2152d(hbVar)) {
            seqParameterSet.vuiParams = readVUIParameters(hbVar);
        }
        return seqParameterSet;
    }

    private static HRDParameters readHRDParameters(C3231hb hbVar) {
        HRDParameters hRDParameters = new HRDParameters();
        hRDParameters.cpb_cnt_minus1 = C3214gk.m2149a(hbVar);
        hRDParameters.bit_rate_scale = hbVar.mo38518a(4);
        hRDParameters.cpb_size_scale = hbVar.mo38518a(4);
        hRDParameters.bit_rate_value_minus1 = new int[(hRDParameters.cpb_cnt_minus1 + 1)];
        hRDParameters.cpb_size_value_minus1 = new int[(hRDParameters.cpb_cnt_minus1 + 1)];
        hRDParameters.cbr_flag = new boolean[(hRDParameters.cpb_cnt_minus1 + 1)];
        for (int i = 0; i <= hRDParameters.cpb_cnt_minus1; i++) {
            hRDParameters.bit_rate_value_minus1[i] = C3214gk.m2149a(hbVar);
            hRDParameters.cpb_size_value_minus1[i] = C3214gk.m2149a(hbVar);
            hRDParameters.cbr_flag[i] = C3214gk.m2152d(hbVar);
        }
        hRDParameters.initial_cpb_removal_delay_length_minus1 = hbVar.mo38518a(5);
        hRDParameters.cpb_removal_delay_length_minus1 = hbVar.mo38518a(5);
        hRDParameters.dpb_output_delay_length_minus1 = hbVar.mo38518a(5);
        hRDParameters.time_offset_length = hbVar.mo38518a(5);
        return hRDParameters;
    }

    private static void readScalingListMatrix(C3231hb hbVar, SeqParameterSet seqParameterSet) {
        seqParameterSet.scalingMatrix = new ScalingMatrix();
        for (int i = 0; i < 8; i++) {
            if (C3214gk.m2152d(hbVar)) {
                seqParameterSet.scalingMatrix.ScalingList4x4 = new ScalingList[8];
                seqParameterSet.scalingMatrix.ScalingList8x8 = new ScalingList[8];
                if (i < 6) {
                    seqParameterSet.scalingMatrix.ScalingList4x4[i] = ScalingList.read(hbVar, 16);
                } else {
                    seqParameterSet.scalingMatrix.ScalingList8x8[i - 6] = ScalingList.read(hbVar, 64);
                }
            }
        }
    }

    private static VUIParameters readVUIParameters(C3231hb hbVar) {
        VUIParameters vUIParameters = new VUIParameters();
        vUIParameters.aspect_ratio_info_present_flag = C3214gk.m2152d(hbVar);
        if (vUIParameters.aspect_ratio_info_present_flag) {
            vUIParameters.aspect_ratio = AspectRatio.fromValue(hbVar.mo38518a(8));
            if (vUIParameters.aspect_ratio == AspectRatio.Extended_SAR) {
                vUIParameters.sar_width = hbVar.mo38518a(16);
                vUIParameters.sar_height = hbVar.mo38518a(16);
            }
        }
        vUIParameters.overscan_info_present_flag = C3214gk.m2152d(hbVar);
        if (vUIParameters.overscan_info_present_flag) {
            vUIParameters.overscan_appropriate_flag = C3214gk.m2152d(hbVar);
        }
        vUIParameters.video_signal_type_present_flag = C3214gk.m2152d(hbVar);
        if (vUIParameters.video_signal_type_present_flag) {
            vUIParameters.video_format = hbVar.mo38518a(3);
            vUIParameters.video_full_range_flag = C3214gk.m2152d(hbVar);
            vUIParameters.colour_description_present_flag = C3214gk.m2152d(hbVar);
            if (vUIParameters.colour_description_present_flag) {
                vUIParameters.colour_primaries = hbVar.mo38518a(8);
                vUIParameters.transfer_characteristics = hbVar.mo38518a(8);
                vUIParameters.matrix_coefficients = hbVar.mo38518a(8);
            }
        }
        vUIParameters.chroma_loc_info_present_flag = C3214gk.m2152d(hbVar);
        if (vUIParameters.chroma_loc_info_present_flag) {
            vUIParameters.chroma_sample_loc_type_top_field = C3214gk.m2149a(hbVar);
            vUIParameters.chroma_sample_loc_type_bottom_field = C3214gk.m2149a(hbVar);
        }
        vUIParameters.timing_info_present_flag = C3214gk.m2152d(hbVar);
        if (vUIParameters.timing_info_present_flag) {
            vUIParameters.num_units_in_tick = hbVar.mo38518a(32);
            vUIParameters.time_scale = hbVar.mo38518a(32);
            vUIParameters.fixed_frame_rate_flag = C3214gk.m2152d(hbVar);
        }
        boolean d = C3214gk.m2152d(hbVar);
        if (d) {
            vUIParameters.nalHRDParams = readHRDParameters(hbVar);
        }
        boolean d2 = C3214gk.m2152d(hbVar);
        if (d2) {
            vUIParameters.vclHRDParams = readHRDParameters(hbVar);
        }
        if (d || d2) {
            vUIParameters.low_delay_hrd_flag = C3214gk.m2152d(hbVar);
        }
        vUIParameters.pic_struct_present_flag = C3214gk.m2152d(hbVar);
        if (C3214gk.m2152d(hbVar)) {
            vUIParameters.bitstreamRestriction = new VUIParameters.BitstreamRestriction();
            vUIParameters.bitstreamRestriction.motion_vectors_over_pic_boundaries_flag = C3214gk.m2152d(hbVar);
            vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom = C3214gk.m2149a(hbVar);
            vUIParameters.bitstreamRestriction.max_bits_per_mb_denom = C3214gk.m2149a(hbVar);
            vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal = C3214gk.m2149a(hbVar);
            vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical = C3214gk.m2149a(hbVar);
            vUIParameters.bitstreamRestriction.num_reorder_frames = C3214gk.m2149a(hbVar);
            vUIParameters.bitstreamRestriction.max_dec_frame_buffering = C3214gk.m2149a(hbVar);
        }
        return vUIParameters;
    }

    private void writeHRDParameters(HRDParameters hRDParameters, C3232hc hcVar) {
        C3219gp.m2181a(hcVar, hRDParameters.cpb_cnt_minus1);
        C3219gp.m2182a(hcVar, (long) hRDParameters.bit_rate_scale, 4);
        C3219gp.m2182a(hcVar, (long) hRDParameters.cpb_size_scale, 4);
        for (int i = 0; i <= hRDParameters.cpb_cnt_minus1; i++) {
            C3219gp.m2181a(hcVar, hRDParameters.bit_rate_value_minus1[i]);
            C3219gp.m2181a(hcVar, hRDParameters.cpb_size_value_minus1[i]);
            C3219gp.m2183a(hcVar, hRDParameters.cbr_flag[i]);
        }
        C3219gp.m2182a(hcVar, (long) hRDParameters.initial_cpb_removal_delay_length_minus1, 5);
        C3219gp.m2182a(hcVar, (long) hRDParameters.cpb_removal_delay_length_minus1, 5);
        C3219gp.m2182a(hcVar, (long) hRDParameters.dpb_output_delay_length_minus1, 5);
        C3219gp.m2182a(hcVar, (long) hRDParameters.time_offset_length, 5);
    }

    private void writeVUIParameters(VUIParameters vUIParameters, C3232hc hcVar) {
        C3219gp.m2183a(hcVar, vUIParameters.aspect_ratio_info_present_flag);
        if (vUIParameters.aspect_ratio_info_present_flag) {
            C3219gp.m2182a(hcVar, (long) vUIParameters.aspect_ratio.getValue(), 8);
            if (vUIParameters.aspect_ratio == AspectRatio.Extended_SAR) {
                C3219gp.m2182a(hcVar, (long) vUIParameters.sar_width, 16);
                C3219gp.m2182a(hcVar, (long) vUIParameters.sar_height, 16);
            }
        }
        C3219gp.m2183a(hcVar, vUIParameters.overscan_info_present_flag);
        if (vUIParameters.overscan_info_present_flag) {
            C3219gp.m2183a(hcVar, vUIParameters.overscan_appropriate_flag);
        }
        C3219gp.m2183a(hcVar, vUIParameters.video_signal_type_present_flag);
        if (vUIParameters.video_signal_type_present_flag) {
            C3219gp.m2182a(hcVar, (long) vUIParameters.video_format, 3);
            C3219gp.m2183a(hcVar, vUIParameters.video_full_range_flag);
            C3219gp.m2183a(hcVar, vUIParameters.colour_description_present_flag);
            if (vUIParameters.colour_description_present_flag) {
                C3219gp.m2182a(hcVar, (long) vUIParameters.colour_primaries, 8);
                C3219gp.m2182a(hcVar, (long) vUIParameters.transfer_characteristics, 8);
                C3219gp.m2182a(hcVar, (long) vUIParameters.matrix_coefficients, 8);
            }
        }
        C3219gp.m2183a(hcVar, vUIParameters.chroma_loc_info_present_flag);
        if (vUIParameters.chroma_loc_info_present_flag) {
            C3219gp.m2181a(hcVar, vUIParameters.chroma_sample_loc_type_top_field);
            C3219gp.m2181a(hcVar, vUIParameters.chroma_sample_loc_type_bottom_field);
        }
        C3219gp.m2183a(hcVar, vUIParameters.timing_info_present_flag);
        if (vUIParameters.timing_info_present_flag) {
            C3219gp.m2182a(hcVar, (long) vUIParameters.num_units_in_tick, 32);
            C3219gp.m2182a(hcVar, (long) vUIParameters.time_scale, 32);
            C3219gp.m2183a(hcVar, vUIParameters.fixed_frame_rate_flag);
        }
        boolean z = false;
        C3219gp.m2183a(hcVar, vUIParameters.nalHRDParams != null);
        if (vUIParameters.nalHRDParams != null) {
            writeHRDParameters(vUIParameters.nalHRDParams, hcVar);
        }
        C3219gp.m2183a(hcVar, vUIParameters.vclHRDParams != null);
        if (vUIParameters.vclHRDParams != null) {
            writeHRDParameters(vUIParameters.vclHRDParams, hcVar);
        }
        if (!(vUIParameters.nalHRDParams == null && vUIParameters.vclHRDParams == null)) {
            C3219gp.m2183a(hcVar, vUIParameters.low_delay_hrd_flag);
        }
        C3219gp.m2183a(hcVar, vUIParameters.pic_struct_present_flag);
        if (vUIParameters.bitstreamRestriction != null) {
            z = true;
        }
        C3219gp.m2183a(hcVar, z);
        if (vUIParameters.bitstreamRestriction != null) {
            C3219gp.m2183a(hcVar, vUIParameters.bitstreamRestriction.motion_vectors_over_pic_boundaries_flag);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.max_bits_per_mb_denom);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.num_reorder_frames);
            C3219gp.m2181a(hcVar, vUIParameters.bitstreamRestriction.max_dec_frame_buffering);
        }
    }

    public SeqParameterSet copy() {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        write(allocate);
        allocate.flip();
        return read(allocate);
    }

    public void write(ByteBuffer byteBuffer) {
        ScalingList scalingList;
        C3232hc hcVar = new C3232hc(byteBuffer);
        C3219gp.m2182a(hcVar, (long) this.profile_idc, 8);
        C3219gp.m2183a(hcVar, this.constraint_set_0_flag);
        C3219gp.m2183a(hcVar, this.constraint_set_1_flag);
        C3219gp.m2183a(hcVar, this.constraint_set_2_flag);
        C3219gp.m2183a(hcVar, this.constraint_set_3_flag);
        C3219gp.m2182a(hcVar, 0, 4);
        C3219gp.m2182a(hcVar, (long) this.level_idc, 8);
        C3219gp.m2181a(hcVar, this.seq_parameter_set_id);
        boolean z = false;
        if (this.profile_idc == 100 || this.profile_idc == 110 || this.profile_idc == 122 || this.profile_idc == 144) {
            C3219gp.m2181a(hcVar, fromColor(this.chroma_format_idc));
            if (this.chroma_format_idc == C3237hg.YUV444) {
                C3219gp.m2183a(hcVar, this.residual_color_transform_flag);
            }
            C3219gp.m2181a(hcVar, this.bit_depth_luma_minus8);
            C3219gp.m2181a(hcVar, this.bit_depth_chroma_minus8);
            C3219gp.m2183a(hcVar, this.qpprime_y_zero_transform_bypass_flag);
            C3219gp.m2183a(hcVar, this.scalingMatrix != null);
            if (this.scalingMatrix != null) {
                for (int i = 0; i < 8; i++) {
                    if (i < 6) {
                        C3219gp.m2183a(hcVar, this.scalingMatrix.ScalingList4x4[i] != null);
                        if (this.scalingMatrix.ScalingList4x4[i] != null) {
                            scalingList = this.scalingMatrix.ScalingList4x4[i];
                        }
                    } else {
                        int i2 = i - 6;
                        C3219gp.m2183a(hcVar, this.scalingMatrix.ScalingList8x8[i2] != null);
                        if (this.scalingMatrix.ScalingList8x8[i2] != null) {
                            scalingList = this.scalingMatrix.ScalingList8x8[i2];
                        }
                    }
                    scalingList.write(hcVar);
                }
            }
        }
        C3219gp.m2181a(hcVar, this.log2_max_frame_num_minus4);
        C3219gp.m2181a(hcVar, this.pic_order_cnt_type);
        if (this.pic_order_cnt_type == 0) {
            C3219gp.m2181a(hcVar, this.log2_max_pic_order_cnt_lsb_minus4);
        } else if (this.pic_order_cnt_type == 1) {
            C3219gp.m2183a(hcVar, this.delta_pic_order_always_zero_flag);
            C3219gp.m2184b(hcVar, this.offset_for_non_ref_pic);
            C3219gp.m2184b(hcVar, this.offset_for_top_to_bottom_field);
            C3219gp.m2181a(hcVar, this.offsetForRefFrame.length);
            for (int b : this.offsetForRefFrame) {
                C3219gp.m2184b(hcVar, b);
            }
        }
        C3219gp.m2181a(hcVar, this.num_ref_frames);
        C3219gp.m2183a(hcVar, this.gaps_in_frame_num_value_allowed_flag);
        C3219gp.m2181a(hcVar, this.pic_width_in_mbs_minus1);
        C3219gp.m2181a(hcVar, this.pic_height_in_map_units_minus1);
        C3219gp.m2183a(hcVar, this.frame_mbs_only_flag);
        if (!this.frame_mbs_only_flag) {
            C3219gp.m2183a(hcVar, this.mb_adaptive_frame_field_flag);
        }
        C3219gp.m2183a(hcVar, this.direct_8x8_inference_flag);
        C3219gp.m2183a(hcVar, this.frame_cropping_flag);
        if (this.frame_cropping_flag) {
            C3219gp.m2181a(hcVar, this.frame_crop_left_offset);
            C3219gp.m2181a(hcVar, this.frame_crop_right_offset);
            C3219gp.m2181a(hcVar, this.frame_crop_top_offset);
            C3219gp.m2181a(hcVar, this.frame_crop_bottom_offset);
        }
        if (this.vuiParams != null) {
            z = true;
        }
        C3219gp.m2183a(hcVar, z);
        if (this.vuiParams != null) {
            writeVUIParameters(this.vuiParams, hcVar);
        }
        C3219gp.m2180a(hcVar);
    }
}
