package com.google.android.play.core.splitinstall;

/* renamed from: com.google.android.play.core.splitinstall.s */
final class C2143s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f941a;

    /* renamed from: b */
    final /* synthetic */ int f942b;

    /* renamed from: c */
    final /* synthetic */ int f943c;

    /* renamed from: d */
    final /* synthetic */ C2144t f944d;

    C2143s(C2144t tVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f944d = tVar;
        this.f941a = splitInstallSessionState;
        this.f942b = i;
        this.f943c = i2;
    }

    public final void run() {
        C2144t tVar = this.f944d;
        SplitInstallSessionState splitInstallSessionState = this.f941a;
        tVar.mo33656a(new C2098a(splitInstallSessionState.sessionId(), this.f942b, this.f943c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo33729a(), splitInstallSessionState.mo33730b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo33732c()));
    }
}
