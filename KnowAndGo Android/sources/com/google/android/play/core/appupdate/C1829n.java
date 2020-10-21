package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.appupdate.n */
final class C1829n extends C1828m<Void> {
    C1829n(C1831p pVar, C2170i<Void> iVar) {
        super(pVar, new C1982af("OnCompleteUpdateCallback"), iVar);
    }

    /* renamed from: b */
    public final void mo33274b(Bundle bundle) throws RemoteException {
        super.mo33274b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f239b.mo33808b((Exception) new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f239b.mo33809b(null);
        }
    }
}
