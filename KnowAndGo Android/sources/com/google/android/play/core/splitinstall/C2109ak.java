package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.splitinstall.ak */
final class C2109ak extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ C2170i f892a;

    /* renamed from: b */
    final /* synthetic */ C2120av f893b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2109ak(C2120av avVar, C2170i iVar, C2170i iVar2) {
        super(iVar);
        this.f893b = avVar;
        this.f892a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f893b.f901a.mo33563b().mo33581a(this.f893b.f902d, new C2117as(this.f893b, this.f892a));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "getSessionStates", new Object[0]);
            this.f892a.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
