package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.uxcam.internals.hs */
public final class C3249hs {

    /* renamed from: a */
    private static Map f2561a;

    static {
        HashMap hashMap = new HashMap();
        f2561a = hashMap;
        hashMap.put(C3223gt.MPEG2, "m2v1");
        f2561a.put(C3223gt.H264, "avc1");
        f2561a.put(C3223gt.J2K, "mjp2");
    }

    /* renamed from: a */
    public static void m2234a(C3230ha haVar, C3283ix ixVar) {
        ByteBuffer allocate = ByteBuffer.allocate(4194304);
        ixVar.mo38541b(allocate);
        allocate.flip();
        haVar.write(allocate);
    }
}
