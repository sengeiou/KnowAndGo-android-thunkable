package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.uxcam.internals.ja */
public class C3286ja extends C3255hx {

    /* renamed from: e */
    protected List f2685e = new LinkedList();

    /* renamed from: f */
    protected C3256hy f2686f = C3256hy.m2247a();

    public C3286ja(C3277ir irVar) {
        super(irVar);
    }

    /* renamed from: a */
    public final void mo38546a(C3255hx hxVar) {
        this.f2685e.add(hxVar);
    }

    /* renamed from: a */
    public final void mo38547a(C3284iy iyVar) {
        this.f2685e.add(0, iyVar);
    }

    /* renamed from: a */
    public void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": {\n");
        mo38549b(sb);
        sb.append("\n}");
    }

    /* renamed from: a */
    public void mo38506a(ByteBuffer byteBuffer) {
        for (C3255hx b : this.f2685e) {
            b.mo38541b(byteBuffer);
        }
    }

    /* renamed from: b */
    public final List mo38548b() {
        return this.f2685e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo38549b(StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f2685e.iterator();
        while (it.hasNext()) {
            ((C3255hx) it.next()).mo38539a(sb2);
            if (it.hasNext()) {
                sb2.append(",\n");
            }
        }
        sb.append(sb2.toString().replaceAll("([^\n]*)\n", "  $1\n"));
    }
}
