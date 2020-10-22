package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.internal.C2062u;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.af */
final class C1847af extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f320a;

    /* renamed from: b */
    final /* synthetic */ String f321b;

    /* renamed from: c */
    final /* synthetic */ String f322c;

    /* renamed from: d */
    final /* synthetic */ int f323d;

    /* renamed from: e */
    final /* synthetic */ C2170i f324e;

    /* renamed from: f */
    final /* synthetic */ C1859ar f325f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1847af(C1859ar arVar, C2170i iVar, int i, String str, String str2, int i2, C2170i iVar2) {
        super(iVar);
        this.f325f = arVar;
        this.f320a = i;
        this.f321b = str;
        this.f322c = str2;
        this.f323d = i2;
        this.f324e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f325f.f358e.mo33563b()).mo33640a(this.f325f.f356c, C1859ar.m311c(this.f320a, this.f321b, this.f322c, this.f323d), C1859ar.m315e(), (C2062u) new C1852ak(this.f325f, this.f324e, (char[]) null));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33551a((Throwable) e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
