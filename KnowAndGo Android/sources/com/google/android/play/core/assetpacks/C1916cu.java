package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C2170i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cu */
final /* synthetic */ class C1916cu implements Runnable {

    /* renamed from: a */
    private final C1921cz f559a;

    /* renamed from: b */
    private final List f560b;

    /* renamed from: c */
    private final C2170i f561c;

    /* renamed from: d */
    private final List f562d;

    C1916cu(C1921cz czVar, List list, C2170i iVar, List list2) {
        this.f559a = czVar;
        this.f560b = list;
        this.f561c = iVar;
        this.f562d = list2;
    }

    public final void run() {
        this.f559a.mo33464a(this.f560b, this.f561c, this.f562d);
    }
}
