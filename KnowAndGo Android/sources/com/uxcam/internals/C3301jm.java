package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.jm */
public class C3301jm extends C3292jf {

    /* renamed from: a */
    private static final C3302aa f2710a = new C3302aa();

    /* renamed from: b */
    private int f2711b;

    /* renamed from: c */
    private int f2712c;

    /* renamed from: g */
    private int f2713g;

    /* renamed from: h */
    private byte f2714h;

    /* renamed from: com.uxcam.internals.jm$aa */
    public static class C3302aa extends C3256hy {

        /* renamed from: a */
        private Map f2715a = new HashMap();
    }

    public C3301jm() {
        super(new C3277ir("tmcd"));
        this.f2686f = f2710a;
    }

    public C3301jm(int i, int i2, int i3, int i4) {
        super(new C3277ir("tmcd"));
        this.f2711b = i;
        this.f2712c = i2;
        this.f2713g = i3;
        this.f2714h = (byte) i4;
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        sb.append(this.f2610d.f2662a + ": {\n");
        sb.append("entry: ");
        C3246hp.m2232a(this, sb, "flags", "timescale", "frameDuration", "numFrames");
        sb.append(",\nexts: [\n");
        mo38549b(sb);
        sb.append("\n]\n");
        sb.append("}\n");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f2711b);
        byteBuffer.putInt(this.f2712c);
        byteBuffer.putInt(this.f2713g);
        byteBuffer.put(this.f2714h);
        byteBuffer.put((byte) -49);
    }
}
