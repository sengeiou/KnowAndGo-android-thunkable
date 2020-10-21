package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.uxcam.internals.ij */
public class C3269ij extends C3273in {

    /* renamed from: c */
    private List f2642c;

    public C3269ij() {
        this(new C3277ir("elst"));
    }

    private C3269ij(C3277ir irVar) {
        super(irVar);
    }

    public C3269ij(List list) {
        this();
        this.f2642c = list;
    }

    /* renamed from: a */
    public static String m2265a() {
        return "elst";
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": ");
        C3246hp.m2232a(this, sb, "edits");
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        super.mo38506a(byteBuffer);
        byteBuffer.putInt(this.f2642c.size());
        for (C3268ii iiVar : this.f2642c) {
            byteBuffer.putInt((int) iiVar.f2639a);
            byteBuffer.putInt((int) iiVar.f2640b);
            byteBuffer.putInt((int) (iiVar.f2641c * 65536.0f));
        }
    }
}
