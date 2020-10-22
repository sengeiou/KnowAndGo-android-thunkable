package com.uxcam.internals;

import android.opengl.GLES20;

/* renamed from: com.uxcam.internals.ks */
public final class C3340ks {

    /* renamed from: a */
    public final float[] f2904a = new float[16];

    /* renamed from: b */
    public int f2905b;

    /* renamed from: c */
    public int f2906c;

    /* renamed from: d */
    public C3341kt f2907d;

    public C3340ks(int i, int i2) {
        this.f2905b = i;
        this.f2906c = i2;
    }

    /* renamed from: a */
    public static int m2408a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }
}
