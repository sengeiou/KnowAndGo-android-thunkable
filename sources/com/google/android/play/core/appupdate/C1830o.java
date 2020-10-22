package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.o */
final class C1830o extends C1828m<AppUpdateInfo> {

    /* renamed from: d */
    final /* synthetic */ C1831p f241d;

    /* renamed from: e */
    private final String f242e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1830o(C1831p pVar, C2170i<AppUpdateInfo> iVar, String str) {
        super(pVar, new C1982af("OnRequestInstallCallback"), iVar);
        this.f241d = pVar;
        this.f242e = str;
    }

    /* renamed from: a */
    public final void mo33273a(Bundle bundle) throws RemoteException {
        super.mo33273a(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f239b.mo33808b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f239b.mo33809b(C1831p.m229a(this.f241d, bundle, this.f242e));
        }
    }
}
