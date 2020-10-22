package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.u */
final class C2156u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallRequest f998a;

    /* renamed from: b */
    final /* synthetic */ C2158w f999b;

    C2156u(C2158w wVar, SplitInstallRequest splitInstallRequest) {
        this.f999b = wVar;
        this.f998a = splitInstallRequest;
    }

    public final void run() {
        C2144t a = this.f999b.f1002b;
        List<String> moduleNames = this.f998a.getModuleNames();
        List a2 = C2158w.m1045b(this.f998a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!a2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(a2));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        a.mo33656a(SplitInstallSessionState.m914a(bundle));
    }
}
