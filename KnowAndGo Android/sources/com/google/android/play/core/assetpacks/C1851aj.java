package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
final class C1851aj extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ C2170i f340a;

    /* renamed from: b */
    final /* synthetic */ C1859ar f341b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1851aj(C1859ar arVar, C2170i iVar, C2170i iVar2) {
        super(iVar);
        this.f341b = arVar;
        this.f340a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f341b.f359f.mo33563b()).mo33644b(this.f341b.f356c, C1859ar.m315e(), new C1855an(this.f341b, this.f340a));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "keepAlive", new Object[0]);
        }
    }
}
