package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.internal.C2062u;
import com.google.android.play.core.tasks.C2170i;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ac */
final class C1844ac extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ List f309a;

    /* renamed from: b */
    final /* synthetic */ C2170i f310b;

    /* renamed from: c */
    final /* synthetic */ C1859ar f311c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1844ac(C1859ar arVar, C2170i iVar, List list, C2170i iVar2) {
        super(iVar);
        this.f311c = arVar;
        this.f309a = list;
        this.f310b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f311c.f358e.mo33563b()).mo33645b(this.f311c.f356c, (List<Bundle>) C1859ar.m299a((Collection) this.f309a), C1859ar.m315e(), (C2062u) new C1852ak(this.f311c, this.f310b, (byte[]) null));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "cancelDownloads(%s)", this.f309a);
        }
    }
}
