package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable */
public class PredictionWeightTable {
    public int chroma_log2_weight_denom;
    public int[][][] chroma_offset = new int[2][][];
    public int[][][] chroma_weight = new int[2][][];
    public int luma_log2_weight_denom;
    public int[][] luma_offset = new int[2][];
    public int[][] luma_weight = new int[2][];
}
