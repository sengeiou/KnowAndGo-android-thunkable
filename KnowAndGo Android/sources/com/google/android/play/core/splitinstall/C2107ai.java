package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.tasks.C2170i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ai */
final class C2107ai extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f886a;

    /* renamed from: b */
    final /* synthetic */ C2170i f887b;

    /* renamed from: c */
    final /* synthetic */ C2120av f888c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2107ai(C2120av avVar, C2170i iVar, List list, C2170i iVar2) {
        super(iVar);
        this.f888c = avVar;
        this.f886a = list;
        this.f887b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f888c.f901a.mo33563b().mo33586e(this.f888c.f902d, C2120av.m956b((Collection) this.f886a), C2120av.m955b(), new C2114ap(this.f888c, this.f887b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "deferredLanguageUninstall(%s)", this.f886a);
            this.f887b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
