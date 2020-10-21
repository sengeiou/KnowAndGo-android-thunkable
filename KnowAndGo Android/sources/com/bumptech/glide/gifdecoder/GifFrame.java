package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;

class GifFrame {
    static final int DISPOSAL_BACKGROUND = 2;
    static final int DISPOSAL_NONE = 1;
    static final int DISPOSAL_PREVIOUS = 3;
    static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* renamed from: ih */
    int f70ih;
    boolean interlace;

    /* renamed from: iw */
    int f71iw;

    /* renamed from: ix */
    int f72ix;

    /* renamed from: iy */
    int f73iy;
    @ColorInt
    int[] lct;
    int transIndex;
    boolean transparency;

    GifFrame() {
    }
}
