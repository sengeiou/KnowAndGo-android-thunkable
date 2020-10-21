package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.SliceType */
public enum SliceType {
    P,
    B,
    I,
    SP,
    SI;

    public final boolean isInter() {
        return (this == I || this == SI) ? false : true;
    }

    public final boolean isIntra() {
        return this == I || this == SI;
    }
}
