package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.AspectRatio */
public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(255);
    private int value;

    private AspectRatio(int i) {
        this.value = i;
    }

    public static AspectRatio fromValue(int i) {
        return i == Extended_SAR.value ? Extended_SAR : new AspectRatio(i);
    }

    public int getValue() {
        return this.value;
    }
}
