package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.i */
final class C2132i implements SplitInstallManager {

    /* renamed from: a */
    private final C2040cj<C2158w> f921a;

    /* renamed from: b */
    private final C2040cj<FakeSplitInstallManager> f922b;

    /* renamed from: c */
    private final C2040cj<File> f923c;

    C2132i(C2040cj<C2158w> cjVar, C2040cj<FakeSplitInstallManager> cjVar2, C2040cj<File> cjVar3) {
        this.f921a = cjVar;
        this.f922b = cjVar2;
        this.f923c = cjVar3;
    }

    /* renamed from: a */
    private final SplitInstallManager m987a() {
        return (SplitInstallManager) (this.f923c.mo33606a() == null ? this.f921a : this.f922b).mo33606a();
    }

    @NonNull
    public final Task<Void> cancelInstall(int i) {
        return m987a().cancelInstall(i);
    }

    @NonNull
    public final Task<Void> deferredInstall(List<String> list) {
        return m987a().deferredInstall(list);
    }

    @NonNull
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return m987a().deferredLanguageInstall(list);
    }

    @NonNull
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return m987a().deferredLanguageUninstall(list);
    }

    @NonNull
    public final Task<Void> deferredUninstall(List<String> list) {
        return m987a().deferredUninstall(list);
    }

    @NonNull
    public final Set<String> getInstalledLanguages() {
        return m987a().getInstalledLanguages();
    }

    @NonNull
    public final Set<String> getInstalledModules() {
        return m987a().getInstalledModules();
    }

    @NonNull
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return m987a().getSessionState(i);
    }

    @NonNull
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return m987a().getSessionStates();
    }

    public final void registerListener(@NonNull SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m987a().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(@NonNull SplitInstallSessionState splitInstallSessionState, @NonNull Activity activity, int i) throws IntentSender.SendIntentException {
        return m987a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(@NonNull SplitInstallSessionState splitInstallSessionState, @NonNull IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return m987a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(@NonNull SplitInstallRequest splitInstallRequest) {
        return m987a().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(@NonNull SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m987a().unregisterListener(splitInstallStateUpdatedListener);
    }
}
