package com.uxcam.internals;

import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.uxcam.internals.cu */
public final class C3044cu {

    /* renamed from: a */
    private final Set f1859a = new LinkedHashSet();

    /* renamed from: a */
    public final synchronized void mo38211a(C3026ch chVar) {
        this.f1859a.add(chVar);
    }

    /* renamed from: b */
    public final synchronized void mo38212b(C3026ch chVar) {
        this.f1859a.remove(chVar);
    }

    /* renamed from: c */
    public final synchronized boolean mo38213c(C3026ch chVar) {
        return this.f1859a.contains(chVar);
    }
}
