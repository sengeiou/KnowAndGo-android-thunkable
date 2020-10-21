package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.review.e */
final class C2076e extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ C2170i f811a;

    /* renamed from: b */
    final /* synthetic */ C2079h f812b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2076e(C2079h hVar, C2170i iVar, C2170i iVar2) {
        super(iVar);
        this.f812b = hVar;
        this.f811a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f812b.f817a.mo33563b().mo33544a(this.f812b.f818c, PlayCoreVersion.m566a(), new C2078g(this.f812b, this.f811a));
        } catch (RemoteException e) {
            C2079h.f816b.mo33551a((Throwable) e, "error requesting in-app review for %s", this.f812b.f818c);
            this.f811a.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
