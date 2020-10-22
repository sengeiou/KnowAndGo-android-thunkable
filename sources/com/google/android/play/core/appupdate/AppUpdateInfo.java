package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

public abstract class AppUpdateInfo {
    /* renamed from: a */
    public static AppUpdateInfo m204a(@NonNull String str, int i, @UpdateAvailability int i2, @InstallStatus int i3, @Nullable Integer num, int i4, long j, long j2, long j3, long j4, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4) {
        return new C1835t(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    /* renamed from: b */
    private final boolean m205b(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && mo33234a() <= mo33237b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract long mo33234a();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public final PendingIntent mo33235a(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (mo33239c() != null) {
                    return mo33239c();
                }
                if (m205b(appUpdateOptions)) {
                    return mo33242e();
                }
            }
            return null;
        } else if (mo33241d() != null) {
            return mo33241d();
        } else {
            if (m205b(appUpdateOptions)) {
                return mo33243f();
            }
            return null;
        }
    }

    public abstract int availableVersionCode();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo33237b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public abstract PendingIntent mo33239c();

    @Nullable
    public abstract Integer clientVersionStalenessDays();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public abstract PendingIntent mo33241d();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: e */
    public abstract PendingIntent mo33242e();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: f */
    public abstract PendingIntent mo33243f();

    @InstallStatus
    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(@AppUpdateType int i) {
        return mo33235a(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(@NonNull AppUpdateOptions appUpdateOptions) {
        return mo33235a(appUpdateOptions) != null;
    }

    @NonNull
    public abstract String packageName();

    public abstract long totalBytesToDownload();

    @UpdateAvailability
    public abstract int updateAvailability();

    public abstract int updatePriority();
}
