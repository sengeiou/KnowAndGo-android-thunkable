package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.aa */
final class C1842aa extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ String f301a;

    /* renamed from: b */
    final /* synthetic */ C2170i f302b;

    /* renamed from: c */
    final /* synthetic */ C1859ar f303c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1842aa(C1859ar arVar, C2170i iVar, String str, C2170i iVar2) {
        super(iVar);
        this.f303c = arVar;
        this.f301a = str;
        this.f302b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f303c.f358e.mo33563b()).mo33649e(this.f303c.f356c, C1859ar.m310c(0, this.f301a), C1859ar.m315e(), new C1852ak(this.f303c, this.f302b, (short[]) null));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "removePack(%s)", this.f301a);
        }
    }
}
