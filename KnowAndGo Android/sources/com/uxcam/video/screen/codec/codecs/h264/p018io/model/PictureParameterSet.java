package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

import com.uxcam.internals.C3214gk;
import com.uxcam.internals.C3219gp;
import com.uxcam.internals.C3231hb;
import com.uxcam.internals.C3232hc;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.PictureParameterSet */
public class PictureParameterSet {
    public int[] bottom_right;
    public int chroma_qp_index_offset;
    public boolean constrained_intra_pred_flag;
    public boolean deblocking_filter_control_present_flag;
    public boolean entropy_coding_mode_flag;
    public PPSExt extended;
    public int[] num_ref_idx_active_minus1 = new int[2];
    public int num_slice_groups_minus1;
    public int pic_init_qp_minus26;
    public int pic_init_qs_minus26;
    public boolean pic_order_present_flag;
    public int pic_parameter_set_id;
    public boolean redundant_pic_cnt_present_flag;
    public int[] run_length_minus1;
    public int seq_parameter_set_id;
    public boolean slice_group_change_direction_flag;
    public int slice_group_change_rate_minus1;
    public int[] slice_group_id;
    public int slice_group_map_type;
    public int[] top_left;
    public int weighted_bipred_idc;
    public boolean weighted_pred_flag;

    /* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.PictureParameterSet$PPSExt */
    public static class PPSExt {
        public boolean[] pic_scaling_list_present_flag;
        public ScalingMatrix scalindMatrix;
        public int second_chroma_qp_index_offset;
        public boolean transform_8x8_mode_flag;
    }

    public static PictureParameterSet read(ByteBuffer byteBuffer) {
        C3231hb hbVar = new C3231hb(byteBuffer);
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.pic_parameter_set_id = C3214gk.m2149a(hbVar);
        pictureParameterSet.seq_parameter_set_id = C3214gk.m2149a(hbVar);
        pictureParameterSet.entropy_coding_mode_flag = C3214gk.m2152d(hbVar);
        pictureParameterSet.pic_order_present_flag = C3214gk.m2152d(hbVar);
        pictureParameterSet.num_slice_groups_minus1 = C3214gk.m2149a(hbVar);
        boolean z = true;
        if (pictureParameterSet.num_slice_groups_minus1 > 0) {
            pictureParameterSet.slice_group_map_type = C3214gk.m2149a(hbVar);
            pictureParameterSet.top_left = new int[(pictureParameterSet.num_slice_groups_minus1 + 1)];
            pictureParameterSet.bottom_right = new int[(pictureParameterSet.num_slice_groups_minus1 + 1)];
            pictureParameterSet.run_length_minus1 = new int[(pictureParameterSet.num_slice_groups_minus1 + 1)];
            if (pictureParameterSet.slice_group_map_type == 0) {
                for (int i = 0; i <= pictureParameterSet.num_slice_groups_minus1; i++) {
                    pictureParameterSet.run_length_minus1[i] = C3214gk.m2149a(hbVar);
                }
            } else if (pictureParameterSet.slice_group_map_type == 2) {
                for (int i2 = 0; i2 < pictureParameterSet.num_slice_groups_minus1; i2++) {
                    pictureParameterSet.top_left[i2] = C3214gk.m2149a(hbVar);
                    pictureParameterSet.bottom_right[i2] = C3214gk.m2149a(hbVar);
                }
            } else {
                int i3 = 3;
                if (pictureParameterSet.slice_group_map_type == 3 || pictureParameterSet.slice_group_map_type == 4 || pictureParameterSet.slice_group_map_type == 5) {
                    pictureParameterSet.slice_group_change_direction_flag = C3214gk.m2152d(hbVar);
                    pictureParameterSet.slice_group_change_rate_minus1 = C3214gk.m2149a(hbVar);
                } else if (pictureParameterSet.slice_group_map_type == 6) {
                    if (pictureParameterSet.num_slice_groups_minus1 + 1 <= 4) {
                        i3 = pictureParameterSet.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                    }
                    int a = C3214gk.m2149a(hbVar);
                    pictureParameterSet.slice_group_id = new int[(a + 1)];
                    for (int i4 = 0; i4 <= a; i4++) {
                        int[] iArr = pictureParameterSet.slice_group_id;
                        StringBuilder sb = new StringBuilder("PPS: slice_group_id [");
                        sb.append(i4);
                        sb.append("]f");
                        iArr[i4] = hbVar.mo38518a(i3);
                    }
                }
            }
        }
        pictureParameterSet.num_ref_idx_active_minus1 = new int[]{C3214gk.m2150b(hbVar), C3214gk.m2150b(hbVar)};
        pictureParameterSet.weighted_pred_flag = C3214gk.m2152d(hbVar);
        pictureParameterSet.weighted_bipred_idc = hbVar.mo38518a(2);
        pictureParameterSet.pic_init_qp_minus26 = C3214gk.m2151c(hbVar);
        pictureParameterSet.pic_init_qs_minus26 = C3214gk.m2151c(hbVar);
        pictureParameterSet.chroma_qp_index_offset = C3214gk.m2151c(hbVar);
        pictureParameterSet.deblocking_filter_control_present_flag = C3214gk.m2152d(hbVar);
        pictureParameterSet.constrained_intra_pred_flag = C3214gk.m2152d(hbVar);
        pictureParameterSet.redundant_pic_cnt_present_flag = C3214gk.m2152d(hbVar);
        if (hbVar.mo38519b() < 32 && hbVar.mo38520b(1) == 1 && (hbVar.mo38520b(24) << 9) == 0) {
            z = false;
        }
        if (z) {
            pictureParameterSet.extended = new PPSExt();
            pictureParameterSet.extended.transform_8x8_mode_flag = C3214gk.m2152d(hbVar);
            if (C3214gk.m2152d(hbVar)) {
                for (int i5 = 0; i5 < ((pictureParameterSet.extended.transform_8x8_mode_flag ? 1 : 0) * true) + 6; i5++) {
                    if (C3214gk.m2152d(hbVar)) {
                        pictureParameterSet.extended.scalindMatrix.ScalingList4x4 = new ScalingList[8];
                        pictureParameterSet.extended.scalindMatrix.ScalingList8x8 = new ScalingList[8];
                        if (i5 < 6) {
                            pictureParameterSet.extended.scalindMatrix.ScalingList4x4[i5] = ScalingList.read(hbVar, 16);
                        } else {
                            pictureParameterSet.extended.scalindMatrix.ScalingList8x8[i5 - 6] = ScalingList.read(hbVar, 64);
                        }
                    }
                }
            }
            pictureParameterSet.extended.second_chroma_qp_index_offset = C3214gk.m2151c(hbVar);
        }
        return pictureParameterSet;
    }

    public PictureParameterSet copy() {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        write(allocate);
        allocate.flip();
        return read(allocate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
        if (!Arrays.equals(this.bottom_right, pictureParameterSet.bottom_right) || this.chroma_qp_index_offset != pictureParameterSet.chroma_qp_index_offset || this.constrained_intra_pred_flag != pictureParameterSet.constrained_intra_pred_flag || this.deblocking_filter_control_present_flag != pictureParameterSet.deblocking_filter_control_present_flag || this.entropy_coding_mode_flag != pictureParameterSet.entropy_coding_mode_flag) {
            return false;
        }
        if (this.extended == null) {
            if (pictureParameterSet.extended != null) {
                return false;
            }
        } else if (!this.extended.equals(pictureParameterSet.extended)) {
            return false;
        }
        return this.num_ref_idx_active_minus1[0] == pictureParameterSet.num_ref_idx_active_minus1[0] && this.num_ref_idx_active_minus1[1] == pictureParameterSet.num_ref_idx_active_minus1[1] && this.num_slice_groups_minus1 == pictureParameterSet.num_slice_groups_minus1 && this.pic_init_qp_minus26 == pictureParameterSet.pic_init_qp_minus26 && this.pic_init_qs_minus26 == pictureParameterSet.pic_init_qs_minus26 && this.pic_order_present_flag == pictureParameterSet.pic_order_present_flag && this.pic_parameter_set_id == pictureParameterSet.pic_parameter_set_id && this.redundant_pic_cnt_present_flag == pictureParameterSet.redundant_pic_cnt_present_flag && Arrays.equals(this.run_length_minus1, pictureParameterSet.run_length_minus1) && this.seq_parameter_set_id == pictureParameterSet.seq_parameter_set_id && this.slice_group_change_direction_flag == pictureParameterSet.slice_group_change_direction_flag && this.slice_group_change_rate_minus1 == pictureParameterSet.slice_group_change_rate_minus1 && Arrays.equals(this.slice_group_id, pictureParameterSet.slice_group_id) && this.slice_group_map_type == pictureParameterSet.slice_group_map_type && Arrays.equals(this.top_left, pictureParameterSet.top_left) && this.weighted_bipred_idc == pictureParameterSet.weighted_bipred_idc && this.weighted_pred_flag == pictureParameterSet.weighted_pred_flag;
    }

    public int hashCode() {
        int i = 1237;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((Arrays.hashCode(this.bottom_right) + 31) * 31) + this.chroma_qp_index_offset) * 31) + (this.constrained_intra_pred_flag ? 1231 : 1237)) * 31) + (this.deblocking_filter_control_present_flag ? 1231 : 1237)) * 31) + (this.entropy_coding_mode_flag ? 1231 : 1237)) * 31) + (this.extended == null ? 0 : this.extended.hashCode())) * 31) + this.num_ref_idx_active_minus1[0]) * 31) + this.num_ref_idx_active_minus1[1]) * 31) + this.num_slice_groups_minus1) * 31) + this.pic_init_qp_minus26) * 31) + this.pic_init_qs_minus26) * 31) + (this.pic_order_present_flag ? 1231 : 1237)) * 31) + this.pic_parameter_set_id) * 31) + (this.redundant_pic_cnt_present_flag ? 1231 : 1237)) * 31) + Arrays.hashCode(this.run_length_minus1)) * 31) + this.seq_parameter_set_id) * 31) + (this.slice_group_change_direction_flag ? 1231 : 1237)) * 31) + this.slice_group_change_rate_minus1) * 31) + Arrays.hashCode(this.slice_group_id)) * 31) + this.slice_group_map_type) * 31) + Arrays.hashCode(this.top_left)) * 31) + this.weighted_bipred_idc) * 31;
        if (this.weighted_pred_flag) {
            i = 1231;
        }
        return hashCode + i;
    }

    public void write(ByteBuffer byteBuffer) {
        ScalingList scalingList;
        C3232hc hcVar = new C3232hc(byteBuffer);
        C3219gp.m2181a(hcVar, this.pic_parameter_set_id);
        C3219gp.m2181a(hcVar, this.seq_parameter_set_id);
        C3219gp.m2183a(hcVar, this.entropy_coding_mode_flag);
        C3219gp.m2183a(hcVar, this.pic_order_present_flag);
        C3219gp.m2181a(hcVar, this.num_slice_groups_minus1);
        if (this.num_slice_groups_minus1 > 0) {
            C3219gp.m2181a(hcVar, this.slice_group_map_type);
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            if (this.slice_group_map_type == 0) {
                for (int i = 0; i <= this.num_slice_groups_minus1; i++) {
                    C3219gp.m2181a(hcVar, iArr3[i]);
                }
            } else if (this.slice_group_map_type == 2) {
                for (int i2 = 0; i2 < this.num_slice_groups_minus1; i2++) {
                    C3219gp.m2181a(hcVar, iArr[i2]);
                    C3219gp.m2181a(hcVar, iArr2[i2]);
                }
            } else {
                int i3 = 3;
                if (this.slice_group_map_type == 3 || this.slice_group_map_type == 4 || this.slice_group_map_type == 5) {
                    C3219gp.m2183a(hcVar, this.slice_group_change_direction_flag);
                    C3219gp.m2181a(hcVar, this.slice_group_change_rate_minus1);
                } else if (this.slice_group_map_type == 6) {
                    if (this.num_slice_groups_minus1 + 1 <= 4) {
                        i3 = this.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                    }
                    C3219gp.m2181a(hcVar, this.slice_group_id.length);
                    for (int i4 = 0; i4 <= this.slice_group_id.length; i4++) {
                        hcVar.mo38523a(this.slice_group_id[i4], i3);
                    }
                }
            }
        }
        C3219gp.m2181a(hcVar, this.num_ref_idx_active_minus1[0]);
        C3219gp.m2181a(hcVar, this.num_ref_idx_active_minus1[1]);
        C3219gp.m2183a(hcVar, this.weighted_pred_flag);
        C3219gp.m2182a(hcVar, (long) this.weighted_bipred_idc, 2);
        C3219gp.m2184b(hcVar, this.pic_init_qp_minus26);
        C3219gp.m2184b(hcVar, this.pic_init_qs_minus26);
        C3219gp.m2184b(hcVar, this.chroma_qp_index_offset);
        C3219gp.m2183a(hcVar, this.deblocking_filter_control_present_flag);
        C3219gp.m2183a(hcVar, this.constrained_intra_pred_flag);
        C3219gp.m2183a(hcVar, this.redundant_pic_cnt_present_flag);
        if (this.extended != null) {
            C3219gp.m2183a(hcVar, this.extended.transform_8x8_mode_flag);
            C3219gp.m2183a(hcVar, this.extended.scalindMatrix != null);
            if (this.extended.scalindMatrix != null) {
                for (int i5 = 0; i5 < ((this.extended.transform_8x8_mode_flag ? 1 : 0) * true) + 6; i5++) {
                    if (i5 < 6) {
                        C3219gp.m2183a(hcVar, this.extended.scalindMatrix.ScalingList4x4[i5] != null);
                        if (this.extended.scalindMatrix.ScalingList4x4[i5] != null) {
                            scalingList = this.extended.scalindMatrix.ScalingList4x4[i5];
                        }
                    } else {
                        int i6 = i5 - 6;
                        C3219gp.m2183a(hcVar, this.extended.scalindMatrix.ScalingList8x8[i6] != null);
                        if (this.extended.scalindMatrix.ScalingList8x8[i6] != null) {
                            scalingList = this.extended.scalindMatrix.ScalingList8x8[i6];
                        }
                    }
                    scalingList.write(hcVar);
                }
            }
            C3219gp.m2184b(hcVar, this.extended.second_chroma_qp_index_offset);
        }
        C3219gp.m2180a(hcVar);
    }
}
