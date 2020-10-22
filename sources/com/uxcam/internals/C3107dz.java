package com.uxcam.internals;

import java.io.IOException;

/* renamed from: com.uxcam.internals.dz */
public final class C3107dz extends IOException {

    /* renamed from: a */
    public final C3070dm f2104a;

    public C3107dz(C3070dm dmVar) {
        super("stream was reset: ".concat(String.valueOf(dmVar)));
        this.f2104a = dmVar;
    }
}
