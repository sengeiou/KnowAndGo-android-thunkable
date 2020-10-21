package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.internal.C2062u;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
final class C1849ah extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f331a;

    /* renamed from: b */
    final /* synthetic */ C2170i f332b;

    /* renamed from: c */
    final /* synthetic */ C1859ar f333c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1849ah(C1859ar arVar, C2170i iVar, int i, C2170i iVar2) {
        super(iVar);
        this.f333c = arVar;
        this.f331a = i;
        this.f332b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f333c.f358e.mo33563b()).mo33646c(this.f333c.f356c, C1859ar.m309c(this.f331a), C1859ar.m315e(), (C2062u) new C1852ak(this.f333c, this.f332b, (int[]) null));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "notifySessionFailed", new Object[0]);
        }
    }
}
