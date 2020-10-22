package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.splitinstall.aj */
final class C2108aj extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f889a;

    /* renamed from: b */
    final /* synthetic */ C2170i f890b;

    /* renamed from: c */
    final /* synthetic */ C2120av f891c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2108aj(C2120av avVar, C2170i iVar, int i, C2170i iVar2) {
        super(iVar);
        this.f891c = avVar;
        this.f889a = i;
        this.f890b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f891c.f901a.mo33563b().mo33580a(this.f891c.f902d, this.f889a, new C2116ar(this.f891c, this.f890b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "getSessionState(%d)", Integer.valueOf(this.f889a));
            this.f890b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
