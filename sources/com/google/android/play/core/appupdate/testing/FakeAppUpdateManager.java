package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.C1816a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a */
    private final C1816a f267a;

    /* renamed from: b */
    private final Context f268b;
    @InstallStatus

    /* renamed from: c */
    private int f269c = 0;
    @InstallErrorCode

    /* renamed from: d */
    private int f270d = 0;

    /* renamed from: e */
    private boolean f271e = false;

    /* renamed from: f */
    private int f272f = 0;
    @Nullable

    /* renamed from: g */
    private Integer f273g = null;

    /* renamed from: h */
    private int f274h = 0;

    /* renamed from: i */
    private long f275i = 0;

    /* renamed from: j */
    private long f276j = 0;

    /* renamed from: k */
    private boolean f277k = false;

    /* renamed from: l */
    private boolean f278l = false;

    /* renamed from: m */
    private boolean f279m = false;
    @AppUpdateType
    @Nullable

    /* renamed from: n */
    private Integer f280n;

    public FakeAppUpdateManager(Context context) {
        this.f267a = new C1816a(context);
        this.f268b = context;
    }

    @UpdateAvailability
    /* renamed from: a */
    private final int m247a() {
        if (!this.f271e) {
            return 1;
        }
        int i = this.f269c;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    /* renamed from: a */
    private final boolean m248a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f278l = true;
            i = 1;
        } else {
            this.f277k = true;
            i = 0;
        }
        this.f280n = i;
        return true;
    }

    /* renamed from: b */
    private final void m249b() {
        this.f267a.mo33656a(InstallState.m574a(this.f269c, this.f275i, this.f276j, this.f270d, this.f268b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i = this.f270d;
        if (i != 0) {
            return Tasks.m1052a((Exception) new InstallException(i));
        }
        int i2 = this.f269c;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.m1052a((Exception) new InstallException(-8)) : Tasks.m1052a((Exception) new InstallException(-7));
        }
        this.f269c = 3;
        this.f279m = true;
        Integer num = 0;
        if (num.equals(this.f280n)) {
            m249b();
        }
        return Tasks.m1053a(null);
    }

    public void downloadCompletes() {
        int i = this.f269c;
        if (i == 2 || i == 1) {
            this.f269c = 11;
            this.f275i = 0;
            this.f276j = 0;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f280n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.f269c;
        if (i == 1 || i == 2) {
            this.f269c = 5;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
            this.f280n = null;
            this.f278l = false;
            this.f269c = 0;
        }
    }

    public void downloadStarts() {
        if (this.f269c == 1) {
            this.f269c = 2;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        int i = this.f270d;
        if (i != 0) {
            return Tasks.m1052a((Exception) new InstallException(i));
        }
        PendingIntent broadcast = (m247a() == 2 && this.f270d == 0) ? PendingIntent.getBroadcast(this.f268b, 0, new Intent(), 0) : null;
        PendingIntent broadcast2 = (m247a() == 2 && this.f270d == 0) ? PendingIntent.getBroadcast(this.f268b, 0, new Intent(), 0) : null;
        if (m247a() == 2 && this.f270d == 0) {
            PendingIntent broadcast3 = PendingIntent.getBroadcast(this.f268b, 0, new Intent(), 0);
            pendingIntent2 = PendingIntent.getBroadcast(this.f268b, 0, new Intent(), 0);
            pendingIntent = broadcast3;
        } else {
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.m1053a(AppUpdateInfo.m204a(this.f268b.getPackageName(), this.f272f, m247a(), this.f269c, this.f273g, this.f274h, this.f275i, this.f276j, 0, 0, broadcast2, broadcast, pendingIntent2, pendingIntent));
    }

    @AppUpdateType
    @Nullable
    public Integer getTypeForUpdateInProgress() {
        return this.f280n;
    }

    public void installCompletes() {
        if (this.f269c == 3) {
            this.f269c = 4;
            this.f271e = false;
            this.f272f = 0;
            this.f273g = null;
            this.f274h = 0;
            this.f275i = 0;
            this.f276j = 0;
            this.f278l = false;
            this.f279m = false;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
            this.f280n = null;
            this.f269c = 0;
        }
    }

    public void installFails() {
        if (this.f269c == 3) {
            this.f269c = 5;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
            this.f280n = null;
            this.f279m = false;
            this.f278l = false;
            this.f269c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f277k;
    }

    public boolean isImmediateFlowVisible() {
        return this.f278l;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f279m;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f267a.mo33655a(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j) {
        if (this.f269c == 2 && j <= this.f276j) {
            this.f275i = j;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
        }
    }

    public void setClientVersionStalenessDays(@Nullable Integer num) {
        if (this.f271e) {
            this.f273g = num;
        }
    }

    public void setInstallErrorCode(@InstallErrorCode int i) {
        this.f270d = i;
    }

    public void setTotalBytesToDownload(long j) {
        if (this.f269c == 2) {
            this.f276j = j;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
        }
    }

    public void setUpdateAvailable(int i) {
        this.f271e = true;
        this.f272f = i;
    }

    public void setUpdateNotAvailable() {
        this.f271e = false;
        this.f273g = null;
    }

    public void setUpdatePriority(int i) {
        if (this.f271e) {
            this.f274h = i;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return m248a(appUpdateInfo, appUpdateOptions) ? Tasks.m1053a(-1) : Tasks.m1052a((Exception) new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) {
        return m248a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return m248a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return m248a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        return m248a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f267a.mo33658b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f277k || this.f278l) {
            this.f277k = false;
            this.f269c = 1;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.f269c;
        if (i == 1 || i == 2) {
            this.f269c = 6;
            Integer num = 0;
            if (num.equals(this.f280n)) {
                m249b();
            }
            this.f280n = null;
            this.f278l = false;
            this.f269c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.f277k || this.f278l) {
            this.f277k = false;
            this.f278l = false;
            this.f280n = null;
            this.f269c = 0;
        }
    }
}
