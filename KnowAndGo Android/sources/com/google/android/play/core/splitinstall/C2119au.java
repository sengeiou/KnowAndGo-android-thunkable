package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2025bv;
import com.google.android.play.core.tasks.C2170i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.au */
class C2119au<T> extends C2025bv {

    /* renamed from: a */
    final C2170i<T> f897a;

    /* renamed from: b */
    final /* synthetic */ C2120av f898b;

    C2119au(C2120av avVar, C2170i<T> iVar) {
        this.f898b = avVar;
        this.f897a = iVar;
    }

    /* renamed from: a */
    public final void mo33587a() throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onCompleteInstallForAppUpdate", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33588a(int i) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo33589a(int i, Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onCancelInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo33590a(Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onDeferredInstall", new Object[0]);
    }

    /* renamed from: a */
    public void mo33591a(List<Bundle> list) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public final void mo33592b() throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onGetSplitsForAppUpdate", new Object[0]);
    }

    /* renamed from: b */
    public void mo33593b(int i, Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo33594b(Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onDeferredLanguageInstall", new Object[0]);
    }

    /* renamed from: c */
    public void mo33595c(int i, Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onStartInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo33596c(Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onDeferredLanguageUninstall", new Object[0]);
    }

    /* renamed from: d */
    public void mo33597d(Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        C2120av.f899b.mo33553c("onDeferredUninstall", new Object[0]);
    }

    /* renamed from: e */
    public final void mo33598e(Bundle bundle) throws RemoteException {
        this.f898b.f901a.mo33561a();
        int i = bundle.getInt("error_code");
        C2120av.f899b.mo33552b("onError(%d)", Integer.valueOf(i));
        this.f897a.mo33808b((Exception) new SplitInstallException(i));
    }
}
