package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.internal.C2062u;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.ag */
final class C1848ag extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f326a;

    /* renamed from: b */
    final /* synthetic */ String f327b;

    /* renamed from: c */
    final /* synthetic */ C2170i f328c;

    /* renamed from: d */
    final /* synthetic */ int f329d;

    /* renamed from: e */
    final /* synthetic */ C1859ar f330e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1848ag(C1859ar arVar, C2170i iVar, int i, String str, C2170i iVar2, int i2) {
        super(iVar);
        this.f330e = arVar;
        this.f326a = i;
        this.f327b = str;
        this.f328c = iVar2;
        this.f329d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f330e.f358e.mo33563b()).mo33643b(this.f330e.f356c, C1859ar.m310c(this.f326a, this.f327b), C1859ar.m315e(), (C2062u) new C1856ao(this.f330e, this.f328c, this.f326a, this.f327b, this.f329d));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
