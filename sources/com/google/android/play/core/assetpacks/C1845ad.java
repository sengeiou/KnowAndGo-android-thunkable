package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.tasks.C2170i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ad */
final class C1845ad extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ Map f312a;

    /* renamed from: b */
    final /* synthetic */ C2170i f313b;

    /* renamed from: c */
    final /* synthetic */ C1859ar f314c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1845ad(C1859ar arVar, C2170i iVar, Map map, C2170i iVar2) {
        super(iVar);
        this.f314c = arVar;
        this.f312a = map;
        this.f313b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f314c.f358e.mo33563b()).mo33641a(this.f314c.f356c, C1859ar.m305b(this.f312a), new C1854am(this.f314c, this.f313b));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "syncPacks", new Object[0]);
            this.f313b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
