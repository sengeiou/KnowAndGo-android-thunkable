package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2026bw;
import com.google.android.play.core.tasks.C2170i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ae */
final class C2103ae extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ Collection f873a;

    /* renamed from: b */
    final /* synthetic */ Collection f874b;

    /* renamed from: c */
    final /* synthetic */ C2170i f875c;

    /* renamed from: d */
    final /* synthetic */ C2120av f876d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2103ae(C2120av avVar, C2170i iVar, Collection collection, Collection collection2, C2170i iVar2) {
        super(iVar);
        this.f876d = avVar;
        this.f873a = collection;
        this.f874b = collection2;
        this.f875c = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        ArrayList a = C2120av.m954a(this.f873a);
        a.addAll(C2120av.m956b(this.f874b));
        try {
            this.f876d.f901a.mo33563b().mo33582a(this.f876d.f902d, (List<Bundle>) a, C2120av.m955b(), (C2026bw) new C2118at(this.f876d, this.f875c));
        } catch (RemoteException e) {
            C2120av.f899b.mo33551a((Throwable) e, "startInstall(%s,%s)", this.f873a, this.f874b);
            this.f875c.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
