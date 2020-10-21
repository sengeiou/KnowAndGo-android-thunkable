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

/* renamed from: com.google.android.play.core.assetpacks.ab */
final class C1843ab extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f304a;

    /* renamed from: b */
    final /* synthetic */ Map f305b;

    /* renamed from: c */
    final /* synthetic */ C2170i f306c;

    /* renamed from: d */
    final /* synthetic */ List f307d;

    /* renamed from: e */
    final /* synthetic */ C1859ar f308e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1843ab(C1859ar arVar, C2170i iVar, List list, Map map, C2170i iVar2, List list2) {
        super(iVar);
        this.f308e = arVar;
        this.f304a = list;
        this.f305b = map;
        this.f306c = iVar2;
        this.f307d = list2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        ArrayList a = C1859ar.m299a((Collection) this.f304a);
        try {
            String a2 = this.f308e.f356c;
            Bundle b = C1859ar.m305b(this.f305b);
            C1859ar arVar = this.f308e;
            ((C2060s) this.f308e.f358e.mo33563b()).mo33642a(a2, (List<Bundle>) a, b, (C2062u) new C1858aq(arVar, this.f306c, arVar.f357d, this.f307d));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "startDownload(%s)", this.f304a);
            this.f306c.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
