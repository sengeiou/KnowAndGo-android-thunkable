package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C2170i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cv */
final /* synthetic */ class C1917cv implements Runnable {

    /* renamed from: a */
    private final C1921cz f563a;

    /* renamed from: b */
    private final List f564b;

    /* renamed from: c */
    private final C1867az f565c;

    /* renamed from: d */
    private final C2170i f566d;

    C1917cv(C1921cz czVar, List list, C1867az azVar, C2170i iVar) {
        this.f563a = czVar;
        this.f564b = list;
        this.f565c = azVar;
        this.f566d = iVar;
    }

    public final void run() {
        this.f563a.mo33463a(this.f564b, this.f565c, this.f566d);
    }
}
