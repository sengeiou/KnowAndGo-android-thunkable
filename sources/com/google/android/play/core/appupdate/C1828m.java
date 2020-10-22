package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2056o;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.m */
class C1828m<T> extends C2056o {

    /* renamed from: a */
    final C1982af f238a;

    /* renamed from: b */
    final C2170i<T> f239b;

    /* renamed from: c */
    final /* synthetic */ C1831p f240c;

    C1828m(C1831p pVar, C1982af afVar, C2170i<T> iVar) {
        this.f240c = pVar;
        this.f238a = afVar;
        this.f239b = iVar;
    }

    /* renamed from: a */
    public void mo33273a(Bundle bundle) throws RemoteException {
        this.f240c.f245a.mo33561a();
        this.f238a.mo33553c("onRequestInfo", new Object[0]);
    }

    /* renamed from: b */
    public void mo33274b(Bundle bundle) throws RemoteException {
        this.f240c.f245a.mo33561a();
        this.f238a.mo33553c("onCompleteUpdate", new Object[0]);
    }
}
