package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.uxcam.internals.jp */
public class C3305jp extends C3273in {

    /* renamed from: c */
    private String f2726c;

    /* renamed from: a */
    public static String m2330a() {
        return "url ";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        Charset forName = Charset.forName("utf-8");
        if (this.f2726c != null) {
            C3229gz.m2201a(byteBuffer, ByteBuffer.wrap(this.f2726c.getBytes(forName)));
            byteBuffer.put((byte) 0);
        }
    }
}
