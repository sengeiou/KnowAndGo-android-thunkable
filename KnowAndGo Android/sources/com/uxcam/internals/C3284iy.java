package com.uxcam.internals;

import java.nio.ByteBuffer;

/* renamed from: com.uxcam.internals.iy */
public class C3284iy extends C3273in {

    /* renamed from: c */
    public int f2676c;

    /* renamed from: e */
    private long f2677e;

    /* renamed from: f */
    private float f2678f;

    /* renamed from: g */
    private float f2679g;

    /* renamed from: h */
    private long f2680h;

    /* renamed from: i */
    private long f2681i;

    /* renamed from: j */
    private int[] f2682j;

    /* renamed from: k */
    private int f2683k;

    public C3284iy() {
        super(new C3277ir("mvhd"));
    }

    public C3284iy(int i, long j, long j2, long j3, int[] iArr, int i2) {
        super(new C3277ir("mvhd"));
        this.f2676c = i;
        this.f2677e = j;
        this.f2678f = 1.0f;
        this.f2679g = 1.0f;
        this.f2680h = j2;
        this.f2681i = j3;
        this.f2682j = iArr;
        this.f2683k = i2;
    }

    /* renamed from: a */
    public static String m2292a() {
        return "mvhd";
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": ");
        C3246hp.m2232a(this, sb, "timescale", "duration", "rate", "volume", "created", "modified", "nextTrackId");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(C3250ht.m2235a(this.f2680h));
        byteBuffer.putInt(C3250ht.m2235a(this.f2681i));
        byteBuffer.putInt(this.f2676c);
        byteBuffer.putInt((int) this.f2677e);
        byteBuffer.putInt((int) (((double) this.f2678f) * 65536.0d));
        byteBuffer.putShort((short) ((int) (((double) this.f2679g) * 256.0d)));
        byteBuffer.put(new byte[10]);
        for (int i = 0; i < Math.min(9, this.f2682j.length); i++) {
            byteBuffer.putInt(this.f2682j[i]);
        }
        for (int min = Math.min(9, this.f2682j.length); min < 9; min++) {
            byteBuffer.putInt(0);
        }
        byteBuffer.put(new byte[24]);
        byteBuffer.putInt(this.f2683k);
    }
}
