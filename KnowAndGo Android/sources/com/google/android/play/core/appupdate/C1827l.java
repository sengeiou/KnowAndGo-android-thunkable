package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.l */
final class C1827l extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ C2170i f235a;

    /* renamed from: b */
    final /* synthetic */ String f236b;

    /* renamed from: c */
    final /* synthetic */ C1831p f237c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1827l(C1831p pVar, C2170i iVar, C2170i iVar2, String str) {
        super(iVar);
        this.f237c = pVar;
        this.f235a = iVar2;
        this.f236b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f237c.f245a.mo33563b().mo33639b(this.f237c.f246d, C1831p.m234d(), new C1829n(this.f237c, this.f235a));
        } catch (RemoteException e) {
            C1831p.f243b.mo33551a((Throwable) e, "completeUpdate(%s)", this.f236b);
            this.f235a.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
