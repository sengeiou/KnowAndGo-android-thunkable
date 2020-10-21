package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.ArrayList;
import java.util.List;

public abstract class SplitInstallSessionState {
    /* renamed from: a */
    public static SplitInstallSessionState m914a(Bundle bundle) {
        return new C2098a(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public static SplitInstallSessionState create(int i, @SplitInstallSessionStatus int i2, @SplitInstallErrorCode int i3, long j, long j2, List<String> list, List<String> list2) {
        if (i2 != 8) {
            return new C2098a(i, i2, i3, j, j2, list, list2, (PendingIntent) null, (List<Intent>) null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public abstract List<String> mo33729a();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public abstract List<String> mo33730b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public abstract List<Intent> mo33732c();

    @SplitInstallErrorCode
    public abstract int errorCode();

    public boolean hasTerminalStatus() {
        int status = status();
        return status == 0 || status == 5 || status == 6 || status == 7;
    }

    @NonNull
    public List<String> languages() {
        return mo33730b() != null ? new ArrayList(mo33730b()) : new ArrayList();
    }

    @NonNull
    public List<String> moduleNames() {
        return mo33729a() != null ? new ArrayList(mo33729a()) : new ArrayList();
    }

    @Deprecated
    @Nullable
    public abstract PendingIntent resolutionIntent();

    public abstract int sessionId();

    @SplitInstallSessionStatus
    public abstract int status();

    public abstract long totalBytesToDownload();
}
