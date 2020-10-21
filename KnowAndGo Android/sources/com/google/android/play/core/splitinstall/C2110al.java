package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2026bw;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.splitinstall.al */
final class C2110al extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f894a;

    /* renamed from: b */
    final /* synthetic */ C2170i f895b;

    /* renamed from: c */
    final /* synthetic */ C2120av f896c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2110al(C2120av avVar, C2170i iVar, int i, C2170i iVar2) {
        super(iVar);
        this.f896c = avVar;
        this.f894a = i;
        this.f895b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            this.f896c.f901a.mo33563b().mo33579a(this.f896c.f902d, this.f894a, C2120av.m955b(), (C2026bw) new C2111am(this.f896c, this.f895b));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "cancelInstall(%d)", Integer.valueOf(this.f894a));
            this.f895b.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
