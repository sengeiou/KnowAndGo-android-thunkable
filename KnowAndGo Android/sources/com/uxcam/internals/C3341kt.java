package com.uxcam.internals;

import android.opengl.GLES20;

/* renamed from: com.uxcam.internals.kt */
public final class C3341kt {

    /* renamed from: a */
    String f2908a = "uniform mat4 uScreen;\nattribute vec2 aPosition;\nattribute vec2 aTexPos;\nvarying vec2 vTexPos;\nvoid main() {\n  vTexPos = aTexPos;\n  gl_Position = uScreen * vec4(aPosition.xy, 0.0, 1.0);\n}";

    /* renamed from: b */
    String f2909b = "precision mediump float;\nuniform sampler2D uTexture;\nvarying vec2 vTexPos;\nvoid main(void)\n{\n  gl_FragColor = texture2D(uTexture, vTexPos);\n}";

    /* renamed from: c */
    public int f2910c = -1;

    /* renamed from: d */
    public int[] f2911d = new int[1];

    public C3341kt() {
        int a = C3340ks.m2408a(35633, this.f2908a);
        int a2 = C3340ks.m2408a(35632, this.f2909b);
        this.f2910c = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f2910c, a);
        GLES20.glAttachShader(this.f2910c, a2);
        GLES20.glLinkProgram(this.f2910c);
    }
}
