package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.splitcompat.d */
final class C2084d implements C2089i {

    /* renamed from: a */
    final /* synthetic */ C2085e f829a;

    C2084d(C2085e eVar) {
        this.f829a = eVar;
    }

    /* renamed from: a */
    public final void mo33696a(C2090j jVar, File file, boolean z) throws IOException {
        this.f829a.f831b.add(file);
        if (!z) {
            this.f829a.f832c.set(false);
        }
    }
}
