package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;

/* renamed from: com.uxcam.internals.im */
public class C3272im extends C3255hx {

    /* renamed from: a */
    private String f2645a;

    /* renamed from: b */
    private int f2646b;

    /* renamed from: c */
    private Collection f2647c = new LinkedList();

    public C3272im() {
        super(new C3277ir("ftyp"));
    }

    public C3272im(String str, Collection collection) {
        super(new C3277ir("ftyp"));
        this.f2645a = str;
        this.f2646b = 512;
        this.f2647c = collection;
    }

    /* renamed from: a */
    public static String m2271a() {
        return "ftyp";
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.put(C3227gx.m2197a(this.f2645a));
        byteBuffer.putInt(this.f2646b);
        for (String a : this.f2647c) {
            byteBuffer.put(C3227gx.m2197a(a));
        }
    }
}
