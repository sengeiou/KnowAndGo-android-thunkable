package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.af */
final class C2104af extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f877a;

    /* renamed from: b */
    final /* synthetic */ C2170i f878b;

    /* renamed from: c */
    final /* synthetic */ C2120av f879c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2104af(C2120av avVar, C2170i iVar, List list, C2170i iVar2) {
        super(iVar);
        this.f879c = avVar;
        this.f877a = list;
        this.f878b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f879c.f901a.mo33563b().mo33583b(this.f879c.f902d, C2120av.m954a((Collection) this.f877a), C2120av.m955b(), new C2115aq(this.f879c, this.f878b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "deferredUninstall(%s)", this.f877a);
            this.f878b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
