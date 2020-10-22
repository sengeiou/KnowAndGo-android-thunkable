package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.jr */
public class C3307jr extends C3292jf {

    /* renamed from: c */
    private static final C3308aa f2731c = new C3308aa();

    /* renamed from: a */
    public short f2732a;

    /* renamed from: b */
    public short f2733b;

    /* renamed from: g */
    private short f2734g = 0;

    /* renamed from: h */
    private short f2735h = 0;

    /* renamed from: i */
    private String f2736i;

    /* renamed from: j */
    private int f2737j;

    /* renamed from: k */
    private int f2738k;

    /* renamed from: l */
    private float f2739l;

    /* renamed from: m */
    private float f2740m;

    /* renamed from: n */
    private short f2741n;

    /* renamed from: o */
    private String f2742o;

    /* renamed from: p */
    private short f2743p;

    /* renamed from: q */
    private short f2744q;

    /* renamed from: com.uxcam.internals.jr$aa */
    public static class C3308aa extends C3256hy {

        /* renamed from: a */
        private Map f2745a = new HashMap();

        public C3308aa() {
            this.f2745a.put(C3288jc.m2304a(), C3288jc.class);
            this.f2745a.put(C3262ie.m2258a(), C3262ie.class);
            this.f2745a.put(C3274io.m2275a(), C3274io.class);
            this.f2745a.put(C3259ib.m2252a(), C3259ib.class);
            this.f2745a.put(C3271il.m2269a(), C3271il.class);
        }
    }

    public C3307jr(C3277ir irVar, String str, short s, short s2, String str2) {
        super(irVar, (byte) 0);
        this.f2686f = f2731c;
        this.f2736i = str;
        this.f2737j = 0;
        this.f2738k = 768;
        this.f2732a = s;
        this.f2733b = s2;
        this.f2739l = 72.0f;
        this.f2740m = 72.0f;
        this.f2741n = 1;
        this.f2742o = str2;
        this.f2743p = 24;
        this.f2744q = -1;
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        sb.append(this.f2610d.f2662a + ": {\n");
        sb.append("entry: ");
        C3246hp.m2232a(this, sb, "version", "revision", "vendor", "temporalQual", "spacialQual", "width", "height", "hRes", "vRes", "frameCount", "compressorName", "depth", "clrTbl");
        sb.append(",\nexts: [\n");
        mo38549b(sb);
        sb.append("\n]\n");
        sb.append("}\n");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putShort(this.f2734g);
        byteBuffer.putShort(this.f2735h);
        byteBuffer.put(C3227gx.m2197a(this.f2736i), 0, 4);
        byteBuffer.putInt(this.f2737j);
        byteBuffer.putInt(this.f2738k);
        byteBuffer.putShort(this.f2732a);
        byteBuffer.putShort(this.f2733b);
        byteBuffer.putInt((int) (this.f2739l * 65536.0f));
        byteBuffer.putInt((int) (this.f2740m * 65536.0f));
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f2741n);
        C3229gz.m2200a(byteBuffer, this.f2742o, 31);
        byteBuffer.putShort(this.f2743p);
        byteBuffer.putShort(this.f2744q);
        mo38550c(byteBuffer);
    }
}
