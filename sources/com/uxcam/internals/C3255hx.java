package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* renamed from: com.uxcam.internals.hx */
public abstract class C3255hx {

    /* renamed from: d */
    protected C3277ir f2610d;

    public C3255hx(C3277ir irVar) {
        this.f2610d = irVar;
    }

    /* renamed from: a */
    public static void m2243a(C3255hx hxVar, List list, Collection collection) {
        if (list.size() > 0) {
            String str = (String) list.remove(0);
            if (hxVar instanceof C3286ja) {
                for (C3255hx hxVar2 : ((C3286ja) hxVar).mo38548b()) {
                    if (str == null || str.equals(hxVar2.f2610d.f2662a)) {
                        m2243a(hxVar2, list, collection);
                    }
                }
            }
            list.add(0, str);
            return;
        }
        collection.add(hxVar);
    }

    /* renamed from: a */
    public void mo38539a(StringBuilder sb) {
        sb.append("'" + this.f2610d.f2662a + "'");
    }

    /* renamed from: a */
    public abstract void mo38506a(ByteBuffer byteBuffer);

    /* renamed from: b */
    public final void mo38541b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        C3229gz.m2198a(byteBuffer, 8);
        mo38506a(byteBuffer);
        C3277ir irVar = this.f2610d;
        irVar.f2663b = ((long) ((byteBuffer.position() - duplicate.position()) - 8)) + irVar.mo38544a();
        if (this.f2610d.mo38544a() == 8) {
            this.f2610d.mo38545a(duplicate);
            return;
        }
        throw new AssertionError();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        mo38539a(sb);
        return sb.toString();
    }
}
