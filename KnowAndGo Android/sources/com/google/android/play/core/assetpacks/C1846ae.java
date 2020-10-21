package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.internal.C2062u;
import com.google.android.play.core.tasks.C2170i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ae */
final class C1846ae extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f315a;

    /* renamed from: b */
    final /* synthetic */ Map f316b;

    /* renamed from: c */
    final /* synthetic */ C2170i f317c;

    /* renamed from: d */
    final /* synthetic */ C1867az f318d;

    /* renamed from: e */
    final /* synthetic */ C1859ar f319e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1846ae(C1859ar arVar, C2170i iVar, List list, Map map, C2170i iVar2, C1867az azVar) {
        super(iVar);
        this.f319e = arVar;
        this.f315a = list;
        this.f316b = map;
        this.f317c = iVar2;
        this.f318d = azVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        ArrayList a = C1859ar.m299a((Collection) this.f315a);
        try {
            String a2 = this.f319e.f356c;
            Bundle b = C1859ar.m305b(this.f316b);
            C1859ar arVar = this.f319e;
            ((C2060s) this.f319e.f358e.mo33563b()).mo33647c(a2, (List<Bundle>) a, b, (C2062u) new C1857ap(arVar, this.f317c, arVar.f357d, this.f318d));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "getPackStates(%s)", this.f315a);
            this.f317c.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
