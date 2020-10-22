package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ah */
final class C2106ah extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f883a;

    /* renamed from: b */
    final /* synthetic */ C2170i f884b;

    /* renamed from: c */
    final /* synthetic */ C2120av f885c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2106ah(C2120av avVar, C2170i iVar, List list, C2170i iVar2) {
        super(iVar);
        this.f885c = avVar;
        this.f883a = list;
        this.f884b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f885c.f901a.mo33563b().mo33585d(this.f885c.f902d, C2120av.m956b((Collection) this.f883a), C2120av.m955b(), new C2113ao(this.f885c, this.f884b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "deferredLanguageInstall(%s)", this.f883a);
            this.f884b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
