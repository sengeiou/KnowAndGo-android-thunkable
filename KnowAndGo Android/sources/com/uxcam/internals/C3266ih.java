package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.ih */
public class C3266ih extends C3286ja {

    /* renamed from: a */
    private static final C3267aa f2637a = new C3267aa();

    /* renamed from: com.uxcam.internals.ih$aa */
    public static class C3267aa extends C3256hy {

        /* renamed from: a */
        private Map f2638a = new HashMap();

        public C3267aa() {
            this.f2638a.put(C3305jp.m2330a(), C3305jp.class);
            this.f2638a.put(C3252hv.m2236a(), C3252hv.class);
            this.f2638a.put("cios", C3252hv.class);
        }
    }

    public C3266ih() {
        this(new C3277ir("dref"));
    }

    private C3266ih(C3277ir irVar) {
        super(irVar);
        this.f2686f = f2637a;
    }

    /* renamed from: a */
    public static String m2263a() {
        return "dref";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f2685e.size());
        super.mo38506a(byteBuffer);
    }
}
