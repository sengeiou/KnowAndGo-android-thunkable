package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ag */
final class C2105ag extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f880a;

    /* renamed from: b */
    final /* synthetic */ C2170i f881b;

    /* renamed from: c */
    final /* synthetic */ C2120av f882c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2105ag(C2120av avVar, C2170i iVar, List list, C2170i iVar2) {
        super(iVar);
        this.f882c = avVar;
        this.f880a = list;
        this.f881b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f882c.f901a.mo33563b().mo33584c(this.f882c.f902d, C2120av.m954a((Collection) this.f880a), C2120av.m955b(), new C2112an(this.f882c, this.f881b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "deferredInstall(%s)", this.f880a);
            this.f881b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
