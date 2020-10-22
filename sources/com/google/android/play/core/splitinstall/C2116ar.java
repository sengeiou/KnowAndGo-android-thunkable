package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.splitinstall.ar */
final class C2116ar extends C2119au<SplitInstallSessionState> {
    C2116ar(C2120av avVar, C2170i<SplitInstallSessionState> iVar) {
        super(avVar, iVar);
    }

    /* renamed from: b */
    public final void mo33593b(int i, Bundle bundle) throws RemoteException {
        super.mo33593b(i, bundle);
        this.f897a.mo33809b(SplitInstallSessionState.m914a(bundle));
    }
}
