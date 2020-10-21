package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.ai */
final class C1850ai extends C1983ag {

    /* renamed from: a */
    final /* synthetic */ int f334a;

    /* renamed from: b */
    final /* synthetic */ String f335b;

    /* renamed from: c */
    final /* synthetic */ String f336c;

    /* renamed from: d */
    final /* synthetic */ int f337d;

    /* renamed from: e */
    final /* synthetic */ C2170i f338e;

    /* renamed from: f */
    final /* synthetic */ C1859ar f339f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1850ai(C1859ar arVar, C2170i iVar, int i, String str, String str2, int i2, C2170i iVar2) {
        super(iVar);
        this.f339f = arVar;
        this.f334a = i;
        this.f335b = str;
        this.f336c = str2;
        this.f337d = i2;
        this.f338e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33272a() {
        try {
            ((C2060s) this.f339f.f358e.mo33563b()).mo33648d(this.f339f.f356c, C1859ar.m311c(this.f334a, this.f335b, this.f336c, this.f337d), C1859ar.m315e(), new C1853al(this.f339f, this.f338e));
        } catch (RemoteException e) {
            C1859ar.f354a.mo33552b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f335b, this.f336c, Integer.valueOf(this.f337d), Integer.valueOf(this.f334a));
            this.f338e.mo33808b((Exception) new RuntimeException(e));
        }
    }
}
