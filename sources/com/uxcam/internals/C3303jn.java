package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.jn */
public class C3303jn extends C3273in {

    /* renamed from: c */
    private int f2716c;

    /* renamed from: e */
    private long f2717e;

    /* renamed from: f */
    private float f2718f;

    /* renamed from: g */
    private float f2719g;

    /* renamed from: h */
    private long f2720h;

    /* renamed from: i */
    private long f2721i;

    /* renamed from: j */
    private float f2722j;

    /* renamed from: k */
    private short f2723k;

    /* renamed from: l */
    private long f2724l;

    /* renamed from: m */
    private int[] f2725m;

    public C3303jn() {
        super(new C3277ir("tkhd"));
    }

    public C3303jn(int i, long j, float f, float f2, long j2, long j3, int[] iArr) {
        super(new C3277ir("tkhd"));
        this.f2716c = i;
        this.f2717e = j;
        this.f2718f = f;
        this.f2719g = f2;
        this.f2720h = j2;
        this.f2721i = j3;
        this.f2722j = 1.0f;
        this.f2723k = 0;
        this.f2724l = 0;
        this.f2725m = iArr;
    }

    /* renamed from: a */
    public static String m2326a() {
        return "tkhd";
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": ");
        C3246hp.m2232a(this, sb, "trackId", "duration", "width", "height", "created", "modified", "volume", "layer", "altGroup");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(C3250ht.m2235a(this.f2720h));
        byteBuffer.putInt(C3250ht.m2235a(this.f2721i));
        byteBuffer.putInt(this.f2716c);
        byteBuffer.putInt(0);
        byteBuffer.putInt((int) this.f2717e);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f2723k);
        byteBuffer.putShort((short) ((int) this.f2724l));
        byteBuffer.putShort((short) ((int) (((double) this.f2722j) * 256.0d)));
        byteBuffer.putShort(0);
        for (int i = 0; i < 9; i++) {
            byteBuffer.putInt(this.f2725m[i]);
        }
        byteBuffer.putInt((int) (this.f2718f * 65536.0f));
        byteBuffer.putInt((int) (this.f2719g * 65536.0f));
    }
}
