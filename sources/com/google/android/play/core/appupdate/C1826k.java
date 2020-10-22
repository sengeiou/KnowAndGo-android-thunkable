package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.k */
final class C1826k extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ String f232a;

    /* renamed from: b */
    final /* synthetic */ C2170i f233b;

    /* renamed from: c */
    final /* synthetic */ C1831p f234c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1826k(C1831p pVar, C2170i iVar, String str, C2170i iVar2) {
        super(iVar);
        this.f234c = pVar;
        this.f232a = str;
        this.f233b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f234c.f245a.mo33563b().mo33638a(this.f234c.f246d, C1831p.m228a(this.f234c, this.f232a), new C1830o(this.f234c, this.f233b, this.f232a));
        } catch (RemoteException e) {
            C1831p.f243b.mo33551a((Throwable) e, "requestUpdateInfo(%s)", this.f232a);
            this.f233b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
