package com.google.android.play.core.install;

import androidx.annotation.NonNull;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

public abstract class InstallState {
    /* renamed from: a */
    public static InstallState m574a(@InstallStatus int i, long j, long j2, @InstallErrorCode int i2, @NonNull String str) {
        return new C1974a(i, j, j2, i2, str);
    }

    public abstract long bytesDownloaded();

    @InstallErrorCode
    public abstract int installErrorCode();

    @InstallStatus
    public abstract int installStatus();

    public abstract String packageName();

    public abstract long totalBytesToDownload();
}
