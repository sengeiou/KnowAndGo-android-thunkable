package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uxcam.internals.gr */
public final class C3221gr extends C3255hx {

    /* renamed from: a */
    private int f2444a;

    /* renamed from: b */
    private int f2445b;

    /* renamed from: c */
    private int f2446c;

    /* renamed from: e */
    private List f2447e;

    /* renamed from: f */
    private List f2448f;

    public C3221gr() {
        super(new C3277ir("avcC"));
        this.f2447e = new ArrayList();
        this.f2448f = new ArrayList();
    }

    public C3221gr(int i, int i2, List list, List list2) {
        this();
        this.f2444a = i;
        this.f2445b = 0;
        this.f2446c = i2;
        this.f2447e = list;
        this.f2448f = list2;
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) this.f2444a);
        byteBuffer.put((byte) this.f2445b);
        byteBuffer.put((byte) this.f2446c);
        byteBuffer.put((byte) -1);
        byteBuffer.put((byte) (this.f2447e.size() | 224));
        for (ByteBuffer byteBuffer2 : this.f2447e) {
            byteBuffer.putShort((short) (byteBuffer2.remaining() + 1));
            byteBuffer.put((byte) 103);
            C3229gz.m2201a(byteBuffer, byteBuffer2);
        }
        byteBuffer.put((byte) this.f2448f.size());
        for (ByteBuffer byteBuffer3 : this.f2448f) {
            byteBuffer.putShort((short) ((byte) (byteBuffer3.remaining() + 1)));
            byteBuffer.put((byte) 104);
            C3229gz.m2201a(byteBuffer, byteBuffer3);
        }
    }
}
